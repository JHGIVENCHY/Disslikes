package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnection.DBConn;
import VO.LastVoteInfoVO;
import VO.VoteInfoVO;


public class VoteInfoDAO {

	private Connection con;			
	
	PreparedStatement pstmt=null;
	ResultSet rs=null;				
	
	public VoteInfoDAO() throws ClassNotFoundException, SQLException {
		con=new DBConn().getConnection(); 
	} 
	
	public ArrayList<VoteInfoVO> getVote() throws SQLException{ //��ǥ����Ʈ ��������.
		ArrayList<VoteInfoVO> vtarray=new ArrayList<VoteInfoVO>();
		String sql="select * from votes where sysdate-vt_enddate < 0 order by rownum";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			String id=rs.getString("vt_id");
			String img=rs.getString("vt_img_path");
			String vt_img_name = rs.getString("vt_img_name");
			System.out.println("�̹��� �̸� : " + vt_img_name);
			String title=rs.getString("vt_name");
			VoteInfoVO tv=new VoteInfoVO(id, img, title, vt_img_name);
				
			vtarray.add(tv);
		} 
		return vtarray;
	}
		
	public ArrayList<LastVoteInfoVO> getlastVote() throws SQLException{ //���� ��ǥ
		ArrayList<LastVoteInfoVO> vtarray1=new ArrayList<LastVoteInfoVO>();
		String sql="select * from (select * from votes where sysdate-vt_enddate > 1 order by vt_enddate desc) where rownum <= 4";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			String id=rs.getString("vt_id");
			String img=rs.getString("vt_img_path");
			String vt_img_name = rs.getString("vt_img_name");
			String title=rs.getString("vt_name");
			int like=rs.getInt("vt_ag_num");
			int dislike=rs.getInt("vt_dag_num");
			String win=rs.getString("vt_ag_name");
			LastVoteInfoVO tv=new LastVoteInfoVO(id, img, title, like, dislike, win, vt_img_name);
				
			vtarray1.add(tv);
		} 
		return vtarray1;
	}
	public void resultUpdate(String img_name, String result) throws SQLException {
		String like = "ȣ";
		String diss = "��ȣ";
		String same = "���º�";
		if (result.equals("ȣ")) {
			String sql= "update votes "
					+"set vt_total_num=vt_total_num+1, vt_ag_num=vt_ag_num+1, vt_ag_name = case "
					+"when vt_ag_num+1>vt_dag_num then ? "
					+"when  vt_ag_num+1<vt_dag_num then ? "
					+"when vt_ag_num+1=vt_dag_num then ? "
					+"end where vt_img_name=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, like);
			pstmt.setString(2, diss);
			pstmt.setString(3, same);
			pstmt.setString(4, img_name);
			pstmt.executeUpdate();
			System.out.println("ȣ ����");
		}
		else {
			String sql= "update votes " 
					+"set vt_total_num=vt_total_num+1, vt_dag_num=vt_dag_num+1, vt_ag_name = case "
					+"when vt_ag_num>vt_dag_num+1 then ? "
					+"when  vt_ag_num<vt_dag_num+1 then ? "
					+"when vt_ag_num=vt_dag_num+1 then ? "
					+"end where vt_img_name=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, like);
			pstmt.setString(2, diss);
			pstmt.setString(3, same);
			pstmt.setString(4, img_name);
			pstmt.executeUpdate();
			System.out.println("��ȣ ����");
		}
	}
} 
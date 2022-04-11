package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBConn;
import VO.InprogressVO;

public class InprogressDAO {
	
	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public InprogressDAO() throws ClassNotFoundException, SQLException {
		con = new DBConn().getConnection();
	}
	
	public void pstmtClose() throws SQLException {
		if(pstmt != null) 
			pstmt.close();
	}
	
/*	public void getAllInfoClass() throws SQLException {
		if(rs != null)
			rs.close();
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();
	}*/
	
	public InprogressVO getinfoVotes(String vt_img_name) throws SQLException {
		InprogressVO iVo = null;
		String sql = "SELECT * FROM VOTES where vt_img_name = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vt_img_name);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			String vt_id = rs.getString(1);
			String vt_name = rs.getString(2);
			//String vt_img_name = rs.getString(3);
			String vt_img_path = rs.getString(4);
			String vt_ag_name = rs.getString(5);
			int vt_total_num = rs.getInt(6);
			int vt_ag_num = rs.getInt(7);
			int vt_dag_num = rs.getInt(8);
			Date vt_indate = rs.getDate(9);
			Date vt_stdate = rs.getDate(10);
			Date vt_enddate = rs.getDate(11);
			String vt_type = rs.getString(12);
			String vt_dtype = rs.getString(13);
			iVo = new InprogressVO(vt_id, vt_name, vt_img_name, vt_img_path, vt_ag_name, vt_total_num, vt_ag_num, vt_dag_num, vt_indate, vt_stdate, vt_enddate, vt_type, vt_dtype);
			//System.out.println("¡æ∑·¿œ" + iVo.getVt_enddate());
		} else {
			iVo = null;
		}
		return iVo;
	}
}

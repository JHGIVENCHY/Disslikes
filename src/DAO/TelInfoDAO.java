package DAO;
//이혜연 만듬.
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import DBConnection.DBConn;
import VO.InprogressVO;

public class TelInfoDAO {
	private Connection con;
	private String sql;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public TelInfoDAO() throws ClassNotFoundException, SQLException{
		con= new DBConn().getConnection();
		//TelInfoDbConn.java의 객체를 만듦
	}
	
	//전체
	public ArrayList <InprogressVO> getAllList() throws SQLException{
		ArrayList<InprogressVO> tiarray = new ArrayList<InprogressVO>();
		sql = "SELECT * FROM votes where vt_enddate > sysdate";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();	//DB로 만든 정보
		
		while(rs.next()){	
			String vt_id = rs.getString("vt_id");
			String vt_name = rs.getString("vt_name");
			String vt_img_name = rs.getString("vt_img_name");
			String vt_img_path = rs.getString("vt_img_path");
			String vt_ag_name = rs.getString("vt_ag_name");
			int vt_total_num = rs.getInt("vt_total_num");
			int vt_ag_num = rs.getInt("vt_ag_num");
			int vt_dag_num = rs.getInt("vt_dag_num");
			Date vt_indate = rs.getDate("vt_indate");
			Date vt_stdate = rs.getDate("vt_stdate");
			Date vt_enddate = rs.getDate("vt_enddate");
			String vt_type = rs.getString("vt_type");
			String vt_dtype = rs.getString("vt_dtype");
			
			InprogressVO tiv = new InprogressVO(vt_id, vt_name, vt_img_name, vt_img_path, vt_ag_name, vt_total_num,
					 vt_ag_num, vt_dag_num, vt_indate, vt_stdate, vt_enddate, vt_type,
					 vt_dtype);
			tiarray.add(tiv);	//홍길동의 정보 바로 들어감
		}
		return tiarray;	
		//컬렉션의 객체명을 리턴하니까 getAllInfo() 호출한곳으로 다시 돌아감 => 컬렉션에 있는 정보를 통째로 다가져감
	}
	
	public ArrayList <InprogressVO> getAllCloseList() throws SQLException{
		ArrayList<InprogressVO> tiarray = new ArrayList<InprogressVO>();
		sql = "SELECT * FROM votes where vt_enddate < sysdate ORDER BY vt_indate desc";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();	//DB로 만든 정보
		
		while(rs.next()){	
			String vt_id = rs.getString("vt_id");
			String vt_name = rs.getString("vt_name");
			String vt_img_name = rs.getString("vt_img_name");
			String vt_img_path = rs.getString("vt_img_path");
			String vt_ag_name = rs.getString("vt_ag_name");
			int vt_total_num = rs.getInt("vt_total_num");
			int vt_ag_num = rs.getInt("vt_ag_num");
			int vt_dag_num = rs.getInt("vt_dag_num");
			Date vt_indate = rs.getDate("vt_indate");
			Date vt_stdate = rs.getDate("vt_stdate");
			Date vt_enddate = rs.getDate("vt_enddate");
			String vt_type = rs.getString("vt_type");
			String vt_dtype = rs.getString("vt_dtype");
			
			InprogressVO tiv = new InprogressVO(vt_id, vt_name, vt_img_name, vt_img_path, vt_ag_name, vt_total_num,
					 vt_ag_num, vt_dag_num, vt_indate, vt_stdate, vt_enddate, vt_type,
					 vt_dtype);
			tiarray.add(tiv);	//홍길동의 정보 바로 들어감
		}
		return tiarray;	
		//컬렉션의 객체명을 리턴하니까 getAllInfo() 호출한곳으로 다시 돌아감 => 컬렉션에 있는 정보를 통째로 다가져감
	}
		public void insertDB(String vt_id, String vt_name, String vt_img_name, String vt_img_path, String vt_stdate, String vt_enddate, String vt_type, String vt_dtype) {
			sql = "insert into votes values(?,?,?,?,?,?,?,?,to_date(?),to_date(?),to_date(?),?,?)";
			try {
				LocalDate now = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
				String formatedNow = now.format(formatter);
				System.out.println(formatedNow); // 2021/06/17

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vt_id);
				pstmt.setString(2, vt_name);
				pstmt.setString(3, vt_img_name);
				pstmt.setString(4, vt_img_path);
				pstmt.setString(5, "미정"); //호불호 아직 안정해짐. "미정"
				pstmt.setInt(6, 0);
				pstmt.setInt(7, 0);
				pstmt.setInt(8, 0);
				pstmt.setString(9, formatedNow);
				pstmt.setString(10, vt_stdate);
				pstmt.setString(11, vt_enddate);
				pstmt.setString(12, vt_type);
				pstmt.setString(13, vt_dtype);
				pstmt.executeUpdate();
				
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	
	
	/*
	 * //최신순 public ArrayList <aInprogressVO> getNewOne() throws SQLException{
	 * ArrayList<aInprogressVO> tiarray = new ArrayList<aInprogressVO>(); String sql
	 * = "SELECT * FROM votes ORDER BY vt_indate desc";
	 * 
	 * pstmt = con.prepareStatement(sql); rs = pstmt.executeQuery(); //DB로 만든 정보
	 * 
	 * while(rs.next()){
	 * 
	 * String vt_name = rs.getString("vt_name"); String vt_img_name =
	 * rs.getString("vt_img_name"); String vt_img_path =
	 * rs.getString("vt_img_path"); String vt_ag_name = rs.getString("vt_ag_name");
	 * int vt_total_num = rs.getInt("vt_total_num"); int vt_ag_num =
	 * rs.getInt("vt_ag_num"); int vt_dag_num = rs.getInt("vt_dag_num"); Date
	 * vt_indate = rs.getDate("vt_indate"); Date vt_stdate =
	 * rs.getDate("vt_stdate"); Date vt_enddate = rs.getDate("vt_enddate"); String
	 * vt_type = rs.getString("vt_type"); String vt_dtype =
	 * rs.getString("vt_dtype");
	 * 
	 * 
	 * aInprogressVO tiv = new aInprogressVO(vt_name, vt_img_name, vt_img_path,
	 * vt_ag_name, vt_dtype, vt_total_num, vt_ag_num, vt_dag_num, vt_indate,
	 * vt_stdate, vt_enddate, vt_type, vt_dtype); tiarray.add(tiv); } return
	 * tiarray;
	 * 
	 * }
	 * 
	 * //인기순 public ArrayList <aInprogressVO> getPopular() throws SQLException{
	 * ArrayList<aInprogressVO> tiarray = new ArrayList<aInprogressVO>(); String sql
	 * = "select * from votes order by vt_total_num desc";
	 * 
	 * pstmt = con.prepareStatement(sql); rs = pstmt.executeQuery();
	 * 
	 * while(rs.next()){
	 * 
	 * String vt_name = rs.getString("vt_name"); String vt_img_name =
	 * rs.getString("vt_img_name"); String vt_img_path =
	 * rs.getString("vt_img_path"); String vt_ag_name = rs.getString("vt_ag_name");
	 * int vt_total_num = rs.getInt("vt_total_num"); int vt_ag_num =
	 * rs.getInt("vt_ag_num"); int vt_dag_num = rs.getInt("vt_dag_num"); Date
	 * vt_indate = rs.getDate("vt_indate"); Date vt_stdate =
	 * rs.getDate("vt_stdate"); Date vt_enddate = rs.getDate("vt_enddate"); String
	 * vt_type = rs.getString("vt_type"); String vt_dtype =
	 * rs.getString("vt_dtype");
	 * 
	 * 
	 * aInprogressVO tiv = new aInprogressVO(vt_name, vt_img_name, vt_img_path,
	 * vt_ag_name, vt_dtype, vt_total_num, vt_ag_num, vt_dag_num, vt_indate,
	 * vt_stdate, vt_enddate, vt_type, vt_dtype); tiarray.add(tiv); } return
	 * tiarray;
	 * 
	 * }
	 */
	/*//카테고리
	public TelInfoVO getCategory(String cate1) throws SQLException{
		//ArrayList<TelInfoVO> alist14 = new ArrayList<TelInfoVO>();
		TelInfoVO tv = null;
		//System.out.println(cate1);
		String sql = "SELECT * FROM votes where vt_type = ?";
		
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, cate1);
	     rs = pstmt.executeQuery();
	     
	    System.out.println("2"+cate1);
		
	     while(rs.next()){	
				
	    	 String vt_name = rs.getString("vt_name");
				String vt_img_name = rs.getString("vt_img_name");
				String vt_img_path = rs.getString("vt_img_path");
				String vt_ag_name = rs.getString("vt_ag_name");
				int vt_total_num = rs.getInt("vt_total_num");
				int vt_ag_num = rs.getInt("vt_ag_num");
				int vt_dag_num = rs.getInt("vt_dag_num");
				Date vt_indate = rs.getDate("vt_indate");
				Date vt_stdate = rs.getDate("vt_stdate");
				Date vt_enddate = rs.getDate("vt_enddate");
				String vt_type = rs.getString("vt_type");
				String vt_dtype = rs.getString("vt_dtype");
				
				tv = new TelInfoVO(vt_name, vt_img_name, vt_img_path, vt_ag_name, vt_total_num,
						 vt_ag_num, vt_dag_num, vt_indate, vt_stdate, vt_enddate, vt_type,
						 vt_dtype);
				
				//alist14.add(tv);
			}
			return tv;	
	}*/
}
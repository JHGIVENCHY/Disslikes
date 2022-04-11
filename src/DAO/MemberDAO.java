package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import DBConnection.DBConn;
import VO.MemberVO;

public class MemberDAO {
	
	private static Connection con;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//생성자, 의존성 주입
	public MemberDAO() throws ClassNotFoundException, SQLException {
		con = new DBConn().getConnection();
	}
	//회원가입
	public int MemberInsert(String email, String password) { 
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		String id = email.substring(0, email.indexOf("@"));
		Date d1 = new Date();
		String indate = (d1.getYear() + 1900) + "-" + (d1.getMonth() + 1) + "-" + d1.getDate();
		
		
		
		try {
			sql = "insert into MEMBERS values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, "0");
			pstmt.setString(3, password);
			pstmt.setString(4, indate);
			pstmt.setString(5, email);
			
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	//회원 데이터 가져오기
	public static MemberVO getReadData(String email){ //이메일로 DB에서 읽어오는 메서드
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		MemberVO mv = new MemberVO();
		try {
			sql = "SELECT * FROM members WHERE mb_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()){ // 데이터가 있을때 처리.
				mv.setEmail(rs.getString("mb_email"));
				System.out.println("mv : " + mv.getEmail());
				mv.setPassword(rs.getString("mb_pwd"));
				System.out.println("mv : " + mv.getPassword());
				do {
					
				} while(rs.next());
			}else { // 데이터가 없을떄 처리.
				mv.setEmail("아이디중복아님");
				System.out.println(mv.getEmail());
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return mv;
	}
}

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
	
	//������, ������ ����
	public MemberDAO() throws ClassNotFoundException, SQLException {
		con = new DBConn().getConnection();
	}
	//ȸ������
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
	//ȸ�� ������ ��������
	public static MemberVO getReadData(String email){ //�̸��Ϸ� DB���� �о���� �޼���
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		MemberVO mv = new MemberVO();
		try {
			sql = "SELECT * FROM members WHERE mb_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()){ // �����Ͱ� ������ ó��.
				mv.setEmail(rs.getString("mb_email"));
				System.out.println("mv : " + mv.getEmail());
				mv.setPassword(rs.getString("mb_pwd"));
				System.out.println("mv : " + mv.getPassword());
				do {
					
				} while(rs.next());
			}else { // �����Ͱ� ������ ó��.
				mv.setEmail("���̵��ߺ��ƴ�");
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

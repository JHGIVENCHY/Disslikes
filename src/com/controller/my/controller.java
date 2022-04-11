package com.controller.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.execute.my.Execute_Impl;
import com.execute.my.Execute_ResultVote;
import com.execute.my.Execute_Survey;
import com.execute.my.Execute_getLastVote;
import com.execute.my.Execute_getVote;

import DAO.InprogressDAO;
import DAO.MemberDAO;
import DAO.TelInfoDAO;
import VO.CustomInfoVO;
import VO.InprogressVO;
import VO.MemberVO;

/**
 * Servlet implementation class Votecontroller
 */
@WebServlet("*.do")
@MultipartConfig(fileSizeThreshold = 1024*1024, maxFileSize = 1024*1024*50, maxRequestSize = 1024*1024*50*5)
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
        super();
    }
  //������ �޼ҵ�
  	protected void forward(HttpServletRequest request, HttpServletResponse response, String url)
  			throws ServletException, IOException {
  		RequestDispatcher rd = request.getRequestDispatcher(url);
  		rd.forward(request, response); 	
  	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println(request.getRequestURI());	
		System.out.println(request.getContextPath());
		//�ڹ� Ŭ���������� html���� �޸� ������ �����Ƿ� ��ü�� �޶�� ��û�� �ؾ���
		HttpSession session = request.getSession();
		String c =request.getRequestURI().substring
                     (request.getContextPath().length());
		System.out.println(c);
		String str = null;  
		Execute_Impl e1 = null;
		switch(c) {
		case "/Sign-In.do":
			str = "Login/Sign-In.jsp";
			break;
		case "/password-find1.do":
			str = "Login/password-find1.jsp";
			break;
		case "/Sign-Up.do":
			str = "Login/Sign-Up.jsp";
			break;
		case "/new-Vote.do":
			str = "New_Vote/new-Vote.jsp";
			break;
		case "/closeOne.do":
			Execute_Survey surveyImpl = new Execute_Survey();
			try {
				surveyImpl.Execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			str = "/Closed_Survey/html/closed_survey.jsp";
			break;
			
	    case "/Main.do":
			e1 = new Execute_getVote();
			try {  
				e1.Execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			e1 = new Execute_getLastVote();
	        try {  
	        	e1.Execute(request, response); 
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
			str = "Main/Main.jsp";
			break;
	    case "/Result.do":
			e1 = new Execute_ResultVote();
			try {  
				e1.Execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			//String id = request.getParameter("id");
			String vt_img_name = request.getParameter("img");
            //request.setAttribute("id", id);
            request.setAttribute("vt_img_name", vt_img_name);
            
            str = "/After_Click/InProgress_Survey.jsp";
            break;
	    case "/Search_vt_id.do":
			InprogressDAO iDao1 = null;
			InprogressVO iVo1 = null;
	        try {	        	
	        	iDao1 = new InprogressDAO();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
//	        String vt_id = request.getParameter("id");
	        vt_img_name = request.getParameter("img");
			try {
				iVo1=iDao1.getinfoVotes(vt_img_name);
			} catch (SQLException e) {
				e.printStackTrace();
			}
//			request.setAttribute("vt_id", vt_id);
			request.setAttribute("vt_img_name", vt_img_name);
			request.setAttribute("iVo1", iVo1);
			str = "/After_Click/InProgress_Survey.jsp";
			break;
			//����.
	    case "/allList.do" :	
			TelInfoDAO tidao1 = null;
			try {
				tidao1 = new TelInfoDAO();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			ArrayList<InprogressVO> alist1 = null;	
			try {
				alist1 = tidao1.getAllList();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("alist1", alist1);
			str = "/Vote_List/list_main.jsp";
			break;
	    case "/getAllCloseList.do":
			TelInfoDAO tidao131 = null;
			try {
				tidao131 = new TelInfoDAO();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			ArrayList<InprogressVO> alist131 = null;
			try {
				alist131 = tidao131.getAllCloseList();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("alist1", alist131);
			str = "/Vote_List/list_main.jsp";
			break;
		}
		RequestDispatcher rd1 = request.getRequestDispatcher(str);
		rd1.forward(request, response);	//��û,������ ������
	}// do-get-end
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//POST ����� �ѱ�ó��
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberDAO dao = null;
		TelInfoDAO dao1 = null;
		
		try {
			dao = new MemberDAO();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String cp = request.getContextPath();
		String uri = request.getRequestURI();
		MemberVO mv = null;
		String url;
		//------------------------���ε�---------------------------
		if(uri.indexOf("/new-vote-upload.do")!=-1){
			System.out.println("���ε� Ȯ�ο�.");
			
			UploadUtil uploadUtil = UploadUtil.create(request.getServletContext());
			Part part = request.getPart("vt_img_name"); //List<Part> parts = (List<Part>)
			request.getParts();
			String fileName = uploadUtil.saveFiles(part, "", uploadUtil.createFilePath());
			try {
				dao1 = new TelInfoDAO();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//String vt_id = request.getParameter("email"); //
			String vt_id = (String) session.getAttribute("nick"); //
			String vt_name = request.getParameter("vt_name"); // ��ǥ�̸�
			String vt_img_name = fileName; // �̹����̸�
			String vt_img_path = "Img_Data/" + fileName;
			String vt_stdate = request.getParameter("vt_stdate"); // ������
			String vt_enddate = request.getParameter("vt_enddate"); //������
			String vt_type = request.getParameter("vt_type");// ī�װ�
			String vt_dtype = request.getParameter("vt_dtype");// ����ī�װ�
			dao1.insertDB(vt_id, vt_name, vt_img_name, vt_img_path, vt_stdate, vt_enddate, vt_type, vt_dtype);
			System.out.println("���ε� Ȯ�ο�2");
			url = cp + "/Main/Main.jsp";
			response.sendRedirect(url);
		}
		//ȸ�����Խ�----------------------------------------------------
		if(uri.indexOf("Sign-Up.do")!=-1){
			
			//ȸ�����Կ� �����ϸ� MemberInsert(mv)�޼��� ����..
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			String reg_pwd = "^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$";
			Matcher matcher = Pattern.compile(reg_pwd).matcher(password); // ��й�ȣȮ��.
			System.out.println("��й�ȣ ��ȿ���˻� : " + matcher.matches());
			
			mv = dao.getReadData(email);
			
			// ���̵� ���� Ȯ�ιٶ��ϴ�.	
			if(email.indexOf("@") == -1 || email.indexOf(".com") == -1){ // �̸����� ������ @�� ã���� ���ų� .com�� ã���� ���ٸ� 
				url = "/disslikes/Sign-Up.do";
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('���̵� ���� Ȯ�ιٶ��ϴ�.'); location.href='" + url + "';</script>");
				writer.close();
				System.out.println("���̵� ���� Ȯ�ιٶ��ϴ�.");
				return;//�α��� ���н� ���̻��� �ҽ��ڵ尡 ������� �ʵ��� return�ۼ�
				
			//��й�ȣ�� 6�ڸ����� �۴ٸ�.
			}else if(!(password.length() >= 6)){ 
				url = "/disslikes/Sign-Up.do";
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('��й�ȣ�� 6�ڸ� �̸��Դϴ�.'); location.href='" + url + "';</script>");
				writer.close();
				System.out.println("��й�ȣ���δٸ�.");
				return;//�α��� ���н� ���̻��� �ҽ��ڵ尡 ������� �ʵ��� return�ۼ�
				
			//��й�ȣ�� ����+���� ������ �ƴ϶��
			}else if(!matcher.matches()){ 
				System.out.println("����� ���Գ� Ȯ��"); // ����� ������������ �����ϸ��.
				url = "/disslikes/Sign-Up.do";
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('��й�ȣ�� ����+���� 6�ڸ�.'); location.href='" + url + "';</script>");
				writer.close();
				System.out.println("��й�ȣ����");
				return;//�α��� ���н� ���̻��� �ҽ��ڵ尡 ������� �ʵ��� return�ۼ�
			
			// ��й�ȣ�� ���� �ٸ��ϴ�.Ȯ�ιٶ��ϴ�.
			}else if(!password.equals(password2)){ //��й�ȣ�� ��й�ȣ�� not equals ��� .. 
				url = "/disslikes/Sign-Up.do";
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('��й�ȣ�� ���� �ٸ��ϴ�.'); location.href='" + url+ "';</script>");
				writer.close();
				System.out.println("��й�ȣ���δٸ�.");
				return;//�α��� ���н� ���̻��� �ҽ��ڵ尡 ������� �ʵ��� return�ۼ�
			
			//���̵� �ߺ��� ���Ծȵ�. �ߺ��Ⱦ��̵� mv.getEmail() �� ���� �ΰ��̸� ���Ҽ�����.
			}else if(mv.getEmail().equals(email)){ // ���������� ���ǰ� ��.
				url = "/disslikes/Sign-Up.do";
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('�ߺ��� ���̵�'); location.href='" + url + "';</script>");
				writer.close();
				return;//�α��� ���н� ���̻��� �ҽ��ڵ尡 ������� �ʵ��� return�ۼ�
			}
			//ȸ�������� �Ϸ�Ǹ� �ε����������� �̵�
			dao.MemberInsert(email, password);
			url = "/Login/Sign-UpOK.jsp";
			forward(request, response, url);
			// �α��� ��..
		}else if(uri.indexOf("Sign-InOK.do")!=-1){ 
			System.out.println("�������ok");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			mv = dao.getReadData(email);
			System.out.println("�α��ν� mv�� �� : " + mv.getEmail());
			// �α��� �Ҷ�------------------------------------------------
			//mv==null�� ��� ���̵� ����
			//���ǿ� �ִ� pwd�� DB�� pwd�� ��ġ���� �ʴ� ���
			if(mv.getEmail().equals("���̵��ߺ��ƴ�") ||!mv.getPassword().equals(password)){ // ���������� ���ǰ� ��.
				url = "/disslikes/Sign-In.do";
				response.setContentType("text/html; charset=UTF-8");
				System.out.println("����� �����°� Ȯ��.");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('�̸��Ͼ��ų� ��й�ȣ Ʋ��.'); location.href='" + url +"';</script>");
				writer.close();
				System.out.println("��й�ȣƲ��");
				return;//�α��� ���н� ���̻��� �ҽ��ڵ尡 ������� �ʵ��� return�ۼ�
			}
			CustomInfoVO info = new CustomInfoVO();
			info.setEmail(mv.getEmail());
			System.out.println("info : " + info.getEmail());
			
			String nickname = info.getEmail().substring(0, info.getEmail().indexOf("@"));
			session.setAttribute("nick", nickname);
			System.out.println(session.getAttribute("nick"));

			url = cp + "/Main/Main.jsp";
			response.sendRedirect(url);
			//��й�ȣ ã��
		}else if(uri.indexOf("passwordfind.do")!=-1){ 

			String findemail = request.getParameter("findemail");
			mv = dao.getReadData(findemail);

			//mv==null�� ��� ���̵� ���� 
			if(mv.getEmail().equals("���̵��ߺ��ƴ�")){ // mv�� ���������� null �������˻�..
				url = "/disslikes/password-find1.do";
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('�̸��� �ּ� Ȯ�����ּ���.'); location.href='" + url + "';</script>");
				writer.close();
				return;//�α��� ���н� ���̻��� �ҽ��ڵ尡 ������� �ʵ��� return�ۼ�
			} //�Ʒ����� �˻��غ���� ��ġ�Ҷ�. ------------------------------------�����ʿ�---------------------------------
			CustomInfoVO info = new CustomInfoVO();
			info.setPassword(mv.getPassword()); //������������ info�� ���
			System.out.println("info : " + info.getPassword()); // �´���Ȯ��.
			session.setAttribute("findpassword", info.getPassword());
			System.out.println(session.getAttribute("nick"));

			url = "/Login/password-find2.jsp"; // �н����� ã�������� �̵�.
			forward(request, response, url);
		}
	}
}
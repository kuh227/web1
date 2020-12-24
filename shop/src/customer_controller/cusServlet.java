package customer_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer_model.cusDAO;
import customer_model.cusDTO;

@WebServlet("*.cu")
public class cusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private cusDAO dao;
	private cusDTO dto;
	private HttpSession session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/join.cu")) {	//회원가입 
			dao = new cusDAO();
			dto = new cusDTO();
			dto.setName(request.getParameter("name"));
			dto.setId(request.getParameter("id"));
			dto.setPw(request.getParameter("pw"));
			dto.setAddr(request.getParameter("addr"));
			dto.setTel(request.getParameter("tel"));
			
			try {
				Connection conn = dao.getConnection();
				int cnt = dao.join(conn, dto);
				out.print("<script>");
				out.print("alert('"+cnt+"명 가입되었습니다.');");
				out.print("location.href='index.jsp';");
				out.print("</script>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/login.cu")) {	//회원 로그인
			dao = new cusDAO();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			try {
				Connection conn = dao.getConnection();
				ResultSet rs = dao.login(conn, id);
				String dbid=null;
				String dbpw=null;
				if(!rs.isBeforeFirst()) {
					out.print("<script>");
					out.print("alert('아이디가 일치하지 않습니다.');");
					out.print("history.back();");
					out.print("</script>");
				}else{
					if(rs.next()) {
						dbid = rs.getString("id");
						dbpw = rs.getString("pw");
					
						if(!dbpw.equals(pw)) {
							out.print("<script>");
							out.print("alert('비밀번호가 일치하지 않습니다.');");
							out.print("history.back();");
							out.print("</script>");
						}else {
						session = request.getSession();
						session.setAttribute("id", id);
						response.sendRedirect("index.jsp");
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/mypage.cu")) {	//회원정보
			dao = new cusDAO();
			dto = new cusDTO();
			try {
				Connection conn = dao.getConnection();
				ResultSet rs = dao.login(conn, (String)session.getAttribute("id"));
				if(rs.next()) {
					dto.setId(rs.getString("id"));
					dto.setPw(rs.getString("pw"));
					dto.setName(rs.getString("name"));
					dto.setAddr(rs.getString("addr"));
					dto.setTel(rs.getString("tel"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=customer/mypage.jsp");
			request.setAttribute("dto", dto);
			dis.forward(request, response);
		
		}else if(command.equals("/update.cu")) {	//회원정보 수정
			dao = new cusDAO();
			dto = new cusDTO();
			dto.setId(request.getParameter("id"));
			dto.setPw(request.getParameter("pw"));
			dto.setAddr(request.getParameter("addr"));
			dto.setTel(request.getParameter("tel"));
			
			try {
				Connection conn = dao.getConnection();
				int cnt = dao.update(conn, dto);
				out.print("<script>");
				out.print("alert('"+cnt+"명 수정되었습니다.');");
				out.print("location.href='index.jsp';");
				out.print("</script>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(command.equals("/signout.cu")) {	//회원탈퇴
			dao = new cusDAO();
			String id = request.getParameter("id");
			try {
				Connection conn = dao.getConnection();
				int cnt = dao.signout(conn, id);
				session.invalidate();
				out.print("<script>");
				out.print("alert('"+cnt+"명 탈퇴되었습니다.');");
				out.print("location.href='index.jsp';");
				out.print("</script>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/logout.cu")) {	//로그아웃
			session = request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
			
		}else if(command.equals("/searchId.cu")) {	//아이디 찾기
			dao = new cusDAO();
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String id=null;
			try {
				Connection conn = dao.getConnection();
				id = dao.searchId(conn, name, tel);
				if(id!=null){
					out.print("<script>");
					out.print("alert('찾으시는 아이디는 "+id+" 입니다.');");
					out.print("location.href='index.jsp?page=login.jsp';");
					out.print("</script>");
				}else{
					out.print("<script>");
					out.print("alert('찾는 아이디가 없습니다.');");
					out.print("location.href='index.jsp?page=customer/searchId.jsp';");
					out.print("</script>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/searchPw.cu")) {
			dao = new cusDAO();
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String id = request.getParameter("id");
			try {
				Connection conn = dao.getConnection();
				String pw = dao.searchPw(conn, id, name, tel);
				if(pw!=null){
					out.print("<script>");
					out.print("alert('찾으시는 비밀번호는 "+pw+" 입니다.');");
					out.print("location.href='index.jsp?page=customer/login.jsp';");
					out.print("</script>");
				}else{
					out.print("<script>");
					out.print("alert('입력하신 정보가 일치하지 않습니다.');");
					out.print("location.href='index.jsp?page=customer/searchPw.jsp';");
					out.print("</script>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

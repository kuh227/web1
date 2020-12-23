package board_controller;

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


import board_model.boDAO;
import board_model.boDTO;
import customer_model.cusDAO;

@WebServlet("*.bo")
public class boardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private cusDAO con;
	private boDAO dao;
	private boDTO dto;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String requestURI = request.getRequestURI();
		String context = request.getContextPath();
		String command = requestURI.substring(context.length());
		
	
		if(command.equals("/register.bo")) {	//글 등록
			con = new cusDAO();
			dao = new boDAO();
			dto = new boDTO();
			dto.setTitle(request.getParameter("title"));
			dto.setAuthor(request.getParameter("author"));
			dto.setContent(request.getParameter("content"));
			dto.setNal(request.getParameter("nal"));
			dto.setReadCount(request.getParameter("readCount"));
			
			try {
				Connection conn = con.getConnection();
				int cnt = dao.boardRegister(conn, dto);
				out.print("<script>");
				out.print("alert('"+cnt+"건 등록되었습니다.');");
				out.print("location.href='list.bo'");
				out.print("</script>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(command.equals("/list.bo")) {	//글 목록
			con = new cusDAO();
			dao = new boDAO();
			try {
				Connection conn = con.getConnection();
				ArrayList<boDTO> boList = dao.boardList(conn);
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=qna/qnaList.jsp");
				request.setAttribute("boList", boList);
				dis.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(command.equals("/detail.bo")) {	//글 조회
			con = new cusDAO();
			dao = new boDAO();
			int no = Integer.parseInt(request.getParameter("no"));
			try {
				Connection conn = con.getConnection();
				dao.boardReadcountUp(conn, no);
				ResultSet rs = dao.boardDetail(conn, no);
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=qna/qnaDetail.jsp");
				request.setAttribute("rs", rs);
				dis.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(command.equals("/delete.bo")) {	//글 삭제
			con = new cusDAO();
			dao = new boDAO();
			int no = Integer.parseInt(request.getParameter("no"));
			try {
				Connection conn = con.getConnection();
				int cnt = dao.boardDelete(conn, no);
				out.print("<script>");
				out.print("alert('"+cnt+"건 삭제되었습니다.');");
				out.print("location.href='list.bo'");
				out.print("</script>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/update.bo")) {	//글 수정
			con = new cusDAO();
			dao = new boDAO();
			int no = Integer.parseInt(request.getParameter("no"));
			try {
				Connection conn = con.getConnection();
				ResultSet rs = dao.boardDetail(conn, no);
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=qna/qnaUpdate.jsp");
				request.setAttribute("rs", rs);
				dis.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/updateAcc.bo")) {
			con = new cusDAO();
			dao = new boDAO();
			dto = new boDTO();
			dto.setNo(Integer.parseInt(request.getParameter("no")));
			dto.setTitle(request.getParameter("title"));
			dto.setAuthor(request.getParameter("author"));
			dto.setContent(request.getParameter("content"));
			dto.setNal(request.getParameter("nal"));
			try {
				Connection conn = con.getConnection();
				int cnt = dao.boardUpdate(conn, dto);
				out.print("<script>");
				out.print("alert('"+cnt+"건 수정되었습니다.');");
				out.print("location.href='list.bo'");
				out.print("</script>");
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

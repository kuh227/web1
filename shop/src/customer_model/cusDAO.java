package customer_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class cusDAO {
	public Connection getConnection() throws Exception{
		String url ="jdbc:mysql://127.0.0.1:3306/mysql?characterEncoding=utf8";
		String dbid = "root";
		String dbpw = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,dbid,dbpw);
		return conn;
	}
	
	
	public int join(Connection conn, cusDTO dto)throws SQLException {
		String sql = "insert into customer(name,id,pw,addr,tel) values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getId());
		pstmt.setString(3, dto.getPw());
		pstmt.setString(4, dto.getAddr());
		pstmt.setString(5, dto.getTel());
		int cnt = pstmt.executeUpdate();
		return cnt;
	}
	
	public ResultSet login(Connection conn, String id)throws SQLException {
		String sql = "select name,id,pw,addr,tel from customer where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		return rs;
		}
	
	public int update(Connection conn, cusDTO dto)throws SQLException {
		String sql = "update customer set pw=?, addr=?, tel=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getPw());
		pstmt.setString(2, dto.getAddr());
		pstmt.setString(3, dto.getTel());
		pstmt.setString(4, dto.getId());
		int cnt = pstmt.executeUpdate();
		return cnt;
	}
	
	public int signout(Connection conn, String id)throws SQLException {
		String sql = "delete from customer where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		int cnt = pstmt.executeUpdate();
		return cnt;
	}
	
	public String searchId(Connection conn, String name, String tel)throws SQLException {
		String sql = "select id from customer where name=? and tel=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, tel);
		ResultSet rs = pstmt.executeQuery();
		String id=null; 
		if(rs.next()) {
			id = rs.getString("id");
		}
		return id;
	}
	
	public String searchPw(Connection conn, String id, String name, String tel)throws SQLException {
		String sql = "select pw from customer where id=? and name=? and tel=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, tel);
		ResultSet rs = pstmt.executeQuery();
		String pw=null;
		if(rs.next()) {
			pw = rs.getString("pw");
		}
		return pw;
	}
}

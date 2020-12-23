package board_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class boDAO {
	private ArrayList<boDTO> boList;
	private boDTO dto;
	
	public int boardRegister(Connection conn, boDTO dto)throws SQLException {
		String sql = "insert into board(title,author,content,nal,readCount) values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getAuthor());
		pstmt.setString(3, dto.getContent());
		pstmt.setString(4, dto.getNal());
		pstmt.setString(5, dto.getReadCount());
		int cnt = pstmt.executeUpdate();
		return cnt;
	}
	public ArrayList<boDTO> boardList(Connection conn)throws SQLException {
		String sql = "select no,title,author,content,nal,readCount from board";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		boList = new ArrayList<boDTO>();
		while(rs.next()){
			dto = new boDTO();
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setAuthor(rs.getString("author"));
			dto.setNal(rs.getString("nal"));
			dto.setReadCount(rs.getString("readCount"));
			boList.add(dto);
			}
		return boList;
	}
	public int boardDelete(Connection conn, int no)throws SQLException {
		String sql = "delete from board where no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		int cnt = pstmt.executeUpdate();
		return cnt;
	}
	public ResultSet boardDetail(Connection conn, int no)throws SQLException {
		String sql = "select no,title,author,content,nal,readCount from board where no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	public void boardReadcountUp(Connection conn, int no)throws SQLException {
		String sql = "update board set readCount=readCount+1 where no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.executeUpdate();
	}
	public int boardUpdate(Connection conn, boDTO dto)throws SQLException{
		String sql = "update board set title=?,author=?,content=?,nal=? where no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getAuthor());
		pstmt.setString(3, dto.getContent());
		pstmt.setString(4, dto.getNal());
		pstmt.setInt(5, dto.getNo());
		int cnt = pstmt.executeUpdate();
		return cnt;
	}
}

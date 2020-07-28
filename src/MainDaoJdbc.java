
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MainDaoJdbc {


	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	String url = "jdbc:oracle:thin:@172.16.144.33:1521:xe";
	String user = "project";
	String password = "project01";

	public MainVo selectLoginMember(MainVo mainVo) {
		MainVo vo = null;
		String sql = "SELECT mem_id, mem_password, mem_nickname FROM member WHERE mem_id = ? and mem_password = ?";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, mainVo.getMemId());
			pstmt.setString(2, mainVo.getMemPassword());

			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {

					vo = new MainVo();

					vo.setMemId(rs.getString("mem_id"));
					vo.setMemPassword(rs.getString("mem_password"));
					vo.setMemNickname(rs.getString("mem_nickname"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public MainVo selectMember(String memId) {
		MainVo vo = null;
		
		String sql = "SELECT mem_id, mem_password, mem_nickname FROM member WHERE mem_id = ?";
		
		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) { 
			
			pstmt.setString(1, memId);
			
			try(ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) { 
					vo = new MainVo();
					vo.setMemId(rs.getString("mem_id"));
					vo.setMemPassword(rs.getString("mem_password"));
					vo.setMemNickname(rs.getString("mem_nickname"));
					
				} 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public String selectQuestion(int num) {

		String explain = null;

		String sql = "SELECT question_explain FROM question " + "WHERE question_no = ?";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setInt(1, num);

			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {

					explain = rs.getString("question_explain");

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return explain;
	}

	public int insertMember(MainVo vo) {
		int num = 0;
		String sql = "INSERT INTO member (mem_id, mem_password, mem_nickname) "
				+ "values (?, ?, ?)";
		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) { 

			pstmt.setString(1, vo.getMemId()); 	
			pstmt.setString(2, vo.getMemPassword()); 	
			pstmt.setString(3, vo.getMemNickname()); 	
			num = pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public int updateMember(MainVo vo) {
		int num = 0;
		String sql = "UPDATE member SET mem_password =?, mem_nickname =? WHERE mem_id =?";
		try(
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) { 

			pstmt.setString(1, vo.getMemPassword()); 	
			pstmt.setString(2, vo.getMemNickname()); 	
			pstmt.setString(3, vo.getMemId()); 	
			num = pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
}
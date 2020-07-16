
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
}

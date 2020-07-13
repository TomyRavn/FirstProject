

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionDaoJdbc {

	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "project";
	String password = "project01";

	
	public ArrayList<QuestionVo> selectQuestionList() {
		ArrayList<QuestionVo> questionList = new ArrayList<QuestionVo>();
		String sql = "SELECT question_word, question_explain FROM question ORDER BY question_reg_date";
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
			
			while(rs.next()) {
				QuestionVo vo = new QuestionVo();
				vo.setQuestionWord(rs.getString("question_word"));
				vo.setQuestionExplain(rs.getString("question_explain"));
				questionList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questionList;
	}
	
	
	public int insertQustion(QuestionVo vo) {

		int num = 0;

		String sql = "INSERT INTO question (question_word, question_explain) " + "VALUES (?, ?)";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, vo.getQuestionWord());
			pstmt.setString(2, vo.getQuestionExplain());
//			pstmt.setString(3, vo.getQuestionWriter());

			num = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return num;
	}

}
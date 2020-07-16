

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

	String url = "jdbc:oracle:thin:@172.16.144.33:1521:xe";
	String user = "project";
	String password = "project01";

	
	//모든 단어, 설명을 가져오는 임시용 메소드
	public ArrayList<QuestionVo> selectQuestionList() {
		ArrayList<QuestionVo> questionList = new ArrayList<QuestionVo>();
		String sql = "SELECT question_word, question_explain FROM question ORDER BY question_reg_date DESC";
		
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
	
	
	public ArrayList<QuestionVo> selectRecentQuestionList(String id) {
		ArrayList<QuestionVo> questionList = new ArrayList<QuestionVo>();
		String sql = "SELECT question_word FROM question WHERE question_writer = '" + id + "' ORDER BY question_reg_date DESC";
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
			
//			pstmt.setString(1, id);
			
			while(rs.next()) {
				QuestionVo vo = new QuestionVo();
				vo.setQuestionWord(rs.getString("question_word"));
				questionList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questionList;
	}
	
	
	public int insertQustion(QuestionVo vo) {

		int num = 0;

		String sql = "INSERT INTO question (question_no, question_word, question_explain, question_writer) " + "VALUES (seq_question_no.NEXTVAL, ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, vo.getQuestionWord());
			pstmt.setString(2, vo.getQuestionExplain());
			pstmt.setString(3, vo.getQuestionWriter());

			num = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return num;
	}

}
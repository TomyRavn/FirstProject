

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RankingDaoJdbc {

	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	String url = "jdbc:oracle:thin:172.16.144.33:1521:xe";
	String user = "project";
	String password = "project01";

	public ArrayList<RankingVo> selectRanking() {
		ArrayList<RankingVo> ranking = new ArrayList<RankingVo>();
		String sql = "SELECT u_id, u_ranking, u_nickname, u_score, u_reg_date FROM RANKING ORDER BY u_reg_date";

		try(
				Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){

			while(rs.next()) {

				RankingVo vo = new RankingVo();
				vo.setuId(rs.getString("u_id"));
				vo.setuRanking(rs.getInt("u_ranking"));
				vo.setuNickname(rs.getString("u_nickname"));
				vo.setuScore(rs.getInt("u_score"));
				vo.setuRegDate(rs.getTimestamp("u_reg_date"));

				ranking.add(vo);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return ranking;
	}
	
	public int insertRanking(RankingVo vo) {
		int num = 0;
		String sql = "INSERT INTO rank (u_ranking, u_nickname, u_score) " + "VALUES (?, ?, ?)";
		
		try(
				Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setInt(1, vo.getuRanking());
			pstmt.setString(2, vo.getuNickname());
			pstmt.setInt(3, vo.getuScore());
			num = pstmt.executeUpdate();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	public int udateRanking(RankingVo vo) {
		int num = 0;
		String sql = "UPDATE rank SET u_ranking = ?, u_nickname = ?, u_score = ? where u_id = ? ";
		
		try(
				Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			pstmt.setInt(1, vo.getuRanking());
			pstmt.setString(2, vo.getuNickname());
			pstmt.setInt(3, vo.getuScore());
			num = pstmt.executeUpdate();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
}

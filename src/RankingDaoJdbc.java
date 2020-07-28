

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

	String url = "jdbc:oracle:thin:@172.16.144.33:1521:xe";
	String user = "project";
	String password = "project01";

	public ArrayList<RankingVo> selectRanking() {
		ArrayList<RankingVo> ranking = new ArrayList<RankingVo>();
		String sql = "SELECT u_no, u_id, u_nickname, u_score FROM RANKING ORDER BY u_score desc, u_no";

		try(
				Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){

			while(rs.next()) {

				RankingVo vo = new RankingVo();
				vo.setuNo(rs.getInt("u_no"));
				vo.setuId(rs.getString("u_id"));
				vo.setuNickname(rs.getString("u_nickname"));
				vo.setuScore(rs.getInt("u_score"));

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
		String sql = "INSERT INTO RANKING (u_no, u_id, u_nickname, u_score) " + "VALUES (u_seq.NEXTVAL, ?, ?, ?)";
		
		try(
				Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setString(1, vo.getuId());
			pstmt.setString(2, vo.getuNickname());
			pstmt.setInt(3, vo.getuScore());
			num = pstmt.executeUpdate();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	public int updateRanking(RankingVo vo) {
		int num = 0;
		String sql = "UPDATE RANKING SET u_id = ?, u_nickname = ?, u_score = ? where u_no = ? ";
		
		try(
				Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			pstmt.setString(1, vo.getuId());
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

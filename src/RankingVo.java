

import java.util.Date;

public class RankingVo {

	private String uId;
	private String uNickname;
	private int uScore;
	private Date uRegDate;
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuNickname() {
		return uNickname;
	}
	public void setuNickname(String uNickname) {
		this.uNickname = uNickname;
	}
	public int getuScore() {
		return uScore;
	}
	public void setuScore(int uScore) {
		this.uScore = uScore;
	}
	public Date getuRegDate() {
		return uRegDate;
	}
	public void setuRegDate(Date uRegDate) {
		this.uRegDate = uRegDate;
	}
	

}

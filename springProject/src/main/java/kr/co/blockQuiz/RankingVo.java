package kr.co.blockQuiz;

public class RankingVo {

	private int uNo;
	private String uId;
	private String uNickname;
	private int uScore;
	
	public int getuNo() {
		return uNo;
	}
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}
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

}

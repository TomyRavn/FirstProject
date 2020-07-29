package kr.co.blockQuiz;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MainVo {
	
	@NotBlank
	@Size(min = 2, max = 20)
	private String memId;
	
	@NotBlank
	@Size(min = 2, max = 20)
	private String memPassword;
	
	@NotBlank
	@Size(min = 2, max = 30)
	private String memNickname;
	
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public String getMemNickname() {
		return memNickname;
	}
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}

}
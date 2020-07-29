package kr.co.blockQuiz;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class QuestionVo {
	
	@NotBlank
	@Size(min = 2, max = 20)
	private String questionWord;
	
	@NotBlank
	@Size(min = 2, max = 400)
	private String questionExplain;
	
	private String questionWriter;
	
	
	public String getQuestionWord() {
		return questionWord;
	}
	public void setQuestionWord(String questionWord) {
		this.questionWord = questionWord;
	}
	public String getQuestionExplain() {
		return questionExplain;
	}
	public void setQuestionExplain(String questionExplain) {
		this.questionExplain = questionExplain;
	}
	public String getQuestionWriter() {
		return questionWriter;
	}
	public void setQuestionWriter(String questionWriter) {
		this.questionWriter = questionWriter;
	}

}
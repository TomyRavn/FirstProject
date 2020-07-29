package kr.co.blockQuiz;

import java.util.ArrayList;

public interface QuestionService {

	ArrayList<QuestionVo> selectQuestionList();

	ArrayList<QuestionVo> selectRecentQuestionList(String id);

	int insertQustion(QuestionVo vo);

	QuestionVo extractQuestion(int no);
	
	int maxQuestionNumber();
	
}
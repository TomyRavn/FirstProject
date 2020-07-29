package kr.co.blockQuiz;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionDao {

	ArrayList<QuestionVo> selectQuestionList();

	ArrayList<QuestionVo> selectRecentQuestionList(String id);

	int insertQustion(QuestionVo vo);

	QuestionVo extractQuestion(int no);
	
	int maxQuestionNumber();
	
}
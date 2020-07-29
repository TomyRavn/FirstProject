package kr.co.blockQuiz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

	@Resource(name="questionDao")
	private QuestionDao questionDao;
	
	@Override
	public ArrayList<QuestionVo> selectQuestionList() {
		return questionDao.selectQuestionList();
	}

	@Override
	public ArrayList<QuestionVo> selectRecentQuestionList(String id) {
		return questionDao.selectRecentQuestionList(id);
	}

	@Override
	public int insertQustion(QuestionVo vo) {
		return questionDao.insertQustion(vo);
	}

	@Override
	public QuestionVo extractQuestion(int no) {
		return questionDao.extractQuestion(no);
	}

	@Override
	public int maxQuestionNumber() {
		return questionDao.maxQuestionNumber();
	}

}

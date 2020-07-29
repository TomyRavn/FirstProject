package kr.co.blockQuiz;

public interface MainService {

	MainVo selectLoginMember(MainVo mainVo);
	
	MainVo selectMember(String memId);

	String selectQuestion(int num);

	int insertMember(MainVo vo);

	int updateMember(MainVo vo);
}
package kr.co.blockQuiz;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainDao {

	MainVo selectLoginMember(MainVo mainVo);
	
	MainVo selectMember(String memId);

	String selectQuestion(int num);

	int insertMember(MainVo vo);

	int updateMember(MainVo vo);
}
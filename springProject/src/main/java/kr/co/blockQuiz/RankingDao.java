package kr.co.blockQuiz;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RankingDao {

	ArrayList<RankingVo> selectRanking();
	
	int insertRanking(RankingVo vo);
	
	int updateRanking(RankingVo vo);
	
}
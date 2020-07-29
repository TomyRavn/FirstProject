package kr.co.blockQuiz;

import java.util.ArrayList;

public interface RankingService {

	ArrayList<RankingVo> selectRanking();
	
	int insertRanking(RankingVo vo);
	
	int updateRanking(RankingVo vo);
	
}
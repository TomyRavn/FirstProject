package kr.co.blockQuiz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("rankingService")
public class RankingServiceImpl implements RankingService {

	@Resource(name="rankingDao")
	private RankingDao rankingDao;
	
	@Override
	public ArrayList<RankingVo> selectRanking() {
		return rankingDao.selectRanking();
	}

	@Override
	public int insertRanking(RankingVo vo) {
		return rankingDao.insertRanking(vo);
	}

	@Override
	public int updateRanking(RankingVo vo) {
		return rankingDao.updateRanking(vo);
	}

}

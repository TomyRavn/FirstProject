package kr.co.blockQuiz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("mainService")
public class MainServiceImpl implements MainService{

	@Resource(name="mainDao")
	private MainDao mainDao;
	
	@Override
	public MainVo selectLoginMember(MainVo mainVo) {
		return mainDao.selectLoginMember(mainVo);
	}

	@Override
	public MainVo selectMember(String memId) {
		return mainDao.selectMember(memId);
	}

	@Override
	public String selectQuestion(int num) {
		return mainDao.selectQuestion(num);
	}

	@Override
	public int insertMember(MainVo vo) {
		return mainDao.insertMember(vo);
	}

	@Override
	public int updateMember(MainVo vo) {
		return mainDao.updateMember(vo);
	}

}
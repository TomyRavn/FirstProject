

import java.util.List;

public interface MainDao {

	List<MainVo> selectMemberList();

	MainVo selectMember(String memId);

	int insertmember(MainVo vo);

	int updatemember(MainVo vo);

	int deletemember(String memId);

	MainVo selectLoginmember(MainVo memberVo);
}

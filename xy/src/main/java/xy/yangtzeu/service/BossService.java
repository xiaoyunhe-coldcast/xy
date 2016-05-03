package xy.yangtzeu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xy.yangtzeu.exception.BusinessException;
import xy.yangtzeu.model.Boss;
import xy.yangtzeu.repository.BossRepository;

@Service("BossService")
public class BossService {
	
	@Resource(name="bossRepository")
	private BossRepository BR;
	
	public Boss login(String name, String password){
		Boss boss = BR.login(name);
		if (boss.getPassword().equals(password)){
			return boss;
		}
		throw new BusinessException("用户名或者密码不正确");
	}
}

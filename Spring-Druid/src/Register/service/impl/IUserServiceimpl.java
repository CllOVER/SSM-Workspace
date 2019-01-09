package Register.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Register.dao.IUserDao;
import Register.domain.User;
import Register.service.IUserService;
@Service  //service层
public class IUserServiceimpl implements IUserService {

	@Autowired
	private IUserDao dao;
	@Override
	public void register(User user) throws Exception {
		System.out.println("注册操作。。");
		dao.save(user);   //保存
	}
	public void setDao(IUserDao dao) {
		this.dao = dao;
	}
	

}

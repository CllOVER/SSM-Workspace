package Register.dao;

import Register.domain.User;

//接口层
public interface IUserDao {

	void save(User user) throws Exception;
}

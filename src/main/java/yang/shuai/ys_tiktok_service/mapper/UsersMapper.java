package yang.shuai.ys_tiktok_service.mapper;

import org.springframework.stereotype.Repository;
import yang.shuai.ys_tiktok_service.dao.PhoneCode;
import yang.shuai.ys_tiktok_service.dao.Users;

@Repository//映射mapper文件，替代@mapper
public interface UsersMapper {
    void createTable();
    void add(Users users);
    void del(Users users);
    void update(Users users);
    Users sel(Users users);
    Users selWithId(Integer id);

}

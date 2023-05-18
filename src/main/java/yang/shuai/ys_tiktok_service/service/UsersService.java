package yang.shuai.ys_tiktok_service.service;

import org.springframework.stereotype.Service;
import yang.shuai.ys_tiktok_service.dao.PhoneCode;
import yang.shuai.ys_tiktok_service.dao.Users;
import yang.shuai.ys_tiktok_service.mapper.UsersMapper;

import javax.annotation.Resource;

@Service//service标识
public class UsersService {
    @Resource//自动初始化对象
    UsersMapper mapper;
    //创建表
    public void createTable(){
        mapper.createTable();
    }
    //增加数据
    public void add(Users users){
        mapper.add(users);
    }
    //删
    public void del(Users users){
        mapper.del(users);
    }
    //改
    public void update(Users users){
        mapper.update(users);
    }
    public Users sel(Users users){
        return mapper.sel(users);
    }
    public Users selWithId(Integer id){
        return mapper.selWithId(id);
    }
}

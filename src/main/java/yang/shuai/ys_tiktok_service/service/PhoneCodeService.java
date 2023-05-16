package yang.shuai.ys_tiktok_service.service;

import org.springframework.stereotype.Service;
import yang.shuai.ys_tiktok_service.dao.PhoneCode;
import yang.shuai.ys_tiktok_service.mapper.PhoneCodeMapper;

import javax.annotation.Resource;

@Service//service标识
public class PhoneCodeService {
    @Resource//自动初始化对象
    PhoneCodeMapper mapper;
    //创建表
    public void createTable(){
        mapper.createTable();
    }
    //增加数据
    public void add(PhoneCode phoneCode){
        mapper.add(phoneCode);
    }
    //删
    public void del(PhoneCode phoneCode){
        mapper.del(phoneCode);
    }
    //改
    public void update(PhoneCode phoneCode){
        mapper.update(phoneCode);
    }
    public PhoneCode sel(PhoneCode phoneCode){
        return mapper.sel(phoneCode);
    }
    public PhoneCode selWithId(Integer id){
        return mapper.selWithId(id);
    }
}

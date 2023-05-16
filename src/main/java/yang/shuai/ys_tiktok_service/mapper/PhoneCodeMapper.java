package yang.shuai.ys_tiktok_service.mapper;

import org.springframework.stereotype.Repository;
import yang.shuai.ys_tiktok_service.dao.PhoneCode;

@Repository//映射mapper文件，替代@mapper
public interface PhoneCodeMapper {
    void createTable();
    void add(PhoneCode phoneCode);
    void del(PhoneCode phoneCode);
    void update(PhoneCode phoneCode);
    PhoneCode sel(PhoneCode phoneCode);
    PhoneCode selWithId(Integer id);

}

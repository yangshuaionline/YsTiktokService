package yang.shuai.ys_tiktok_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yang.shuai.ys_tiktok_service.dao.PhoneCode;
import yang.shuai.ys_tiktok_service.entity.ReturnEntity;
import yang.shuai.ys_tiktok_service.service.PhoneCodeService;
import yang.shuai.ys_tiktok_service.utils.NumberUtils;
import yang.shuai.ys_tiktok_service.utils.ReturnUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    PhoneCodeService phoneCodeService;
    /**
     * //获取验证码
     * @param phone 手机号码
     * @param type //分类 0为app 1为运营后台
     * */
    @GetMapping("/getCode")
    public ReturnEntity getTest(
            @RequestParam("phone") String phone,
            @RequestParam("type") String type){
//        System.out.println("phone = "+phone+"   type ="+type);
        //创建返回类
        ReturnEntity entity = new ReturnEntity();
        //创建表
        phoneCodeService.createTable();
        //判断手机号是否合规
        if(NumberUtils.isPhoneNumber(phone)){
            //搜索表里边手机号对应的验证码是否过期
            PhoneCode selectCode = new PhoneCode();
            selectCode.setPhone(phone);
            selectCode.setType(type);
            PhoneCode findCode = phoneCodeService.sel(selectCode);
            if(findCode == null){
                //如果没有找到  插入数据
                entity = sendCode(phone,type,true);
            }else{
                //如果找到 验证是否过期
//                //获取时间差
//                long time = System.currentTimeMillis() - findCode.getSendTime().getTime();
//                //三分钟
//                if(time>1000*60*3){
//                    //超过三分钟，重新发送
//                    //如果没有找到  插入数据
//                    entity = sendCode(phone,type,false);
//                }else{
//                    //如果验证码没有过期，刷新发送时间
//                    entity = sendCode(phone,type,false);
//                }
                entity = sendCode(phone,type,false);
            }
        }else{
            entity.setCode(ReturnUtils.ERROR);
            entity.setMsg("请输入正确手机号");
        }
        return entity;
    }

    private ReturnEntity sendCode(String phone,String type,boolean isAdd){
        ReturnEntity entity = new ReturnEntity();
        String code = NumberUtils.getRandomNumber();
        PhoneCode insertCode = new PhoneCode();
        insertCode.setPhone(phone);
        insertCode.setType(type);
        insertCode.setCode(code);
        insertCode.setSendTime(new Timestamp(System.currentTimeMillis()));
        if(isAdd){
            phoneCodeService.add(insertCode);
        }else{
            phoneCodeService.update(insertCode);
        }
        entity.setCode(ReturnUtils.SUCCESS);
        entity.setMsg("发送验证码成功,验证码有效期三分钟");
        entity.setData(code);
        return entity;
    }
}

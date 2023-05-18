package yang.shuai.ys_tiktok_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yang.shuai.ys_tiktok_service.dao.PhoneCode;
import yang.shuai.ys_tiktok_service.dao.Users;
import yang.shuai.ys_tiktok_service.entity.ReturnEntity;
import yang.shuai.ys_tiktok_service.service.PhoneCodeService;
import yang.shuai.ys_tiktok_service.service.UsersService;
import yang.shuai.ys_tiktok_service.utils.JwtUtil;
import yang.shuai.ys_tiktok_service.utils.NumberUtils;
import yang.shuai.ys_tiktok_service.utils.ReturnUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    PhoneCodeService phoneCodeService;
    @Autowired
    UsersService usersService;
    /**
     * //获取验证码
     * @param phone 手机号码
     * @param code_type //分类 0为app 1为运营后台
     * */
    @GetMapping("/getCode")
    public ReturnEntity getTest(
            @RequestParam("phone") String phone,
            @RequestParam("code_type") int code_type){
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
            selectCode.setCode_type(code_type);
            PhoneCode findCode = phoneCodeService.sel(selectCode);
            if(findCode == null){
                //如果没有找到  插入数据
                entity = sendCode(phone,code_type,true);
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
                entity = sendCode(phone,code_type,false);
            }
        }else{
            entity.setCode(ReturnUtils.ERROR);
            entity.setMessage("请输入正确手机号");
        }
        return entity;
    }

    private ReturnEntity sendCode(String phone,int code_type,boolean isAdd){
        ReturnEntity entity = new ReturnEntity();
        int code = NumberUtils.getRandomNumber();
        PhoneCode insertCode = new PhoneCode();
        insertCode.setPhone(phone);
        insertCode.setCode_type(code_type);
        insertCode.setCode(code);
        insertCode.setSendTime(new Timestamp(System.currentTimeMillis()));
        if(isAdd){
            phoneCodeService.add(insertCode);
        }else{
            phoneCodeService.update(insertCode);
        }
        entity.setCode(ReturnUtils.SUCCESS);
        entity.setMessage("发送验证码成功,验证码有效期三分钟");
        entity.setData(code);
        return entity;
    }



    /**
     * 登录
     * @param phone 手机号码
     * @param code 短信验证码
     * @param login_type //分类 0为app 1为运营后台
     * */
    @GetMapping("/setLogin")
    public ReturnEntity setLogin(
            @RequestParam("phone") String phone,
            @RequestParam("code") int code,
            @RequestParam("login_type")  int login_type){
        //创建返回类
        ReturnEntity entity = new ReturnEntity();
        //创建表
        usersService.createTable();
        //判断手机号是否正确
        if(NumberUtils.isPhoneNumber(phone)){
            //正确=====>
            //对比code
            PhoneCode selectCode = new PhoneCode();
            selectCode.setPhone(phone);
            selectCode.setCode_type(login_type);
            PhoneCode findCode = phoneCodeService.sel(selectCode);
            if(findCode.getCode()== code){
                //code相同=====>
                //生成token
                //是否有用户数据
                Users users = new Users();
                users.setPhone(phone);
                users.setLogin_type(login_type);
                Users returnUsers = usersService.sel(users);
                if(returnUsers == null){
                    //没有插入数据
                    entity = insertUsers(phone,login_type,false);
                }else{
                    //有更新数据
                    entity = insertUsers(phone,login_type,true);
                }
            }else{
                entity.setCode(ReturnUtils.ERROR);
                entity.setMessage("请输入正确验证码");
            }
        }else{
            entity.setCode(ReturnUtils.ERROR);
            entity.setMessage("请输入正确手机号");
        }
        return entity;
    }
    private ReturnEntity insertUsers(String phone,int login_type,boolean isUp){
        return insertUsers(null,null,null,null,phone,null,0,login_type,null,isUp);
    }
    private ReturnEntity insertUsers(
            String head_pic,
            String user_name,
            String pw,
            String account,
            String phone,
            String ip,
            int pos,
            int login_type,
            String introduction,
            boolean isUp){
        ReturnEntity entity = new ReturnEntity();
        entity.setCode(ReturnUtils.SUCCESS);
        entity.setMessage("登录成功");
        Users users = new Users();
        users.setHead_pic(head_pic == null?"":head_pic);
        users.setUser_name(user_name == null?phone:user_name);
        users.setPw(pw == null?"":pw);
        users.setAccount(account == null?phone:account);
        users.setIp(ip == null?"":ip);
        users.setPos(pos);
        users.setLogin_type(login_type);
        users.setPhone(phone);
        //登录成功，加上token
        String token = JwtUtil.createToken(phone+System.currentTimeMillis());
        users.setToken(token);
        users.setIntroduction(introduction == null?"":introduction);
        if(isUp){
            usersService.update(users);
        }else{
            usersService.add(users);
        }
        entity.setData(users);
        return entity;
    }
}

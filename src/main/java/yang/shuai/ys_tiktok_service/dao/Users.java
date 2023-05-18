package yang.shuai.ys_tiktok_service.dao;

import org.json.JSONObject;

/**
 * 用户信息
 * */
public class Users {
    //唯一id
    private int id;
    //头像
    private String head_pic;
    //用户名
    private String user_name;
    //密码
    private String pw;
    //账号
    private String account;
    //手机号
    private String phone;
    //ip地址
    private String ip;
    //职位(有不同权限)  0普通权限
    private int pos;
    //个人简介
    private String introduction;
    //登录type 0为app   1为运营后台
    private int login_type;
    //token
    private String token;
    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("head_pic",head_pic);
        jsonObject.put("user_name",user_name);
        jsonObject.put("pw",pw);
        jsonObject.put("account",account);
        jsonObject.put("phone",phone);
        jsonObject.put("ip",ip);
        jsonObject.put("pos",pos);
        jsonObject.put("login_type",login_type);
        jsonObject.put("introduction",introduction);
        jsonObject.put("token",token);
        return jsonObject.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHead_pic() {
        return head_pic;
    }

    public void setHead_pic(String head_pic) {
        this.head_pic = head_pic;
    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getLogin_type() {
        return login_type;
    }

    public void setLogin_type(int login_type) {
        this.login_type = login_type;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

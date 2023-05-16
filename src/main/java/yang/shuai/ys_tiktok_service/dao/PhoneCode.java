package yang.shuai.ys_tiktok_service.dao;

import org.json.JSONObject;

import java.sql.Timestamp;
/**
 * 手机验证码
 * */
public class PhoneCode {
    //唯一id
    private int id;
    //手机号
    private String phone;
    //验证码
    private String code;
    //分类 0为app 1为运营后台
    private String loginType;
    //发送时间
    private Timestamp sendTime;
    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("phone",phone);
        jsonObject.put("code",code);
        jsonObject.put("type",loginType);
        jsonObject.put("time", sendTime.toString());
        return jsonObject.toString();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return loginType;
    }

    public void setType(String loginType) {
        this.loginType = loginType;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }
}

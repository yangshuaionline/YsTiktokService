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
    private int code;
    //分类 0为app 1为运营后台
    private int code_type;
    //发送时间
    private Timestamp sendTime;
    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("phone",phone);
        jsonObject.put("code",code);
        jsonObject.put("code_type",code_type);
        jsonObject.put("time", sendTime.toString());
        return jsonObject.toString();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode_type() {
        return code_type;
    }

    public void setCode_type(int code_type) {
        this.code_type = code_type;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }
}

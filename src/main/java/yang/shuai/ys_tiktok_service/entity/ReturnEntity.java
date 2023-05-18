package yang.shuai.ys_tiktok_service.entity;

import org.json.JSONObject;

public class ReturnEntity {
    int code= 200;//错误码
    String message = "";//错误说明
    Object data = null;//返回具体内容

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("message",message);
        jsonObject.put("data",data);
        return jsonObject.toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }


    public Object getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public void setData(Object data) {
        this.data = data;
    }
}

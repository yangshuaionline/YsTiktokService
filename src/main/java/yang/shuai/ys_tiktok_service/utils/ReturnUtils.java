package yang.shuai.ys_tiktok_service.utils;

import yang.shuai.ys_tiktok_service.entity.ReturnEntity;

public class ReturnUtils {
    public static int SUCCESS = 200;//成功
    public static int FAILT = 400;//失败
    public static int ERROR = 500;//错误
    public static ReturnEntity getEntity(int code, String msg, Object data){
        ReturnEntity entity = new ReturnEntity();
        entity.setCode(code);
        entity.setMsg(msg);
        entity.setData(data);
        return entity;
    }
}

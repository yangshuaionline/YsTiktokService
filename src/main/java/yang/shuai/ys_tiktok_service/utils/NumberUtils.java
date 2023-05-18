package yang.shuai.ys_tiktok_service.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数字工具类
 * */
public class NumberUtils {
    //生成随机六位数字（没有对接短信平台之前暂时替代）
    public static int getRandomNumber(){
        // 创建 Random 对象
        Random rand = new Random();
        // 生成随机数，并保证在 0~999999 之间
        int num = rand.nextInt(900000);
        num += 100000;
        // 将数字格式化为六位字符串
//        String randomNum = String.format("%06d", num);
        return num;
    }

    public static boolean isPhoneNumber(String phone){
        // 创建 Pattern 对象，使用正则表达式匹配手机号
        Pattern pattern = Pattern.compile("^1[3|4|5|6|7|8][0-9]\\d{8}$");
        // 创建 Matcher 对象，用于检查输入的字符串是否匹配正则表达式
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}

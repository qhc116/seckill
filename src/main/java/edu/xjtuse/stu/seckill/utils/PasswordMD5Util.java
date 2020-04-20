package edu.xjtuse.stu.seckill.utils;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 失了秩
 * @date 2020/4/18 10:40
 * @description
 */
public class PasswordMD5Util {

    public  static String md5(String src) {
        String s = DigestUtils.md5Hex(src);
        return s;
    }

    private static final String defaultSalt = "lbwnb";

    public static String formMD5(String password) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(defaultSalt.charAt(0));
        stringBuffer.append(defaultSalt.charAt(4));
        stringBuffer.append(password);
        stringBuffer.append(defaultSalt.charAt(1));
        stringBuffer.append(defaultSalt.charAt(3));
        stringBuffer.append(defaultSalt.charAt(2));
        return md5(stringBuffer.toString());
    }

    public static String dbMD5(String password, String dbSalt) {
        String formMD5 = formMD5(password);
        return DigestUtils.md5Hex(formMD5 + dbSalt);
    }

    public static void main(String[] args) {
        String formMD5 = formMD5("123456");
    }
}

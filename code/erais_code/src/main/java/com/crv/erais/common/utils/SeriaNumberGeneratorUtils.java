package com.crv.erais.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.security.x509.SerialNumber;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 流水号
 */
public class SeriaNumberGeneratorUtils {
    /**
     * 获取现在时间
     * @return返回字符串格式yyyyMMddHHmmss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    /**
     * 由年月日时分秒+3位随机数
     * 生成流水号 17位
     * @return
     */
    public static String getSeriaNumberGenerator(){
        String t = getStringDate();
        int x=(int)(Math.random()*900)+100;
        String serial = t + x;
        return serial;
    }

    //主方法测试
    public static void main(String[] args) {
        String m= getSeriaNumberGenerator();
        System.out.println(m);
    }
}

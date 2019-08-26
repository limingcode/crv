package com.crv.erais.common.utils;

import com.crv.erais.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证手机号
 */
public class CheckPhoneUtils {
    /**
     * 0:验证通过  1：为空  2：手机号位数不正确  3：验证失败
     * @param phone
     * @return
     */
    public static  int  checkPhone(String phone) {
        int status =0;
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if (StringUtils.isEmpty(phone)) {
            status =  1;
            throw new BusinessException(1,"手机号为空");
        } else {
            if (phone.length() != 11) {
                System.out.println("手机号应为11位数");
                status =  2;
                throw new BusinessException(1,"手机号应为11位数");
            } else {
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(phone);
                boolean isMatch = m.matches();
                if (isMatch) {
                    System.out.println("您的手机号" + phone + "是正确格式@——@");
                } else {
                    System.out.println("您的手机号" + phone + "是错误格式！！！");
                    status =  3;
                    throw new BusinessException(1,"手机号验证失败，请填写正确的手机号");
                }
            }
        }
        return status;
    }
    public static void main(String[] args) {
        CheckPhoneUtils s = new CheckPhoneUtils();
        s.checkPhone("11111111111");
    }

}

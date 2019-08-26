package com.crv.erais.common.utils;

import com.crv.erais.common.exception.BusinessException;
import com.crv.erais.model.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Component
/**
 * 检查实体类中 配置了注解为 notempty
 * 或者 NotBlank注解的非空检查
 */
public class ValidatorUtils {
    @Autowired
    private Validator validator;

    /**
     * 非空检查
     *
     * @param obj
     * @param <T>
     * @return Map<String, Object>
     */
    public <T> Map<String, Object> validators(T obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        if (constraintViolations.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder("校验失败:");
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                stringBuilder.append(constraintViolation.getMessage() + ";");
            }
            map.put("code", constraintViolations.size());
            map.put("validata", stringBuilder.toString());
        }
        return map;
    }

    /**
     *非空检查
     * @param obj
     * @param <T>
     */
    public  <T>  void validator (T obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        if (constraintViolations.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder("校验失败:");
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                stringBuilder.append(constraintViolation.getMessage() + ";");
            }
            map.put("code", constraintViolations.size());
            map.put("validata", stringBuilder.toString());
        }
        if (map.size() > 0) {
            if (Integer.parseInt(map.get("code").toString()) > 0) {
                throw new BusinessException(1, map.get("validata").toString());
            }
        }
    }
}

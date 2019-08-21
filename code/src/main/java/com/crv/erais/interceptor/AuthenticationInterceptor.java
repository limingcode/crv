package com.crv.erais.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.Claim;
import com.crv.erais.common.JwtUtil;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author zph
 * @date 2018-11-26
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws IOException {
//            String token = httpServletRequest.getHeader("Authorization");
//            try {
//                if (token == null || token.isEmpty()) {
//                    return tokenCheckError(httpServletResponse);
//                } else {
//                    Map<String, Claim> map = JwtUtil.verifyJWT(token);
//                    if (map == null) {
//                        return tokenCheckError(httpServletResponse);
//                    } else {
//                        String[] userInfo = map.get("userInfo").asString().split(",");
//
//                        if ( userInfo.length < 1) {
//                            return tokenCheckError(httpServletResponse);
//                        } else {
//                            httpServletRequest.setAttribute("userAccount", userInfo[0]);
//                            httpServletRequest.setAttribute("userName", userInfo[1]);
//                            return true;
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                return tokenCheckError(httpServletResponse);
//            }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

    private boolean tokenCheckError(HttpServletResponse httpServletResponse) throws IOException {
        JSONObject json = new JSONObject();
        json.put("code", 401);
        json.put("msg", "凭证验证失败，请重新登陆！");
        json.put("data", null);
        httpServletResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpServletResponse.getWriter().print(json);
        return false;
    }
}

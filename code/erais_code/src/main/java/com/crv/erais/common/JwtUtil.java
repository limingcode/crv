package com.crv.erais.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.util.Map;

/**
 * @author zph
 * @date 2018-11-19
 */
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    /**
     * @param userAccount Issuer  发行者
     *                    IssuedAt 发行时间
     *                    ExpiresAt 过期时间
     *                    NotBefore 开始使用时间
     * @return
     */
    public static String createJWT(String userAccount, String userName) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(Dictionary.TOKEN_SECRET);
            return JWT.create()
                    .withIssuer(Dictionary.TOKEN_ISSUER)
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 4 * 1000))
                    .withNotBefore(new Date())
                    .withClaim("userInfo", userAccount + "," + userName)
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            return "";
        }
    }

    public static Map<String, Claim> verifyJWT(String token) {
        try {
            if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
                logger.error(" token format is error,", token);
                return null;
            }
            Algorithm algorithm = Algorithm.HMAC256(Dictionary.TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(Dictionary.TOKEN_ISSUER).build();
            DecodedJWT jwt = verifier.verify(token.replace("Bearer ", ""));
            return jwt.getClaims();
        } catch (JWTVerificationException exception) {
            logger.error("parse token failure,", exception.getMessage());
            return null;
        }
    }
}

package com.flat.management.configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SecurityTokenManager {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateToken(String userId){

        Algorithm algorithm= Algorithm.HMAC256(jwtSecret);
        return JWT.create().withClaim("id", userId).sign(algorithm);
    }

    public String validateToken(String token){
            Verification verification = JWT.require(Algorithm.HMAC256(jwtSecret));
            JWTVerifier jwtverifier = verification.build();
            DecodedJWT decodedjwt = jwtverifier.verify(token);
            Claim claim = decodedjwt.getClaim("id");
            log.info(claim.asString());
            return claim.asString();
    }
}

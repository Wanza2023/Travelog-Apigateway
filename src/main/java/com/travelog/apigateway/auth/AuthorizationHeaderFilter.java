package com.travelog.apigateway.auth;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {

//    public AuthorizationHeaderFilter(JwtUtil jwtUtil) {
//        super(AuthorizationHeaderFilter.Config.class);
//        this.jwtUtil = jwtUtil;
//    }
//
//    private final JwtUtil jwtUtil;
//    private final MemberServiceFeignClient memberServiceFeignClient;

    @Override
    public GatewayFilter apply(AuthorizationHeaderFilter.Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            log.info("request={}", request);

//            String temp = memberServiceFeignClient.authorizeMember((HttpServletRequest) request);
//            log.info("============");
//
//            if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) return onError(exchange, "No authorization header", HttpStatus.UNAUTHORIZED);
//            String authorizationHeader = request.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
//            String jwt = authorizationHeader.replace("Bearer ", "");
//            if (!(jwtUtil.validateToken(jwt))) return onError(exchange, "JWT token is not valid", HttpStatus.UNAUTHORIZED);
            return chain.filter(exchange);
        };
    }


//    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
//        ServerHttpResponse response = exchange.getResponse();
//        response.setStatusCode(httpStatus);
//        log.error(err);
//        return response.setComplete();
//    }

//    private boolean isJwtValid(String jwt) {
//        String subject = null;
//        try {
//            subject = Jwts.parser().setSigningKey(environment.getProperty("token.secret"))
//                    .parseClaimsJws(jwt).getBody()
//                    .getSubject();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return !Strings.isBlank(subject);
//    }


//    public AuthorizationHeaderFilter() {
//
//    }

    public static class Config {}
}

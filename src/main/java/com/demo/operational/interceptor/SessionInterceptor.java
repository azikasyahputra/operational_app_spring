package com.demo.operational.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userId = request.getSession().getAttribute("id");
        if (userId == null) {
            String requestType = request.getHeader("X-PJAX");

            if ("true".equals(requestType)) {
                // If it's a PJAX request, send a full redirect response
                response.setHeader("X-PJAX-URL", "/login");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            } else {
                // Normal request, perform a full redirect
                response.sendRedirect("/login");
            }
            return false; // Prevent further handling of the request
        }

        // Continue processing if session is valid
        return true;
    }
}

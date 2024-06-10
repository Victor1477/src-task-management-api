package com.task.management.api.interceptors;

import com.task.management.api.service.SimpleAuthenticationService;
import com.task.management.api.utils.DateUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {

    @Resource
    SimpleAuthenticationService simpleAuthenticationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(DateUtils.getCurrentDateTime() + " Request to: " + request.getRequestURI().toString());
        if (request.getRequestURI().equals("/api/authenticate") || request.getMethod().equals("OPTIONS")) {
            return true;
        }
        boolean authorized = simpleAuthenticationService.authorize(request.getHeader("Authorization"));
        if (!authorized) {
            authorized = simpleAuthenticationService.authorize(request.getParameter("authorization"));
        }
        if (!authorized)
            response.sendError(401);

        return authorized;
    }
}

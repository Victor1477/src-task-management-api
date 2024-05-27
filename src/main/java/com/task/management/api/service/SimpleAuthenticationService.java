package com.task.management.api.service;

import com.task.management.api.dto.TokenResponseDTO;
import com.task.management.api.entity.User;
import com.task.management.api.utils.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SimpleAuthenticationService {

    @Value("${authentication.name}")
    private String name;

    @Value("${authentication.password}")
    private String password;

    private String currentToken = "";

    public SimpleAuthenticationService() {
    }

    public TokenResponseDTO authenticate(User user) {
        System.out.println(DateUtils.getCurrentDateTime() + " Trying to authenticate: " + user.getName());
        if (user.getName().equals(this.name) && user.getPassword().equals(this.password)) {
            int random = (int) Math.round(Math.random() * 1000);
            int random2 = (int) Math.floor(Math.random() * 100);
            this.currentToken = "Bearer " + random + System.currentTimeMillis() + random2;
            return new TokenResponseDTO(this.currentToken);
        }
        return null;
    }

    public boolean authorize(String token) {
        if (token != null && token.equals(this.currentToken)) {
            return true;
        }
        return false;
    }

}

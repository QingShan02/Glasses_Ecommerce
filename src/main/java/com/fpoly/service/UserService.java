package com.fpoly.service;

import com.fpoly.entity.User;
import com.fpoly.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession session;

    List<User> users;
    public boolean login(String username, String password) {
        final boolean[] checkUser = {false};
        users = userRepository.findAll();

        users.stream().forEach(user -> {
            if (user.getEmail().equals(username)) {
                if (user.getPassword().equals(password)) {
                    session.setAttribute("user", user);
                    System.out.println(session.getAttribute("user"));
                    checkUser[0] = true;
                }
            }
        });

        return checkUser[0];
    }
}

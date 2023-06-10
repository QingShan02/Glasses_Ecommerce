package com.fpoly.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.constant.Hours;
import com.fpoly.entity.User;
import com.fpoly.repository.UserRepository;
import com.fpoly.utility.CookieUtility;
import com.fpoly.utility.SessionUtility;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	HttpServletResponse resp;
	@Autowired
	SessionUtility session;
	@Autowired
	CookieUtility cookie;

    public User save(User u) {
    	
    	return userRepository.save(u);
    }
	
	public void logout() {
		session.remove("user");
		cookie.remove("userId");
	}
	
	public boolean login(String username, String password) {
		User user = userRepository.findByEmail(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				session.set("user", user);
				System.out.println(session.get("user"));

				resp.addCookie(cookie.add("userId", String.valueOf(user.getId()), Hours.HOURS_ACCOUNT));
				resp.addCookie(cookie.add("isAdmin", String.valueOf(user.getIsAdmin()), Hours.HOURS_ACCOUNT));

				return true;
			}
		}
		return false;
	}
	
	public User edit(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
}

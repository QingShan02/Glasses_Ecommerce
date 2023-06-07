package com.fpoly.service;

import java.util.List;

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

	List<User> users;
	
	public void logout() {
		session.remove("user");
		cookie.remove("userId");
	}
	
	public boolean login(String username, String password) {
		final boolean[] checkUser = { false };
		users = userRepository.findAll();
		users.stream().forEach(user -> {
			if (user.getEmail().equals(username)) {
				if (user.getPassword().equals(password)) {
					session.set("user", user);
					System.out.println(session.get("user"));
					Cookie ck = cookie.add("userId", String.valueOf(user.getId()), Hours.HOURS_ACCOUNT);
					resp.addCookie(ck);
					checkUser[0] = true;
				}
			}
		});
		return checkUser[0];
//		User user = userRepository.findByEmail(username);
//		if (user != null) {
//			if (user.getPassword().equals(password)) {
//				session.set("user", user);
//				System.out.println(session.get("user"));
//				Cookie ck = cookie.add("userId", String.valueOf(user.getId()), Hours.HOURS_ACCOUNT);
//				resp.addCookie(ck);
//				return true;
//			}
//		}
//		return false;
	}
}

package com.noyon.main.service;

import com.noyon.main.dto.LoginRequest;
import com.noyon.main.dto.Response;
import com.noyon.main.entity.User;

public interface UserService {

	 Response register(User user);
	    Response login(LoginRequest loginRequest);
	    Response getAllUsers();
	    Response getUSerBookingHistory(String userId);
	    Response deleteUser(String userId);
	    Response getUserById(String userId);
	    Response getMyInfo(String email);
}

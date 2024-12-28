package com.noyon.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.noyon.main.dto.LoginRequest;
import com.noyon.main.dto.Response;
import com.noyon.main.dto.UserDTO;
import com.noyon.main.entity.User;
import com.noyon.main.exception.CustomException;
import com.noyon.main.jwt.JwtService;
import com.noyon.main.repository.UserRepository;
import com.noyon.main.service.UserService;
import com.noyon.main.utils.Utils;
@Service
public class UserServiceImpl implements UserService {

	   @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Autowired
	    private JwtService jwtService;

	    @Autowired
	    private AuthenticationManager authenticationManager;


	    @Override
	    public Response register(User user) {
	        Response response = new Response();

	        try {
	            if (user.getRole() == null || user.getRole().isBlank()) {
	                user.setRole("USER");
	            }
	            if (userRepository.existsByEmail(user.getEmail())) {
	                throw new CustomException(user.getEmail() + " " + "Already Exists");
	            }

	            user.setPassword(passwordEncoder.encode(user.getPassword()));
	            User savedUser = userRepository.save(user);
	            UserDTO userDTO = Utils.mapUserEntityToUserDTO(savedUser);

	           response.setStatusCode(200);
	            response.setUser(userDTO);
	            response.setMessage("successful");

	        } catch (CustomException e) {
	            response.setStatusCode(400);
	            response.setMessage(e.getMessage());

	        } catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error Saving a User" + e.getMessage());

	        }
	        return response;
	    }

	    @Override
	    public Response login(LoginRequest loginRequest) {
	        Response response = new Response();

	        try {
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
	            var user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new CustomException("User Not Found"));
	            var token = jwtService.generatedToken(user);

	            response.setToken(token);
	            response.setExpirationTime("7 days");
	            response.setRole(user.getRole());
	            response.setMessage("successful");
	            response.setStatusCode(200);

	        } catch (CustomException e) {
	            response.setStatusCode(404);
	            response.setMessage(e.getMessage());

	        } catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error Logging in " + e.getMessage());

	        }
	        return response;
	    }

	    @Override
	    public Response getAllUsers() {
	        Response response = new Response();

	        try {
	            List<User> userList = userRepository.findAll();
	            List<UserDTO> userDTOList = Utils.mapUserListEntityToUserListDTO(userList);

	            response.setUserList(userDTOList);
	            response.setMessage("successful");
	            response.setStatusCode(200);

	        } catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error getting all users " + e.getMessage());

	        }
	        return response;
	    }

	    @Override
	    public Response getUSerBookingHistory(String userId) {
	        Response response = new Response();

	        try {
	            User user = userRepository.findById(Integer.valueOf(userId)).orElseThrow(()-> new CustomException("User Not Found"));
	            UserDTO userDTO = Utils.mapUserEntityToUserDTOPlusUserBookingsAndRoom(user);

	            response.setMessage("successful");
	            response.setStatusCode(200);
	            response.setUser(userDTO);

	        } catch (CustomException e) {
	            response.setStatusCode(404);
	            response.setMessage(e.getMessage());

	        } catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error getting user bookings in " + e.getMessage());

	        }
	        return response;
	    }

	    @Override
	    public Response deleteUser(String userId) {
	        Response response = new Response();

	        try {
	            userRepository.findById(Integer.valueOf(userId)).orElseThrow(()-> new CustomException("User Not Found"));
	            userRepository.deleteById(Integer.valueOf(userId));

	            response.setMessage("successful");
	            response.setStatusCode(200);

	        } catch (CustomException e) {
	            response.setStatusCode(404);
	            response.setMessage(e.getMessage());

	        } catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error deleting a user " + e.getMessage());

	        }
	        return response;
	    }

	    @Override
	    public Response getUserById(String userId) {
	        Response response = new Response();

	        try {
	            User user = userRepository.findById(Integer.valueOf(userId)).orElseThrow(()-> new CustomException("User Not Found"));
	            UserDTO userDTO = Utils.mapUserEntityToUserDTO(user);

	            response.setMessage("successful");
	            response.setStatusCode(200);
	            response.setUser(userDTO);

	        } catch (CustomException e) {
	            response.setStatusCode(404);
	            response.setMessage(e.getMessage());

	        } catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error getting a user by id " + e.getMessage());

	        }
	        return response;
	    }

	    @Override
	    public Response getMyInfo(String email) {
	        Response response = new Response();

	        try {
	            User user = userRepository.findByEmail(email).orElseThrow(()-> new CustomException("User Not Found"));
	            UserDTO userDTO = Utils.mapUserEntityToUserDTO(user);

	            response.setMessage("successful");
	            response.setStatusCode(200);
	            response.setUser(userDTO);

	        } catch (CustomException e) {
	            response.setStatusCode(404);
	            response.setMessage(e.getMessage());

	        } catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error getting a user info " + e.getMessage());

	        }
	        return response;
	    }
}
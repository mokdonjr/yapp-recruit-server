package kr.co.yapp.recruit.service;

import java.util.Arrays;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.yapp.recruit.dao.RoleRepository;
import kr.co.yapp.recruit.dao.UserRepository;
import kr.co.yapp.recruit.model.Role;
import kr.co.yapp.recruit.model.User;

@Service
public class UserService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User findUserByEmail(String email){
		return userRepository.findByEmail(email);
	}
	
	public void saveUser(User user){
		user.setPin(bCryptPasswordEncoder.encode(user.getPin()));
		
		Role role = roleRepository.findByRoleName("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(role)));
		userRepository.save(user);
		
		logger.info("새 유저가 등록되었습니다 - {}", user.getUserId());
	}

}

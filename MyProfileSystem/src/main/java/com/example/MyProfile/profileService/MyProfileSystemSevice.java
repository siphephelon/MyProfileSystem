package com.example.MyProfile.profileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyProfile.profileDomain.profile;
import com.example.MyProfile.profileRepository.MyProfileSystemRepository;


@Service
public class MyProfileSystemSevice {
	@Autowired
	private MyProfileSystemRepository repo;
	
	public profile login(String username, String password) {
		profile user = repo.findByUsernameAndPassword(username, password);
		return user;
	}
}

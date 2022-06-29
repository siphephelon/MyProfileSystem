package com.example.MyProfile.profileRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MyProfile.profileDomain.profile;

@Repository
public interface MyProfileSystemRepository extends JpaRepository<profile,Long>{
	profile findByUsernameAndPassword(String username, String password);

}


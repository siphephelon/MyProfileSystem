package com.example.MyProfile.profileController;

import java.util.Objects;

//import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.example.MyProfile.profileService.MyProfileSystemSevice;
import com.example.MyProfile.profileService.MyProfileSystemSevice;
import com.example.MyProfile.profileDomain.profile;

@Controller
public class profilecontroller {
	
	@Autowired
	//private profileService userService;
	private MyProfileSystemSevice userService;
	
	@GetMapping("/login")
	public ModelAndView profile() {
		ModelAndView mav = new ModelAndView("profile");
		mav.addObject("user", new profile());
		return mav;		
	}
	
	@PostMapping("/login")
	public String profile(@ModelAttribute("user") profile user) {
		profile oauthUser = userService.login(user.getUsername(), user.getPassword());
		
		System.out.print(oauthUser);
		if(Objects.nonNull(oauthUser)) {
			return "redirect:/";
		} else {
			return "redirect:/login";
		}
	}
	

	@GetMapping("/signup")
	public ModelAndCreate profile() {
		ModelAndCreate mac = new ModelAndCreate("profile");
		mac.addObject("user", new profile());
		return mac;		
	}
	
	@PostMapping("/signup")
	public String profile(@ModelAttribute("user") profile user) {
		profile oauthUser = userService.login(user.getUser_fname(), user.getUser_lname());
		
		System.out.print(oauthUser);
		if(Objects.nonNull(oauthUser)) {
			return "redirect:/";
		} else {
			return "redirect:/login";
		}
	}
}

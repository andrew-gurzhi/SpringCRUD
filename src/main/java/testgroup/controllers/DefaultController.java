package testgroup.controllers;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import testgroup.security.UserDetailsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

import static org.springframework.security.core.context.SecurityContextHolder.*;

@Controller
public class DefaultController {
	@RequestMapping(value = {"/default"})
	public String defaultAfterLogin() {
		Collection<? extends GrantedAuthority> authorities;
		Authentication authentication = getContext().getAuthentication();
		authorities = authentication.getAuthorities();
		String admin = "admin";

		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals("ADMIN")) {
				return "redirect:/admin/films";
			}
		}
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals("USER")) {
				return "redirect:/user/menu";
			}
		}
		return "redirect:/login";
	}
}
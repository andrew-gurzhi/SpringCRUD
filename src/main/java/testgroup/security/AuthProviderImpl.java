//package testgroup.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import testgroup.dbService.UserService;
//import testgroup.model.Role;
//import testgroup.model.User;
//
//import java.util.ArrayList;
//import java.util.List;
//@Component
//public class AuthProviderImpl implements AuthenticationProvider {
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private UserDetailsServiceImpl userDetailsService;
//
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		String name = authentication.getPrincipal().toString();
//		User user = userService.getUser(name);
//		String pass = authentication.getCredentials().toString();
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		for (Role role:user.getRoles()) {
//		authorities.add(new SimpleGrantedAuthority(role.getType()));
//		}
//		return new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), authorities);
//	}
//
//	@Override
//	public boolean supports(Class<?> aClass) {
//		return aClass.equals(UsernamePasswordAuthenticationToken.class);
//	}
//}

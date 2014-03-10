package springconfig.security;
import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Component;

import antlr.collections.List;

@Component
public class CustomAuthenticationManager implements AuthenticationManager{

	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		
		java.util.List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new CustomGrantedAuthority("ROLE_TELLER"));
		authorities.add(new CustomGrantedAuthority("ROLE_USER"));
		//throw new BadCredentialsException("not authentication");
		
		// TODO Auto-generated method stub
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), authorities);
		
		return token;
	}

}

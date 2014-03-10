package springconfig.security;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
		//these can be populated by the custom user details service, though they don't have to
		//since the auth provider may pull them directly try seeing if user details service 
		//is better injected in security config or here
		java.util.List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new CustomGrantedAuthority("ROLE_TELLER"));
		authorities.add(new CustomGrantedAuthority("ROLE_USER"));
		//throw new BadCredentialsException("not authentication");
		
		// TODO Auto-generated method stub

		
		
		if(authentication.getPrincipal().equals("user") && authentication.getCredentials().equals("password")) {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authentication.getName(), 
					authentication.getCredentials(), authorities);
			return token;
		}
		throw new BadCredentialsException("bad creds");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}

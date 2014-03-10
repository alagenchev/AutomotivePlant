package springconfig.security;

import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3377917929160773615L;
	
	private String _role;
	public CustomGrantedAuthority(String role) {
		_role = role;
	}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return _role;
	}

}

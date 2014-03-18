package services;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
* Implementation of {@link UserDetailsService} which just returns the a new {@link User}
* with username equals the provided username and <code>ROLE_USER</code> as granted authority.
*
* Useful if you don't know the exact username and just want to see if Kerberos works
*
* @author Mike Wiesner
* @since 1.0
* @version $Id$
*/
public class DummyUserDetailsService implements UserDetailsService {


/* (non-Javadoc)
* @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
*/
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
return new User(username, "notUsed", true, true,true,true, AuthorityUtils.createAuthorityList("ROLE_USER"));
}

}
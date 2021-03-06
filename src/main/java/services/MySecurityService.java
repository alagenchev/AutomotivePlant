package services;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("mySecurityService")
public class MySecurityService {
    public boolean hasPermission(String key, Object m) {
    	Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();
        return true;
    }
}
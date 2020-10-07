package com.jobfreelance.config;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class AuthToken extends AbstractAuthenticationToken {

    private final String ucdmId;

    private final String secureToken;

    private AuthToken(String ucdmId, String secureToken, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.ucdmId = ucdmId;
        this.secureToken = secureToken;
        setAuthenticated(true);
    }

    public AuthToken(String ucdmId, String secureToken) {
        this(ucdmId, secureToken, new ArrayList<>());
    }

    public Object getCredentials() {
        return secureToken;
    }

    public Object getPrincipal() {
        return ucdmId;
    }
}

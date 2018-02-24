package com.ccnu.xiahongyun.stmanagementsystem.filter;

import com.ccnu.xiahongyun.stmanagementsystem.model.Root;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class RootAuthentication implements Authentication {
    private final Collection<GrantedAuthority> authorities;
    private Object details;
    private boolean authenticated = false;
    private final Object principal;
    private Object credentials;

    public RootAuthentication(Object principal, Object credentials, Collection<GrantedAuthority> authorities){
        this.principal = principal;
        this.credentials = credentials;

        if (authorities == null) {
            this.authorities = AuthorityUtils.NO_AUTHORITIES;
        } else {
            Iterator var2 = authorities.iterator();

            GrantedAuthority a;
            do {
                if (!var2.hasNext()) {
                    ArrayList<GrantedAuthority> temp = new ArrayList(authorities.size());
                    temp.addAll(authorities);
                    this.authorities = Collections.unmodifiableList(temp);
                    return;
                }

                a = (GrantedAuthority)var2.next();
            } while(a != null);

            throw new IllegalArgumentException("Authorities collection cannot contain any null elements");
        }

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    public void setCredentials(Object credentials){
        this.credentials = credentials;
    }

    @Override
    public Object getDetails() {
        return this.details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }



    @Override
    public Object getPrincipal() {
        return this.principal;
    }


    @Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.authenticated = b;
    }

    @Override
    public String getName() {
        if (this.getPrincipal() instanceof Root) {
            return ((Root)this.getPrincipal()).getEmail();
        }else {
            return this.getPrincipal() == null ? "" : this.getPrincipal().toString();
        }
    }
}

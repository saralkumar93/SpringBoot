package com.smart.config;



import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smart.entities.User;

public class CustomUserDetails implements UserDetails {
	
	private User user;
	
	

	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	//@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());
		
		//edit by internet
		return Collections.singleton(simpleGrantedAuthority);
		
	}

	public String getPassword() {
		
		return user.getPassword();
	}

	public String getUsername() {
		
		return user.getEmail();
	}

	public boolean isAccountNonExpired() {
		
		return true;
	}

	public boolean isAccountNonLocked() {
		
		return true;
	}

	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	public boolean isEnabled() {
		
		return true;
	}

}

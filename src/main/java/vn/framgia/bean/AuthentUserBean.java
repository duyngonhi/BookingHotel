package vn.framgia.bean;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class AuthentUserBean{
	private String userId;
	private String username;
	private String password;
	private Collection<GrantedAuthority> role;

	public AuthentUserBean() {
		super();
	}

	public AuthentUserBean(String userId, String username, String password,
			Collection<GrantedAuthority> role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<GrantedAuthority> getRole() {
		return role;
	}

	public void setRole(Collection<GrantedAuthority> role) {
		this.role = role;
	}

}

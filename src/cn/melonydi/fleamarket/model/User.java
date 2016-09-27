package cn.melonydi.fleamarket.model;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String phoneNumber;
	private String qq;
	private String email;
	private Set<Usercollect> usercollects=new HashSet<Usercollect>();

	// Constructors

	/** default constructor */
	public User() {
	}
	
	public User(String username){
		this.username=username;
	}

	/** full constructor */
	public User(String username, String password, String phoneNumber,
			String qq, String email,Set<Usercollect> usercollects) {
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.qq = qq;
		this.email = email;
		this.usercollects=usercollects;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Usercollect> getUsercollects() {
		return usercollects;
	}

	public void setUsercollects(Set<Usercollect> usercollects) {
		this.usercollects = usercollects;
	}

}
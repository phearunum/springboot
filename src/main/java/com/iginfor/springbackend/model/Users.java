package com.iginfor.springbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="sys_user")
public class Users {

	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public String getCreate_on() {
		return create_on;
	}
	public void setCreate_on(String create_on) {
		this.create_on = create_on;
	}
	public int getCreate_by() {
		return create_by;
	}
	public void setCreate_by(int create_by) {
		this.create_by = create_by;
	}
	public void set_id(int _id) {
		this._id = _id;
	}

	 private int _id;
	 private String first_name;
	 private String last_name;
	 private String sex;
	 private String address;
	 private String username;
	 private String password;
	 private boolean is_active;
	 private String create_on;
	 private int create_by;

	public Users() {

	}

	public Users(int _id, String first_name, String last_name, String sex, String address, String username,
			String password, boolean is_active, String create_on, int create_by) {
		super();
		this._id = _id;
		this.first_name = first_name;
		this.last_name	=last_name;
		this.sex		=sex;
		this.address	=address;
		this.username = username;
		this.password = password;
		this.is_active = is_active;
		this.create_on = create_on;
		this.create_by = create_by;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int get_id() {
		return _id;
	}
}

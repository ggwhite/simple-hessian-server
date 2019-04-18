package lab.ggw.shs.service;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 5096635048865722217L;

	public String name;
	
	public String email;
	
	public User father;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getFather() {
		return father;
	}

	public void setFather(User father) {
		this.father = father;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", father=" + father + "]";
	}
	
}

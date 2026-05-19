package ar.edu.unlp.oo2.persitencia;

import java.util.*;

public class ProxyUser implements PersistableUser {
	
	private User usuarioReal;

	public ProxyUser(String name, String email) {
		super();
		this.usuarioReal = new User(name, email);
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.usuarioReal.getUsername();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return this.usuarioReal.getEmail();
	}

	@Override
	public List<Post> getPosts() {
		return new ArrayList<Post>();
	}


}

package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import pe.edu.upc.entity.Artist;
import pe.edu.upc.entity.RolA;
import pe.edu.upc.entity.UserA;
import pe.edu.upc.serviceinterface.IRolServiceA;
import pe.edu.upc.serviceinterface.IartistService;


@Named
@ViewScoped
public class registerControllerA implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IartistService aS;

	@Inject
	private IRolServiceA rS;

	private Artist artist;
	private UserA userA;
	private String mensaje;

	@PostConstruct
	public void init() {
		this.artist = new Artist();
		this.userA = new UserA();
	}

	public String registerUserA() {
		String redirect = null;
		try {
			String password = this.userA.getPasswordA();
			String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
			this.userA.setPasswordA(passwordHash);
			this.userA.setStateA("A");
			this.artist.setUser(userA);;
			this.userA.setArtist(artist);;
			this.aS.insert(artist);

			List<RolA> roles = new ArrayList<RolA>();
			int TIPO_USUARIO = 4;
			RolA r = new RolA();
			r.setIdA(TIPO_USUARIO);
			roles.add(r);
			rS.assignRolesToUserA(userA, roles);
			redirect = "indexA?faces-redirect=true";
			mensaje =  "User has been created";
		} catch (Exception e) {
			mensaje = "User has not been created";
		}

		return redirect;
	}


	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public UserA getUserA() {
		return userA;
	}

	public void setUserA(UserA userA) {
		this.userA = userA;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}

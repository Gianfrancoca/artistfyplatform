package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usersA")
public class UserA implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int idA;

	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "idArtist", nullable = false)
	private Artist artist;

	@Column(name = "username", nullable = false, length = 30)
	private String usernameA;

	@Column(name = "password", nullable = false, length = 80)
	private String passwordA;

	@Column(name = "state", nullable = false, length = 1)
	private String stateA;

	public int getIdA() {
		return idA;
	}

	public void setIdA(int idA) {
		this.idA = idA;
	}


	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getPasswordA() {
		return passwordA;
	}

	public void setPasswordA(String passwordA) {
		this.passwordA = passwordA;
	}

	public String getStateA() {
		return stateA;
	}

	public void setStateA(String stateA) {
		this.stateA = stateA;
	}

	public String getUsernameA() {
		return usernameA;
	}

	public void setUsernameA(String usernameA) {
		this.usernameA = usernameA;
	}



}

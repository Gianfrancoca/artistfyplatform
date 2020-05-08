package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_rolesA")
public class UserRolA implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idA;

	@ManyToOne
	@JoinColumn(name = "userA_id", nullable = false)
	private UserA userA;

	@ManyToOne
	@JoinColumn(name = "rolA_id", nullable = false)
	private RolA rolA;

	public int getIdA() {
		return idA;
	}

	public void setIdA(int idA) {
		this.idA = idA;
	}

	public UserA getUserA() {
		return userA;
	}

	public void setUserA(UserA userA) {
		this.userA = userA;
	}

	public RolA getRolA() {
		return rolA;
	}

	public void setRolA(RolA rolA) {
		this.rolA = rolA;
	}

}

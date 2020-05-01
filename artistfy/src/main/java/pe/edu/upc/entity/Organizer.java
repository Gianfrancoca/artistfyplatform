package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Organizer")
public class Organizer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrganizer;
	
	@Column(name="firstName", nullable = false, length =50)
	private String firstName;
	
	@Column(name="lastName", nullable = false, length =50)
	private String lastName;
	
	private long dni;
	
	@Column(name="email", nullable = false, length =50)
	private String email;
	
	private long phone;

	//Constructores
	
	public Organizer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organizer(int idOrganizer, String firstName, String lastName, long dni, String email, long phone) {
		super();
		this.idOrganizer = idOrganizer;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.email = email;
		this.phone = phone;
	}

	//Get y set
	
	public int getIdOrganizer() {
		return idOrganizer;
	}

	public void setIdOrganizer(int idOrganizer) {
		this.idOrganizer = idOrganizer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	
}

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
@Table(name = "Contract")
public class Contract implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContract;
	
	@ManyToOne
	@JoinColumn(name = "idArtist", nullable=false)
	private Artist artist;

	private String descriptionContract;
	
	
	private Double salary;
	
	
	private String address;
	
	
	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Contract(int idContract, Artist artist, String descriptionContract, Double salary, String address) {
		super();
		this.idContract = idContract;
		this.artist = artist;
		this.descriptionContract = descriptionContract;
		this.salary = salary;
		this.address = address;
	}


	public int getIdContract() {
		return idContract;
	}


	public void setIdContract(int idContract) {
		this.idContract = idContract;
	}


	public Artist getArtist() {
		return artist;
	}


	public void setArtist(Artist artist) {
		this.artist = artist;
	}


	public String getDescriptionContract() {
		return descriptionContract;
	}


	public void setDescriptionContract(String descriptionContract) {
		this.descriptionContract = descriptionContract;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	
	

	
	

}

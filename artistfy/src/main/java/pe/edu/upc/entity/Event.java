package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Event")
public class Event implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvent;
	
	@ManyToOne
	@JoinColumn(name = "idOrganizer",nullable=false)
	private Organizer organizer;
	
	
	@Column(name = "name", nullable=false , length = 50)
	private String name;
	
	@Column(name = "description", nullable=false , length = 50)
	private String description;
	
	@Column(name = "requeriments", nullable=false , length = 50)
	private String requeriments;
	
	private Double offeredSalary;
	
	private Date scheduleAt;
	
	//constructores

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(int idEvent, Organizer organizer, String name, String description, String requeriments,
			Double offeredSalary, Date scheduleAt) {
		super();
		this.idEvent = idEvent;
		this.organizer = organizer;
		this.name = name;
		this.description = description;
		this.requeriments = requeriments;
		this.offeredSalary = offeredSalary;
		this.scheduleAt = scheduleAt;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequeriments() {
		return requeriments;
	}

	public void setRequeriments(String requeriments) {
		this.requeriments = requeriments;
	}

	public Double getOfferedSalary() {
		return offeredSalary;
	}

	public void setOfferedSalary(Double offeredSalary) {
		this.offeredSalary = offeredSalary;
	}

	public Date getScheduleAt() {
		return scheduleAt;
	}

	public void setScheduleAt(Date scheduleAt) {
		this.scheduleAt = scheduleAt;
	}

	
	
	
}

package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Event;
import pe.edu.upc.serviceinterface.IeventService;

@Named
@RequestScoped
public class eventController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IeventService iService;
	
	private Event e;
	List<Event> listaEvent;
	
	//constructor
	@PostConstruct
	public void init() {
		this.listaEvent=new ArrayList<Event>();
		this.e=new Event();
		this.list();
	}
	
	//Metodos
	
	public String newEvent() {
		this.setE(new Event());
		return "event.xhtml";
	}
	
	public void insert() {
		try {
			iService.insert(e);
			cleanEvent();
			this.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void list() {
		try {
			listaEvent=iService.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void cleanEvent() {
		this.init();
	}
	
	public Event getE() {
		return e;
	}

	public void setE(Event e) {
		this.e = e;
	}

	public List<Event> getListaEvent() {
		return listaEvent;
	}

	public void setListaEvent(List<Event> listaEvent) {
		this.listaEvent = listaEvent;
	}
	
	

}

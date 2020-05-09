package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Artist;
import pe.edu.upc.entity.Contract;
import pe.edu.upc.serviceinterface.IartistService;
import pe.edu.upc.serviceinterface.IcontractService;

@Named
@RequestScoped
public class contractController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IcontractService iService;
	
	@Inject
	private IartistService aService;

	private String mensaje;
	private String mensajeUp;
	
	private Contract c;
	private Artist a;
	
	List<Contract> listaContract;
	List<Artist> listaArtist;
	
	@PostConstruct
	public void init() {
		this.listaContract = new ArrayList<Contract>();
		this.listaArtist= new ArrayList<Artist>();
		this.c=new Contract();
		this.a=new Artist();
		this.list();
		this.listA();
	}
	
	public String newContract() {
		this.setC(new Contract());
		return "contract.xhtml";
	}
	
	public String newContractO() {
		this.setC(new Contract());
		return "contractO.xhtml";
	}
	
	public void insert() {
		try {
			iService.insert(c);
			cleanContract();
			this.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("insertar");
		}
	}
	
	public void list() {
		try {
			listaContract = iService.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void listA() {
		try {
			listaArtist=aService.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	
	public void delete(Contract co) {
		try {
			iService.delete(co.getIdContract());
			list();
			mensaje="Contract has beeen deleted";
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void update() {
		try {
			iService.update(this.c);
			cleanContract();
			this.list();
			mensajeUp="Contract has been updated";
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public String Modifpre(Contract co) {
		this.setC(co);
		return "contractMod.xhtml";
	}
	
	public void cleanContract() {
		this.init();
	}

	public Contract getC() {
		return c;
	}

	public void setC(Contract c) {
		this.c = c;
	}

	public List<Contract> getListaContract() {
		return listaContract;
	}

	public void setListaContract(List<Contract> listaContract) {
		this.listaContract = listaContract;
	}

	public Artist getA() {
		return a;
	}

	public void setA(Artist a) {
		this.a = a;
	}

	public List<Artist> getListaArtist() {
		return listaArtist;
	}

	public void setListaArtist(List<Artist> listaArtist) {
		this.listaArtist = listaArtist;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensajeUp() {
		return mensajeUp;
	}

	public void setMensajeUp(String mensajeUp) {
		this.mensajeUp = mensajeUp;
	}
	
	
	
}

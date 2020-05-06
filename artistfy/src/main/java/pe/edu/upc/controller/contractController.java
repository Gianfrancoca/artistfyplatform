package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Contract;
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

	private Contract c;
	
	List<Contract> listaContract;
	
	@PostConstruct
	public void init() {
		this.listaContract = new ArrayList<Contract>();
		this.c=new Contract();
		this.list();
	}
	
	public String newContract() {
		this.setC(new Contract());
		return "contract.xhtml";
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
	
	public void delete(Contract co) {
		try {
			iService.delete(co.getIdContract());
			list();
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
	
	
	
}

package pe.edu.upc.controller;


import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.User;
import pe.edu.upc.entity.UserRol;
import pe.edu.upc.serviceinterface.IRolService;

@Named
@ViewScoped
public class masterController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IRolService rS;

	public void verificarSesion() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			User us = (User) context.getExternalContext().getSessionMap().get("user");
			
			if(us == null) {
				context.getExternalContext().redirect("index.xhtml");
			}else {
				//verificacion de roles
				String viewId = context.getViewRoot().getViewId();
				boolean rpta = this.verificarMenu(viewId);
				
				if(!rpta) {
					context.getExternalContext().redirect("./403.xhtml");
				}
			}			
		} catch (Exception e) {

		}
	}
	
	public boolean verificarMenu(String viewId) throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		User us = (User) context.getExternalContext().getSessionMap().get("user");

		List<UserRol> roles = rS.findUserRolesByUser(us);

		String rol = "";
		switch (viewId) {
		case "/organizer.xhtml":
			rol = "ADMIN,ORGANIZER";
			break;
		case "/listOrganizer.xhtml":
			rol = "ADMIN";
			break;
		case "/event.xhtml":
			rol = "ADMIN,ORGANIZER";
			break;
		case "/listEvent.xhtml":
			rol = "ADMIN";
			break;	
		case "/panel.xhtml":
			rol = "ADMIN,ORGANIZER";
			break;	
		case "/contract.xhtml":
			rol = "ADMIN,ORGANIZER";
			break;
		case "/listContract.xhtml":
			rol = "ADMIN";
			break;
		case "/listContractO.xhtml":
			rol = "USER,ORGANIZER";
			break;
		case "/artist.xhtml":
			rol = "ADMIN";
			break;
		case "/listArtist.xhtml":
			rol = "ADMIN";
			break;	
		case "/listArtistO.xhtml":
			rol = "ORGANIZER";
			break;	
		case "/listOrganizerO.xhtml":
			rol = "ORGANIZER";
			break;
		case "/listEventO.xhtml":
			rol = "ORGANIZER";
			break;
		case "/artistMod.xhtml":
			rol = "ADMIN";
			break;	
		case "/contractMod.xhtml":
			rol = "ADMIN,ORGANIZER";
			break;	
		case "/eventMod.xhtml":
			rol = "ADMIN,ORGANIZER";
			break;
		case "/organizerMod.xhtml":
			rol = "ADMIN";
			break;
		default:
			break;
		}

		String arreglo[] = rol.split(",");

		int[] iarr = { 0 };
		roles.forEach(r -> {
			for (String x : arreglo) {
				if (r.getRol().getType().equals(x)) {
					iarr[0]++;
				}
			}
		});

		// System.out.println(iarr[0]);
		if (iarr[0] == 0) {
			return false;
		}
		return true;
	}
	
	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}

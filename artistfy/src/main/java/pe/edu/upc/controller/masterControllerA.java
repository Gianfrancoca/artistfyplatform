package pe.edu.upc.controller;


import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.UserA;
import pe.edu.upc.entity.UserRolA;
import pe.edu.upc.serviceinterface.IrolServiceA;

@Named
@ViewScoped
public class masterControllerA implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IrolServiceA rS;

	public void verificarSesionA() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			UserA us = (UserA) context.getExternalContext().getSessionMap().get("userA");
			
			if(us == null) {
				context.getExternalContext().redirect("indexA.xhtml");
			}else {
				//verificacion de roles
				String viewId = context.getViewRoot().getViewId();
				boolean rpta = this.verificarMenuA(viewId);
				
				if(!rpta) {
					context.getExternalContext().redirect("./403.xhtml");
				}
			}			
		} catch (Exception e) {

		}
	}
	
	public boolean verificarMenuA(String viewId) throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		UserA us = (UserA) context.getExternalContext().getSessionMap().get("userA");

		List<UserRolA> roles = rS.findUserRolesByUserA(us);

		String rol = "";
		switch (viewId) {
		case "/listEventA.xhtml":
			rol = "ADMIN,USER,ARTIST";
			break;	
		case "/panelA.xhtml":
			rol = "ADMIN,USER,ARTIST";
			break;
		case "/listContractA.xhtml":
			rol = "ADMIN,USER,ARTIST";
			break;	
		
		default:
			break;
		}

		String arreglo[] = rol.split(",");

		int[] iarr = { 0 };
		roles.forEach(r -> {
			for (String x : arreglo) {
				if (r.getRolA().getTypeA().equals(x)) {
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

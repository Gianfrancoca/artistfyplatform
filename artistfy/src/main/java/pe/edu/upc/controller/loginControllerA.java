package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.UserA;
import pe.edu.upc.serviceimpl.UserServiceImplA;

@Named
@ViewScoped
public class loginControllerA implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserServiceImplA uS;

	private UserA userA;

	@PostConstruct
	public void init() {
		this.userA = new UserA();
	}

	public String authenticationA() {
		String redirect = null;

		try {
			Optional<UserA> userFound = this.uS.authenticationA(userA);

			if (userFound.isPresent() && userFound.get().getStateA().equalsIgnoreCase("A")) {
				// Almacenar en la sesi�n de JSF
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userA", userFound.get());
				redirect = "/panelA?faces-redirect=true";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return redirect;
	}

	public UserA getUserA() {
		return userA;
	}

	public void setUser(UserA userA) {
		this.userA = userA;
	}

}

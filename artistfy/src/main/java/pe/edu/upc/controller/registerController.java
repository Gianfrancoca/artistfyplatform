package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import pe.edu.upc.entity.Organizer;
import pe.edu.upc.entity.Rol;
import pe.edu.upc.entity.User;
import pe.edu.upc.serviceinterface.IRolService;
import pe.edu.upc.serviceinterface.IorganizerService;

@Named
@ViewScoped
public class registerController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	//private ICustomerService cS;
	private IorganizerService oS;
	
	@Inject
	private IRolService rS;

	//private Customer customer;
	private User user;
	private Organizer organizer;
	
	@PostConstruct
	public void init() {
		//this.customer = new Customer();
		this.user = new User();
		this.organizer=new Organizer();
	}

	public String registerUser() {
		String redirect = null;
		try {
			String password = this.user.getPassword();
			String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
			this.user.setPassword(passwordHash);
			this.user.setState("A");
			this.organizer.setUser(user);
			this.user.setOrganizer(organizer);
			//this.user.setCustomer(customer);
			this.oS.insert(organizer);
//			this.cS.insert(customer);

			List<Rol> roles = new ArrayList<Rol>();
			int TIPO_USUARIO = 3;
			Rol r = new Rol();
			r.setId(TIPO_USUARIO);
			roles.add(r);
			rS.assignRolesToUser(user, roles);
			redirect = "index?faces-redirect=true";
		} catch (Exception e) {

		}

		return redirect;
	}


	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

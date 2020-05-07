package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Artist")
public class Artist implements Serializable{

	private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idArtist;
		
		@Column(name = "firstName",nullable = false, length=50)
		private String firstName;
		
		@Column(name = "lastName",nullable = false, length=50)
		private String lastName;
		
	    private Long dni;
		
		@Column(name = "email",nullable = false, length=50)
	    private String email;
		
	    private Long phone;
		
	    private String skill;
		
		@Column(name = "genre",nullable = false, length=50)
	    private String genre;
		
		@Column(name = "websiteUrl",nullable = false, length=50)
	    private String websiteUrl;
		
		public Artist() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Artist(int idArtist, String firstName, String lastName, Long dni, String email, Long phone, String skill,
				String genre, String websiteUrl) {
			super();
			this.idArtist = idArtist;
			this.firstName = firstName;
			this.lastName = lastName;
			this.dni = dni;
			this.email = email;
			this.phone = phone;
			this.skill = skill;
			this.genre = genre;
			this.websiteUrl = websiteUrl;
		}

		public int getIdArtist() {
			return idArtist;
		}

		public void setIdArtist(int idArtist) {
			this.idArtist = idArtist;
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

		public Long getDni() {
			return dni;
		}

		public void setDni(Long dni) {
			this.dni = dni;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Long getPhone() {
			return phone;
		}

		public void setPhone(Long phone) {
			this.phone = phone;
		}

		public String getSkill() {
			return skill;
		}

		public void setSkill(String skill) {
			this.skill = skill;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getWebsiteUrl() {
			return websiteUrl;
		}

		public void setWebsiteUrl(String websiteUrl) {
			this.websiteUrl = websiteUrl;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dni == null) ? 0 : dni.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((genre == null) ? 0 : genre.hashCode());
			result = prime * result + idArtist;
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((phone == null) ? 0 : phone.hashCode());
			result = prime * result + ((skill == null) ? 0 : skill.hashCode());
			result = prime * result + ((websiteUrl == null) ? 0 : websiteUrl.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Artist other = (Artist) obj;
			if (dni == null) {
				if (other.dni != null)
					return false;
			} else if (!dni.equals(other.dni))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (genre == null) {
				if (other.genre != null)
					return false;
			} else if (!genre.equals(other.genre))
				return false;
			if (idArtist != other.idArtist)
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (phone == null) {
				if (other.phone != null)
					return false;
			} else if (!phone.equals(other.phone))
				return false;
			if (skill == null) {
				if (other.skill != null)
					return false;
			} else if (!skill.equals(other.skill))
				return false;
			if (websiteUrl == null) {
				if (other.websiteUrl != null)
					return false;
			} else if (!websiteUrl.equals(other.websiteUrl))
				return false;
			return true;
		}
		
		
		
}

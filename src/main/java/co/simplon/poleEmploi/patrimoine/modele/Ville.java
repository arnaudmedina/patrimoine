package co.simplon.poleEmploi.patrimoine.modele;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

//@Embeddable
@Entity
@Table (name="CITIES")
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="NAME")
	private String nom;

	@Column(name="LATITUDE")
	private double latitude;
	
	@Column(name="LONGITUDE")
	private double longitude;
	
	@OneToMany (mappedBy = "ville", cascade={CascadeType.ALL})
//	@JoinColumn(name="CITIES_ID")
	private Set<Monument> monuments;
	
	public Ville() {
	}

	public Ville ( String nom, double latitude, double longitude) {
		setNom(nom);
		setLatitude(latitude);
		setLongitude(longitude);
		monuments = new HashSet<Monument>();
	}
	
	public Ville ( long id, String nom, double latitude, double longitude) {
		this(nom, latitude, longitude);
		setId(id);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String toString(){
		return ( getNom() + " : " + getLatitude() + " , " + getLongitude()	);
		}

	public Set<Monument>  getMonuments() {
		return this.monuments;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((monuments == null) ? 0 : monuments.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Ville other = (Ville) obj;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (monuments == null) {
			if (other.monuments != null)
				return false;
		} else if (!monuments.equals(other.monuments))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
}
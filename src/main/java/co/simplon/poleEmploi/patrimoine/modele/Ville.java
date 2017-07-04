package co.simplon.poleEmploi.patrimoine.modele;

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
}
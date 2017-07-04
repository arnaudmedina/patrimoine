package co.simplon.poleEmploi.patrimoine.modele;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the MONUMENTS database table.
 * 
 */
@Entity
@Table(name = "MONUMENTS")
@NamedQuery(name = "Monument.findAll", query = "SELECT m FROM Monument m")
public class Monument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name = "CITIES_ID")
	private int citiesId;

	private String name;

	@ManyToOne
	private Ville cities;

	public Monument() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCitiesId() {
		return this.citiesId;
	}

	public void setCitiesId(int citiesId) {
		this.citiesId = citiesId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ville getVille() {
		return cities;
	}

	public void setVille(Ville ville) {
		this.cities = ville;
	}

	public String toString() {
		return this.name + " - " + cities.toString();
	}

}
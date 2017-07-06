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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
 	private Long identifiant;

//	@Column(name = "CITIES_ID", nullable = false, insertable = false, updatable = false)
//	private long citiesId;

	@Column(name = "NAME", nullable = false, length = 100)
 	private String nom;

	@ManyToOne
	@JoinColumn(name="CITIES_ID")
	private Ville ville;

	public Monument() {
	}
	
	public Monument(String name) {
		setName(name);
	}

	public long getId() {
		return this.identifiant;
	}

	public void setId(long id) {
		this.identifiant = id;
	}

//	public long getCitiesId() {
//		return this.citiesId;
//	}
//
//	public void setCitiesId(long l) {
//		this.citiesId = l;
//	}

	public String getName() {
		return this.nom;
	}

	public void setName(String name) {
		this.nom = name;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public String toString() {
		return this.nom + " - " + ville.toString();
	}

}
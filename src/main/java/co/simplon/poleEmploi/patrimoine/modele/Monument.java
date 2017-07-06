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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifiant == null) ? 0 : identifiant.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Monument other = (Monument) obj;
		if (identifiant == null) {
			if (other.identifiant != null) {
				return false;
			}
		} else if (!identifiant.equals(other.identifiant)) {
			return false;
		}
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}
		if (ville == null) {
			if (other.ville != null) {
				return false;
			}
		} else if (!ville.equals(other.ville)) {
			return false;
		}
		return true;
	}

}
/**
 * 
 */
package entites;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author antPinot
 *
 */

@Entity
@Table
public class Client {

	@ManyToOne
	@JoinColumn(name = "ID_BANQUE")
	private Banque banque;

	@ManyToMany
	@JoinTable(name = "CLIENT_COMPTE", joinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_COM", referencedColumnName = "ID"))
	private Set<Compte> comptes;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NOM", length = 100, nullable = false, unique = false)
	private String nom;

	@Column(name = "PRENOM", length = 100, nullable = false, unique = false)
	private String prenom;

	@Column(name = "DATE_NAISSANCE", length = 30, nullable = false, unique = false)
	private LocalDate dateNaissance;

	@Embedded
	private Adresse adresse;

	/**Constructeur
	 * 
	 */
	public Client() {
	}
	
	

	/**Constructeur
	 * @param banque
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param adresse
	 */
	public Client(Banque banque, String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
		this.banque = banque;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}



	/**Getter pour l'attribut banque
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**Setter pour l'attribut banque
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/**Getter pour l'attribut comptes
	 * @return the comptes
	 */
	public Set<Compte> getComptes() {
		return comptes;
	}

	/**Setter pour l'attribut comptes
	 * @param comptes the comptes to set
	 */
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	/**Getter pour l'attribut id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**Setter pour l'attribut id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Getter pour l'attribut nom
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**Setter pour l'attribut nom
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**Getter pour l'attribut prenom
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**Setter pour l'attribut prenom
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**Getter pour l'attribut dateNaissance
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**Setter pour l'attribut dateNaissance
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**Getter pour l'attribut adresse
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**Setter pour l'attribut adresse
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}

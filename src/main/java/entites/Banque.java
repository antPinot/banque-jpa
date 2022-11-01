/**
 * 
 */
package entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author antPinot
 *
 */

@Entity
@Table
public class Banque {
	
	@OneToMany(mappedBy = "banque")
	private Set<Client> clients;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOM", length = 100, nullable = false, unique = false)
	private String nom;

	/**Constructeur
	 * 
	 */
	public Banque() {
		this.clients = new HashSet<Client>();
	}

	@Override
	public String toString() {
		return "Banque [clients=" + clients + ", id=" + id + ", nom=" + nom + "]";
	}

	/**Getter pour l'attribut clients
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/**Setter pour l'attribut clients
	 * @param clients the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
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
	

}

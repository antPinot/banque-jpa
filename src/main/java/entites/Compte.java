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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author antPinot
 *
 */

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {
	
	@OneToMany(mappedBy = "compte")
	private Set<Operation> operations;
	
	@ManyToMany
	@JoinTable(name = "CLIENT_COMPTE", joinColumns = @JoinColumn(name = "ID_COM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID"))
	private Set<Client> clients;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NUMERO", length = 30, nullable = true, unique = true)
	private String numero;
	
	@Column(name = "SOLDE", length = Integer.MAX_VALUE, nullable = true, unique = false)
	private double solde;

	/**Constructeur
	 * 
	 */
	public Compte() {
		this.operations = new HashSet<Operation>();
	}
	
	/**Constructeur
	 * @param numero
	 * @param solde
	 */
	public Compte(String numero, double solde) {
		this.numero = numero;
		this.solde = solde;
		this.operations = new HashSet<Operation>();
	}

	public void addClient(Client client) {
		this.clients.add(client);
	}

	/**Getter pour l'attribut operations
	 * @return the operations
	 */
	public Set<Operation> getOperations() {
		return operations;
	}

	/**Setter pour l'attribut operations
	 * @param operations the operations to set
	 */
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
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

	/**Getter pour l'attribut numero
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**Setter pour l'attribut numero
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**Getter pour l'attribut solde
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**Setter pour l'attribut solde
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

}

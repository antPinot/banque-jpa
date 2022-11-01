/**
 * 
 */
package entites;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author antPinot
 *
 */

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {
	
	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	private Compte compte;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "DATE", length = 30, nullable = false, unique = false)
	private LocalDateTime date;
	
	@Column(name = "MONTANT", length = Integer.MAX_VALUE, nullable = true, unique = false)
	private double montant;
	
	@Column(name = "MOTIF", length = 255, nullable = true, unique = false)
	private String motif;

	/**Constructeur
	 * 
	 */
	public Operation() {
	}
	

	/**Constructeur
	 * @param compte
	 * @param date
	 * @param montant
	 * @param motif
	 */
	public Operation(Compte compte, LocalDateTime date, double montant, String motif) {
		this.compte = compte;
		this.date = date;
		this.montant = montant;
		this.motif = motif;
	}

	/**Getter pour l'attribut compte
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**Setter pour l'attribut compte
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
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

	/**Getter pour l'attribut date
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**Setter pour l'attribut date
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**Getter pour l'attribut montant
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}

	/**Setter pour l'attribut montant
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**Getter pour l'attribut motif
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**Setter pour l'attribut motif
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

}

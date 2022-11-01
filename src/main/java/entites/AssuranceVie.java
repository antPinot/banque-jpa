/**
 * 
 */
package entites;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author antPinot
 *
 */

@Entity
public class AssuranceVie extends Compte {
	
	@Column(name = "DATE_FIN", length = 30, nullable = false, unique = false)
	private LocalDate dateFin;
	
	@Column(name="TAUX", length = Integer.MAX_VALUE, nullable = true, unique = false)
	private double taux;
	
	public AssuranceVie() {
	}

	/**Constructeur
	 * @param numero
	 * @param solde
	 */
	public AssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
		super(numero, solde);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	/**Getter pour l'attribut dateFin
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**Setter pour l'attribut dateFin
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**Getter pour l'attribut taux
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**Setter pour l'attribut taux
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}

}

/**
 * 
 */
package entites;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author antPinot
 *
 */

@Entity
public class LivretA extends Compte {

	@Column(name = "TAUX", length = Integer.MAX_VALUE, nullable = true, unique = false)
	private double taux;
	
	public LivretA() {
	}

	/**
	 * Constructeur
	 * 
	 * @param numero
	 * @param solde
	 */
	public LivretA(String numero, double solde, double taux) {
		super(numero, solde);
		this.taux = taux;
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

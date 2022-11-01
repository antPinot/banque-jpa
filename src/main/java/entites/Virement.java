package entites;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Virement extends Operation {
	
	@Column(name="BENEFICIAIRE", length = 255, nullable = false, unique = false)
	private String beneficiaire;

	/**Constructeur
	 * 
	 */
	public Virement() {
	}

	/**Constructeur
	 * @param compte
	 * @param date
	 * @param montant
	 * @param motif
	 */
	public Virement(Compte compte, LocalDateTime date, double montant, String motif, String beneficiaire) {
		super(compte, date, montant, motif);
		this.beneficiaire = beneficiaire;
	}

	/**Getter pour l'attribut beneficiaire
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/**Setter pour l'attribut beneficiaire
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	

}

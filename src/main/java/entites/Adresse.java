/**
 * 
 */
package entites;

import javax.persistence.Embeddable;

/**
 * @author antPinot
 *
 */

@Embeddable
public class Adresse {
	
	private Integer numero;
	
	private String rue;
	
	private String ville;

	/**Constructeur
	 * @param numero
	 * @param rue
	 * @param ville
	 */
	
	public Adresse(Integer numero, String rue, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
	}

	/**Constructeur
	 * 
	 */
	public Adresse() {
	}
	
	

}

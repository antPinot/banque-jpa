import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entites.Adresse;
import entites.AssuranceVie;
import entites.Banque;
import entites.Client;
import entites.Compte;
import entites.LivretA;
import entites.Operation;
import entites.Virement;

/**
 * 
 */

/**
 * @author antPinot
 *
 */
public class ConnexionBanque {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		Banque societeGenerale = new Banque();
		Banque lcl = new Banque();
		Banque caisseEpargne = new Banque();

		societeGenerale.setNom("Société Générale");
		lcl.setNom("LCL");
		caisseEpargne.setNom("Caisse d'Epargne");

		List<Banque> banques = new ArrayList<Banque>(Arrays.asList(societeGenerale, lcl, caisseEpargne));

		for (Banque etablissements : banques) {
			em.persist(etablissements);
		}

		Client jeromeKerviel = new Client();
		jeromeKerviel.setDateNaissance(LocalDate.of(1977, 1, 11));
		jeromeKerviel.setNom("Kerviel");
		jeromeKerviel.setPrenom("Jérome");
		jeromeKerviel.setAdresse(new Adresse(7, "Avenue des Peupliers", "Fleury-Mérogis"));
		jeromeKerviel.setBanque(societeGenerale);;
		
		Client bernardTapie = new Client();
		bernardTapie.setDateNaissance(LocalDate.of(1943, 1, 26));
		bernardTapie.setNom("Tapie");
		bernardTapie.setPrenom("Bernard");
		bernardTapie.setAdresse(new Adresse(239, "Chemin de Morgiou", "Marseille"));
		bernardTapie.setBanque(lcl);
		
		Client albertSpaggiari = new Client(societeGenerale, "Spaggiari", "Albert", LocalDate.of(1932, 12, 14), new Adresse(8, "Avenue Jean Médecin", "Nice"));
		
		List<Client> clients = new ArrayList<Client>(Arrays.asList(jeromeKerviel, bernardTapie, albertSpaggiari));
		
		for (Client personnages : clients) {
			em.persist(personnages);
		}
		
		Compte livretA = new LivretA("3569764123586", 2500000, 2.5);
		
		Compte assuranceVie = new AssuranceVie("14841844841", 460000825, LocalDate.of(2222, 5, 14), 3);
		
		Set<Client> clientsACreer = new HashSet<Client>();
		clientsACreer.add(albertSpaggiari);
		clientsACreer.add(jeromeKerviel);
		
		livretA.setClients(clientsACreer);
		
		em.persist(livretA);
		em.persist(assuranceVie);
		
		Set<Compte> comptesNanard = new HashSet<Compte>();
		comptesNanard.add(livretA);
		comptesNanard.add(assuranceVie);
		
		bernardTapie.setComptes(comptesNanard);
		
		em.merge(bernardTapie);
		
		
		Client nanardQuery = em.find(Client.class, bernardTapie.getId());
		
		Set<Compte> nanardComptes = nanardQuery.getComptes();
		
		double totalComptesNanard = 0;
		for (Compte comptes : nanardComptes) {
			totalComptesNanard += comptes.getSolde();
		}
		
		System.out.println("Le total des comptes de B. Tapie est " + totalComptesNanard);
		
		Virement magouille = new Virement(assuranceVie, LocalDateTime.now(), 2650.00, "Magouille", "Jérôme Kerviel");
		
		Operation corruption = new Operation(livretA, LocalDateTime.now(), 1247.56, "Corruption");
		
		em.persist(magouille);
		em.persist(corruption);
		
		transaction.commit();

	}

}

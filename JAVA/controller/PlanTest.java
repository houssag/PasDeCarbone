package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;
import org.junit.Test;


public class PlanTest {
  /** Classe de test. **/

  /** Création de particulier. **/
  @Test
  public void creationUtilisateur() {
    // Important
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Particulier p2 = new Particulier("Diego", "mdp2", "Roger", "Lenoir", "", "Roger@mail.fr");


    assertEquals("Erreur nom ne correspond pas", "Leblanc", p1.getNom());
    assertEquals("Erreur prénom ne correspond pas", "Michel", p1.getPrenom());
    assertEquals("Erreur nom ne correspond pas", "Lenoir", p2.getNom());
    assertEquals("Erreur prénom ne correspond pas", "Roger", p2.getPrenom());


    Particulier p3 = null;
    try {
      p3 = new Particulier("", "mdp2", "Roger", "Lenoir", "", "Roger@mail.fr");
      fail("le particulier ne devrait pas pouvoir être créee");
    } catch (Exception e) {
      assert (p3 == null);
    }


    // Important
    Particulier p4 = null;
    try {
      p4 = new Particulier("PseudoP4", null, null, null, null, null);
      fail("le particulier ne devrait pas pouvoir être créee");
    } catch (Exception e) {
      assert (p4 == null);
    }

  }


  /** Création Utilisateur. **/
  @Test
  public void verificationString() {
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");

    assertEquals("Erreur nom ne correspond pas", true, p1.estInvalide("123456"));
    assertEquals("Erreur nom ne correspond pas", false, p1.estInvalide("test"));
    assertEquals("Erreur nom ne correspond pas", true, p1.estInvalide("te123st"));

    // Important
    Particulier p2 = null;
    try {
      p2 = new Particulier("Do&$Martin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
      fail("le particulier ne devrait pas pouvoir être créee");
    } catch (Exception e) {
      assert (p2 == null);
    }

    assertEquals("Erreur le nom contient des caractères spéciaux et n'est pas détécté", true,
        p1.estInvalide("t€e@st"));
  }

  /** Création listeUtilisateur. **/

  @Test
  public void creationListeUtilisateur() {
    // Important
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Particulier p2 = new Particulier("Diego", "mdp2", "Roger", "Lenoir", "", "Roger@mail.fr");
    ListeUtilisateur l1 = new ListeUtilisateur();
    l1.ajouterUtilisateur(p1);
    l1.ajouterUtilisateur(p2);
    assertEquals("Erreur Liste ne correspond pas", "[DonMartin][Diego]", l1.toStringListA());

    // Important
    l1.ajouterUtilisateur(p2);
    assertEquals("Erreur Liste ne correspond pas", "[DonMartin][Diego]", l1.toStringListA());



  }

  @Test
  public void suppressionUtilisateur() {
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Particulier p2 = new Particulier("Diego", "mdp2", "Roger", "Lenoir", "", "Roger@mail.fr");
    ListeUtilisateur l1 = new ListeUtilisateur();
    l1.ajouterUtilisateur(p2);
    l1.ajouterUtilisateur(p1);
    l1.supprimerUtilisateur(p2);
    assertEquals("Erreur Liste ne correspond pas", "[DonMartin]", l1.toStringListA());

  }

  @Test
  public void rechercherUnUtilisateur() {
    ListeUtilisateur l1 = new ListeUtilisateur();
    assertEquals("Erreur Liste ne correspond pas", null, l1.rechercherUtilisateur("Diego"));
    Particulier p2 = new Particulier("Diego", "mdp2", "Roger", "Lenoir", "", "Roger@mail.fr");
    l1.ajouterUtilisateur(p2);
    assertEquals("Erreur Liste ne correspond pas", p2, l1.rechercherUtilisateur("Diego"));
  }

  @Test
  public void utilisateurExiste() {
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    ListeUtilisateur l1 = new ListeUtilisateur();
    assertEquals("Erreur Liste ne correspond pas", false, l1.utilisateurExiste(p1));
    l1.ajouterUtilisateur(p1);
    assertEquals("Erreur Liste ne correspond pas", true, l1.utilisateurExiste(p1));
  }

  @Test
  public void creationEquipement() {

    // Important
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    assertEquals("Le nom de l'équipement n'est pas bon", "Porsche", v1.getNom());

    Voiture v2 = null;
    try {
      v2 = new Voiture("", Voiture.TypeCarburant.Diesel, 12);
      fail("la voiture ne devrait pas pouvoir être créee");
    } catch (Exception e) {
      assert (v2 == null);
    }
    Voiture v3 = null;
    try {
      v3 = new Voiture("P€éééé\"0r€2h€", Voiture.TypeCarburant.Diesel, 12);
      fail("la voiture ne devrait pas pouvoir être créee");
    } catch (Exception e) {
      assert (v3 == null);
    }

    Voiture v44 = new Voiture("Péééér2h", Voiture.TypeCarburant.Diesel, 12);
    assertEquals("Le nom de l'équipement n'est pas bon", "Péééér2h", v44.getNom());



    Voiture v5 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    assertEquals("La valeure du litre par km n'est pas bon", 12.0 + "", v5.getLitresParKm() + "");


    Voiture v4 = null;
    try {
      v4 = new Voiture("P€éééé\"0r€2h€", Voiture.TypeCarburant.Diesel, -15);
      fail("la voiture ne devrait pas pouvoir être créee");
    } catch (Exception e) {
      assert (v4 == null);
    }
  }


  /** Création Train. **/
  @Test
  public void creerTrain() {
    Train t1 = new Train("tchoutchou", Train.TypeTrain.OUIGO);
    assertEquals("Erreur nom ne correspond pas", "tchoutchou", t1.getNom());
    assertEquals("Erreur le type ne correspond pas", Train.TypeTrain.OUIGO, t1.getType());
  }

  @Test
  public void calculerTauxTrain() {
    Train t1 = new Train("tchoutchou", Train.TypeTrain.OUIGO);
    assertEquals("Erreur le taux ne correspond pas", 1.9 + "", t1.calculerTaux() + "");
  }

  /** Création avion. **/
  @Test
  public void creerAvion() {
    Avion a1 = new Avion("avion", true);

    assertEquals("Erreur nom ne correspond pas", "avion", a1.getNom());
    assertEquals("Erreur le type ne correspond pas", true, a1.isEconomique());
  }

  @Test
  public void calculerTauxAvion() {
    Avion a1 = new Avion("avion", true);
    assertEquals("Erreur le taux ne correspond pas", 172.0 + "", a1.calculerTaux() + "");
  }

  @Test
  public void recupererEmissionAvion() {
    assertEquals("Erreur l'emission ne correspond pas", 172.0 + "", Avion.getEmissionParKm() + "");

  }

  @Test
  public void definitEmissionAvion() {
    Avion a1 = new Avion("avion", true);
    a1.setEmissionParKm(173.00f);
    assertEquals("Erreur l'emission ne correspond pas", 173.0 + "", Avion.getEmissionParKm() + "");
    a1.setEmissionParKm(172.0f);
    assertEquals("Erreur l'emission ne correspond pas", 172.0 + "", Avion.getEmissionParKm() + "");
  }


  /** Création voiture. **/
  @Test
  public void creationVoiture() {
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    assertEquals("Erreur le type ne correspond pas", Voiture.TypeCarburant.Diesel + "",
        v1.getCarburant() + "");
    assertEquals("Erreur le nom ne correspond pas", "Porsche" + "", v1.getNom() + "");
    assertEquals("Erreur le litre par km ne correspond pas", 12f + "", v1.getLitresParKm() + "");
  }

  @Test
  public void emissionCarburantVoiture() {
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    assertEquals("Erreur l'émission ne correspond pas", 2640,
        v1.getEmissionCarburant());
  }

  @Test
  public void calculerTauxVoiture() {
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    assertEquals("Erreur taux ne correspond pas", 2640.0 * 12 + "", v1.calculerTaux() + "");
  }

  @Test
  public void setEmissionCarburant() {
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    Voiture.setEmissionCarburant(v1.getCarburant(), 2540);
    assertEquals("Erreur l'émission ne correspond pas", 2540,
        v1.getEmissionCarburant());
    Voiture.setEmissionCarburant(v1.getCarburant(), 2640);
    assertEquals("Erreur l'émission ne correspond pas", 2640,
        v1.getEmissionCarburant());
  }


  /** création Chauffage. **/

  @Test
  public void creationChauffage() {
    Chauffage c1 = new Chauffage("chaud", Chauffage.TypeChauffage.Bois, 15);
    assertEquals("La liste ne correspond pas", "chaud", c1.getNom());
    Chauffage c2 = new Chauffage("chaud", Chauffage.TypeChauffage.Bois, true, false, 15);
    assertEquals("La liste ne correspond pas", "chaud", c2.getNom());


  }

  @Test
  public void calculerTauxChauffage() {
    Chauffage c1 = new Chauffage("chaud", Chauffage.TypeChauffage.Bois, 15);
    assertEquals("La liste ne correspond pas", 15 * 13.0 + "", c1.calculerTaux() + "");


    Chauffage c2 = new Chauffage("chaud", Chauffage.TypeChauffage.Bois, true, false, 15);
    assertEquals("La liste ne correspond pas", 15 * 198.0 + "", c2.calculerTaux() + "");


  }

  /** Création Profil. **/
  @Test
  public void creationProfile() {
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Profil pr1 = new Profil(p1);
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    Voiture v2 = new Voiture("Twingo", Voiture.TypeCarburant.Diesel, 12);
    pr1.ajouterEquipement(v1);
    pr1.ajouterEquipement(v2);

    assertEquals("La liste ne correspond pas", "[Porsche][Twingo]", pr1.toStringListP());
    Voiture v3 = new Voiture("Twingo", Voiture.TypeCarburant.Diesel, 12);
    pr1.ajouterEquipement(v3);
    assertEquals("La liste ne correspond pas", "[Porsche][Twingo]", pr1.toStringListP());
  }

  @Test
  public void rechercheEquipement() {

    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Profil pr1 = new Profil(p1);
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    Voiture v2 = new Voiture("Twingo", Voiture.TypeCarburant.Diesel, 12);
    pr1.ajouterEquipement(v1);
    pr1.ajouterEquipement(v2);

    assertEquals("L'équipement ne correspond pas", v1, pr1.rechercherEquipement("Porsche"));

  }

  @Test
  public void equipementExiste() {
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Profil pr1 = new Profil(p1);
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    Voiture v2 = new Voiture("Twingo", Voiture.TypeCarburant.Diesel, 12);
    pr1.ajouterEquipement(v1);

    assertEquals("L'équipement n'a pas été trouvé", true, pr1.equipementExiste(v1));
    assertEquals("L'équipement a été trouvé alors qu'il devrait pas", false,
        pr1.equipementExiste(v2));

  }


  @Test
  public void supprimerEquipement() {
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Profil pr1 = new Profil(p1);
    Voiture v2 = new Voiture("Twingo", Voiture.TypeCarburant.Diesel, 12);
    pr1.ajouterEquipement(v2);

    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    assertEquals("L'équipement n'a pas été supprimé", false, pr1.supprimerEquipement(v1));
    pr1.ajouterEquipement(v1);
    assertEquals("L'équipement a été supprimé", true, pr1.supprimerEquipement(v1));
    assertEquals("L'équipement est toujours dans la liste", "[Twingo]", pr1.toStringListP());
  }

  /** Création Utilisation. **/

  @Test
  public void creerUtilisation() {
    // Important
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    Utilisation u1 = new Utilisation(8, v1);
    assertEquals("L'équipement ne correspond pas", v1, u1.getUnEquipement());
    assertEquals("L'équipement ne correspond pas", 1, u1.getNbPersonne());
    assertEquals("Le nombre d'utilisation ne correspond pas", 8, u1.getQuantite());

    // Important
    Utilisation u2 = null;
    try {
      u2 = new Utilisation(-8, v1, 2);
      fail("l'utilisation ne devrait pas pouvoir être créee");
    } catch (Exception e) {
      assert (u2 == null);
    }
  }


  /** Creation Consommation Mensuelle. **/
  @Test
  public void ajouterConsommationMensuelle() {
    // Important
    Utilisation u2 = null;
    try {
      u2 = new Utilisation(8, null);
      fail("l'utilisation ne devrait pas pouvoir être créee");
    } catch (Exception e) {
      assert (u2 == null);
    }



    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Profil pr1 = new Profil(p1);
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    Utilisation u1 = new Utilisation(360, v1);
    pr1.ajouterEquipement(v1);

    ConsommationMensuelle cm1 = new ConsommationMensuelle(u1, new Date(System.currentTimeMillis()));
    cm1.ajouterUneUtilisation(u1);
    // assertEquals("L'équipement ne correspond pas", , cm1.get());

  }

  @Test
  public void getUtilisation() {
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Profil pr1 = new Profil(p1);
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    Utilisation u1 = new Utilisation(360, v1);
    pr1.ajouterEquipement(v1);

    ConsommationMensuelle cm1 = new ConsommationMensuelle(u1, new Date(System.currentTimeMillis()));
    cm1.ajouterUneUtilisation(u1);
    assertEquals("L'équipement ne correspond pas", u1, cm1.getUtilisation(v1));
  }

  @Test
  public void calculerConsommation() {
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Profil pr1 = new Profil(p1);
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    Utilisation u1 = new Utilisation(360, v1);
    pr1.ajouterEquipement(v1);
    ConsommationMensuelle cm1 = new ConsommationMensuelle(u1, new Date(System.currentTimeMillis()));
    cm1.ajouterUneUtilisation(u1);
    assertEquals("L'équipement ne correspond pas", 2.28096E7 + "",
        cm1.calculerConsommation() + "");
    Voiture v2 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    pr1.ajouterEquipement(v2);
    cm1.ajouterUneUtilisation(u1);
    assertEquals("L'équipement ne correspond pas", Math.toIntExact(34214400) + "",
        Math.toIntExact((long) cm1.calculerConsommation()) + "");
  }


  /** Creation Consommation. **/
  @SuppressWarnings("deprecation")
  @Test
  public void ajouterConsommation() {
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    Utilisation u1 = new Utilisation(360, v1);

    ConsommationMensuelle m2 = null;
    try {
      Date d1 = new Date(System.currentTimeMillis());
      d1.setYear(d1.getYear() + 300);
      m2 = new ConsommationMensuelle(u1, d1);
      fail("la consommation ne devrait pas pouvoir être créee");
    } catch (Exception e) {
      assert (m2 == null);
    }


    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Profil pr1 = new Profil(p1);
    pr1.ajouterEquipement(v1);

    Consommation c1 = new Consommation(pr1);

    ConsommationMensuelle cm1 = new ConsommationMensuelle(u1, new Date(System.currentTimeMillis()));
    assertEquals("L'équipement ne correspond pas", false, c1.consommationExiste(cm1));

    c1.ajouterConsommation(cm1);
    assertEquals("L'équipement ne correspond pas", true, c1.consommationExiste(cm1));

  }

  @Test
  public void recupereConsommationDate() {
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Profil pr1 = new Profil(p1);
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    Utilisation u1 = new Utilisation(360, v1);
    pr1.ajouterEquipement(v1);

    Consommation c1 = new Consommation(pr1);

    ConsommationMensuelle cm1 = new ConsommationMensuelle(u1, new Date(2020121));
    assertEquals("L'équipement ne correspond pas", null,
        c1.recupererConsommationDate(new Date(2020121)));
    c1.ajouterConsommation(cm1);
    assertEquals("L'équipement ne correspond pas", cm1,
        c1.recupererConsommationDate(new Date(2020121)));
    ConsommationMensuelle cm2 = new ConsommationMensuelle(u1, new Date(25555));
    c1.ajouterConsommation(cm2);
    assertEquals("L'équipement ne correspond pas", cm1,
        c1.recupererConsommationDate(new Date(2020121)));


    assertEquals("L'équipement ne correspond pas", true, c1.consommationExiste(cm1));

  }

  /** Scenario type d'utilisation. **/
  @Test
  public void testScenario() {
    // Important
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Particulier p2 = new Particulier("Diego", "mdp2", "Roger", "Lenoir", "", "Roger@mail.fr");

    ListeUtilisateur l1 = new ListeUtilisateur();
    l1.ajouterUtilisateur(p1);
    l1.ajouterUtilisateur(p2);

    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    Avion a1 = new Avion("avion", true);
    Train t1 = new Train("tchoutchou", Train.TypeTrain.OUIGO);
    Chauffage ch1 = new Chauffage("chaud", Chauffage.TypeChauffage.Bois, 15);

    Utilisation u1 = new Utilisation(1200, v1);
    Utilisation u2 = new Utilisation(360, a1);
    Utilisation u3 = new Utilisation(12, t1);
    Utilisation u4 = new Utilisation(1, ch1);

    ConsommationMensuelle cm1 = new ConsommationMensuelle(u1, new Date(2020121));
    cm1.ajouterUneUtilisation(u3);

    ConsommationMensuelle cm2 = new ConsommationMensuelle(u2, new Date(2020121));
    cm2.ajouterUneUtilisation(u4);

    ConsommationMensuelle cm3 = new ConsommationMensuelle(u1, new Date(2020101));
    cm3.ajouterUneUtilisation(u2);

    ConsommationMensuelle cm4 = new ConsommationMensuelle(u2, new Date(2020101));
    cm4.ajouterUneUtilisation(u1);

    Profil pr1 = new Profil(p1);
    Consommation c1 = new Consommation(pr1);
    c1.ajouterConsommation(cm1);
    c1.ajouterConsommation(cm3);

    Profil pr2 = new Profil(p2);
    Consommation c2 = new Consommation(pr2);
    c2.ajouterConsommation(cm2);
    c2.ajouterConsommation(cm4);
    DecimalFormat df = new DecimalFormat("#.#");
    df.setRoundingMode(RoundingMode.DOWN);

    assertEquals("La consommationMensuelle ne correspond pas",
        (3.8016024E7 + ""),
        (cm1.calculerConsommation() + ""));
    

    assertEquals("La consommationMensuelle ne correspond pas",
        ((62115.0) + ""),
        (cm2.calculerConsommation() + ""));
    assertEquals("La consommationMensuelle ne correspond pas",
        (3.807792E7 + ""),
        (cm3.calculerConsommation() + ""));
    assertEquals("La consommationMensuelle ne correspond pas",
        (3.807792E7 + ""),
        (cm4.calculerConsommation() + ""));

  }

}

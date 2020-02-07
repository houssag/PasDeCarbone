import static org.junit.Assert.assertEquals;
import java.sql.Date;
import org.junit.Test;


public class Main {
  /** Classe de test. **/

  /** Création de particulier. **/
  @Test
  public void creationUtilisateur() {
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Particulier p2 = new Particulier("Diego", "mdp2", "Roger", "Lenoir", "", "Roger@mail.fr");

    assertEquals("Erreur nom ne correspond pas", "Leblanc", p1.getNom());
    assertEquals("Erreur prénom ne correspond pas", "Michel", p1.getPrenom());
    assertEquals("Erreur nom ne correspond pas", "Lenoir", p2.getNom());
    assertEquals("Erreur prénom ne correspond pas", "Roger", p2.getPrenom());

    Particulier p3 = new Particulier("", "mdp2", "Roger", "Lenoir", "", "Roger@mail.fr");

    assertEquals("Erreur pseudo ne correspond pas", null, p3.getPseudo());
    
    p3.setPseudo("LePseudo");
    
    assertEquals("Erreur pseudo ne correspond pas", "LePseudo", p3.getPseudo());
    
    Particulier p4 = new Particulier("PseudoP4", "mdp2", "Roger23", "Lenoir", "", "Roger@mail.fr");
    
    assertEquals("Erreur prenom ne correspond pas", null, p4.getPrenom());


  }

  /** Création Utilisateur. **/
  @Test
  public void verificationString() {
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");

    assertEquals("Erreur nom ne correspond pas", true, p1.estInvalide("123456"));
    assertEquals("Erreur nom ne correspond pas", false, p1.estInvalide("test"));
    assertEquals("Erreur nom ne correspond pas", true, p1.estInvalide("te123st"));
    assertEquals("Erreur le nom contient des caractères spéciaux et n'est pas détécté", true,
        p1.estInvalide("t€e@st"));
  }

  /** Création listeUtilisateur. **/

  @Test
  public void creationListeUtilisateur() {
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Particulier p2 = new Particulier("Diego", "mdp2", "Roger", "Lenoir", "", "Roger@mail.fr");
    ListeUtilisateur l1 = new ListeUtilisateur();
    l1.ajouterUtilisateur(p1);
    l1.ajouterUtilisateur(p2);
    assertEquals("Erreur Liste ne correspond pas", "[DonMartin][Diego]", l1.toStringListA());
    Particulier p3 = new Particulier("Diego", "mdp2", "Roger2", "Lenoi2r", "", "Roger@mail.fr");
    l1.ajouterUtilisateur(p3);
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
    Particulier p2 =
        new Particulier("Do1nMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    l1.ajouterUtilisateur(p2);
    assertEquals("Erreur Liste ne correspond pas", true, l1.utilisateurExiste(p1));
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
    Avion a1 = new Avion("avion", true, 360);

    assertEquals("Erreur nom ne correspond pas", "avion", a1.getNom());
    assertEquals("Erreur le type ne correspond pas", true, a1.isEconomique());
    assertEquals("Erreur la distance ne correspond pas", 360, a1.getDistance());
  }

  @Test
  public void calculerTauxAvion() {
    Avion a1 = new Avion("avion", true, 360);
    assertEquals("Erreur le taux ne correspond pas", 61920.0 + "", a1.calculerTaux() + "");
  }

  @Test
  public void recupererEmissionAvion() {
    Avion a1 = new Avion("avion", true, 360);
    assertEquals("Erreur l'emission ne correspond pas", 172.0 + "", a1.getEmissionParKm() + "");

  }

  @Test
  public void definitEmissionAvion() {
    Avion a1 = new Avion("avion", true, 360);
    a1.setEmissionParKm(173.00f);
    assertEquals("Erreur l'emission ne correspond pas", 173.0 + "", a1.getEmissionParKm() + "");
    a1.setEmissionParKm(172.0f);
    assertEquals("Erreur l'emission ne correspond pas", 172.0 + "", a1.getEmissionParKm() + "");
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
        v1.getEmissionCarburant(v1.getCarburant()));
  }

  @Test
  public void calculerTauxVoiture() {
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    assertEquals("Erreur taux ne correspond pas", 2640.0 * 12 + "", v1.calculerTaux() + "");
  }

  @Test
  public void setEmissionCarburant() {
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    v1.setEmissionCarburant(v1.getCarburant(), 2540);
    assertEquals("Erreur l'émission ne correspond pas", 2540,
        v1.getEmissionCarburant(v1.getCarburant()));
    v1.setEmissionCarburant(v1.getCarburant(), 2640);
    assertEquals("Erreur l'émission ne correspond pas", 2640,
        v1.getEmissionCarburant(v1.getCarburant()));
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
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    Utilisation u1 = new Utilisation(360, v1);
    assertEquals("L'équipement ne correspond pas", v1, u1.getUnEquipement());
    assertEquals("L'équipement ne correspond pas", 1, u1.getNbPersonne());
    Utilisation u2 = new Utilisation(360, v1, 2);
    assertEquals("L'équipement ne correspond pas", 2, u2.getNbPersonne());
  }


  /** Creation Consommation Mensuelle. **/
  @Test
  public void ajouterConsommationMensuelle() {
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
    assertEquals("L'équipement ne correspond pas", Math.toIntExact(2640 * 12 * 360 / 1) + "",
        Math.toIntExact((long) cm1.calculerConsommation()) + "");
    Voiture v2 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    pr1.ajouterEquipement(v2);
    cm1.ajouterUneUtilisation(u1);
    assertEquals("L'équipement ne correspond pas", Math.toIntExact(2640 * 12 * 360 * 2 / 1) + "",
        Math.toIntExact((long) cm1.calculerConsommation()) + "");
  }


  /** Creation Consommation. **/
  @Test
  public void ajouterConsommation() {
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Profil pr1 = new Profil(p1);
    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    Utilisation u1 = new Utilisation(360, v1);
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
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Particulier p2 = new Particulier("Diego", "mdp2", "Roger", "Lenoir", "", "Roger@mail.fr");

    ListeUtilisateur l1 = new ListeUtilisateur();
    l1.ajouterUtilisateur(p1);
    l1.ajouterUtilisateur(p2);

    Voiture v1 = new Voiture("Porsche", Voiture.TypeCarburant.Diesel, 12);
    Avion a1 = new Avion("avion", true, 360);
    Train t1 = new Train("tchoutchou", Train.TypeTrain.OUIGO);
    Chauffage ch1 = new Chauffage("chaud", Chauffage.TypeChauffage.Bois, 15);

    Utilisation u1 = new Utilisation(1200, v1);
    Utilisation u2 = new Utilisation(2, a1);
    Utilisation u3 = new Utilisation(12, t1);
    Utilisation u4 = new Utilisation(1, ch1);

    ConsommationMensuelle cm1 = new ConsommationMensuelle(u1, new Date(2020121));
    cm1.ajouterUneUtilisation(u3);

    ConsommationMensuelle cm2 = new ConsommationMensuelle(u2, new Date(2020121));
    cm2.ajouterUneUtilisation(u4);

    ConsommationMensuelle cm3 = new ConsommationMensuelle(u1, new Date(2020121));
    cm3.ajouterUneUtilisation(u2);

    ConsommationMensuelle cm4 = new ConsommationMensuelle(u2, new Date(2020121));
    cm4.ajouterUneUtilisation(u1);

    Profil pr1 = new Profil(p1);
    Consommation c1 = new Consommation(pr1);
    c1.ajouterConsommation(cm1);

    Profil pr2 = new Profil(p2);
    Consommation c2 = new Consommation(pr2);
    c2.ajouterConsommation(cm2);

    assertEquals("La consommationMensuelle ne correspond pas",
        Math.toIntExact((2640 * 12 * 1200 / 1)+(**2/1)) + "",
        Math.toIntExact((long) cm1.calculerConsommation()) + "");

  }

}

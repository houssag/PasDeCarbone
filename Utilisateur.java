public abstract class Utilisateur {
  private String pseudo;
  private String mdp;
  private String prenom;
  private String nom;
  private String adresse;
  private String mail;

  /** Constructeur de la classe Utilisateur. **/

  Utilisateur(String p, String m, String pre, String n, String ad, String ma) {
    
    // On intialise le pseudo et le mot de passe si ils ne sont pas vides
    if (p.isEmpty() != true && m.isEmpty() != true && ma.isEmpty() != true) { 

      this.pseudo = p;
      this.mdp = m;
      this.mail = ma;

      if (pre.isEmpty() != true) {
        // On initialise le prénom si il n'est pas vide et si il ne contient pas de chiffre
        if (contientChiffre(pre) == false) { 
          this.prenom = pre;
        }
      }
      // On initialise le nom si il n'est pas vide et si il ne contient pas de chiffre
      if (n.isEmpty() != true) { 
        if (contientChiffre(n) == false) {
          this.nom = n;
        }
      }
      // On intialise l'adresse si elle n'est pas vide (elle peut contenir des chiffres)
      if (ad.isEmpty() != true) { 
        this.adresse = ad;
      }
    }

  }

  /** Getters et Setters. **/

  /** Récupère la valeur du pseudo. **/
  public String getPseudo() {
    return pseudo;
  }

  /** Change la valeur du pseudo. **/
  public void setPseudo(String pseudo) {
    if (pseudo.isEmpty() != true) {
      this.pseudo = pseudo;
    }
  }

  /** Récupère la valeur du mot de passe. **/
  public String getMdp() {
    return mdp;
  }

  /** Change la valeur du mot de passe. **/
  public void setMdp(String mdp) {
    if (mdp.isEmpty() != true) {
      this.mdp = mdp;
    }
  }

  /** Récupère la valeur du mail. **/
  public String getMail() {
    return mail;
  }

  /** Change la valeur du mail. **/
  public void setMail(String mail) {
    if (mail.isEmpty() != true) {
      this.mail = mail;
    }
  }

  /** Récupère la valeur du prénom. **/
  public String getPrenom() {
    return prenom;
  }

  /** Change la valeur du prénom. **/
  public void setPrenom(String prenom) {
    if (prenom.isEmpty() != true) {
      if (contientChiffre(prenom) == false) {
        this.prenom = prenom;
      }
    }
  }

  /** Récupère la valeur du nom. **/
  public String getNom() {
    return nom;
  }

  /** Change la valeur du nom. **/
  public void setNom(String nom) {
    if (nom.isEmpty() != true) {
      if (contientChiffre(nom) == false) {
        this.nom = nom;
      }
    }
  }

  /** Récupère la valeur de l'adresse. **/
  public String getAdresse() {
    return adresse;
  }

  /** Change la valeur de l'adresse. **/
  public void setAdresse(String adresse) {
    if (adresse.isEmpty() != true) {
      this.adresse = adresse;
    }
  }

  /** Méthode pour vérifier qu'une chaine de caractères ne contient pas de chiffres. **/

  public boolean contientChiffre(String s) {
    boolean ok = false;
    for (int i = 0; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i)) == true) {
        ok = true;
      }
    }
    return ok;
  }
}

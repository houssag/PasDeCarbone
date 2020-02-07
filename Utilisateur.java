public abstract class Utilisateur {
  private String pseudo;
  private String mdp;
  private String prenom;
  private String nom;
  private String adresse;
  private String mail;

  /**
   * Constructeur de la classe Utilisateur.
   * 
   * @param p pseudo de l'utilisateur
   * @param m mot de passe de l'utilisateur
   * @param pre prenom de l'utilisateur
   * @param n nom de l'utilisateur
   * @param ad adresse de l'utilisateur
   * @param ma mail de l'utilisateur
   */

  Utilisateur(String p, String m, String pre, String n, String ad, String ma) {

    // On intialise le pseudo et le mot de passe si ils ne sont pas vides
    if (p.isEmpty() != true && m.isEmpty() != true && ma.isEmpty() != true) {

      this.pseudo = p;
      this.mdp = m;
      this.mail = ma;

      if (pre.isEmpty() != true) {
        // On initialise le prénom si il n'est pas vide et si il ne contient pas de chiffre
        if (estInvalide(pre) == false) {
          this.prenom = pre;
        }
      }
      // On initialise le nom si il n'est pas vide et si il ne contient pas de chiffre
      if (n.isEmpty() != true) {
        if (estInvalide(n) == false) {
          this.nom = n;
        }
      }
      // On intialise l'adresse si elle n'est pas vide (elle peut contenir des chiffres)
      if (ad.isEmpty() != true) {
        this.adresse = ad;
      }
    }
    
    else {
      System.out.println("Pseudo/mot de passe/mail incorrect.");
    }

  }

  /**
   * Permet de récupérer le pseudo d'un utilisateur.
   * 
   * @return le pseudo
   */
  public String getPseudo() {
    return pseudo;
  }

  /**
   * Permet de changer le pseudo d'un utilisateur.
   * 
   * @param pseudo nouveau pseudo de l'utilisateur
   */
  public void setPseudo(String pseudo) {
    if (pseudo.isEmpty() != true) {
      this.pseudo = pseudo;
    }
  }

  /**
   * Permet de récupérer le mot de passe d'un utilisateur.
   * 
   * @return le mot de passe de l'utilisateur
   */
  public String getMdp() {
    return mdp;
  }

  /**
   * Permet de changer le mot de passe d'un utilisateur.
   * 
   * @param mdp le nouveau mot de passe de l'utilisateur
   */
  public void setMdp(String mdp) {
    if (mdp.isEmpty() != true) {
      this.mdp = mdp;
    }
  }

  /**
   * Permet de récupérer le mail d'un utilisateur.
   * 
   * @return le mail de l'utilisateur
   */
  public String getMail() {
    return mail;
  }

  /**
   * Permet de changer le mail d'un utilisateur.
   * 
   * @param mail le nouveau mail de l'utilisateur
   */
  public void setMail(String mail) {
    if (mail.isEmpty() != true) {
      this.mail = mail;
    }
  }

  /**
   * Permet de récupérer le prénom d'un utilisateur.
   * 
   * @return le prénom de l'utilisateur
   */
  public String getPrenom() {
    return prenom;
  }

  /**
   * Permet de changer le prénom d'un utilisateur si il ne contient pas de chiffre.
   * 
   * @param prenom le nouveau prénom de l'utilisateur
   */
  public void setPrenom(String prenom) {
    if (prenom.isEmpty() != true) {
      if (estInvalide(prenom) == false) {
        this.prenom = prenom;
      }
    }
  }

  /**
   * Permet de récupérer le nom d'un utilisateur.
   * 
   * @return le nom de l'utilisateur
   */
  public String getNom() {
    return nom;
  }

  /**
   * Permet de changer le nom d'un utilisateur si il ne contient pas de chiffre.
   * 
   * @param nom le nouveau nom de l'utilisateur
   */
  public void setNom(String nom) {
    if (nom.isEmpty() != true) {
      if (estInvalide(nom) == false) {
        this.nom = nom;
      }
    }
  }

  /**
   * Permet de récupérer l'adresse d'un utilisateur.
   * 
   * @return l'adresse de l'utilisateur
   */
  public String getAdresse() {
    return adresse;
  }

  /**
   * Permet de changer l'adresse d'un utilisateur.
   * 
   * @param adresse la nouvelle adresse de l'utilisateur
   */
  public void setAdresse(String adresse) {
    if (adresse.isEmpty() != true) {
      this.adresse = adresse;
    }
  }

  /**
   * Permet de savoir si une chaîne passée en paramètre ne contient que des caractères
   * contenus dans un prénom.
   * 
   * @param s La chaîne de caractère que l'on veut analyser
   * @return un booléen, vrai si la chaîne ne correspond pas aux exigences, faux sinon
   */

  public boolean estInvalide(String s) {
    boolean ok = false;
    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetter(s.charAt(i)) == false && s.charAt(i) != '-' && s.charAt(i) != '\'') {
        ok = true;
      }
    }
    return ok;
  }
 
}

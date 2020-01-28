public abstract class Utilisateur {
	private String pseudo;
	private String mdp;
	private String prenom;
	private String nom;
	private String adresse;
	private String mail;
	
	/** Constructeur de la classe Utilisateur **/
	
	Utilisateur(String p, String m, String pre, String n, String ad,String ma){
		if(p.isEmpty() != true && m.isEmpty() != true && ma.isEmpty() != true) { // On intialise le pseudo et le mot de passe si ils ne sont pas vides
			this.pseudo = p;
			this.mdp = m;
			this.mail = ma;
			
			if(pre.isEmpty() != true) {	
				if(contientChiffre(pre) == false) { // On initialise le prénom si il n'est pas vide et si il ne contient pas de chiffre
					this.prenom = pre;
				}
			}
			if(n.isEmpty() != true) { // On initialise le nom si il n'est pas vide et si il ne contient pas de chiffre
				if(contientChiffre(n) == false) {
					this.nom = n;
				}
			}
			if(ad.isEmpty() != true) { // On intialise l'adresse si elle n'est pas vide (elle peut contenir des chiffres)
				this.adresse = ad;
			}
		}

	}

	/** Getters et Setters **/
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		if(pseudo.isEmpty() != true) {
			this.pseudo = pseudo;	
		}
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		if (mdp.isEmpty() != true) {
			this.mdp = mdp;
		}
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		if(mail.isEmpty() != true) {
			this.mail = mail;
		}
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		if( prenom.isEmpty() != true) {
			if(contientChiffre(prenom) == false) {
				this.prenom = prenom;
			}
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		if( nom.isEmpty() != true) {
			if(contientChiffre(nom) == false) {
				this.nom =nom;
			}
		}
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		if(adresse.isEmpty() != true) {
			this.adresse = adresse;			
		}
	}

	/** Méthode pour vérifier qu'une chaine de caractères ne contient pas de chiffres **/
	
	public boolean contientChiffre(String s) {
		boolean ok = false;
		for(int i=0;i<s.length();i++) {
			if(Character.isDigit(s.charAt(i)) == true) {
				ok = true;
			}
		}
		return ok;
	}
}

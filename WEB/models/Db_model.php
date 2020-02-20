<?php
class Db_model extends CI_Model {
 	public function __construct()
 	{
 		$this->load->database();

   	}

   		public function get_all_account(){
		   $sql = "SELECT * FROM UTILISATEUR";
           $result = $this->db->query($sql);
           return $result->result();
		}

		public function insert_aUser($pseudo, $mail, $mdp, $nom, $prenom,$adresse,$codepost,$pays){
		   $sql = "INSERT INTO UTILISATEUR VALUES (?,?,?,?,?,?,?,?,null,?)";
           $result = $this->db->query($sql,array($pseudo, $mail,$mdp,$nom, $prenom, $adresse, 3));
           return $result;
		}

		public function connexion($adresseMail,$mdpUtilisateur){
			$sql = "SELECT * FROM UTILISATEUR WHERE utiMail = ? AND utiMdp  = ?";
			$result =  $this->db->query($sql, array($adresseMail,$mdpUtilisateur));
			if($result->num_rows() > 0) return true;
			else return false;
		}

		public function get_pseudo($mail){
			$sql = "SELECT utiPseudo FROM UTILISATEUR where utiMail = ?";
           	$result = $this->db->query($sql,$mail);
           	return $result->row();
		}

		public function get_profil($pseudo){
			$sql = "SELECT * FROM UTILISATEUR where utiPseudo = ?";
           	$result = $this->db->query($sql,$pseudo);
           	return $result->result_array();
		}

		public function update_aUser($id,$pseudo, $mail, $mdp, $nom, $prenom,$adresse,$codepost,$pays){
			if($mail != null){
				$sql = "Update UTILISATEUR set utiMail = ? where utiId = ?";
				$this->db->query($sql,array($mail,$id));
			}
			if($mdp != null){
				$sql = "Update UTILISATEUR set utiMdp = ? where utiId = ?";
				$this->db->query($sql,array($mdp,$id));
			}
			if($pseudo != null){
				$sql = "Update UTILISATEUR set utiPseudo = ? where utiId = ?";
				$this->db->query($sql,array($pseudo,$id));
			}
			$sql = "Update UTILISATEUR set utiNom = ?, utiPrenom = ?, utiAdresse1 = ?, utiCodePostal = ?, utiAdressePays = ? where utiId = ?";
			$this->db->query($sql,array($nom,$prenom,$adresse,$codepost,$pays,$id));
		}

		public function get_mdp($pseudo){
			$sql = "select utiMdp from UTILISATEUR where utiPseudo = ?";
			$result = $this->db->query($sql,$pseudo);
			return $result->row();
		}

		public function get_idProfil($pseudo){
			$sql = "select utiId from UTILISATEUR where utiPseudo = ?";
			$result = $this->db->query($sql,$pseudo);
			return $result->row();
		}

		public function get_equipement($id){
			$sql = "SELECT PROFIL.proSupprime, PROFIL.equNom, TAUX.tauValeur as taux, TAUX.tauNom as type, PROFIL.equ_equId as id FROM PROFIL inner join EQUIPEMENT on PROFIL.equ_equId = EQUIPEMENT.equId inner join TAUX on TAUX.tauId = EQUIPEMENT.tau_tauId where uti_utiId = ?";
           	$result = $this->db->query($sql,$id);
           	return $result->result_array();
		}

		public function delete_equipement($id_profil,$idEquipement){
			$sql = "UPDATE PROFIL set proSupprime = 0 where equ_equId = ? and uti_utiId = ?";
           	$result = $this->db->query($sql,array($idEquipement,$id_profil));
		}

		public function getAll_equipement(){
			$sql = "Select equId, equNom, tau_tauId, cat_catId, TAUX.tauValeur from EQUIPEMENT inner join TAUX on EQUIPEMENT.tau_tauId = TAUX.tauId";
           	$result = $this->db->query($sql);
           	return $result->result_array();
		}

		public function getAll_taux(){
			$sql = "Select distinct tauId, tauValeur, tauNom from TAUX inner join EQUIPEMENT on TAUX.tauId = EQUIPEMENT.tau_tauId";
           	$result = $this->db->query($sql);
           	return $result->result_array();
		}

		public function getAll_categorie(){
			$sql = "Select distinct catId, catNom from CATEGORIE inner join EQUIPEMENT on CATEGORIE.catId = EQUIPEMENT.cat_catId";
           	$result = $this->db->query($sql);
           	return $result->result_array();
		}

		public function get_idEquipement_cat($id){
			$sql = "Select equId, equNom, tau_tauId, cat_catId, TAUX.tauValeur from EQUIPEMENT inner join TAUX on EQUIPEMENT.tau_tauId = TAUX.tauId where cat_catId = ?";
           	$result = $this->db->query($sql,$id);
           	return $result->result_array();
		}

		public function get_idEquipement_taux($id){
			$sql = "Select equId, equNom, tau_tauId, cat_catId, TAUX.tauValeur from EQUIPEMENT inner join TAUX on EQUIPEMENT.tau_tauId = TAUX.tauId where tau_tauId = ?";
           	$result = $this->db->query($sql,$id);
           	return $result->result_array();
		}

		public function set_equipementProfil($id,$nom,$uti){
			$sql = "INSERT into PROFIL (equ_equId, equNom, uti_utiId, proSupprime, proConsoLparKM) value(?,?,?,1,1)";
			$this->db->query($sql,array($id,$nom,$uti));
		}

		public function set_equipementProfil($id,$uti){
			$sql = "UPDATE PROFIL set proSupprime = 1 where uti_utiId = ? and equ_equId = ?";
			$this->db->query($sql,array($uti,$id));
		}
}
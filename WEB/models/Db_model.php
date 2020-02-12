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

		public function insert_aUser($pseudo, $mail, $mdp, $nom, $prenom,$adresse){
		   $sql = "INSERT INTO UTILISATEUR VALUES (null,?,?,?,?,?,?)";
           $result = $this->db->query($sql,array($pseudo, $mail,$mdp,$nom, $prenom, $adresse));
           return $result;
		}

		public function connexion($adresseMail,$mdpUtilisateur){
			$sql = "SELECT * FROM UTILISATEUR WHERE mailUtilisateur= ? AND mdpUtilisateur  = ?";
			$result =  $this->db->query($sql, array($adresseMail,$mdpUtilisateur));
			if($result->num_rows() > 0) return true;
			else return false;
		}

		public function get_pseudo($mail){
			$sql = "SELECT pseudoUtilisateur FROM UTILISATEUR where mailUtilisateur = ?";
           	$result = $this->db->query($sql,$mail);
           	return $result->row();
		}

		public function get_profil($pseudo){
			$sql = "SELECT * FROM UTILISATEUR where pseudoUtilisateur = ?";
           	$result = $this->db->query($sql,$pseudo);
           	return $result->result_array();
		}

		public function update_aUser($pseudo, $mail, $mdp, $nom, $prenom,$adresse){
			if($pseudo != null){
				$sql = "Update UTILISATEUR set mailUtilisateur = ? where pseudoUtilisateur = ?)";
				$this->db->query($sql,array($mail,$pseudo));
			}
			if($pseudo != null){
				$sql = "Update UTILISATEUR set mdpUtilisateur = ? where pseudoUtilisateur = ?)";
				$this->db->query($sql,array($mdp,$pseudo));
			}
			if($pseudo != null){
				$sql = "Update UTILISATEUR set nomUtilisateur = ? where pseudoUtilisateur = ?)";
				$this->db->query($sql,array($nom,$pseudo));
			}
			if($pseudo != null){
				$sql = "Update UTILISATEUR set prenomUtilisateur = ? where pseudoUtilisateur = ?)";
				$this->db->query($sql,array($prenom,$pseudo));
			}
			if($pseudo != null){
				$sql = "Update UTILISATEUR set adresseUtilisateur = ? where pseudoUtilisateur = ?)";
				$this->db->query($sql,array($adresse,$pseudo));
			}
			if($pseudo != null){
				$sql = "Update UTILISATEUR set pseudoUtilisateur = ? where pseudoUtilisateur = ?)";
				$this->db->query($sql,array($pseudo,$pseudo));
			}
		}
}
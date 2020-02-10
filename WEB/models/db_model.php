<?php
class Db_model extends CI_Model {
 	public function __construct()
 	{
 		$this->load->database();

   	}

   		public function get_all_account(){
		   $sql = "SELECT * FROM utilisateur";
           $result = $this->db->query($sql);
           return $result->result();
		}

		public function insert_aUser($POST){
		   $sql = "INSERT INTO UTILISATEUR VALUES (?,?,?,?,?,?,?)";
           $result = $this->db->query($sql,array($POST['pseudoUtilisateur'], $POST['mailUtilisateur'],$POST['mdpUtilisateur'],$POST['nomUtilisateur'], $POST['prenomUtilisateur'], $POST['adresseUtilisateur'],1));
           return $result;
		}
}
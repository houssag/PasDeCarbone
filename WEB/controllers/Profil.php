<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Profil extends CI_Controller {
	   
	public function __construct(){

		parent::__construct();
		$this->load->model('db_model');
		$this->load->helper('url_helper');
		$this->load->library('session');
		$this->load->helper('form');
		$this->load->helper('url');
	}

	public function index()
	{
		$pseudo = $_SESSION['pseudo'];
		$data["profil"] = $this->db_model->get_profil($pseudo);
		$this->load->view('template/header');
		$this->load->view('profil',$data);
		$this->load->view('template/footer');
	}

	public function submit(){
		extract($_POST);
		$allUser = $this->db_model->get_all_account();

		$isIn=0;

		foreach($allUser as $aUser){
			if($aUser->pseudoUtilisateur == $pseudoUtilisateur || $aUser->mailUtilisateur == $mailUtilisateur){
				$isIn = 1;
				break;
			}
		}

		if($isIn == 1 || $_POST['mdpUtilisateurConfirmation'] != $_POST['mdpUtilisateur'] ){
			   redirect( base_url() . 'index.php/profil/index', 'refresh');
		}else{
			$salt = "LeSelSurLesPâtesCarbones";
        	$test = hash('sha256',$salt.$mdpUtilisateur);
			$this->db_model->insert_aUser($pseudoUtilisateur,$mailUtilisateur,$test,$nomUtilisateur,$prenomUtilisateur,$adresseUtilisateur);
			redirect( base_url());
		}
	}

	public function modifier()
	{
		$pseudo = $_SESSION['pseudo'];
		$data["profil"] = $this->db_model->get_profil($pseudo);
		$this->load->view('template/header');
		$this->load->view('profil_modifier',$data);
		$this->load->view('template/footer');
	}

	public function valider_modifier(){
		extract($_POST);
		$allUser = $this->db_model->get_all_account();
		$mdp = $this->db_model->get_mdp($_SESSION['pseudo']); //Ancient mdp BDD
		$salt = "LeSelSurLesPâtesCarbones";
		if($ancienMdp != null){
        	$aMdp = hash('sha256',$salt.$ancienMdp); //Ancient mdp formulaire
        }
        if($mdpUtilisateur != null){
        	$nMdp = hash('sha256',$salt.$mdpUtilisateur); //Nouveau mdp formulaire
        }

		$isIn=0;

		foreach($allUser as $aUser){
			if(($aUser->pseudoUtilisateur == $pseudoUtilisateur && $pseudoUtilisateur != $_SESSION['pseudo']) || ($aUser->mailUtilisateur == $mailUtilisateur && $mailUtilisateur != $_SESSION['mail'])){
				$isIn = 1;
				break;
			}
		}

		$profil = $this->db_model->get_profil($_SESSION['pseudo']);
		foreach($profil as $p){ //Si valeur inchangée alors passer la valeur à null
			if($p['pseudoUtilisateur'] == $pseudoUtilisateur){
				$pseudoUtilisateur = null;
			}
			if($p['mailUtilisateur'] == $mailUtilisateur){
				$mailUtilisateur = null;
			}
			if($p['mdpUtilisateur'] == $nMdp){
				$nMdp = null;
			}
			if($p['nomUtilisateur'] == $nomUtilisateur){
				$nomUtilisateur = null;
			}
			if($p['prenomUtilisateur'] == $prenomUtilisateur){
				$prenomUtilisateur = null;
			}
			if($p['adresseUtilisateur'] == $adresseUtilisateur){
				$adresseUtilisateur = null;
			}
		}

		if($isIn == 1 || $_POST['mdpUtilisateurConfirmation'] != $_POST['mdpUtilisateur'] || ($aMdp != $mdp && $aMdp != null)){
			   redirect( base_url() . 'index.php/profil/modifier', 'refresh');
		}else{
			$this->db_model->update_aUser($pseudoUtilisateur,$mailUtilisateur,$nMdp,$nomUtilisateur,$prenomUtilisateur,$adresseUtilisateur);
			redirect( base_url());
		}
	}


}

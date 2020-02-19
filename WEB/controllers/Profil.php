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
		$id = $this->db_model->get_idProfil($_SESSION['pseudo'])->utiId;
		$data["equipement"] = $this->db_model->get_equipement($id);
		$this->load->view('template/header');
		$this->load->view('vue_profil',$data);
		$this->load->view('template/footer');
	}

	public function submit(){
		extract($_POST);
		$allUser = $this->db_model->get_all_account();

		$isIn=0;

		foreach($allUser as $aUser){
			if($aUser->utiPseudo == $pseudoUtilisateur || $aUser->utiMail == $mailUtilisateur){
				$isIn = 1;
				break;
			}
		}

		if($isIn == 1 || $_POST['mdpUtilisateurConfirmation'] != $_POST['mdpUtilisateur'] ){
			   redirect( base_url() . 'index.php/profil/index', 'refresh');
		}else{
			$salt = "LeSelSurLesPâtesCarbones";
        	$test = hash('sha256',$salt.$mdpUtilisateur);
			$this->db_model->insert_aUser($pseudoUtilisateur,$mailUtilisateur,$test,$nomUtilisateur,$prenomUtilisateur,$adresseUtilisateur,$codePost,$pays);
			redirect( base_url());
		}
	}

	public function modifier()
	{
		$pseudo = $_SESSION['pseudo'];
		$data["profil"] = $this->db_model->get_profil($pseudo);
		$this->load->view('template/header');
		$this->load->view('vue_profil_modifier',$data);
		$this->load->view('template/footer');
	}

	public function valider_modifier(){
		extract($_POST);
		$allUser = $this->db_model->get_all_account();
		$mdp = $this->db_model->get_mdp($_SESSION['pseudo'])->utiMdp; //Ancient mdp BDD
		$salt = "LeSelSurLesPâtesCarbones";
		$aMdp = null;
		if($ancienMdp != null){
        	$aMdp = hash('sha256',$salt.$ancienMdp); //Ancient mdp formulaire
        }else{
        	$aMdp = $mdp;
        }
        $nMdp = null;
        if($mdpUtilisateur != null){
        	$nMdp = hash('sha256',$salt.$mdpUtilisateur); //Nouveau mdp formulaire
        }

		$isIn=0;

		foreach($allUser as $aUser){
			if(($aUser->utiPseudo == $pseudoUtilisateur && $pseudoUtilisateur != $_SESSION['pseudo']) || $pseudoUtilisateur == null || $mailUtilisateur == null || ($aUser->utiMail == $mailUtilisateur && $mailUtilisateur != $_SESSION['mail'])){
				$isIn = 1;
				break;
			}
		}

		if($isIn == 1 || $mdpUtilisateurConfirmation != $mdpUtilisateur || ($aMdp != $mdp && $aMdp != null)){
			   redirect( base_url() . 'index.php/profil/modifier', 'refresh');
		}else{
			$id_profil = $this->db_model->get_idProfil($_SESSION['pseudo'])->utiId;
			$_SESSION["pseudo"] = $pseudoUtilisateur;
			$this->db_model->update_aUser($id_profil,$pseudoUtilisateur,$mailUtilisateur,$nMdp,$nomUtilisateur,$prenomUtilisateur,$adresseUtilisateur,$adressePostalUtilisateur,$adressePaysUtilisateur);
			redirect( base_url() . 'index.php/profil/index');
		}
	}


	public function supprimer_equipement(){
		extract($_POST);
		$id_profil = $this->db_model->get_idProfil($_SESSION['pseudo'])->utiId;
		$this->db_model->delete_equipement($id_profil,$idEquipement);
		redirect( base_url() . 'index.php/profil/index');
	}


}

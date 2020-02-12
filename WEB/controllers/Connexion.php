<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Connexion extends CI_Controller {

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
		$this->load->view('template/header');
		$this->load->view('connexion');
		$this->load->view('template/footer');
	}

	public function submit(){
		extract($_POST);

        $salt = "LeSelSurLesPâtesCarbones";
        $test = hash('sha256',$salt.$mdpUtilisateur);

		$isConnected = $this->db_model->connexion($adresseMail,$test);

		if($isConnected){
			$pseudo = $this->db_model->get_pseudo($adresseMail);
			$_SESSION["mail"] = $adresseMail;
			$_SESSION["pseudo"] = $pseudo->pseudoUtilisateur;

;
			redirect( base_url() . 'index.php/profil/index', 'refresh');
		}else{
			redirect( base_url() . 'index.php/connexion/index', 'refresh');
		}


	}
}

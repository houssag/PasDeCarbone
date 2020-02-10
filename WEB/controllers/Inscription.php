<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Inscription extends CI_Controller {
	   
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
		$this->load->view('inscription');
		$this->load->view('template/footer');
	}

	public function submit(){
		$allUser = $this->db_model->get_all_account();

		$isIn=0;

		foreach($allUser as $aUser){
			if($aUser->pseudoUtilisateur == $_POST['pseudoUtilisateur'] || $aUser->mailUtilisateur == $_POST['mailUtilisateur']){
				$isIn = 1;
				break;
			}
		}

		if($isIn == 1 || $_POST['mdpUtilisateurConfirmation'] != $_POST['mdpUtilisateur'] ){
			   redirect( base_url() . 'index.php/inscription/index', 'refresh');
		}else{
			$_POST[mdpUtilisateur] = md5($_POST[mdpUtilisateur]);
			$this->db_model->insert_aUser($_POST);
			redirect( base_url());
		}
	}


}

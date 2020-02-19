<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Consommation extends CI_Controller {
	   
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
		$this->load->view('vue_mes_consommations');
		$this->load->view('template/footer');
	}

	public function consommation($idCons = null){
		if(isset($idCons)){
			// $vals = Charger consommation 
		}else{
			$this->load->view('template/header');
			$this->load->view('vue_ajouter_consommation');
			$this->load->view('template/footer');
		}
	}

}

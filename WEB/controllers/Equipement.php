<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Equipement extends CI_Controller {
	   
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
		$data["equipement"] = $this->db_model->getAll_equipement();
		$data["taux"] = $this->db_model->getAll_taux();
		$data["categorie"] = $this->db_model->getAll_categorie();
		$this->load->view('template/header');
		$this->load->view('vue_equipement',$data);
		$this->load->view('template/footer');
	}

	public function filtre_typeEquipement(){
		extract($_POST);
		if($type_equipement != 0){
			$data["equipement"] = $this->db_model->get_idEquipement_cat($type_equipement);
		}else{
			$data["equipement"] = $this->db_model->getAll_equipement();
		}
		
		$data["taux"] = $this->db_model->getAll_taux();
		$data["categorie"] = $this->db_model->getAll_categorie();
		$data["id_cat"] = $type_equipement;
		$this->load->view('template/header');
		$this->load->view('vue_equipement',$data);
		$this->load->view('template/footer');
	}

	public function filtre_typeTaux(){
		extract($_POST);
		if($type_taux != 0){
			$data["equipement"] = $this->db_model->get_idEquipement_taux($type_taux);
		}else{
			$data["equipement"] = $this->db_model->getAll_equipement();
		}
		
		$data["taux"] = $this->db_model->getAll_taux();
		$data["categorie"] = $this->db_model->getAll_categorie();
		$data["id_taux"] = $type_taux;
		$this->load->view('template/header');
		$this->load->view('vue_equipement',$data);
		$this->load->view('template/footer');
	}

	public function ajouter_equipement(){
		extract($_POST);
		$equipement_existe = $this->db_model->get_equipement($id);
		$ok = 1;

		foreach($equipement_existe as $e){
			if($e['equId'] == $idEquipement){
				$ok = 0;
			}
		}

		$id = $this->db_model->get_idProfil($_SESSION['pseudo'])->utiId;
		if(ok){
			$this->db_model->set_equipementProfil($idEquipement,$nomEquipement,$id);
		}else{
			$this->db_model->update_equipementProfil($idEquipement,$id);
		}
		
		$pseudo = $_SESSION['pseudo'];
		$data["profil"] = $this->db_model->get_profil($pseudo);
		$data["equipement"] = $this->db_model->get_equipement($id);
		$this->load->view('template/header');
		$this->load->view('vue_profil',$data);
		$this->load->view('template/footer');
	}

}

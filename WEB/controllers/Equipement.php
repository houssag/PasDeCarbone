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
		$this->load->view('template/header');
		$this->load->view('vue_equipement',$data);
		$this->load->view('template/footer');
	}

}

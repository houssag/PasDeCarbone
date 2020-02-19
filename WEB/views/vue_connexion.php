<br>
<br>
<br>
<br>


  <form action="<?php echo base_url() . 'index.php/connexion/submit' ?>" method="post">
	<div class="container">
			<h2>Connexion</h1>
		<div class="form-group required">
			<label for="AdresseMail">Adresse mail</label>
			<input type="email" class="form-control" id="AdresseMail" name="adresseMail"aria-describedby="Adresse mail" placeholder="Entrez votre adresse email">
		</div>
		<div class="form-group required">
			<div class="control-label">
				<label for="mdpUtilisateur">Mot de passe</label>
			</div>
			<input type="password" class="form-control" id="mdpUtilisateur" name="mdpUtilisateur" placeholder="Entrez votre mot de passe">
		</div>
		<button type="submit" class="btn btn-primary">Valider</button>
	</form>

</div>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="container">
  <form action="<?php echo base_url() . 'index.php/inscription/submit' ?>" method="post">
    <div class="form-group required" >
      <div class="control-label">
        <label for="exampleInputEmail1" required="required">Pseudo</label>
      </div>
      <input type="pseudo" class="form-control" id="pseudoUtilisateur" name="pseudoUtilisateur" required="required" aria-describedby="Pseudo" placeholder="Entrez votre pseudo" pattern="[0-9a-zA-Z]+" title="Pas de caractère spéciaux">

    </div>
    <div class="form-group required">
      <div class="control-label">
        <label for="exampleInputEmail1">Adresse mail</label>
      </div>
      <input type="email" class="form-control" id="mailUtilisateur" name="mailUtilisateur" aria-describedby="Adresse mail" placeholder="Entrez votre adresse email">
      <small id="emailHelp" class="form-text text-muted">Nous ne partagerons jamais votre adresse mail avec qui que ce soit.</small>
    </div>
    <div class="form-group required">
      <div class="control-label">
        <label for="exampleInputPassword1">Mot de passe</label>
      </div>
      <input type="password" class="form-control" id="mdpUtilisateur" name="mdpUtilisateur" placeholder="Entrez votre mot de passe">
    </div>
    <div class="form-group required">
      <div class="control-label">
        <label for="exampleInputPassword1">Confirmation mot de passe</label>
      </div>
      <input type="password" class="form-control" id="mdpUtilisateurConfirmation" name="mdpUtilisateurConfirmation" placeholder="Confirmez votre mot de passe">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">Nom</label>
      <input type="text" class="form-control" id="nomUtilisateur"  name="nomUtilisateur" aria-describedby="emailHelp" placeholder="Entrez votre Nom" pattern="[0-9a-zA-Z]+" title="Pas de caractère spéciaux">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">Prénom</label>
      <input type="text" class="form-control" id="prenomUtilisateur"  name="prenomUtilisateur" aria-describedby="emailHelp" placeholder="entrez votre Prénom" pattern="[0-9a-zA-Z]+" title="Pas de caractère spéciaux">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">Adresse domicile</label>
      <input type="text" class="form-control" id="adresseUtilisateur" name="adresseUtilisateur" aria-describedby="emailHelp" placeholder="entrez votre adresse de domicile" pattern="[0-9a-zA-Z]+" title="Pas de caractère spéciaux">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">Code postal</label>
      <input type="text" class="form-control" id="adressePostalUtilisateur" name="adressePostalUtilisateur" aria-describedby="emailHelp" placeholder="entrez votre code postal" pattern="[0-9]+" title="Pas de lettres ni de caractères spéciaux">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">Pays</label>
      <input type="text" class="form-control" id="adressePaysUtilisateur" name="adressePaysUtilisateur" aria-describedby="emailHelp" placeholder="entrez votre pays" pattern="[a-zA-Z]+" title="Pas de caractère spéciaux ni de nombres">
    </div>
    <button type="submit" class="btn btn-primary">Valider</button>
  </form>
</div>

<style>
  .form-group.required .control-label:after {
    content:"*";
    color:red;
  }
</style>

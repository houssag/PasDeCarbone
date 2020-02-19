<br>
<br>
<br>
<br>
<br>
<br>


<div class="container">

  <div class="blog_right_sidebar">

    <h3>Informations du profil</h3>
    <br />
    <?php foreach($profil as $p): ?>
      <p>Pseudo : <?php echo $p['utiPseudo']; ?></p>
      <p>Nom - Prénom : <?php  if(isset($p['utiNom'])){echo $p['utiNom']." - ";} if(isset($p['utiPrenom'])){ echo $p['utiPrenom'];} ?></p>
      <p>Mail : <?php echo $p['utiMail']; ?></p>
      <p>Adresse : <?php if(isset($p['utiAdresse1'])){echo $p['utiAdresse1'];} if(isset($p['utiPrenom'])){ echo " - " . $p['utiCodePostal'];} ?></p>
      <p>Pays : <?php echo $p['utiAdressePays']; ?></p>
    <?php endforeach; ?>
    <form class="row login_form col-md-12">
        <div class="form-group" align="center">
             <a href="<?php echo site_url('profil/modifier'); ?>" class="primary-btn" style="color:white;text-decoration:none;">Modifier</a>
        </div>
    </form>

  </div>


  <div class="order_details_table">

    <h2>Liste vos Equipements</h2>

    <div class="cart_inner">

      <div class="table-responsive">

        <table class="table">
          <thead>
            <tr>
              <th scope="col" style="max-width: 20px;">Type</th>
              <th scope="col">Nom</th>
              <th scope="col">Taux</th>
              <th style="max-width: 20px;"></th>
            </tr>
          </thead>
         <tbody>
            <?php foreach($equipement as $equi): ?>
              <?php if($equi['proSupprime'] != 0): ?>
              <tr>
                <td>
                  <p><?php echo $equi['type']; ?></p>
                </td>
                <td>
                  <p><?php echo $equi['equNom']; ?></p>
                </td>
                <td>
                  <p><?php echo $equi['taux'] . "g de CO²"; ?></p>
                </td>
                <td>
                  <form action="supprimer_equipement" method="post" style="margin:0;" onsubmit="return confirm('Etes-vous sur de vouloir supprimer cette equipement ?');">
                    <div align="center">
                      <input type="hidden" id="idEquipement" name="idEquipement" value="<?php echo $equi['id']; ?>">
                      <input type="submit" class="genric-btn primary-border medium" style="" value="Supprimer l'équipement">
                    </div>
                  </form>
                </td>
              </tr> 
            <?php endif; ?>
            <?php endforeach; ?>
          </tbody>

        </table>
                
        <form class="row login_form col-md-12">
          <div class="form-group" align="center">
            <a href="<?php echo site_url('equipement/index'); ?>" class="primary-btn" style="color:white;text-decoration:none;">Ajouter un équipement</a>
          </div>
        </form>
                
      </div>

    </div>

  </div>

</div>

<style>
  .form-group.required .control-label:after {
    content:"*";
    color:red;
  }
</style>

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
      <p>Pseudo : <?php echo $p['pseudoUtilisateur']; ?></p>
      <p>Nom - Prénom : <?php  if(isset($p['nomUtilisateur'])){echo $p['nomUtilisateur']." - ";} if(isset($p['prenomUtilisateur'])){ echo $p['prenomUtilisateur'];} ?></p>
      <p>Mail : <?php echo $p['mailUtilisateur']; ?></p>
      <p>Adresse : <?php echo $p['adresseUtilisateur'] ?></p>
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
              <th scope="col">Goodie</th>
              <th scope="col">Description</th>
              <th scope="col">Quantite</th>
              <th scope="col">Prix</th>
              <th scope="col">Total</th>
            </tr>
          </thead>
         <!--  <tbody>
            <?php $total = 0; foreach($comm as $commande): ?>
              <tr>
                <td>
                  <div class="media">
                    <div class="d-flex">
                      <img style="max-width:200px" src="<?php echo base_url();?>/style/images/<?php echo $commande['nomImageGoodie']; ?>" alt="">
                    </div>
                    <div class="media-body">
                      <p><?php echo $commande['nomGoodie']; ?></p>
                    </div>
                  </div>
                </td>
                <td>
                  <p><?php echo $commande['descriptionGoodie']; ?></p>
                </td>
                <td>
                  <p><?php echo $commande['quantite']; ?></p>
                </td>
                <td>
                  <p><?php echo $commande['prix']; ?>€</p>
                </td>
                <td id="res">
                  <p><?php echo $commande['total'];$total = $total + $commande['total']; ?>€</p>
                </td>
              </tr> 
            <?php endforeach; ?>
            <tr>
              <td><h4>TOTAL</h4></td>
              <td colspan="3"></td>
              <td id="total"><?php echo $total; ?>€</td>
            </tr>
          </tbody> -->

        </table>
                
               <!--  <div class="col-md-12 form-group">
                    <form method="post" id="form_suppression" action="supprimer_comm" onsubmit="return confirm('Etes-vous sur de vouloir supprimer cette commande ?');" style="<?php if(isset($_SESSION['login'])){echo "display:none"; }?>">
                        <input type="hidden" name="id" id="id" value="<?php echo $id; ?>">
                        <button type="submit" value="submit" class="genric-btn danger-border">Supprimer la commande</button>
                    </form>
                    <form method="post" id="form_retirer" action="retirer_comm" onsubmit="return confirm('Etes-vous sur de vouloir retirer cette commande ?');" style="<?php if(isset($_SESSION['role'])){if($_SESSION['role'] != 'vendeur'){echo "display:none";}}else{ echo 'display:none';} ?>">
                        <input type="hidden" name="id" id="id" value="<?php echo $id; ?>">
                        <button type="submit" value="submit" class="genric-btn danger-border">Retirer la commande</button>
                    </form>
                    <form method="post" id="form_annuler" action="annuler_comm" onsubmit="return confirm('Etes-vous sur de vouloir annuler cette commande ?');" style="<?php if(isset($_SESSION['role'])){if($_SESSION['role'] != 'vendeur'){echo "display:none";}}else{ echo 'display:none';} ?>">
                        <input type="hidden" name="id" id="id" value="<?php echo $id; ?>">
                        <button type="submit" value="submit" class="genric-btn danger-border">Annuler la commande</button>
                    </form>
                </div> -->
                
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

<br>
<br>
<br>
<br>
<br>
<br>


<div class="container">

  <div class="order_details_table">

    <h2>Liste des Equipements</h2>

    <div class="cart_inner">

      <div class="table-responsive">

        <form action="filtre_typeEquipement" method="post">
          <div class="row" style="margin:0!important;">
            <p>Sélectionnez le type d'équipement : </p>
            <select id="type_equipement" name="type_equipement" onchange="this.parentNode.parentNode.submit();">
              <option value="0">Equipement</option>
              <?php foreach($categorie as $c): ?>
              <option value="<?php echo $c['catId']; ?>" <?php if(isset($id_cat)){ if($id_cat == $c['catId']){ echo "selected"; }}?>><?php echo $c['catNom']; ?></option>
              <?php endforeach; ?>
            </select>
          </div>
        </form>

        <form action="filtre_typeTaux" method="post">
          <div class="row" style="margin:0!important;">
            <p>Sélectionnez le type de taux : </p>
            <select id="type_taux" name="type_taux" onchange="this.parentNode.parentNode.submit();">
              <option value="0">Taux</option>
              <?php foreach($taux as $t): ?>
              <option value="<?php echo $t['tauId']; ?>" <?php if(isset($id_taux)){ if($id_taux == $t['tauId']){ echo "selected"; }}?>><?php echo $t['tauNom']; ?></option>
              <?php endforeach; ?>
            </select>
          </div>
        </form>

        <table class="table">
          <thead>
            <tr>
              <th scope="col" style="max-width: 20px;">Nom</th>
              <th scope="col">Taux</th>
              <th style="max-width: 20px;"></th>
            </tr>
          </thead>
         <tbody>
            <?php foreach($equipement as $equi): ?>
              <tr>
                <td>
                  <p><?php echo $equi['equNom']; ?></p>
                </td>
                <td>
                  <p><?php echo $equi['tauValeur'] . "g de CO²"; ?></p>
                </td>
                <td>
                  <form action="ajouter_equipement" method="post" style="margin:0;">
                    <div align="center">
                      <input type="hidden" id="idEquipement" name="idEquipement" value="<?php echo $equi['equId']; ?>">
                      <input type="hidden" id="nomEquipement" name="nomEquipement" value="<?php echo $equi['equNom']; ?>">
                      <input type="submit" class="genric-btn primary-border medium" style="" value="Ajouter l'équipement">
                    </div>
                  </form>
                </td>
              </tr> 
            <?php endforeach; ?>
          </tbody>

        </table>
                
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

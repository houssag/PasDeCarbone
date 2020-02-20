<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Comission</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/Contact-Form-Clean.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
    <div class="contact-clean">
        <form class="pulse animated" method="post" action="../submit">
            <div class="container">
                <h2 class="text-center">Commission</h2>
                <div class="form-group">
                    <div class="dropdown"><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button">Choisissez votre équipement&nbsp;</button>
                        <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation" href="#">First Item</a><a class="dropdown-item" role="presentation" href="#">Second Item</a><a class="dropdown-item" role="presentation" href="#">Third Item</a></div>
                    </div>
                </div><small class="form-text text-muted">Entrez la date d'utilisation</small><input class="form-control" type="month"><small class="form-text text-muted">Entrez l'utilisation de votre équipement dans le mois</small>
                <div class="form-group"><input class="form-control" type="text"></div><small class="form-text" id="nbPersonne">Entrez le nombre de personne l'ayant utilisé.&nbsp;</small>
                <div class="form-group"><input class="border rounded-0 custom-range" type="range" id="nbPersonne2" name="nbPersonne" value="1" min="1" max="10" step="1"></div><button class="btn btn-primary" type="button">Valider</button><button class="btn btn-primary" type="button"
                    style="background-color: rgb(255,0,0);margin-left: 20%;">Supprimer</button></div>
        </form>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
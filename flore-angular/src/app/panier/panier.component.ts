import {Component, OnInit} from '@angular/core';
import {Title} from '@angular/platform-browser';
import {PanierService} from '../services/panier.service';
import {Panier} from '../model/Panier';
import {Selection} from '../model/Selection';
import {Faune} from '../model/Faune';
import {Flore} from '../model/Flore';
import {SelectionService} from '../services/selection.service';
import {Utilisateur} from '../model/Utilisateur';
import {Paiement} from '../model/Paiement';
import {CommonService} from '../common.service';
import {Commande} from '../model/Commande';
import {Router} from '@angular/router';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss']
})
export class PanierComponent implements OnInit {
  panier: Panier;
  selections: Array<Selection> = new Array<Selection>();
  nombreArticle: number = 0;
  total: number = 0;
  id: number = 1;
  etapePanier: number = 1;
  fraisLivraison: number = 0;
  formPaiement: Paiement;
  commandeForm: Commande = new Commande();
  typeEnvoi: string;
  typeCarte: string;
  typePaiement: string;
  typeCartes: Array<string> = new Array<string>();


  constructor(private titleService: Title, private panierService: PanierService, private router: Router, private selectionService: SelectionService, private commonService: CommonService) {
    this.titleService.setTitle('Panier');
    this.load(parseInt(sessionStorage.getItem('idPanierEnCours')));
    this.calcul();
    this.commonService.page="panier";

  }

  ngOnInit(): void {
    this.commonService.findAllTypeCarte().subscribe(resp => {
      this.typeCartes = resp;
    }, error => console.log(error));

  }

  load(id: number) {
    this.panierService.findById(id).subscribe(resp => {
      this.panier = resp;
      this.selections = resp.selections;
    }, error => console.log(error));
  }

  filterCaracFaune(faune: Faune, nomCarac: string): string {
    if (faune.referentielFaunes) {
      for (let refFaune of faune.referentielFaunes) {
        if (refFaune.caracteristique.nom == nomCarac) {
          return refFaune.caracteristique.valeur;
        }
      }
    }
    return 'non renseigné';
  }

  filterCaracFlore(flore: Flore, nomCarac: string): string {
    if (flore.referentielCaracteristiques) {

      for (let refCarac of flore.referentielCaracteristiques) {
        if (refCarac.caracteristique.nom == nomCarac) {
          return refCarac.caracteristique.valeur;
        }
      }
    }

    return 'non renseigné';
  }

  delete(id: number) {
    this.selectionService.deleteById(id);
    this.load(parseInt(sessionStorage.getItem('idPanierEnCours')));
  }

  return() {

  }

  etapeSuivante() {
    this.etapePanier = this.etapePanier + 1;

  }

  etapePrecedente() {
    this.etapePanier = this.etapePanier - 1;
    if (this.etapePanier == 2) {
      this.fraisLivraison = 0;
      this.calcul();
    }
    if (this.etapePanier == 3) {
      this.formPaiement = null;
    }
  }

  confirmerAchat() {

  }

  redirectToAccueil() {
    this.router.navigateByUrl('NPK/accueil');
  }

  calcul() {
    this.nombreArticle = 0;
    this.total = 0;
    for (let sel of this.selections) {
      this.nombreArticle = this.nombreArticle + sel.nombre;
      this.total = (this.total + (sel.produit.prix * sel.nombre));
    }
    this.total = this.total + this.fraisLivraison;
  }

  creationForm() {
    this.formPaiement = new Paiement();
    this.formPaiement.montant = this.total;
  }

  suppressionForm() {
    this.formPaiement = null;
  }

}

import {Component, OnInit} from '@angular/core';
import {FloreService} from '../services/flore.service';
import {Title} from '@angular/platform-browser';
import {Flore} from '../model/Flore';
import {normalizeExtraEntryPoints} from '@angular-devkit/build-angular/src/angular-cli-files/models/webpack-configs';
import {FauneService} from '../services/faune.service';
import {Router} from '@angular/router';
import {CommonService} from '../common.service';
import {Produit} from '../model/Produit';
import {CompteUtilisateurService} from '../services/compte-utilisateur.service';
import {Panier} from '../model/Panier';
import {Selection} from '../model/Selection';
import {SelectionService} from '../services/selection.service';
import {PanierService} from '../services/panier.service';

@Component({
  selector: 'app-fiche-flore',
  templateUrl: './fiche-flore.component.html',
  styleUrls: ['./fiche-flore.component.scss']
})
export class FicheFloreComponent implements OnInit {
  nomFlore: string;
  flore: Flore;
  plusFauneAttire: boolean = false;
  plusFauneRepoussee: boolean = false;
  plusFloreKompagne: boolean = false;
  plusFloreEnnemie: boolean = false;

  constructor(public floreService: FloreService, private titleService: Title, public fauneService: FauneService, private router: Router, public commonService: CommonService, private compteUtilisateurService: CompteUtilisateurService, private selectionService: SelectionService, private panierService: PanierService) {
    this.titleService.setTitle('Fiche-Flore');
    this.commonService.page = 'flore';
  }

  ngOnInit(): void {
    this.findFlore();
  }

  findFlore() {
    this.floreService.findByNom(this.nomFlore).subscribe(next => {
      this.flore = next;
    }, error => console.log(error));
  }

  filterCarac(flore: Flore, nomCarac: string): string {
    if (flore.referentielCaracteristiques) {

      for (let refCarac of flore.referentielCaracteristiques) {
        if (refCarac.caracteristique && refCarac.caracteristique.nom == nomCarac) {
          return refCarac.caracteristique.valeur;
        }
      }
    }

    return 'non renseigné';
  }

  tableauCarac(flore: Flore, nomCarac: string): Array<string> {
    let listeCarac: Array<string> = new Array<string>();

    if (flore.referentielCaracteristiques) {

      for (let refCarac of flore.referentielCaracteristiques) {
        if (refCarac.caracteristique.nom == nomCarac) {
          listeCarac.push(refCarac.caracteristique.valeur);
        }
      }
    }
    return listeCarac;
  }

  valeurCarac(flore: Flore, nomCarac: string, valeurCarac: string): boolean {
    if (flore.referentielCaracteristiques) {

      for (let refCarac of flore.referentielCaracteristiques) {
        if (refCarac.caracteristique.nom == nomCarac && refCarac.caracteristique.valeur == valeurCarac) {
          return true;
        }
      }
    }
    return false;
  }

  redirectToFicheFlore(nomFlore: string) {
    this.floreService.findByNom(nomFlore).subscribe(resp => {
      this.floreService.flore = resp[0];
    }, error => console.log(error));
  }

  redirectToFicheFaune(nomFaune: string) {
    this.fauneService.findByNom(nomFaune).subscribe(resp => {
      this.fauneService.faune = resp[0];
      this.router.navigateByUrl('NPK/faune/fiche-faune');
    }, error => console.log(error));
    ;
  }

  tableauCaracFauneFlore(flore: Flore, valeurCarac: string): Array<string> {
    let listeCarac: Array<string> = new Array<string>();
    if (flore.referentielFaunes) {
      for (let refCarac of flore.referentielFaunes) {
        if (refCarac.caracteristique && refCarac.caracteristique.nom == 'FloreFaune' && refCarac.caracteristique.valeur == valeurCarac) {
          listeCarac.push(refCarac.faune.nomFaune);
        }
      }
    }
    return listeCarac;
  }

  ajouterAuPanier(produit: Produit) {
    let selec: Selection= new Selection();
    selec.produit = produit;
    this.panierService.findById(parseInt(sessionStorage.getItem('idPanierEnCours'))).subscribe(resp=>{
      selec.nombre=1;
      selec.panier=resp;
      this.selectionService.create(selec).subscribe(resp2=>{selec=resp2
      },error => console.log(error))
    },error => console.log(error))
    // this.compteUtilisateurService.findById(parseInt(sessionStorage.getItem('idCompte'))).subscribe(resp => {
    //   console.log("respUtilisateur" +resp.utilisateur);
    //   let selec: Selection= new Selection();
    //   selec.produit = produit;
    //   this.selectionService.create(selec).subscribe(resp2=>{
    //     selec=resp2;
    //     console.log("resp2" + resp2);
    //     let panier:Panier =new Panier();
    //     resp.utilisateur.paniers = new Array<Panier>();
    //     panier.utilisateur=resp.utilisateur;
    //     panier.selections = new Array<Selection>();
    //     panier.selections.push(selec);
    //     resp.utilisateur.paniers.push(panier);
    //     this.panierService.create(resp.utilisateur.paniers[resp.utilisateur.paniers.length - 1]).subscribe(resp3=>{
    //       console.log("ok")
    //     },error => console.log(error))
    //   },error => console.log(error))
    // },error => console.log(error));
  }

  connexion(){
    this.router.navigateByUrl("NPK/connexion")
  }
}

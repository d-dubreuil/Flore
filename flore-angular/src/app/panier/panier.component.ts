import {Component, OnInit} from '@angular/core';
import {Title} from '@angular/platform-browser';
import {PanierService} from '../services/panier.service';
import {Panier} from '../model/Panier';
import {Selection} from '../model/Selection';
import {Faune} from '../model/Faune';
import {Flore} from '../model/Flore';
import {SelectionService} from '../services/selection.service';
import {Utilisateur} from '../model/Utilisateur';

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


  constructor(private titleService: Title, private panierService: PanierService, private selectionService: SelectionService) {
    this.titleService.setTitle('Panier');
    this.load(this.id);
    this.calcul();
  }

  ngOnInit(): void {
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
  }

  return() {

  }

  etapeSuivante(){
    this.etapePanier = this.etapePanier + 1 ;
  }

  etapePrecedente(){
    this.etapePanier = this.etapePanier -1;
  }

  confirmerAchat(){

  }

  calcul() {
    this.nombreArticle = 0;
    this.total = 0;
    for (let sel of this.selections) {
      this.nombreArticle = this.nombreArticle + sel.nombre;
      this.total = (this.total + (sel.produit.prix * sel.nombre));
    }
  }
}

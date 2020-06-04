import {Component, Input, OnInit} from '@angular/core';
import {Title} from '@angular/platform-browser';
import {CompteUtilisateurService} from '../services/compte-utilisateur.service';
import {CommonService} from '../common.service';
import {Produit} from '../model/Produit';
import {ProduitService} from '../services/produit.service';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.scss']
})
export class ProduitComponent implements OnInit {

  produits: Array<Produit> = new Array<Produit>();
  produitForm: Produit;
  id: number;

  denomination: string;

  constructor(private compteUtilisateurService: CompteUtilisateurService, private titleService: Title, private commonService: CommonService, private produitService: ProduitService) {
    this.titleService.setTitle('Produits');
    this.denomination = this.compteUtilisateurService.denomination;
    this.commonService.page="monCompte";
  }

  ngOnInit(): void {
  }

  list(): Array<Produit> {
    this.produits = this.produitService.findAll();
    let produitsFournisseur: Array<Produit> = new Array<Produit>();
    for (let prod of this.produits) {
      if (prod.fournisseur == this.denomination) {
        produitsFournisseur.push(prod);
      }
    }
    return produitsFournisseur;

  }

  add() {
    this.produitForm = new Produit();
  }

  save() {
    this.produitService.modify(this.produitForm).subscribe(resp => {
      this.produitForm = null;
      this.produitService.load();
    }, error => console.log(error));
  }

  cancel() {
    this.produitForm = null;
  }

  delete(id: number) {
    this.produitService.deleteById(id);
  }

}

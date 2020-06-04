import {Component, Input, OnInit} from '@angular/core';
import {Title} from "@angular/platform-browser";
import {CompteUtilisateurService} from "../services/compte-utilisateur.service";
import {CommonService} from "../common.service";
import {Produit} from "../model/Produit";
import {ProduitService} from "../services/produit.service";

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.scss']
})
export class ProduitComponent implements OnInit {

  produitForm: Produit;
  id: number;

  @Input()
  denomination: string;

  constructor(private compteUtilisateurService: CompteUtilisateurService, private titleService: Title, private commonService: CommonService, private produitService: ProduitService) {
    this.titleService.setTitle("Produits");
  }

  ngOnInit(): void {
  }

  list(): Array<Produit> {
    return this.produitService.findAll();
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

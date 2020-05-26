import {Produit} from "./Produit";
import {Panier} from "./Panier";

export class Selection {
  id:number;
  version:number;
  total:number;
  produit:Produit;
  panier:Panier;

  constructor(id?: number, version?: number, total?: number,
              produit?: Produit, panier?: Panier) {
    this.id = id;
    this.version = version;
    this.total = total;
    this.produit = produit;
    this.panier = panier;
  }
}

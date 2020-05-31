import {Produit} from "./Produit";
import {Panier} from "./Panier";

export class Selection {
  id:number;
  version:number;
  nombre:number;
  produit:Produit;
  panier:Panier;

  constructor(id?: number, version?: number, nombre?: number,
              produit?: Produit, panier?: Panier) {
    this.id = id;
    this.version = version;
    this.nombre = nombre;
    this.produit = produit;
    this.panier = panier;
  }
}

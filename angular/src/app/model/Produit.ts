import {Faune} from "./Faune";
import {Flore} from "./Flore";
import {Utilisateur} from "./Utilisateur";

export class Produit {
  id:number;
  version:number;
  refProduit:number;
  prix:number;
  fournisseur:string;
  stock:number;
  faune:Faune;
  flore:Flore;
  selections:Array<Selection>;
  utilisateur:Utilisateur;

  constructor(id?: number, version?: number, refProduit?: number,
              prix?: number, fournisseur?: string, stock?: number,
              faune?: Faune, flore?: Flore, selections?: Array<Selection>,
              utilisateur?: Utilisateur) {
    this.id = id;
    this.version = version;
    this.refProduit = refProduit;
    this.prix = prix;
    this.fournisseur = fournisseur;
    this.stock = stock;
    this.faune = faune;
    this.flore = flore;
    this.selections = selections;
    this.utilisateur = utilisateur;
  }
}

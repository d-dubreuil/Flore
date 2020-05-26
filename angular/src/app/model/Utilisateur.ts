import {CompteUtilisateur} from "./CompteUtilisateur";
import {Conseil} from "./Conseil";
import {Panier} from "./Panier";
import {Produit} from "./Produit";
import {Flore} from "./Flore";

export class Utilisateur {
  id:number;
  version:number;
  disc:string;
  compteUtilisateur:CompteUtilisateur;
  conseils:Array<Conseil>;
  paniers:Array<Panier>;
  produits:Array<Produit>;
  flores:Array<Flore>;

  constructor(id?: number, version?: number, disc?: string, compteUtilisateur?: CompteUtilisateur,
              conseils?: Array<Conseil>, paniers?: Array<Panier>, produits?: Array<Produit>,
              flores?: Array<Flore>) {
    this.id = id;
    this.version = version;
    this.disc = disc;
    this.compteUtilisateur = compteUtilisateur;
    this.conseils = conseils;
    this.paniers = paniers;
    this.produits = produits;
    this.flores = flores;
  }
}

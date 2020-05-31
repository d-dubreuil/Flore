import {Commande} from "./Commande";
import {Utilisateur} from "./Utilisateur";
import {Selection} from './Selection';

export class Panier {
  id:number;
  version:number;
  total:number;
  commande:Commande;
  selections:Array<Selection>;
  utilisateur:Utilisateur;


  constructor(id?: number, version?: number, total?: number,
              commande?: Commande, selections?: Array<Selection>,
              utilisateur?: Utilisateur) {
    this.id = id;
    this.version = version;
    this.total = total;
    this.commande = commande;
    this.selections = selections;
    this.utilisateur = utilisateur;
  }
}

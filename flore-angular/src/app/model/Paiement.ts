import {Commande} from "./Commande";

export class Paiement {
  id:number;
  version:number;
  numeroCarte:string;
  dtValidite:string;
  cryptogramme:string
  montant:number;
  typeCarte:string;
  commande:Commande;


  constructor(id?: number, version?: number, numeroCarte?: string,
              dtValidite?: string, cryptogramme?: string, montant?: number,
              typeCarte?:string, commande?: Commande) {
    this.id = id;
    this.version = version;
    this.numeroCarte = numeroCarte;
    this.dtValidite = dtValidite;
    this.cryptogramme = cryptogramme;
    this.montant = montant;
    this.typeCarte = typeCarte;
    this.commande = commande;
  }
}

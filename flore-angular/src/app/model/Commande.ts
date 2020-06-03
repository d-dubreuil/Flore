import {Paiement} from './Paiement';
import {Panier} from './Panier';

export class Commande {
  id: number;
  version: number;
  reference: number;
  typeEnvoi: string;
  total: number;
  dtCommande: Date;
  paiement: Paiement;
  panier: Panier;


  constructor(id?: number, version?: number, reference?: number,
              typeEnvoi?: string, total?: number, dtCommande?: Date, paiement?: Paiement,
              panier?: Panier) {
    this.id = id;
    this.version = version;
    this.reference = reference;
    this.typeEnvoi = typeEnvoi;
    this.total = total;
    this.dtCommande = dtCommande;
    this.paiement = paiement;
    this.panier = panier;
  }
}

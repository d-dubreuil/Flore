import {CompteUtilisateur} from "./CompteUtilisateur";
import {Caracteristique} from "./Caracteristique";

export class ReferentielUtilisateur {
  id:number;
  version:number;
  compteUtilisateur:CompteUtilisateur;
  caracteristique:Caracteristique;

  constructor(id?: number, version?: number, compteUtilisateur?: CompteUtilisateur,
              caracteristique?: Caracteristique) {
    this.id = id;
    this.version = version;
    this.compteUtilisateur = compteUtilisateur;
    this.caracteristique = caracteristique;
  }
}

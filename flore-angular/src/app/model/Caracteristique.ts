import {ReferentielUtilisateur} from "./ReferentielUtilisateur";
import {ReferentielCaracteristique} from "./ReferentielCaracteristique";
import {ReferentielFaune} from "./ReferentielFaune";

export class Caracteristique {
  id:number;
  version:number;
  nom:string;
  valeur:string;
  bonusMalus:boolean;
  typeCarac:string;
  referentielUtilisateurs:Array<ReferentielUtilisateur>;
  referentielCaracteristiques:Array<ReferentielCaracteristique>;
  referentielFaunes:Array<ReferentielFaune>;


  constructor(id?: number, version?: number, nom?: string, valeur?: string,
              bonusMalus?: boolean, typeCarac?: string,
              referentielUtilisateurs?: Array<ReferentielUtilisateur>,
              referentielCaracteristiques?: Array<ReferentielCaracteristique>,
              referentielFaunes?: Array<ReferentielFaune>) {
    this.id = id;
    this.version = version;
    this.nom = nom;
    this.valeur = valeur;
    this.bonusMalus = bonusMalus;
    this.typeCarac = typeCarac;
    this.referentielUtilisateurs = referentielUtilisateurs;
    this.referentielCaracteristiques = referentielCaracteristiques;
    this.referentielFaunes = referentielFaunes;
  }
}

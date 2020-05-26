import {Caracteristique} from "./Caracteristique";
import {Flore} from "./Flore";

export class ReferentielCaracteristique {
  id:number;
  version:number;
  caracteristique:Caracteristique;
  flore:Flore;


  constructor(id?: number, version?: number, caracteristique?: Caracteristique,
              flore?: Flore) {
    this.id = id;
    this.version = version;
    this.caracteristique = caracteristique;
    this.flore = flore;
  }
}

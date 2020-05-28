import {Caracteristique} from "./Caracteristique";
import {Flore} from "./Flore";
import {Faune} from "./Faune";

export class ReferentielFaune {
  id:number;
  version:number;
  caracteristique:Caracteristique;
  flore:Flore;
  faune:Faune;

  constructor(id?: number, version?: number, caracteristique?: Caracteristique,
              flore?: Flore, faune?: Faune) {
    this.id = id;
    this.version = version;
    this.caracteristique = caracteristique;
    this.flore = flore;
    this.faune = faune;
  }
}

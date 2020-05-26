import {Utilisateur} from "./Utilisateur";

export class Conseil {
  id:number;
  version:number;
  nom:string;
  texte:string;
  theme:string;
  dtpublication:Date;
  utilisateur:Utilisateur;


  constructor(id?: number, version?: number, nom?: string, texte?: string,
              theme?: string, dtpublication?: Date, utilisateur?: Utilisateur) {
    this.id = id;
    this.version = version;
    this.nom = nom;
    this.texte = texte;
    this.theme = theme;
    this.dtpublication = dtpublication;
    this.utilisateur = utilisateur;
  }
}

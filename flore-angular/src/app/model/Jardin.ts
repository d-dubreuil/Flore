import {Flore} from "./Flore";
import {CompteUtilisateur} from "./CompteUtilisateur";

export class Jardin {
  id:number;
  version:number;
  nom:string;
  flores:Array<Flore>;
  compteUtilisateur:CompteUtilisateur;


  constructor(id?: number, version?: number, nom?: string,
              flores?: Array<Flore>, compteUtilisateur?: CompteUtilisateur) {
    this.id = id;
    this.version = version;
    this.nom = nom;
    this.flores = flores;
    this.compteUtilisateur = compteUtilisateur;
  }
}

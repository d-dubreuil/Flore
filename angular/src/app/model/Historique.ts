import {CompteUtilisateur} from "./CompteUtilisateur";

export class Historique {
  id:number;
  version:number;
  recherche:string;
  nomRecherche:string;
  compte:CompteUtilisateur;


  constructor(id?: number, version?: number, recherche?: string,
              nomRecherche?: string, compte?: CompteUtilisateur) {
    this.id = id;
    this.version = version;
    this.recherche = recherche;
    this.nomRecherche = nomRecherche;
    this.compte = compte;
  }
}

import {ReferentielCaracteristique} from "./ReferentielCaracteristique";
import {ReferentielFaune} from "./ReferentielFaune";
import {Utilisateur} from "./Utilisateur";
import {Produit} from "./Produit";
import {Favoris} from "./Favoris";
import {Jardin} from "./Jardin";

export class Flore {
  id:number;
  version:number;
  nom:string;
  referentielCaracteristiques:Array<ReferentielCaracteristique>;
  referentielFaunes:Array<ReferentielFaune>;
  utilisateurs:Array<Utilisateur>;
  produits:Array<Produit>;
  favoris:Array<Favoris>;
  jardins:Array<Jardin>;


  constructor(id?: number, version?: number, nom?: string,
              referentielCaracteristiques?: Array<ReferentielCaracteristique>,
              referentielFaunes?: Array<ReferentielFaune>,
              utilisateurs?: Array<Utilisateur>, produits?: Array<Produit>,
              favoris?: Array<Favoris>, jardins?: Array<Jardin>) {
    this.id = id;
    this.version = version;
    this.nom = nom;
    this.referentielCaracteristiques = referentielCaracteristiques;
    this.referentielFaunes = referentielFaunes;
    this.utilisateurs = utilisateurs;
    this.produits = produits;
    this.favoris = favoris;
    this.jardins = jardins;
  }

  filterCarac(nomCarac:string):string{
    for (let refCarac of this.referentielCaracteristiques){
      if(refCarac.caracteristique.nom == nomCarac){
        return refCarac.caracteristique.valeur;
      }
    }
    return 'non renseigné'
  }
}

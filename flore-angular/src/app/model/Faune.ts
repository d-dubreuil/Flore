import {ReferentielFaune} from './ReferentielFaune';
import {Produit} from './Produit';

export class Faune {
  id: number;
  version: number;
  nomFaune: string;
  referentielFaunes: Array<ReferentielFaune>;
  produits:Array<Produit>;


  constructor(id?: number, version?: number, nomFaune?: string,
              referentielFaunes?: Array<ReferentielFaune>,produits?:Array<Produit>) {
    this.id = id;
    this.version = version;
    this.nomFaune = nomFaune;
    this.referentielFaunes = referentielFaunes;
    this.produits = produits;
  }

  filterCarac(nomCarac:string):string{
    for (let refCarac of this.referentielFaunes){
      if(refCarac.caracteristique.nom == nomCarac){
        return refCarac.caracteristique.valeur;
      }
    }
    return 'non renseigné'
  }


}

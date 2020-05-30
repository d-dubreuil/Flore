import {ReferentielFaune} from './ReferentielFaune';

export class Faune {
  id: number;
  version: number;
  nomFaune: string;
  referentielFaunes: Array<ReferentielFaune>;

  constructor(id?: number, version?: number, nomFaune?: string,
              referentielFaunes?: Array<ReferentielFaune>) {
    this.id = id;
    this.version = version;
    this.nomFaune = nomFaune;
    this.referentielFaunes = referentielFaunes;
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

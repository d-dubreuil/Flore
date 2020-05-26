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
}

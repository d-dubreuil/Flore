import { Component, OnInit } from '@angular/core';
import {Faune} from "../model/Faune";
import {FauneService} from "../services/faune.service";
import {Caracteristique} from "../model/Caracteristique";
import {CaracteristiqueService} from "../services/caracteristique.service";

@Component({
  selector: 'app-faune',
  templateUrl: './faune.component.html',
  styleUrls: ['./faune.component.scss']
})

export class FauneComponent implements OnInit {

  faunes: Array<Faune>;
  caracs: Array<Caracteristique>;

  constructor(private fauneService: FauneService, private caracteristiqueService: CaracteristiqueService) { }

  ngOnInit(): void {
  }

  list(): Array<Faune> {
    return this.fauneService.findAll();
  }

  filterCarac(faune: Faune, nomCarac: string): string {
    if (faune.referentielFaunes) {
      for (let refCarac of faune.referentielFaunes) {
        if (refCarac.caracteristique.nom == nomCarac) {
          return refCarac.caracteristique.valeur;
        }
      }
    }
    return 'non renseigné';
  }

}

import {Component, OnInit} from '@angular/core';
import {Faune} from '../model/Faune';
import {FauneService} from '../services/faune.service';
import {CaracteristiqueService} from '../services/caracteristique.service';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-faune',
  templateUrl: './faune.component.html',
  styleUrls: ['./faune.component.scss']
})

export class FauneComponent implements OnInit {

  nomFaune: string = '';

  constructor(private fauneService: FauneService, private caracteristiqueService: CaracteristiqueService, private titleService: Title) {
    this.titleService.setTitle('Faune');
  }

  ngOnInit(): void {
  }

  list(): Array<Faune> {
    return this.fauneService.findAll();
  }

  filterCarac(faune: Faune, nomCarac: string): string {
    if (faune.referentielFaunes) {
      for (let refFaune of faune.referentielFaunes) {
        if (refFaune.caracteristique.nom == nomCarac) {
          return refFaune.caracteristique.valeur;
        }
      }
    }
    return 'non renseigné';
  }

  filterAlpha(faune: Faune, nomCarac: string): string {

  }


}

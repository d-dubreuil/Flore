import { Component, OnInit } from '@angular/core';
import {Faune} from "../model/Faune";
import {FauneService} from "../services/faune.service";
import {Caracteristique} from "../model/Caracteristique";
import {CaracteristiqueService} from "../services/caracteristique.service";
import {FloreService} from "../services/flore.service";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-faune',
  templateUrl: './faune.component.html',
  styleUrls: ['./faune.component.scss']
})

export class FauneComponent implements OnInit {

  faunes: Array<Faune>;
  caracs: Array<Caracteristique>;
  lettre: string = '';
  lettres: Array<string> = [];
  request: string = '';
  A : string;
  B : string;
  value: string;


  constructor(private fauneService: FauneService, private caracteristiqueService: CaracteristiqueService, private titleService: Title) {
    this.titleService.setTitle("Faune");
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

  clickAB() {
    this.value = 'AB';
    this.request = '(this.faune.nomFaune.toUpperCase().startsWith(\'A\'))';
    console.log(this.value);
    console.log(this.request);
  }
}

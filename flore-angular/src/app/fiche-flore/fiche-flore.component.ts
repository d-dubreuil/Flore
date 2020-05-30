import { Component, OnInit } from '@angular/core';
import {FloreService} from '../services/flore.service';
import {Title} from '@angular/platform-browser';
import {Flore} from '../model/Flore';
import {normalizeExtraEntryPoints} from '@angular-devkit/build-angular/src/angular-cli-files/models/webpack-configs';

@Component({
  selector: 'app-fiche-flore',
  templateUrl: './fiche-flore.component.html',
  styleUrls: ['./fiche-flore.component.scss']
})
export class FicheFloreComponent implements OnInit {
  nomFlore:string;
  flore:Flore;

  constructor(public floreService:FloreService, private titleService: Title) {
    this.titleService.setTitle("Fiche Flore");
  }

  ngOnInit(): void {
    this.findFlore();
  }

  findFlore(){
    this.floreService.findByNom(this.nomFlore).subscribe(next=>{
      this.flore=next;
    },error => console.log(error));
  }

  filterCarac(flore: Flore, nomCarac: string): string {
    if (flore.referentielCaracteristiques) {

      for (let refCarac of flore.referentielCaracteristiques) {
        if (refCarac.caracteristique.nom == nomCarac) {
          return refCarac.caracteristique.valeur;
        }
      }
    }

    return 'non renseigné';
  }

}

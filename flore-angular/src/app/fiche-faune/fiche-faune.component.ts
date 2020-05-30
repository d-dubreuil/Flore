import { Component, OnInit } from '@angular/core';
import {FloreService} from '../services/flore.service';
import {Title} from '@angular/platform-browser';
import {FauneService} from '../services/faune.service';
import {Router} from '@angular/router';
import {Faune} from '../model/Faune';
import {Flore} from '../model/Flore';

@Component({
  selector: 'app-fiche-faune',
  templateUrl: './fiche-faune.component.html',
  styleUrls: ['./fiche-faune.component.scss']
})
export class FicheFauneComponent implements OnInit {
  faune:Faune;
  plusFloreRepoussant:boolean=false;
  plusFloreAttirant:boolean=false;
  plusFlorePollenisant:boolean=false;
  plusFaunePredateur:boolean=false;
  plusFauneProie:boolean=false

  constructor(public floreService: FloreService, private titleService: Title, public fauneService: FauneService, private router: Router) {
    this.titleService.setTitle('Fiche-Faune');
  }

  ngOnInit(): void {
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

  tableauCarac(faune: Faune, nomCarac: string, valeurCarac:string): Array<string> {
    let listeFlore: Array<string> = new Array<string>();

    if (faune.referentielFaunes) {

      for (let refCarac of faune.referentielFaunes) {
        if (refCarac.caracteristique && refCarac.caracteristique.nom == nomCarac &&refCarac.caracteristique.valeur==valeurCarac && refCarac.flore) {
          listeFlore.push(refCarac.flore.nom);
        }
      }
    }
    return listeFlore;
  }

  tableauFaune(faune: Faune, nomCarac: string): Array<string> {
    let listeFlore: Array<string> = new Array<string>();

    if (faune.referentielFaunes) {

      for (let refCarac of faune.referentielFaunes) {
        if (refCarac.caracteristique && refCarac.caracteristique.nom == nomCarac) {
          listeFlore.push(refCarac.caracteristique.valeur);
        }
      }
    }
    return listeFlore;
  }

  redirectToFicheFlore(nomFlore: string) {
    this.floreService.findByNom(nomFlore).subscribe(resp => {
      this.floreService.flore = resp[0];
      this.router.navigateByUrl("NPK/flore/fiche-flore");
    }, error => console.log(error));
  }

  redirectToFicheFaune(nomFaune: string) {
    this.fauneService.findByNom(nomFaune).subscribe(resp => {
      this.fauneService.faune = resp[0];
      this.router.navigateByUrl('NPK/faune/fiche-faune');
    }, error => console.log(error));
    ;
  }

}

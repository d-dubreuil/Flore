import {Component, OnInit} from '@angular/core';
import {FloreService} from '../services/flore.service';
import {Title} from '@angular/platform-browser';
import {Flore} from '../model/Flore';
import {normalizeExtraEntryPoints} from '@angular-devkit/build-angular/src/angular-cli-files/models/webpack-configs';
import {FauneService} from '../services/faune.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-fiche-flore',
  templateUrl: './fiche-flore.component.html',
  styleUrls: ['./fiche-flore.component.scss']
})
export class FicheFloreComponent implements OnInit {
  nomFlore: string;
  flore: Flore;
  plusFauneAttire:boolean=false;
  plusFauneRepoussee:boolean=false;
  plusFloreKompagne:boolean=false;
  plusFloreEnnemie:boolean=false;

  constructor(public floreService: FloreService, private titleService: Title, public fauneService: FauneService, private router: Router) {
    this.titleService.setTitle('Fiche-Flore');
  }

  ngOnInit(): void {
    this.findFlore();
  }

  findFlore() {
    this.floreService.findByNom(this.nomFlore).subscribe(next => {
      this.flore = next;
    }, error => console.log(error));
  }

  filterCarac(flore: Flore, nomCarac: string): string {
    if (flore.referentielCaracteristiques) {

      for (let refCarac of flore.referentielCaracteristiques) {
        if (refCarac.caracteristique && refCarac.caracteristique.nom == nomCarac) {
          return refCarac.caracteristique.valeur;
        }
      }
    }

    return 'non renseigné';
  }

  tableauCarac(flore: Flore, nomCarac: string): Array<string> {
    let listeCarac: Array<string> = new Array<string>();

    if (flore.referentielCaracteristiques) {

      for (let refCarac of flore.referentielCaracteristiques) {
        if (refCarac.caracteristique.nom == nomCarac) {
          listeCarac.push(refCarac.caracteristique.valeur);
        }
      }
    }
    return listeCarac;
  }

  valeurCarac(flore: Flore, nomCarac: string, valeurCarac: string): boolean {
    if (flore.referentielCaracteristiques) {

      for (let refCarac of flore.referentielCaracteristiques) {
        if (refCarac.caracteristique.nom == nomCarac && refCarac.caracteristique.valeur == valeurCarac) {
          return true;
        }
      }
    }
    return false;
  }

  redirectToFicheFlore(nomFlore: string) {
    this.floreService.findByNom(nomFlore).subscribe(resp => {
      this.floreService.flore = resp[0];
    }, error => console.log(error));
  }

  redirectToFicheFaune(nomFaune: string) {
    this.fauneService.findByNom(nomFaune).subscribe(resp => {
      this.fauneService.faune = resp[0];
      this.router.navigateByUrl('NPK/faune/fiche-faune');
    }, error => console.log(error));
    ;
  }

  tableauCaracFauneFlore(flore: Flore, valeurCarac: string): Array<string> {
    let listeCarac: Array<string> = new Array<string>();
    if (flore.referentielFaunes) {
      for (let refCarac of flore.referentielFaunes) {
        if (refCarac.caracteristique && refCarac.caracteristique.nom == 'FloreFaune' && refCarac.caracteristique.valeur == valeurCarac) {
          listeCarac.push(refCarac.faune.nomFaune);
        }
      }
    }
    return listeCarac;
  }

}

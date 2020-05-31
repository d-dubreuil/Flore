import {Component, OnInit} from '@angular/core';
import {Faune} from '../model/Faune';
import {FauneService} from '../services/faune.service';
import {CaracteristiqueService} from '../services/caracteristique.service';
import {Title} from '@angular/platform-browser';
import {Flore} from '../model/Flore';
import {Router} from '@angular/router';

@Component({
  selector: 'app-faune',
  templateUrl: './faune.component.html',
  styleUrls: ['./faune.component.scss']
})

export class FauneComponent implements OnInit {

  nomFaune: string = '';
  abc:string=''

  constructor(private fauneService: FauneService, private caracteristiqueService: CaracteristiqueService, private titleService: Title, private router:Router) {
    this.titleService.setTitle('Faune');
  }

  ngOnInit(): void {
  }

  list(): Array<Faune> {
    return this.fauneService.findAll().sort(function(a,b) {
      return a.nomFaune.localeCompare(b.nomFaune);
    });
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

  filterAB() {
    this.abc='AAB';
  }
  filterCD() {
    this.abc='CCD';
  }
  filterEF() {
    this.abc='EEF';
  }
  filterGH() {
    this.abc='GGH';
  }
  filterIJK() {
    this.abc='IJK';
  }
  filterLMN() {
    this.abc='LMN';
  }
  filterOPQ() {
    this.abc='OPQ';
  }
  filterRST() {
    this.abc='RST';
  }
  filterUVW() {
    this.abc='UVW';
  }
  filterXYZ() {
    this.abc='XYZ';
  }
  filterNull(){
    this.abc='';
  }

  redirectToFicheFaune(faune:Faune){
    this.fauneService.faune = faune;
    this.router.navigateByUrl('NPK/faune/fiche-faune');
  }


}

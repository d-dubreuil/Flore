import {Component, OnInit} from '@angular/core';
import {CaracteristiqueService} from '../services/caracteristique.service';
import {FauneService} from '../services/faune.service';
import {FloreService} from '../services/flore.service';
import {Title} from '@angular/platform-browser';
import {CommonService} from '../common.service';
import {ConseilService} from '../services/conseil.service';
import {Flore} from '../model/Flore';
import {Faune} from '../model/Faune';
import {Conseil} from '../model/Conseil';
import {Caracteristique} from '../model/Caracteristique';
import {count} from 'rxjs/operators';

@Component({
  selector: 'app-compte-utilisateur',
  templateUrl: './compte-utilisateur.component.html',
  styleUrls: ['./compte-utilisateur.component.scss']
})
export class CompteUtilisateurComponent implements OnInit {

  nomFiche: string = '';
  floreForm: Flore = new Flore();
  caracForm: Caracteristique = null;
  typeCarac: Array<string> = new Array<string>();
  nomCarac: Array<string> = new Array<string>();
  listNom: Array<string> = new Array<string>();
  carac: Array<Caracteristique> = new Array<Caracteristique>();
  fauneForm: Faune = null;
  conseilForm: Conseil = null;

  constructor(private floreService: FloreService, private fauneService: FauneService, private conseilService: ConseilService, private titleService: Title, private caracteristiqueService: CaracteristiqueService, private commonService: CommonService) {
    this.titleService.setTitle('CompteUtilisateur');
  }

  ngOnInit(): void {
    this.commonService.findAllTypeCarac().subscribe(resp => this.typeCarac = resp, err => console.log(err));
  }

// Méthodes pour l'accordion 1 : Edition d'une fiche
  loadTypeCarac(typeCarac: string) {
    this.caracteristiqueService.findByType(typeCarac).subscribe(resp => {
      this.carac = resp;
    }, error => console.log(error));
  }

  doublons() {
    let number = 0;
    for (let car of this.carac) {
      this.listNom.push(car.nom);
    }
    console.log(this.listNom);
    for (let car2 of this.listNom) {
      console.log(car2);
      if (number == 0) {
        number = number+1;
        this.nomCarac.push(car2);
        console.log(123);
      }
      for (let car3 of this.nomCarac) {
        console.log(car3);
        if (car2 != car3) {
          this.nomCarac.push(car2);
          console.log("##");
        }
      }
    }
    return this.nomCarac;


  }

  loadNomCarac(typeCarac: string, nom: string) {
    this.caracteristiqueService.findByTypeEtNom(typeCarac, nom).subscribe(resp => {
      this.carac = resp;
    }, error => console.log(error));
  }

  // loadValeurCarac(typeCarac: string, nomCarac: string, valeurCarac: string) {
  //   this.caracteristiqueService.findByAttribut(typeCarac, nomCarac, valeurCarac).subscribe(resp => {
  //     this.carac2 = resp;
  //   }, error => console.log(error));
  // }

  addFlore() {
    this.floreForm = new Flore();
  }

  addCarac() {
    this.caracForm = new Caracteristique();
  }

  saveNomFlore() {
    this.floreForm.nom = this.nomFiche;
    this.floreService.create(this.floreForm).subscribe(resp => {
      this.floreForm = null;
      this.nomFiche = '';
      this.floreService.load();
    }, error => console.log(error));
  }

  saveCarac() {
    if (!this.caracForm.id) {
      this.caracteristiqueService.create(this.caracForm).subscribe(resp => {
          this.caracForm = null;
          this.caracteristiqueService.load();
        },
        error => console.log(error)
      )
      ;
    } else {
      this.caracteristiqueService.modify(this.caracForm).subscribe(resp => {
        this.caracForm = null;
        this.caracteristiqueService.load();
      }, error => console.log(error));
    }
  }

  cancelFlore() {
    this.floreForm = null;
  }

  cancelCarac() {
    this.caracForm = null;
  }


// Méthodes pour l'accordion 2 : Edition d'une caractéristique

}

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
  listValue: Array<string> = new Array<string>();


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
      console.log(resp);
    }, error => console.log(error));
  }

  doublons() {
    let number = 0;
    console.log("1" + this.listNom);
    console.log("2" + this.listValue);

    for (let car of this.carac) {
      this.listNom.push(car.nom);
    }

    for (let element of this.listNom) {
      if (!this.listValue.includes(element)) {
        this.listValue.push(element);
      }
    }

    console.log("3" + this.listNom);
    console.log("4" +this.listValue);
    return this.listValue;
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

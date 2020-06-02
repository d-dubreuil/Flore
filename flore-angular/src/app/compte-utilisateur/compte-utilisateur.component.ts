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
import {ReferentielCaracteristiqueService} from '../services/referentiel-caracteristique.service';
import {ReferentielCaracteristique} from '../model/ReferentielCaracteristique';

@Component({
  selector: 'app-compte-utilisateur',
  templateUrl: './compte-utilisateur.component.html',
  styleUrls: ['./compte-utilisateur.component.scss']
})
export class CompteUtilisateurComponent implements OnInit {

  nomFiche: string = '';
  nomLatin: string = '';

  nomFlore: string;
  nom: string;
  valeur: string;

  floreForm: Flore = new Flore();
  fauneForm: Faune = new Faune();
  conseilForm: Conseil = new Conseil();
  nomFloreSearch: Flore = new Flore();
  nomFauneSearch: Faune = new Faune();
  nomConseilSearch: Conseil = new Conseil();
  floreAModifier: Flore = new Flore();
  caracAModifier: Caracteristique = new Caracteristique();
  refCaracACree: ReferentielCaracteristique = new ReferentielCaracteristique();
  caracForm: Caracteristique = new Caracteristique();
  caracFormNomLatin: Caracteristique = new Caracteristique();
  caracFormLink: Caracteristique = new Caracteristique();

  listValue: Array<string> = new Array<string>();
  typeCarac: Array<string> = new Array<string>();
  nomCarac: Array<string> = new Array<string>();
  listNom: Array<string> = new Array<string>();

  carac: Array<Caracteristique> = new Array<Caracteristique>();

  caracFormLatinVisible: boolean = false;
  caracFormVisible: boolean = false;
  caracFormLinkVisible: boolean = false;
  nomFloreBoolean: boolean = false;
  nomFauneBoolean: boolean = false;
  nomConseilBoolean: boolean = false;
  listFloreVisible: boolean = false;
  listFauneVisible: boolean = false;
  listCaracVisible: boolean = false;

  constructor(private floreService: FloreService, private fauneService: FauneService, private conseilService: ConseilService, private titleService: Title, private caracteristiqueService: CaracteristiqueService, private commonService: CommonService, private referentielCaracteristiqueService: ReferentielCaracteristiqueService) {
    this.titleService.setTitle('CompteUtilisateur');
  }

  ngOnInit(): void {
    this.commonService.findAllTypeCarac().subscribe(resp => this.typeCarac = resp, err => console.log(err));
  }

// METHODES LOAD
  loadTypeCarac(typeCarac: string) {
    this.caracteristiqueService.findByType(typeCarac).subscribe(resp => {
      this.carac = resp;
      console.log(resp);
    }, error => console.log(error));
  }

  loadNomCarac(typeCarac: string, nom: string) {
    this.caracteristiqueService.findByTypeEtNom(typeCarac, nom).subscribe(resp => {
      this.carac = resp;
    }, error => console.log(error));
  }

  loadNomFlore(nom: string) {
    this.floreService.findByNom(nom).subscribe(resp => {
      this.nomFloreSearch = resp[0];
      console.log(this.nomFloreSearch)
    }, error => console.log('erreur nom flore'));
  }

  loadListFlore() {
    this.listFloreVisible = true;
    this.listFauneVisible = false;
    this.listCaracVisible = false;
    this.floreService.findAll();
  }

  loadListFaune() {
    this.listFloreVisible = false;
    this.listFauneVisible = true;
    this.listCaracVisible = false;
    this.fauneService.findAll();
  }

  loadListCarac() {
    this.listFloreVisible = false;
    this.listFauneVisible = false;
    this.listCaracVisible = true;
    this.conseilService.findAll();
  }

//AUTRES METHODES
  doublons() {
    for (let car of this.carac) {
      this.listNom.push(car.nom);
    }
    for (let element of this.listNom) {
      if (!this.listValue.includes(element)) {
        this.listValue.push(element);
      }
    }
    return this.listValue;
  }

  listFlore(): Array<Flore> {
    return this.floreService.findAll().sort(function(a,b) {
      return a.nom.localeCompare(b.nom);
    });
  }

  listCarac(): Array<Caracteristique> {
    return this.caracteristiqueService.findAll().sort(function(a,b) {
      return a.typeCarac.localeCompare(b.typeCarac);
    });
  }

  listFaune(): Array<Faune> {
    return this.fauneService.findAll().sort(function(a,b){
      return a.nomFaune.localeCompare(b.nomFaune);
    });
  }


//METHODES ADD
  addFlore() {
    this.floreForm = new Flore();
  }

  addCaracNomLatin() {
    this.caracFormLatinVisible = true;
    this.caracFormNomLatin = new Caracteristique();
  }

  addCarac() {
    this.caracFormVisible = true;
    this.caracForm = new Caracteristique();
  }

  addLink() {
    this.caracFormLinkVisible = true;
    this.caracFormLink = new Caracteristique();
  }

  addNomFlore() {
    this.nomFloreBoolean = true;
    this.nomFauneBoolean = false;
    this.nomConseilBoolean = false;
    this.nomFloreSearch = new Flore();
  }

  addNomFaune() {
    this.nomFloreBoolean = false;
    this.nomFauneBoolean = true;
    this.nomConseilBoolean = false;
    this.nomFauneSearch = new Faune();
  }

  addNomConseil() {
    this.nomFloreBoolean = false;
    this.nomFauneBoolean = false;
    this.nomConseilBoolean = true;
    this.nomConseilSearch = new Conseil();
  }

//METHODES EDIT
  editFlore(id: number) {
    this.floreService.findById(id).subscribe(resp => {
        this.floreForm = resp;
      },
      error => console.log(error));
  }

  editFaune(id: number) {
    this.fauneService.findById(id).subscribe(resp => {
        this.fauneForm = resp;
      },
      error => console.log(error));
  }

  editConseil(id: number) {
    this.conseilService.findById(id).subscribe(resp => {
        this.conseilForm = resp;
      },
      error => console.log(error));
  }


//METHODES SAVE
  saveNomFlore() {
    this.floreForm.nom = this.nomFiche;
    this.floreService.create(this.floreForm).subscribe(resp => {
      this.floreForm = new Flore();
      this.floreService.load();
    }, error => console.log(error));
  }

  saveNomFaune() {
    this.fauneForm.nomFaune = this.nomFiche;
    this.fauneService.create(this.fauneForm).subscribe(resp => {
      this.fauneForm = new Faune();
      this.fauneService.load();
    }, error => console.log(error));
  }

  saveNomConseil() {
    this.conseilForm.nom = this.nomFiche;
    this.conseilService.create(this.conseilForm).subscribe(resp => {
      this.conseilForm = new Conseil();
      this.conseilService.load();
    }, error => console.log(error));
  }

  saveCarac() {
    this.caracteristiqueService.create(this.caracForm).subscribe(resp => {
      this.caracForm = new Caracteristique();
      this.caracteristiqueService.load();
      this.caracFormVisible=false;
      this.caracFormLatinVisible=false;
    }, error => console.log(error));
  }

  saveCaracLatin() {
    this.caracteristiqueService.create(this.caracFormNomLatin).subscribe(resp => {
      this.caracFormNomLatin = new Caracteristique();
      this.caracteristiqueService.load();
    }, error => console.log(error));
  }

  saveFlore() {
    this.floreService.create(this.floreForm).subscribe(resp => {
      this.floreForm = new Flore();
      this.floreService.load();
    }, error => console.log(error));
  }

  saveCaracWithFlore() {
    this.floreService.findByNom(this.nomFlore).subscribe(
      resp => {
        this.floreAModifier = resp;
        this.caracteristiqueService.findByAttribut(this.caracForm.typeCarac, this.caracForm.nom, this.caracForm.valeur).subscribe(resp => {
          this.caracAModifier = resp;
          this.refCaracACree.caracteristique = this.caracAModifier;
          this.refCaracACree.flore = this.floreAModifier[0];
          console.log(this.refCaracACree);
          this.referentielCaracteristiqueService.create(this.refCaracACree).subscribe(resp => alert('création réussie' + this.floreAModifier.nom + 'a été modifiée'), error => console.log(error));
        }, error => console.log((error)));
      }, error => console.log(error)
    );
  }

// METHODES CANCEL:
  cancelFlore() {
    this.floreForm = null;
  }

  cancelCarac() {
    this.caracForm = null;
  }

  cancelNomFlore() {
    this.floreForm = null;
  }

  cancelNomFaune() {
    this.fauneForm = null;
  }

  cancelNomConseil() {
    this.conseilForm = null;
  }

  cancelCaracForm() {
    this.caracFormVisible = false;
    this.caracFormLatinVisible = false;
    this.caracForm = new Caracteristique();
  }

  cancelCaracFormLink() {
    this.caracFormLinkVisible = false;
    this.caracFormLink = new Caracteristique();
  }

  //METHODES DELETE
  deleteFlore(id: number) {
    this.floreService.deleteById(id);
  }

  deleteCarac(id: number) {
    this.caracteristiqueService.deleteById(id);
  }

  deleteFaune(id: number) {
    this.fauneService.deleteById(id);
  }
}

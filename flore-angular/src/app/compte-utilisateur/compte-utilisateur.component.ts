import { Component, OnInit } from '@angular/core';
import {CaracteristiqueService} from "../services/caracteristique.service";
import {FauneService} from "../services/faune.service";
import {FloreService} from "../services/flore.service";
import {Flore} from "../model/Flore";
import {Faune} from "../model/Faune";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-compte-utilisateur',
  templateUrl: './compte-utilisateur.component.html',
  styleUrls: ['./compte-utilisateur.component.scss']
})
export class CompteUtilisateurComponent implements OnInit {

  floreForm: Flore = null;
  fauneForm: Faune = null;

  constructor(private floreService: FloreService, private fauneService: FauneService, private caracteristiqueService: CaracteristiqueService) {
  }

  ngOnInit(): void {
  }

  // FLORE

  listFlore(): Array<Flore> {
    return this.floreService.findAll();
  }

  addFlore() {
    this.floreForm = new Flore();
  }

  editFlore(id: number) {
    this.floreService.findById(id).subscribe(resp => {
      this.floreForm = resp;
    },
      error => console.log(error))
  }

  deleteFlore(id: number) {
    this.floreService.deleteById(id);
  }

  // FAUNE

  listFaune(): Array<Faune> {
    return this.fauneService.findAll();
  }

  addFaune() {
    this.fauneForm = new Faune();
  }

  editFaune(id: number) {
    this.fauneService.findById(id).subscribe(resp => {
        this.fauneForm = resp;
      },
      error => console.log(error))
  }

  deleteFaune(id: number) {
    this.fauneService.deleteById(id);
  }

}

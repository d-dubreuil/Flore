import { Component, OnInit } from '@angular/core';
import {CompteUtilisateurService} from "../services/compte-utilisateur.service";
import {Title} from "@angular/platform-browser";
import {CompteUtilisateur} from "../model/CompteUtilisateur";

@Component({
  selector: 'app-informations-personnelles',
  templateUrl: './informations-personnelles.component.html',
  styleUrls: ['./informations-personnelles.component.scss']
})
export class InformationsPersonnellesComponent implements OnInit {

  informationsForm : CompteUtilisateur;

  constructor(private compteUtilisateurService : CompteUtilisateurService, private titleService: Title) {
    this.titleService.setTitle("Informations Personnelles");
  }

  ngOnInit(): void {
  }



}

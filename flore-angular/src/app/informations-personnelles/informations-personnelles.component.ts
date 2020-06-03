import {Component, Input, OnInit} from '@angular/core';
import {CompteUtilisateurService} from "../services/compte-utilisateur.service";
import {Title} from "@angular/platform-browser";
import {CompteUtilisateur} from "../model/CompteUtilisateur";
import {CommonService} from "../common.service";

@Component({
  selector: 'app-informations-personnelles',
  templateUrl: './informations-personnelles.component.html',
  styleUrls: ['./informations-personnelles.component.scss']
})
export class InformationsPersonnellesComponent implements OnInit {

  disc:string;
  civilite:string;
  nom:string;
  rue:string;
  codePostal:string;
  identifiant:string;
  motDePasse:string;
  mail:string;
  telephone:string;
  complement:string;
  ville:string;
  informationsForm : CompteUtilisateur;

  civilites: Array<String> = new Array<string>();

  @Input()
  prenom:string;

  constructor(private compteUtilisateurService : CompteUtilisateurService, private titleService: Title, private commonService: CommonService) {
    this.titleService.setTitle("Informations Personnelles");
    this.disc=sessionStorage.getItem('typeCompte');
    this.compteUtilisateurService.findById(parseInt(sessionStorage.getItem('idCompte'))).subscribe(resp=>{
      this.civilite=resp.civilite;
      this.nom=resp.nom;
      this.prenom=resp.prenom;
      this.rue=resp.rue;
      this.complement=resp.complement;
      this.codePostal=resp.codePostal;
      this.ville=resp.ville;
      this.identifiant=resp.identifiant;
      this.motDePasse=resp.motDePasse;
      this.mail=resp.mail;
      this.telephone=resp.telephone;

    },error => console.log(error));
  }

  ngOnInit(): void {
    this.commonService.findAllCivilites().subscribe(resp => this.civilites = resp, err => console.log(err));
  }

  edit(id: number) {
    this.compteUtilisateurService.findById(id).subscribe(resp => this.informationsForm = resp, error => console.log(error));
  }

}

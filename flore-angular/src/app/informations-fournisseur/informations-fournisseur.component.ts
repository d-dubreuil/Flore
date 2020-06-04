import {Component, Input, OnInit} from '@angular/core';
import {CompteUtilisateur} from "../model/CompteUtilisateur";
import {CompteUtilisateurService} from "../services/compte-utilisateur.service";
import {Title} from "@angular/platform-browser";
import {CommonService} from "../common.service";

@Component({
  selector: 'app-informations-fournisseur',
  templateUrl: './informations-fournisseur.component.html',
  styleUrls: ['./informations-fournisseur.component.scss']
})
export class InformationsFournisseurComponent implements OnInit {

  id: number;
  version: number;
  disc: string;
  rue: string;
  codePostal: string;
  identifiant: string;
  motDePasse: string;
  mail: string;
  telephone: string;
  complement: string;
  ville: string;
  statut: string;
  SIRET_SIREN: string;
  RCS: string;
  TVA: string;
  informationsForm: CompteUtilisateur = new CompteUtilisateur();
  compteUtilisateur: CompteUtilisateur = new CompteUtilisateur();
  modifierBoolean: boolean = false;

  statuts: Array<String> = new Array<string>();

  @Input()
  denomination: string;

  constructor(private compteUtilisateurService: CompteUtilisateurService, private titleService: Title, private commonService: CommonService) {
    this.titleService.setTitle("Informations Fournisseur");
    this.disc = sessionStorage.getItem('typeCompte');
    this.commonService.page="monCompte";
    this.compteUtilisateurService.findById(parseInt(sessionStorage.getItem('idCompte'))).subscribe(resp => {
      this.id = resp.id;
      this.version = resp.version;
      this.denomination = resp.denomination;
      this.rue = resp.rue;
      this.complement = resp.complement;
      this.codePostal = resp.codePostal;
      this.ville = resp.ville;
      this.identifiant = resp.identifiant;
      this.motDePasse = resp.motDePasse;
      this.mail = resp.mail;
      this.telephone = resp.telephone;
      this.statut = resp.statut;
      this.SIRET_SIREN = resp.SIRET_SIREN;
      this.RCS = resp.RCS;
      this.TVA = resp.TVA;
      this.informationsForm.id = resp.id;
      this.informationsForm.version = resp.version;
      this.compteUtilisateur.id = resp.id;
      this.compteUtilisateur.version = resp.version;
      console.log(this.compteUtilisateur.id);

    }, error => console.log(error));
  }

  ngOnInit(): void {
    this.commonService.findAllStatuts().subscribe(resp => this.statuts = resp, err => console.log(err));
  }

  edit() {
    this.modifierBoolean = true;
    this.informationsForm.rue = this.rue;
    this.informationsForm.complement = this.complement;
    this.informationsForm.codePostal = this.codePostal;
    this.informationsForm.ville = this.ville;
    this.informationsForm.identifiant = this.identifiant;
    this.informationsForm.motDePasse = this.motDePasse;
    this.informationsForm.telephone = this.telephone;
    this.informationsForm.mail = this.mail;
    this.informationsForm.denomination = this.denomination;
    this.informationsForm.statut = this.statut;
    this.informationsForm.SIRET_SIREN = this.SIRET_SIREN;
    this.informationsForm.RCS = this.RCS;
    this.informationsForm.TVA = this.TVA;
  }

  save(compteUtilisateur: CompteUtilisateur) {
    this.compteUtilisateurService.modify(this.informationsForm).subscribe(resp => {
      this.informationsForm.rue = this.rue;
      this.informationsForm.complement = this.complement;
      this.informationsForm.codePostal = this.codePostal;
      this.informationsForm.ville = this.ville;
      this.informationsForm.identifiant = this.identifiant;
      this.informationsForm.motDePasse = this.motDePasse;
      this.informationsForm.telephone = this.telephone;
      this.informationsForm.mail = this.mail;
      this.informationsForm.denomination = this.denomination;
      this.informationsForm.statut = this.statut;
      this.informationsForm.SIRET_SIREN = this.SIRET_SIREN;
      this.informationsForm.RCS = this.RCS;
      this.informationsForm.TVA = this.TVA;
      this.modifierBoolean = false;
      this.reload();

    }, error => console.log(error));

  }

  cancel() {
    this.modifierBoolean = false;
  }

  reload() {
    this.compteUtilisateurService.findById(parseInt(sessionStorage.getItem('idCompte'))).subscribe(resp => {
      this.id = resp.id;
      this.version = resp.version;
      this.denomination = resp.denomination;
      this.rue = resp.rue;
      this.complement = resp.complement;
      this.codePostal = resp.codePostal;
      this.ville = resp.ville;
      this.identifiant = resp.identifiant;
      this.motDePasse = resp.motDePasse;
      this.mail = resp.mail;
      this.telephone = resp.telephone;
      this.statut = resp.statut;
      this.SIRET_SIREN = resp.SIRET_SIREN;
      this.RCS = resp.RCS;
      this.TVA = resp.TVA;;

    }, error => console.log(error));
  }

}


import { Component, OnInit } from '@angular/core';
import {CompteUtilisateurService} from '../services/compte-utilisateur.service';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.scss']
})
export class CompteComponent implements OnInit {
  disc:string;
  nom:string;
  prenom:string;
  denomination:string;

  constructor(private compteUtilisateurService:CompteUtilisateurService) { }

  ngOnInit(): void {
    this.disc=sessionStorage.getItem('typeCompte');
    this.compteUtilisateurService.findById(parseInt(sessionStorage.getItem('idCompte'))).subscribe(resp=>{
      this.prenom=resp.prenom;
      this.denomination=resp.denomination;
    },error => console.log(error));

  }

}

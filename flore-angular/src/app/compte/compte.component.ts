import { Component, OnInit } from '@angular/core';
import {CompteUtilisateurService} from '../services/compte-utilisateur.service';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.scss']
})
export class CompteComponent implements OnInit {
  disc:string;
  prenom:string;


  constructor(private compteUtilisateurService:CompteUtilisateurService) { }

  ngOnInit(): void {
    this.disc=localStorage.getItem('typeCompte');
    this.compteUtilisateurService.findById(parseInt(localStorage.getItem('idCompte'))).subscribe(resp=>{
      this.prenom=resp.prenom;
    },error => console.log(error));

  }

}

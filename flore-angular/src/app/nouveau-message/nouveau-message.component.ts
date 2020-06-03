import { Component, OnInit } from '@angular/core';
import {CompteUtilisateurService} from '../services/compte-utilisateur.service';

@Component({
  selector: 'app-nouveau-message',
  templateUrl: './nouveau-message.component.html',
  styleUrls: ['./nouveau-message.component.scss']
})
export class NouveauMessageComponent implements OnInit {
  prenom:string;

  constructor(private compteUtilisateurService:CompteUtilisateurService) {
    this.compteUtilisateurService.findById(parseInt(sessionStorage.getItem('idCompte'))).subscribe(resp=>{
      this.prenom=resp.prenom;
    },error => console.log(error))
  }

  ngOnInit(): void {
  }

}

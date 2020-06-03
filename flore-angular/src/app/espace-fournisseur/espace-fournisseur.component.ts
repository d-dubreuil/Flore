import {Component, Input, OnInit} from '@angular/core';
import {CompteUtilisateurService} from '../services/compte-utilisateur.service';

@Component({
  selector: 'app-espace-fournisseur',
  templateUrl: './espace-fournisseur.component.html',
  styleUrls: ['./espace-fournisseur.component.scss']
})
export class EspaceFournisseurComponent implements OnInit {

  disc:string;

  @Input()
  denomination:string;

  constructor(private compteUtilisateurService:CompteUtilisateurService) { }

  ngOnInit(): void {
    this.disc=sessionStorage.getItem('typeCompte');
    this.compteUtilisateurService.findById(parseInt(sessionStorage.getItem('idCompte'))).subscribe(resp=>{
      this.denomination=resp.denomination;
    },error => console.log(error));
  }

}

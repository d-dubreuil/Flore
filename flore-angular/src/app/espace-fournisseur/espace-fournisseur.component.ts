import {Component, Input, OnInit} from '@angular/core';
import {CompteUtilisateurService} from '../services/compte-utilisateur.service';
import {Router} from '@angular/router';
import {CommonService} from '../common.service';

@Component({
  selector: 'app-espace-fournisseur',
  templateUrl: './espace-fournisseur.component.html',
  styleUrls: ['./espace-fournisseur.component.scss']
})
export class EspaceFournisseurComponent implements OnInit {

  disc:string;

  @Input()
  denomination:string;

  constructor(private compteUtilisateurService:CompteUtilisateurService,private router:Router,private commonService:CommonService) {
    this.commonService.page="monCompte";

  }

  ngOnInit(): void {
    this.disc=sessionStorage.getItem('typeCompte');
    this.compteUtilisateurService.findById(parseInt(sessionStorage.getItem('idCompte'))).subscribe(resp=>{
      this.denomination=resp.denomination;
    },error => console.log(error));
  }

  voirProduits(){
    this.compteUtilisateurService.denomination=this.denomination;
    this.router.navigateByUrl('/NPK/espace-fournisseur/liste-produits');

  }

}

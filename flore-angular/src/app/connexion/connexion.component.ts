import {Component, OnInit} from '@angular/core';
import {Title} from '@angular/platform-browser';
import {SessionService} from '../session.service';
import {Session} from '../model/Session';
import {Router} from '@angular/router';
import {CommonService} from '../common.service';
import {Panier} from '../model/Panier';
import {PanierService} from '../services/panier.service';
import {CompteUtilisateurService} from '../services/compte-utilisateur.service';
import {constructExclusionsMap} from 'tslint/lib/rules/completed-docs/exclusions';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent implements OnInit {
  session: Session = new Session();
  authechecBoolean: boolean = false;
  creationVideBoolean:boolean=false;
  creationEchecBoolean:boolean=false;

  constructor(private titleService: Title, private sessionService: SessionService, private router: Router,public commonService:CommonService, private panierService:PanierService,private compteUtilisateurService:CompteUtilisateurService) {
    this.titleService.setTitle('Connexion');
  }

  ngOnInit(): void {
  }

  connexion() {
    this.sessionService.connexion(this.session).subscribe(resp => {
      if (resp[0] == 'nonOK') {
        alert("Erreur d'authentification.")
      } else if (resp[0] == 'OK') {
        sessionStorage.setItem('idCompte', resp[1]);
        sessionStorage.setItem('typeCompte', resp[2]);
        this.compteUtilisateurService.findById(parseInt(resp[1])).subscribe(resp2=>{
          let panierEnCours: Panier = new Panier();
          panierEnCours.utilisateur = resp2.utilisateur;
          this.panierService.create(panierEnCours).subscribe(resp=>{
            sessionStorage.setItem('idPanierEnCours',resp.id.toString());
          },error => console.log(error))
        },error => console.log(error))
        this.commonService.connecte=sessionStorage.getItem('typeCompte');
        this.router.navigateByUrl('NPK/compte');
      }
    },error => console.log(error));

  }
  creation(){
    this.creationVideBoolean=false;
    this.creationEchecBoolean=false;
    this.sessionService.creation(this.session).subscribe(resp=>{
      if (resp[0] == 'nonOK'){
        alert("Identifiant déjà utilisé")
      } else if (resp[0] == 'Vide'){
        alert("Le mot de passe et l'identifiant doivent être renseignés.");
      } else if (resp[0]=='OK'){
        sessionStorage.setItem('idCompte', resp[1]);
        sessionStorage.setItem('typeCompte', resp[2]);
        this.commonService.connecte=sessionStorage.getItem('typeCompte');
        this.router.navigateByUrl('NPK/compte');
      }
    })
  }

}

import {Component, OnInit} from '@angular/core';
import {Title} from '@angular/platform-browser';
import {SessionService} from '../session.service';
import {Session} from '../model/Session';
import {Router} from '@angular/router';

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

  constructor(private titleService: Title, private sessionService: SessionService, private router: Router) {
    this.titleService.setTitle('Connexion');
  }

  ngOnInit(): void {
  }

  connexion() {
    this.sessionService.connexion(this.session).subscribe(resp => {
      if (resp[0] == 'nonOK') {
        this.authechecBoolean = true;
      } else if (resp[0] == 'OK') {
        localStorage.setItem('idCompte', resp[1]);
        localStorage.setItem('typeCompte', resp[2]);
        this.router.navigateByUrl('NPK/compte');
      }
    });

  }
  creation(){
    this.creationVideBoolean=false;
    this.creationEchecBoolean=false;
    this.sessionService.creation(this.session).subscribe(resp=>{
      if (resp[0] == 'nonOK'){
        this.creationEchecBoolean=true;
      } else if (resp[0] == 'Vide'){
        this.creationVideBoolean=true;
      } else if (resp[0]=='OK'){
        localStorage.setItem('idCompte', resp[1]);
        localStorage.setItem('typeCompte', resp[2]);
        this.router.navigateByUrl('NPK/compte');
      }
    })
  }

}

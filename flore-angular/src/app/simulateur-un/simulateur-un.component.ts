import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-simulateur-un',
  templateUrl: './simulateur-un.component.html',
  styleUrls: ['./simulateur-un.component.scss']
})
export class SimulateurUnComponent implements OnInit {


  simu1Accueil: boolean = true;
  kompagnonnage: boolean = false;
  details:boolean=false;


  constructor(private titleService: Title) {
    this.titleService.setTitle("Simulateur 1");
  }

  ngOnInit(): void {
  }

  synergie() {
    this.kompagnonnage=true;
    this.simu1Accueil=false;
    this.details=false;

  }

  revenir(){
    this.simu1Accueil=true;
    this.kompagnonnage=false;
    this.details=false;

  }

  plusDeDetail(){
    this.simu1Accueil=false;
    this.kompagnonnage=true;
    this.details=true;

  }

}

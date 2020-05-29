import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-simulateur-un',
  templateUrl: './simulateur-un.component.html',
  styleUrls: ['./simulateur-un.component.scss']
})
export class SimulateurUnComponent implements OnInit {


  simu1Accueil: boolean = true;
  kompagnonnage: boolean = false;
  details:boolean=false;
  constructor() { }

  ngOnInit(): void {
  }

}

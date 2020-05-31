import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-paiement',
  templateUrl: './paiement.component.html',
  styleUrls: ['./paiement.component.scss']
})
export class PaiementComponent implements OnInit {

  constructor(private titleService: Title) {
    this.titleService.setTitle("Paiement");
  }

  ngOnInit(): void {
  }

}

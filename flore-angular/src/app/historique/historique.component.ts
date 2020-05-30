import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-historique',
  templateUrl: './historique.component.html',
  styleUrls: ['./historique.component.scss']
})
export class HistoriqueComponent implements OnInit {

  constructor(private titleService: Title) {
    this.titleService.setTitle("Historique");
  }

  ngOnInit(): void {
  }

}

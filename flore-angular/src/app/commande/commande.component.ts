import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.scss']
})
export class CommandeComponent implements OnInit {

  constructor(private titleService: Title) {
    this.titleService.setTitle("Commandes");
  }

  ngOnInit(): void {
  }

}

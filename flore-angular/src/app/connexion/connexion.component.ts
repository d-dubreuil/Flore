import { Component, OnInit } from '@angular/core';
import {CaracteristiqueService} from "../services/caracteristique.service";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent implements OnInit {

  constructor(private titleService: Title) {
    this.titleService.setTitle("Connexion");
  }

  ngOnInit(): void {
  }

}

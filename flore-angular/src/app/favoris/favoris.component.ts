import {Component, Input, OnInit} from '@angular/core';
import {Title} from "@angular/platform-browser";
import {Favoris} from "../model/Favoris";
import {FavorisService} from "../services/favoris.service";
import {Flore} from "../model/Flore";

@Component({
  selector: 'app-favoris',
  templateUrl: './favoris.component.html',
  styleUrls: ['./favoris.component.scss']
})
export class FavorisComponent implements OnInit {

  flore: Flore;

  @Input()
  prenom: string;

  constructor(private titleService: Title, private favorisService: FavorisService) {
    this.titleService.setTitle("Fiches");
  }

  ngOnInit(): void {
  }

  list(): Array<Favoris> {
    return this.favorisService.findAll();
  }


}

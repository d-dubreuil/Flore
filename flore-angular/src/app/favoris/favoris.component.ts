import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-favoris',
  templateUrl: './favoris.component.html',
  styleUrls: ['./favoris.component.scss']
})
export class FavorisComponent implements OnInit {

  constructor(private titleService: Title) {
    this.titleService.setTitle("Fiches");
  }

  ngOnInit(): void {
  }

}

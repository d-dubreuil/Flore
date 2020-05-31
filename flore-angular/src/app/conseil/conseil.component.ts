import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-conseil',
  templateUrl: './conseil.component.html',
  styleUrls: ['./conseil.component.scss']
})
export class ConseilComponent implements OnInit {

  constructor(private titleService: Title) {
    this.titleService.setTitle("Conseils");
  }

  ngOnInit(): void {
  }

}

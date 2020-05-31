import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-simulateur-deux',
  templateUrl: './simulateur-deux.component.html',
  styleUrls: ['./simulateur-deux.component.scss']
})
export class SimulateurDeuxComponent implements OnInit {

  constructor(private titleService: Title) {
    this.titleService.setTitle("Simulateur 2");
  }

  ngOnInit(): void {
  }

}

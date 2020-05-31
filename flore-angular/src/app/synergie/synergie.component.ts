import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-synergie',
  templateUrl: './synergie.component.html',
  styleUrls: ['./synergie.component.scss']
})
export class SynergieComponent implements OnInit {

  constructor(private titleService: Title) {
    this.titleService.setTitle("Synergie");
  }

  ngOnInit(): void {
  }

}

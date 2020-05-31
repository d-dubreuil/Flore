import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-jardin',
  templateUrl: './jardin.component.html',
  styleUrls: ['./jardin.component.scss']
})
export class JardinComponent implements OnInit {

  constructor(private titleService: Title) {
    this.titleService.setTitle("Mon Petit Jardin");
  }

  ngOnInit(): void {
  }

}

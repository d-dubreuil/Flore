import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-espace-client',
  templateUrl: './espace-client.component.html',
  styleUrls: ['./espace-client.component.scss']
})
export class EspaceClientComponent implements OnInit {

  constructor(private titleService: Title) {
    this.titleService.setTitle("Compte Client");
  }

  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {CommonService} from '../common.service';

@Component({
  selector: 'app-jardin',
  templateUrl: './jardin.component.html',
  styleUrls: ['./jardin.component.scss']
})
export class JardinComponent implements OnInit {

  constructor(private titleService: Title, private commonService:CommonService) {
    this.titleService.setTitle("Mon Petit Jardin");
    this.commonService.page="monCompte";

  }

  ngOnInit(): void {
  }

}

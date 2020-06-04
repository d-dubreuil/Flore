import { Component, OnInit } from '@angular/core';
import {CommonService} from '../common.service';

@Component({
  selector: 'app-jardin-environnement',
  templateUrl: './jardin-environnement.component.html',
  styleUrls: ['./jardin-environnement.component.scss']
})
export class JardinEnvironnementComponent implements OnInit {

  constructor(private commonService:CommonService) {
    this.commonService.page="monCompte";

  }

  ngOnInit(): void {
  }

}

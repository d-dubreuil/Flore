import { Component, OnInit } from '@angular/core';
import {CommonService} from '../common.service';

@Component({
  selector: 'app-fiche',
  templateUrl: './fiche.component.html',
  styleUrls: ['./fiche.component.scss']
})
export class FicheComponent implements OnInit {

  constructor(private commonService:CommonService) {
    this.commonService.page="monCompte";

  }

  ngOnInit(): void {
  }

}

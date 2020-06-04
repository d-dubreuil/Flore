import { Component, OnInit } from '@angular/core';
import {CommonService} from '../common.service';

@Component({
  selector: 'app-formulaire-proposition',
  templateUrl: './formulaire-proposition.component.html',
  styleUrls: ['./formulaire-proposition.component.scss']
})
export class FormulairePropositionComponent implements OnInit {

  constructor(private commonService:CommonService) {
    this.commonService.page="monCompte";

  }

  ngOnInit(): void {
  }

}

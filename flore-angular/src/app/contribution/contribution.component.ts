import { Component, OnInit } from '@angular/core';
import {CommonService} from '../common.service';

@Component({
  selector: 'app-contribution',
  templateUrl: './contribution.component.html',
  styleUrls: ['./contribution.component.scss']
})
export class ContributionComponent implements OnInit {

  constructor(private commonService:CommonService) {
    this.commonService.page="monCompte";

  }

  ngOnInit(): void {
  }

}

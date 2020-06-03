import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {CommonService} from '../common.service';

@Component({
  selector: 'app-synergie',
  templateUrl: './synergie.component.html',
  styleUrls: ['./synergie.component.scss']
})
export class SynergieComponent implements OnInit {

  constructor(private titleService: Title, private commonService:CommonService) {
    this.titleService.setTitle("Synergie");
    this.commonService.page="synergie";
  }

  ngOnInit(): void {
  }

}

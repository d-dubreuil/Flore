import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {CommonService} from '../common.service';

@Component({
  selector: 'app-conseil',
  templateUrl: './conseil.component.html',
  styleUrls: ['./conseil.component.scss']
})
export class ConseilComponent implements OnInit {

  constructor(private titleService: Title,private commonService:CommonService) {
    this.titleService.setTitle("Conseils");
    this.commonService.page="conseils";
  }

  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {CommonService} from '../common.service';

@Component({
  selector: 'app-qui-sommes-nous',
  templateUrl: './qui-sommes-nous.component.html',
  styleUrls: ['./qui-sommes-nous.component.scss']
})
export class QuiSommesNousComponent implements OnInit {

  constructor(private titleService: Title,private commonService:CommonService) {
    this.titleService.setTitle("Qui sommes-nous ?");
    this.commonService.page="quiSommesNous";
  }

  ngOnInit(): void {
  }

}

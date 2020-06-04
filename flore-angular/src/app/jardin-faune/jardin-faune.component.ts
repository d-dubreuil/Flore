import { Component, OnInit } from '@angular/core';
import {CommonService} from '../common.service';

@Component({
  selector: 'app-jardin-faune',
  templateUrl: './jardin-faune.component.html',
  styleUrls: ['./jardin-faune.component.scss']
})
export class JardinFauneComponent implements OnInit {

  constructor(private commonService:CommonService) {
    this.commonService.page="monCompte";

  }

  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';
import {CommonService} from '../common.service';

@Component({
  selector: 'app-jardin-flore',
  templateUrl: './jardin-flore.component.html',
  styleUrls: ['./jardin-flore.component.scss']
})
export class JardinFloreComponent implements OnInit {

  constructor(private commonService:CommonService) {
    this.commonService.page="monCompte";

  }

  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {CommonService} from '../common.service';

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.scss']
})
export class CommandeComponent implements OnInit {

  constructor(private titleService: Title,private commonService:CommonService) {
    this.titleService.setTitle("Commandes");
    this.commonService.page="panier";

  }

  ngOnInit(): void {
  }

}

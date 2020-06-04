import {Component, Input, OnInit} from '@angular/core';
import {Title} from "@angular/platform-browser";
import {CommonService} from '../common.service';

@Component({
  selector: 'app-espace-client',
  templateUrl: './espace-client.component.html',
  styleUrls: ['./espace-client.component.scss']
})
export class EspaceClientComponent implements OnInit {
  @Input()
  prenom:string;

  constructor(private titleService: Title,private commonService:CommonService) {
    this.titleService.setTitle("Compte Client");
    this.commonService.page="monCompte";

  }

  ngOnInit(): void {
  }

}

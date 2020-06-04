import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {CommonService} from '../common.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {

  constructor(private titleService: Title, private commonService:CommonService) {
    this.titleService.setTitle("Contacts");
    this.commonService.page="monCompte";

  }

  ngOnInit(): void {
  }

}

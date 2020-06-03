import {Component, OnInit} from '@angular/core';
import {Title} from '@angular/platform-browser';
import {CommonService} from '../common.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  urlFlore() {

  }

  constructor(private titleService: Title,private commonService: CommonService) {
    this.titleService.setTitle("Accueil");
    this.commonService.page="accueil";
    console.log(this.commonService.connecte);
  }

  ngOnInit(): void {
  }

}

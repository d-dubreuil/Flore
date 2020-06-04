import {Component} from '@angular/core';
import {Title} from '@angular/platform-browser';
import {CommonService} from './common.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'flore-angular';
  page:'string';


  public constructor(public commonService:CommonService) {
  }

  deconnexion(){
    sessionStorage.clear();
    this.commonService.connecte=null;
  }

}

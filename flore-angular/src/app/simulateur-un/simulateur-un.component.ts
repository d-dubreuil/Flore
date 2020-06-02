import { Component, OnInit } from '@angular/core';
import {SynergieService} from "../services/synergie.service";
import {SimulateurUn} from "../model/SimulateurUn";
import {Bonus} from "../model/Bonus";
import {Malus} from "../model/Malus";
import {Flore} from "../model/Flore";
import {FloreService} from "../services/flore.service";
import {Router} from "@angular/router";
import {newArray} from "@angular/compiler/src/util";

@Component({
  selector: 'app-simulateur-un',
  templateUrl: './simulateur-un.component.html',
  styleUrls: ['./simulateur-un.component.scss']
})
export class SimulateurUnComponent implements OnInit {


  simu1Accueil: boolean = true;
  kompagnonnage: boolean = false;
  details:boolean=false;


  simu1:SimulateurUn = new SimulateurUn();
  bonusList: Array<Bonus>= new Array<Bonus>();
  malusList: Array<Malus>= new Array<Malus>();
  bonusTotal: Bonus= new Bonus();
  malusTotal: Malus= new Malus();
  totalPoint: number=0;
  nomFlore1:string;
  nomFlore2:string;

  floreList:Array<Flore>=new Array<Flore>();
  nomFloreList:Array<String>=new Array<String>();

  typeCaracs: Array<String> = new Array<string>();

  constructor(private synergieService: SynergieService, private floreService: FloreService,private router:Router) { }

  ngOnInit(): void {
    this.synergieService.findAllTypeCaracs().subscribe(resp => this.typeCaracs = resp, err => console.log(err));
    this.floreList=this.floreService.findAll();
    for(let flore of this.floreList){
      console.log(flore.nom);
      this.nomFloreList.push(flore.nom);
    }
  }

  revenir(){
    this.simu1Accueil=true;
    this.kompagnonnage=false;
    this.details=false;
    this.totalPoint=0;
    this.bonusList=new Array<Bonus>();
    this.malusList=new Array<Malus>();
    this.simu1 = new SimulateurUn();

  }

  plusDeDetail(){
    this.simu1Accueil=false;
    this.kompagnonnage=true;
    this.details=true;

  }



  synergie(){
    this.kompagnonnage=true;
    this.simu1Accueil=false;
    this.details=false;

    //Création de la query
    this.synergieService.synergieUn(this.nomFlore1,this.nomFlore2).subscribe(resp => {
      this.synergieService.simu1 = resp;
      console.log( this.synergieService.simu1);
      for (let bonus of this.synergieService.simu1.bonus){
        console.log(bonus);
        this.bonusList.push(bonus);
        this.bonusTotal=bonus;
        this.totalPoint=this.totalPoint+this.bonusTotal.point;
        console.log(this.totalPoint);}
      for (let malus of this.synergieService.simu1.malus){
        console.log(malus);
        this.malusList.push(malus);
        this.malusTotal=malus;
        this.totalPoint=this.totalPoint+this.malusTotal.point;
        console.log(this.totalPoint);
        }

    }, error => console.log(error));
  }

  redirectToFicheFlore(flore:Flore){
    this.floreService.flore = flore;
    this.router.navigateByUrl('NPK/flore/fiche-flore');
  }
}

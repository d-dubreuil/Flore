import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Flore} from "../model/Flore";
import {Caracteristique} from "../model/Caracteristique";
import {Observable} from "rxjs";
import {SimulateurUn} from "../model/SimulateurUn";

@Injectable({
  providedIn: 'root'
})
export class SynergieService {
public simu1: SimulateurUn= new SimulateurUn();

  constructor(private http:HttpClient) {
  }
  synergieUn(nomFlore1:string ,nomFlore2:string):Observable<SimulateurUn>{
    return this.http.get<SimulateurUn>('http://localhost:8080/api/synergie/by-simulateur-un/' + nomFlore1+"|"+nomFlore2);

  }
  findAllTypeCaracs(): Observable<Array<string>>{
    return this.http.get<Array<string>>("http://localhost:8080/api/synergie/type-caracs");

  }
}

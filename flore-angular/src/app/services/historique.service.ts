import { Injectable } from '@angular/core';
import {Historique} from '../model/Historique';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HistoriqueService {

  historiques:Array<Historique> = new Array<Historique>();

  constructor(private http:HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Historique>>("http://localhost:8080/api/historique").subscribe(resp => {
      this.historiques = resp;
    }, error => console.log(error))
  }

  findAll(): Array<Historique> {
    return this.historiques;
  }

  findById(id: number): Observable<Historique> {
    return this.http.get<Historique>("http://localhost:8080/api/historique/" + id);
  }

  create(historique: Historique) {
    return this.http.post<Historique>("http://localhost:8080/api/historique", historique);
  }

  modify(historique: Historique) {
    return this.http.put<Historique>("http://localhost:8080/api/historique/" + historique.id, historique);
  }

  deleteById(id: number) {
    this.http.delete("http://localhost:8080/api/historique/" + id).subscribe(resp => this.load(), error => console.log(error))
  }
}

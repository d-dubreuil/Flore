import { Injectable } from '@angular/core';
import {Panier} from '../model/Panier';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  private paniers:Array<Panier> = new Array<Panier>();

  constructor(private http:HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Panier>>("http://localhost:8080/api/panier").subscribe(resp => {
      this.paniers = resp;
    }, error => console.log(error))
  }

  findAll(): Array<Panier> {
    return this.paniers;
  }

  findById(id: number): Observable<Panier> {
    return this.http.get<Panier>("http://localhost:8080/api/panier/" + id);
  }

  create(panier: Panier) {
    return this.http.post<Panier>("http://localhost:8080/api/panier", panier);
  }

  modify(panier: Panier) {
    return this.http.put<Panier>("http://localhost:8080/api/panier/" + panier.id, panier);
  }

  deleteById(id: number) {
    this.http.delete("http://localhost:8080/api/panier/" + id).subscribe(resp => this.load(), error => console.log(error))
  }
}

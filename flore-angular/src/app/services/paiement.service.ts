import { Injectable } from '@angular/core';
import {Paiement} from '../model/Paiement';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaiementService {

  private paiements: Array<Paiement> = new Array<Paiement>();

  constructor(private http:HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Paiement>>("http://localhost:8080/api/paiement").subscribe(resp => {
      this.paiements = resp;
    }, error => console.log(error))
  }

  findAll(): Array<Paiement> {
    return this.paiements;
  }

  findById(id: number): Observable<Paiement> {
    return this.http.get<Paiement>("http://localhost:8080/api/paiement/" + id);
  }

  create(paiement: Paiement) {
    return this.http.post<Paiement>("http://localhost:8080/api/paiement", paiement);
  }

  modify(paiement: Paiement) {
    return this.http.put<Paiement>("http://localhost:8080/api/paiement/" + paiement.id, paiement);
  }

  deleteById(id: number) {
    this.http.delete("http://localhost:8080/api/paiement/" + id).subscribe(resp => this.load(), error => console.log(error))
  }
}

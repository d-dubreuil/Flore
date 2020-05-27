import { Injectable } from '@angular/core';
import {Commande} from '../model/Commande';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {

  private commandes:Array<Commande> = new Array<Commande>();

  constructor(private http:HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Commande>>("http://localhost:8080/api/commande").subscribe(resp => {
      this.commandes = resp;
    }, error => console.log(error))
  }

  findAll(): Array<Commande> {
    return this.commandes;
  }

  findById(id: number): Observable<Commande> {
    return this.http.get<Commande>("http://localhost:8080/api/commande/" + id);
  }

  create(commande: Commande) {
    return this.http.post<Commande>("http://localhost:8080/api/commande", commande);
  }

  modify(commande: Commande) {
    return this.http.put<Commande>("http://localhost:8080/api/commande/" + commande.id, commande);
  }

  deleteById(id: number) {
    this.http.delete("http://localhost:8080/api/commande/" + id).subscribe(resp => this.load(), error => console.log(error))
  }
}

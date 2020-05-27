import { Injectable } from '@angular/core';
import {Produit} from '../model/Produit';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  private produits:Array<Produit> = new Array<Produit>();

  constructor(private http:HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Produit>>("http://localhost:8080/api/produit").subscribe(resp => {
      this.produits = resp;
    }, error => console.log(error))
  }

  findAll(): Array<Produit> {
    return this.produits;
  }

  findById(id: number): Observable<Produit> {
    return this.http.get<Produit>("http://localhost:8080/api/produit/" + id);
  }

  create(produit: Produit) {
    return this.http.post<Produit>("http://localhost:8080/api/produit", produit);
  }

  modify(produit: Produit) {
    return this.http.put<Produit>("http://localhost:8080/api/produit/" + produit.id, produit);
  }

  deleteById(id: number) {
    this.http.delete("http://localhost:8080/api/produit/" + id).subscribe(resp => this.load(), error => console.log(error))
  }
}

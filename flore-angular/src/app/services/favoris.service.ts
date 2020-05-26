import { Injectable } from '@angular/core';
import {Favoris} from '../model/Favoris';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FavorisService {

  private favoris:Array<Favoris> = new Array<Favoris>();

  constructor(private http:HttpClient) {
    this.load();
  }

  load(){
    this.http.get<Array<Favoris>>("http://localhost:8080/api/favoris").subscribe(next=> {
      this.favoris = next;
    },error => console.log(error))
  }

  findAll(): Array<Favoris> {
    return this.favoris;
  }

  findById(id: number): Observable<Favoris> {
    return this.http.get<Favoris>("http://localhost:8080/api/favoris/" + id);
  }

  create(favori: Favoris) {
    return this.http.post<Favoris>("http://localhost:8080/api/favoris", favori);
  }

  modify(favori: Favoris) {
    return this.http.put<Favoris>("http://localhost:8080/api/favoris/" + favori.id, favori);
  }

  deleteById(id: number) {
    this.http.delete("http://localhost:8080/api/favoris/" + id).subscribe(resp => this.load(), error => console.log(error))
  }
}

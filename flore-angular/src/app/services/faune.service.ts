import { Injectable } from '@angular/core';
import {Faune} from '../model/Faune';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FauneService {

  private faunes: Array<Faune> = new Array<Faune>();

  constructor(private http:HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Faune>>("http://localhost:8080/api/faune").subscribe(resp => {
      this.faunes = resp;
    }, error => console.log(error))
  }

  findAll(): Array<Faune> {
    return this.faunes;
  }

  findByNom(nom:string): Observable<Faune>{
    return this.http.get<Faune>("http://localhost:8080/api/faune/by-nom/"+nom)
  }

  findById(id: number): Observable<Faune> {
    return this.http.get<Faune>("http://localhost:8080/api/faune/" + id);
  }

  create(faune: Faune) {
    return this.http.post<Faune>("http://localhost:8080/api/faune", faune);
  }

  modify(faune: Faune) {
    return this.http.put<Faune>("http://localhost:8080/api/faune/" + faune.id, faune);
  }

  deleteById(id: number) {
    this.http.delete("http://localhost:8080/api/faune/" + id).subscribe(resp => this.load(), error => console.log(error))
  }
}

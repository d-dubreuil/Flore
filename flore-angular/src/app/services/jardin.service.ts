import { Injectable } from '@angular/core';
import {Jardin} from '../model/Jardin';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JardinService {

  private jardins:Array<Jardin> = new Array<Jardin>();

  constructor(private http:HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Jardin>>("http://localhost:8080/api/jardin").subscribe(resp => {
      this.jardins = resp;
    }, error => console.log(error))
  }

  findAll(): Array<Jardin> {
    return this.jardins;
  }

  findById(id: number): Observable<Jardin> {
    return this.http.get<Jardin>("http://localhost:8080/api/jardin/" + id);
  }

  create(jardin: Jardin) {
    return this.http.post<Jardin>("http://localhost:8080/api/jardin", jardin);
  }

  modify(jardin: Jardin) {
    return this.http.put<Jardin>("http://localhost:8080/api/jardin/" + jardin.id, jardin);
  }

  deleteById(id: number) {
    this.http.delete("http://localhost:8080/api/jardin/" + id).subscribe(resp => this.load(), error => console.log(error))
  }
}

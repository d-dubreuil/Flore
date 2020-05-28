import { Injectable } from '@angular/core';
import {Flore} from '../model/Flore';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {FloreForm} from '../model/FloreForm';

@Injectable({
  providedIn: 'root'
})
export class FloreService {

  private flores: Array<Flore> = new Array<Flore>();

  constructor(private http:HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Flore>>("http://localhost:8080/api/flore").subscribe(resp => {
      this.flores = resp;
    }, error => console.log(error))
  }

  findAll(): Array<Flore> {
    return this.flores;
  }

  findByFormulaire(floreForm:FloreForm):Observable<Array<Flore>>{
    return this.http.post<Array<Flore>>("http://localhost:8080/api/flore/by-formulaire",floreForm);
  }

  findByNom(nom:string):Observable<Flore>{
    return this.http.get<Flore>("http://localhost:8080/api/flore/by-nom/"+nom)
  }

  findAllByCaracteristique(typeCarac:string,nom:string,valeur:string):Observable<Array<Flore>>{
    return this.http.get<Array<Flore>>("http://localhost:8080/api/flore/by-caracteristique/"+typeCarac+"|"+nom+"|"+valeur);
  }

  findById(id: number): Observable<Flore> {
    return this.http.get<Flore>("http://localhost:8080/api/flore/" + id);
  }

  create(flore: Flore) {
    return this.http.post<Flore>("http://localhost:8080/api/flore",flore);
  }

  modify(flore: Flore) {
    return this.http.put<Flore>("http://localhost:8080/api/flore/" + flore.id, flore);
  }

  deleteById(id: number) {
    this.http.delete("http://localhost:8080/api/flore/" + id).subscribe(resp => this.load(), error => console.log(error));
  }
}

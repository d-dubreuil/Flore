import { Injectable } from '@angular/core';
import {CompteUtilisateur} from '../model/CompteUtilisateur';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompteUtilisateurService {

  private comptesUtilisateurs:Array<CompteUtilisateur> = new Array<CompteUtilisateur>();

  constructor(private http:HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<CompteUtilisateur>>("http://localhost:8080/api/compteUtilisateur").subscribe(resp => {
      this.comptesUtilisateurs = resp;
    }, error => console.log(error))
  }

  findAll(): Array<CompteUtilisateur> {
    return this.comptesUtilisateurs;
  }

  findById(id: number): Observable<CompteUtilisateur> {
    return this.http.get<CompteUtilisateur>("http://localhost:8080/api/compteUtilisateur/" + id);
  }

  create(compteUtilisateur: CompteUtilisateur) {
    return this.http.post<CompteUtilisateur>("http://localhost:8080/api/compteUtilisateur", compteUtilisateur);
  }

  modify(compteUtilisateur: CompteUtilisateur) {
    return this.http.put<CompteUtilisateur>("http://localhost:8080/api/compteUtilisateur/" + compteUtilisateur.id, compteUtilisateur);
  }

  deleteById(id: number) {
    this.http.delete("http://localhost:8080/api/compteUtilisateur/" + id).subscribe(resp => this.load(), error => console.log(error))
  }
}

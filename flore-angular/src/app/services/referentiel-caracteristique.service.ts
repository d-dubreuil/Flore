import { Injectable } from '@angular/core';
import {ReferentielCaracteristique} from '../model/ReferentielCaracteristique';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Caracteristique} from '../model/Caracteristique';

@Injectable({
  providedIn: 'root'
})
export class ReferentielCaracteristiqueService {
  private refCaracs:Array<ReferentielCaracteristique> = new Array<ReferentielCaracteristique>();

  constructor(private http: HttpClient) { }

  load() {
    this.http.get<Array<ReferentielCaracteristique>>('http://localhost:8080/api/referentiel-caracteristique').subscribe(resp => {
      this.refCaracs = resp;
    }, error => console.log(error));
  }

  findAll(): Array<ReferentielCaracteristique> {
    return this.refCaracs;
  }

  findById(id: number): Observable<ReferentielCaracteristique> {
    return this.http.get<ReferentielCaracteristique>('http://localhost:8080/api/referentiel-caracteristique/' + id);
  }

  create(refCarac: ReferentielCaracteristique) {
    return this.http.post<ReferentielCaracteristique>('http://localhost:8080/api/referentiel-caracteristique', refCarac);
  }

  modify(refCarac: ReferentielCaracteristique) {
    return this.http.put<ReferentielCaracteristique>('http://localhost:8080/api/referentiel-caracteristique/' + refCarac.id, refCarac);
  }

  deleteById(id: number) {
    this.http.delete('http://localhost:8080/api/referentiel-caracteristique/' + id).subscribe(resp => this.load(), error => console.log(error));
  }
}

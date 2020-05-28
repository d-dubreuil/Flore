import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Caracteristique} from '../model/Caracteristique';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CaracteristiqueService {
  private caracteristiques: Array<Caracteristique> = new Array<Caracteristique>();

  constructor(private http: HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Caracteristique>>('http://localhost:8080/api/caracteristique').subscribe(resp => {
      this.caracteristiques = resp;
    }, error => console.log(error));
  }

  findAll(): Array<Caracteristique> {
    return this.caracteristiques;
  }

  findByAttribut(typeCarac: string, nom: string, valeur: string): Observable<Caracteristique> {
    return this.http.get<Caracteristique>('http://localhost:8080/api/caracteristique/by-attribut/' + typeCarac + '|' + nom + '|' + valeur);
  }

  findByFlore(nom: string): Observable<Array<Caracteristique>> {
    return this.http.get<Array<Caracteristique>>('http://localhost:8080/api/caracteristique/by-flore/' + nom);
  }

  findByType(typeCarac: string): Observable<Array<Caracteristique>> {
    return this.http.get<Array<Caracteristique>>('http://localhost:8080/api/caracteristique/by-type/' + typeCarac);
  }

  findByFloreCarac(nomFlore: string, nomCarac: string): Observable<Array<Caracteristique>> {
    return this.http.get<Array<Caracteristique>>("http://localhost:8080/api/caracteristique/by-flore-carac/"+nomFlore+"|"+nomCarac);
  }

  findById(id: number): Observable<Caracteristique> {
    return this.http.get<Caracteristique>('http://localhost:8080/api/caracteristique/' + id);
  }

  create(caracteristique: Caracteristique) {
    return this.http.post<Caracteristique>('http://localhost:8080/api/caracteristique', caracteristique);
  }

  modify(caracteristique: Caracteristique) {
    return this.http.put<Caracteristique>('http://localhost:8080/api/caracteristique/' + caracteristique.id, caracteristique);
  }

  deleteById(id: number) {
    this.http.delete('http://localhost:8080/api/caracteristique/' + id).subscribe(resp => this.load(), error => console.log(error));
  }
}

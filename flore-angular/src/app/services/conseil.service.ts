import {Injectable} from '@angular/core';
import {Conseil} from '../model/Conseil';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConseilService {

  private conseils: Array<Conseil> = new Array<Conseil>();

  constructor(private http: HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Conseil>>('http://localhost:8080/api/conseil').subscribe(resp => {
      this.conseils = resp;
    }, error => console.log(error));
  }

  findAll(): Array<Conseil> {
    return this.conseils;
  }

  findByTheme(theme: string): Observable<Array<Conseil>> {
    return this.http.get<Array<Conseil>>('http://localhost:8080/api/conseil/by-theme/' + theme);
  }

  findById(id: number): Observable<Conseil> {
    return this.http.get<Conseil>('http://localhost:8080/api/conseil/' + id);
  }

  findByNom(nom: string): Observable<Array<Conseil>> {
    return this.http.get<Array<Conseil>>('http://localhost:8080/api/conseil/by-nom' + nom);
  }

  create(conseil: Conseil) {
    return this.http.post<Conseil>('http://localhost:8080/api/conseil', conseil);
  }

  modify(conseil: Conseil) {
    return this.http.put<Conseil>('http://localhost:8080/api/conseil/' + conseil.id, conseil);
  }

  deleteById(id: number) {
    this.http.delete('http://localhost:8080/api/conseil/' + id).subscribe(resp => this.load(), error => console.log(error));
  }
}

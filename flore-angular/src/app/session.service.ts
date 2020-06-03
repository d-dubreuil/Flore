import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Session} from './model/Session';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SessionService {
  prenom:string;

  constructor(private http: HttpClient) { }

  connexion(session:Session):Observable<Array<string>> {
    return this.http.post<Array<string>>('http://localhost:8080/api/session/connexion',session);
  }

  creation(session:Session):Observable<Array<string>>{
    return this.http.post<Array<string>>('http://localhost:8080/api/session/creation',session);
  }
}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor(private http: HttpClient) { }

  findAllTypeCarac(): Observable<Array<string>> {
    return this.http.get<Array<string>>("http://localhost:8080/api/typeCarac");
  }

}
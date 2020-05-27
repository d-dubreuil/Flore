import { Injectable } from '@angular/core';
import {Selection} from '../model/Selection';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SelectionService {

  private selections:Array<Selection> = new Array<Selection>();

  constructor(private http:HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Selection>>("http://localhost:8080/api/selection").subscribe(resp => {
      this.selections = resp;
    }, error => console.log(error))
  }

  findAll(): Array<Selection> {
    return this.selections;
  }

  findById(id: number): Observable<Selection> {
    return this.http.get<Selection>("http://localhost:8080/api/selection/" + id);
  }

  create(selection: Selection) {
    return this.http.post<Selection>("http://localhost:8080/api/selection", selection);
  }

  modify(selection: Selection) {
    return this.http.put<Selection>("http://localhost:8080/api/selection/" + selection.id, selection);
  }

  deleteById(id: number) {
    this.http.delete("http://localhost:8080/api/selection/" + id).subscribe(resp => this.load(), error => console.log(error))
  }
}

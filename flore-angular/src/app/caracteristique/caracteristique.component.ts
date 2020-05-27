import {Component, OnInit} from '@angular/core';
import {CaracteristiqueService} from '../services/caracteristique.service';
import {Caracteristique} from '../model/Caracteristique';

@Component({
  selector: 'app-caracteristique',
  templateUrl: './caracteristique.component.html',
  styleUrls: ['./caracteristique.component.scss']
})
export class CaracteristiqueComponent implements OnInit {

  constructor(private caracteristiqueService: CaracteristiqueService) {
  }

  ngOnInit(): void {
  }
  list(): Array<Caracteristique> {
    return this.caracteristiqueService.findAll();
  }

}

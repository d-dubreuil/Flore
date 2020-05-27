import {Component, OnInit} from '@angular/core';
import {Flore} from '../model/Flore';
import {FloreForm} from '../model/FloreForm';
import {FloreService} from '../services/flore.service';
import {CaracteristiqueService} from '../services/caracteristique.service';

@Component({
  selector: 'app-flore',
  templateUrl: './flore.component.html',
  styleUrls: ['./flore.component.scss']
})
export class FloreComponent implements OnInit {

  floreformulaire: FloreForm;
  caracteristiques: Array<string>;
  flores: Array<Flore>;

  constructor(private floreService: FloreService, private caracteristiqueService: CaracteristiqueService) {
  }

  ngOnInit(): void {
  }

  search() {
    this.floreService.findByFormulaire(this.floreformulaire).subscribe(resp => this.flores = resp, error => console.log(error));
  }

}

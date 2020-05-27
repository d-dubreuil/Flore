import {Component, OnInit} from '@angular/core';
import {Flore} from '../model/Flore';
import {FloreForm} from '../model/FloreForm';
import {FloreService} from '../services/flore.service';
import {CaracteristiqueService} from '../services/caracteristique.service';
import {Caracteristique} from '../model/Caracteristique';

@Component({
  selector: 'app-flore',
  templateUrl: './flore.component.html',
  styleUrls: ['./flore.component.scss']
})
export class FloreComponent implements OnInit {

  floreformulaire: FloreForm;
  caracteristiques: Array<string>;
  flores: Array<Flore>;
  caracs: Array<Caracteristique>;

  constructor(private floreService: FloreService, private caracteristiqueService: CaracteristiqueService) {
  }

  ngOnInit(): void {
  }

  list(): Array<Flore> {
    return this.floreService.findAll();
  }

  search() {
    this.floreService.findByFormulaire(this.floreformulaire).subscribe(resp => this.flores = resp, error => console.log(error));
  }

  filterCarac(flore: Flore, nomCarac: string): string {
    if (flore.referentielCaracteristiques) {

      for (let refCarac of flore.referentielCaracteristiques) {
        if (refCarac.caracteristique.nom == nomCarac) {
          return refCarac.caracteristique.valeur;
        }
      }
    }

    return 'non renseigné';
  }

}

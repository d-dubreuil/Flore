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

  floreformulaire: FloreForm = new FloreForm();
  caracteristiques: Array<string> = new Array<string>();
  caracs: Array<string> = new Array<string>();
  caracEspece: string = '';
  caracRecolte: string = '';
  caracPlanter: string = '';
  caracRemontant: string = '';
  caracPH: string = '';
  caracHumidite: string = '';
  caracTexture: string = '';
  caracArrosage: string = '';
  caracClimat: string = '';
  caracResistanceFroid: string = '';
  caracEnsoleillement: string = '';
  caracFloraison: string = '';
  caracHauteur: string = '';
  caracRacine: string = '';
  caracCroissance: string = '';
  caracAzote: string = '';
  caracNutriment: string = '';
  caracStrate: string = '';

  constructor(private floreService: FloreService, private caracteristiqueService: CaracteristiqueService) {
    this.caracs.push(this.caracEspece);
    this.caracs.push(this.caracRecolte);
    this.caracs.push(this.caracPlanter);
    this.caracs.push(this.caracRemontant);
    this.caracs.push(this.caracPH);
    this.caracs.push(this.caracHumidite);
    this.caracs.push(this.caracTexture);
    this.caracs.push(this.caracArrosage);
    this.caracs.push(this.caracClimat);
    this.caracs.push(this.caracResistanceFroid);
    this.caracs.push(this.caracEnsoleillement);
    this.caracs.push(this.caracFloraison);
    this.caracs.push(this.caracHauteur);
    this.caracs.push(this.caracRacine);
    this.caracs.push(this.caracCroissance);
    this.caracs.push(this.caracAzote);
    this.caracs.push(this.caracNutriment);
    this.caracs.push(this.caracStrate);
  }

  ngOnInit(): void {
  }

  list(): Array<Flore> {
    return this.floreService.findAll();
  }

  search() {
    console.log('go');
    for (let car of this.caracs) {
      console.log(car);
      if (car.length != 0) {
        this.caracteristiques.push(car);
        console.log(car);
      }
    }
    console.log(this.caracteristiques);
    this.floreformulaire.caracteristiques = this.caracteristiques;
    console.log(this.floreformulaire);
    this.floreService.findByFormulaire(this.floreformulaire).subscribe(resp => {
      this.floreService.flores = resp;
      console.log(this.list());
    }, error => console.log(error));
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

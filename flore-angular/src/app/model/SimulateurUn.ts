import {Caracteristique} from "./Caracteristique";
import {Bonus} from "./Bonus";
import {Malus} from "./Malus";

export class SimulateurUn{

  bonus:Array<Bonus>;
  malus:Array<Malus>;


  constructor(bonus?: Array<Bonus>, malus?: Array<Malus>) {
    this.bonus = bonus;
    this.malus = malus;
  }
}

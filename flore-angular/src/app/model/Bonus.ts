import {Caracteristique} from "./Caracteristique";

export class Bonus {
  caracUn:Caracteristique;
  caracDeux:Caracteristique;
  message:string;
  point:number;


  constructor(caracUn?: Caracteristique, caracDeux?: Caracteristique, message?: string, point?: number) {
    this.caracUn = caracUn;
    this.caracDeux = caracDeux;
    this.message = message;
    this.point = point;
  }
}

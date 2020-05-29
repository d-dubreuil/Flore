import {Pipe, PipeTransform} from '@angular/core';
import {Faune} from './app/model/Faune';

@Pipe({
  name:'filterByFirstLetter'
})
export class filterByFirstLetterPipe implements PipeTransform {
  transform(faune: Faune, nomCarac: string):string{

  }
}




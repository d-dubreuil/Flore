import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IsAdminGuard implements CanActivate {

  constructor(private router:Router) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    if (Boolean(sessionStorage.getItem('typeCompte') == 'Administrateur') ){
      return true;
    } else {
      this.router.navigateByUrl('NPK/connexion');
      return false;
    }
  }

}

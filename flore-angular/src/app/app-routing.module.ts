import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {FauneComponent} from "./faune/faune.component";
import {ConseilComponent} from "./conseil/conseil.component";
import {SynergieComponent} from "./synergie/synergie.component";
import {ContactComponent} from "./contact/contact.component";
import {QuiSommesNousComponent} from "./qui-sommes-nous/qui-sommes-nous.component";
import {PanierComponent} from "./panier/panier.component";
import {ConnexionComponent} from "./connexion/connexion.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'faune', component: FauneComponent},
  {path: 'synergie', component: SynergieComponent},
  {path: 'conseils', component: ConseilComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'qui-sommes-nous', component: QuiSommesNousComponent},
  {path: 'panier', component: PanierComponent},
  {path: 'connexion', component: ConnexionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

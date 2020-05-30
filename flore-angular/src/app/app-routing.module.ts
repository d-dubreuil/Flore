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
import {FloreComponent} from './flore/flore.component';
import {FicheFauneComponent} from "./fiche-faune/fiche-faune.component";
import {FicheFloreComponent} from "./fiche-flore/fiche-flore.component";
import {SimulateurUnComponent} from "./simulateur-un/simulateur-un.component";
import {SimulateurDeuxComponent} from "./simulateur-deux/simulateur-deux.component";
import {CompteUtilisateurComponent} from "./compte-utilisateur/compte-utilisateur.component";

const routes: Routes = [
  {path: 'NPK/accueil', component: HomeComponent},
  {path: '', redirectTo: 'NPK/accueil', pathMatch: 'full'},
  {path: 'NPK/flore', component: FloreComponent},
  {path: 'NPK/flore/fiche-flore', component: FicheFloreComponent},
  {path: 'NPK/faune', component: FauneComponent},
  {path: 'NPK/faune/fiche-faune', component: FicheFauneComponent},
  {path: 'NPK/synergie', component: SynergieComponent},
  {path: 'NPK/conseils', component: ConseilComponent},
  {path: 'NPK/contact', component: ContactComponent},
  {path: 'NPK/qui-sommes-nous', component: QuiSommesNousComponent},
  {path: 'NPK/panier', component: PanierComponent},
  {path: 'NPK/connexion', component: ConnexionComponent},
  {path: 'NPK/synergie/simulateur-un', component: SimulateurUnComponent},
  {path: 'NPK/synergie/simulateur-deux', component: SimulateurDeuxComponent},
  {path: 'NPK/compte-utilisateur', component: CompteUtilisateurComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {FauneComponent} from './faune/faune.component';
import {ConseilComponent} from './conseil/conseil.component';
import {SynergieComponent} from './synergie/synergie.component';
import {ContactComponent} from './contact/contact.component';
import {QuiSommesNousComponent} from './qui-sommes-nous/qui-sommes-nous.component';
import {PanierComponent} from './panier/panier.component';
import {ConnexionComponent} from './connexion/connexion.component';
import {FloreComponent} from './flore/flore.component';
import {FicheFauneComponent} from './fiche-faune/fiche-faune.component';
import {FicheFloreComponent} from './fiche-flore/fiche-flore.component';
import {SimulateurUnComponent} from './simulateur-un/simulateur-un.component';
import {SimulateurDeuxComponent} from './simulateur-deux/simulateur-deux.component';
import {CompteUtilisateurComponent} from './compte-utilisateur/compte-utilisateur.component';
import {EspaceClientComponent} from './espace-client/espace-client.component';
import {InformationsPersonnellesComponent} from './informations-personnelles/informations-personnelles.component';
import {FavorisComponent} from './favoris/favoris.component';
import {HistoriqueComponent} from './historique/historique.component';
import {JardinComponent} from './jardin/jardin.component';
import {CommandeComponent} from './commande/commande.component';
import {FicheComponent} from './fiche/fiche.component';
import {ContributionComponent} from './contribution/contribution.component';
import {MessagerieComponent} from './messagerie/messagerie.component';
import {FormulairePropositionComponent} from './formulaire-proposition/formulaire-proposition.component';
import {NouveauMessageComponent} from './nouveau-message/nouveau-message.component';
import {JardinFloreComponent} from './jardin-flore/jardin-flore.component';
import {JardinFauneComponent} from './jardin-faune/jardin-faune.component';
import {JardinEnvironnementComponent} from './jardin-environnement/jardin-environnement.component';
import {CompteComponent} from './compte/compte.component';
import {IsClientGuard} from './is-client.guard';
import {IsAdminGuard} from './is-admin.guard';
import {EspaceFournisseurComponent} from "./espace-fournisseur/espace-fournisseur.component";

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
  {path: 'NPK/panier', component: PanierComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/connexion', component: ConnexionComponent},
  {path: 'NPK/synergie/simulateur-un', component: SimulateurUnComponent},
  {path: 'NPK/synergie/simulateur-deux', component: SimulateurDeuxComponent},
  {path: 'NPK/compte', component: CompteComponent},
  {path: 'NPK/compte-utilisateur', component: CompteUtilisateurComponent,canActivate:[IsAdminGuard]},
  {path: 'NPK/espace-client', component: EspaceClientComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-client/informations-personnelles', component: InformationsPersonnellesComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-client/fiches', component: FicheComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-client/fiches/favoris', component: FavorisComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-client/fiches/contributions', component: ContributionComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-client/historique', component: HistoriqueComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-client/mon-petit-jardin', component: JardinComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-client/mon-petit-jardin/flore', component: JardinFloreComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-client/mon-petit-jardin/faune', component: JardinFauneComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-client/mon-petit-jardin/environnement', component: JardinEnvironnementComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-client/commandes', component: CommandeComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-client/contact', component: ContactComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-client/contact/messagerie', component: MessagerieComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-client/contact/messagerie/nouveau-message', component: NouveauMessageComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-client/contact/proposition-fiche', component: FormulairePropositionComponent,canActivate:[IsClientGuard]},
  {path: 'NPK/espace-fournisseur', component: EspaceFournisseurComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

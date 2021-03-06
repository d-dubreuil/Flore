import {BrowserModule, Title} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {CaracteristiqueComponent} from './caracteristique/caracteristique.component';
import {CommandeComponent} from './commande/commande.component';
import {CompteUtilisateurComponent} from './compte-utilisateur/compte-utilisateur.component';
import {ConseilComponent} from './conseil/conseil.component';
import {FauneComponent} from './faune/faune.component';
import {FavorisComponent} from './favoris/favoris.component';
import {FloreComponent} from './flore/flore.component';
import {JardinComponent} from './jardin/jardin.component';
import {PaiementComponent} from './paiement/paiement.component';
import {PanierComponent} from './panier/panier.component';
import {ProduitComponent} from './produit/produit.component';
import {SelectionComponent} from './selection/selection.component';
import {UtilisateurComponent} from './utilisateur/utilisateur.component';
import {SynergieComponent} from './synergie/synergie.component';
import {ContactComponent} from './contact/contact.component';
import {QuiSommesNousComponent} from './qui-sommes-nous/qui-sommes-nous.component';
import {ConnexionComponent} from './connexion/connexion.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { FicheFloreComponent } from './fiche-flore/fiche-flore.component';
import { FicheFauneComponent } from './fiche-faune/fiche-faune.component';
import { SimulateurUnComponent } from './simulateur-un/simulateur-un.component';
import { SimulateurDeuxComponent } from './simulateur-deux/simulateur-deux.component';
import {filterByFirstLetterPipe} from '../filter-by-first-letter.pipe';
import { EspaceClientComponent } from './espace-client/espace-client.component';
import { InformationsPersonnellesComponent } from './informations-personnelles/informations-personnelles.component';
import { HistoriqueComponent } from './historique/historique.component';
import { FicheComponent } from './fiche/fiche.component';
import { ContributionComponent } from './contribution/contribution.component';
import { FormulairePropositionComponent } from './formulaire-proposition/formulaire-proposition.component';
import { MessagerieComponent } from './messagerie/messagerie.component';
import { NouveauMessageComponent } from './nouveau-message/nouveau-message.component';
import { JardinFloreComponent } from './jardin-flore/jardin-flore.component';
import { JardinFauneComponent } from './jardin-faune/jardin-faune.component';
import { JardinEnvironnementComponent } from './jardin-environnement/jardin-environnement.component';
import {Ng2CompleterModule} from "ng2-completer";
import { CompteComponent } from './compte/compte.component';
import { EspaceFournisseurComponent } from './espace-fournisseur/espace-fournisseur.component';
import { InformationsFournisseurComponent } from './informations-fournisseur/informations-fournisseur.component';

@NgModule({
  declarations: [
    AppComponent,
    CaracteristiqueComponent,
    CommandeComponent,
    ConseilComponent,
    CompteUtilisateurComponent,
    FauneComponent,
    FavorisComponent,
    FloreComponent,
    JardinComponent,
    PaiementComponent,
    PanierComponent,
    ProduitComponent,
    SelectionComponent,
    UtilisateurComponent,
    SynergieComponent,
    ContactComponent,
    QuiSommesNousComponent,
    ConnexionComponent,
    HomeComponent,
    FicheFloreComponent,
    FicheFauneComponent,
    SimulateurUnComponent,
    SimulateurDeuxComponent,
    EspaceClientComponent,
    InformationsPersonnellesComponent,
    HistoriqueComponent,
    FicheComponent,
    ContributionComponent,
    filterByFirstLetterPipe,
    FormulairePropositionComponent,
    MessagerieComponent,
    NouveauMessageComponent,
    JardinFloreComponent,
    JardinFauneComponent,
    JardinEnvironnementComponent,
    CompteComponent,
    EspaceFournisseurComponent,
    InformationsFournisseurComponent
    ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    Ng2CompleterModule
  ],
  providers: [Title],
  bootstrap: [AppComponent]
})
export class AppModule {
}

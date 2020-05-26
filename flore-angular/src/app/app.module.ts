import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { CaracteristiqueComponent } from './caracteristique/caracteristique.component';
import { CommandeComponent } from './commande/commande.component';
import { CompteUtilisateurComponent } from './compte-utilisateur/compte-utilisateur.component';
import { ConseilComponent } from './conseil/conseil.component';
import { FauneComponent } from './faune/faune.component';
import { FavorisComponent } from './favoris/favoris.component';
import { FloreComponent } from './flore/flore.component';
import { HistoriqueComponent } from './historique/historique.component';
import { JardinComponent } from './jardin/jardin.component';
import { PaiementComponent } from './paiement/paiement.component';
import { PanierComponent } from './panier/panier.component';
import { ProduitComponent } from './produit/produit.component';
import { SelectionComponent } from './selection/selection.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { SynergieComponent } from './synergie/synergie.component';
import { ContactComponent } from './contact/contact.component';
import { QuiSommesNousComponent } from './qui-sommes-nous/qui-sommes-nous.component';
import { ConnexionComponent } from './connexion/connexion.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CaracteristiqueComponent,
    CommandeComponent,
    CompteUtilisateurComponent,
    ConseilComponent,
    FauneComponent,
    FavorisComponent,
    FloreComponent,
    HistoriqueComponent,
    JardinComponent,
    PaiementComponent,
    PanierComponent,
    ProduitComponent,
    SelectionComponent,
    UtilisateurComponent,
    HomeComponent,
    SynergieComponent,
    ContactComponent,
    QuiSommesNousComponent,
    ConnexionComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

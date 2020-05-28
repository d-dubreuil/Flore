import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ConseilComponent } from './conseil/conseil.component';
import { CaracteristiqueComponent } from './caracteristique/caracteristique.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ConseilComponent,
    CaracteristiqueComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

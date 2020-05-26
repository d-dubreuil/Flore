import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {ConseilComponent} from "./conseil/conseil.component";


//Configuration des routes
const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'conseil', component: ConseilComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

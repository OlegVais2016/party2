import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MembersComponent} from "./content/members/members.component";

const routes: Routes = [
  {path: 'members/all', component: MembersComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

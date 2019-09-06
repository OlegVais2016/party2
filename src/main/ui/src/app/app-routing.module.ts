import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MembersComponent} from "./content/members/members.component";
import {BecomeMemberComponent} from "./content/become-member/become-member.component";

const routes: Routes = [
  {path: 'members/all', component: MembersComponent},
  {path: 'members/save', component: BecomeMemberComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

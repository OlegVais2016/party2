import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MembersComponent} from "./content/members/members.component";
import {BecomeMemberComponent} from "./content/become-member/become-member.component";
import {EventsComponent} from "./content/events/events.component";
import {CreateEventComponent} from "./content/create-event/create-event.component";
import {MemberDetailsComponent} from "./content/members/member-details/member-details.component";

const routes: Routes = [
  {path: 'members/all', component: MembersComponent},
  {path: 'members/save', component: BecomeMemberComponent},
  {path: 'events/all', component: EventsComponent},
  {path: 'events/save', component: CreateEventComponent},
  {path: 'details/:id', component: MemberDetailsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

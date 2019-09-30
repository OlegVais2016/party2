import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ContentComponent } from './content/content.component';
import { MembersComponent } from './content/members/members.component';
import { EventsComponent } from './content/events/events.component';
import {HttpClientModule} from "@angular/common/http";
import { BecomeMemberComponent } from './content/become-member/become-member.component';
import { CreateEventComponent } from './content/create-event/create-event.component';
import { SearchComponent } from './content/members/search/search.component';
import { MemberDetailsComponent } from './content/members/member-details/member-details.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ContentComponent,
    MembersComponent,
    EventsComponent,
    BecomeMemberComponent,
    CreateEventComponent,
    SearchComponent,
    MemberDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

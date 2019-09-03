import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ContentComponent } from './content/content.component';
import { MembersComponent } from './content/members/members.component';
import { EventsComponent } from './content/events/events.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ContentComponent,
    MembersComponent,
    EventsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

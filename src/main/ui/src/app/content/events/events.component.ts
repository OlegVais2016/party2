import { Component, OnInit } from '@angular/core';

import {EventHttpService} from "../../service/event-http.service";
import Event from "../../model/Event";

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  public events: Event [] = [];

  constructor(private eventHttpService: EventHttpService) { }

  getEvents(){
    return this.eventHttpService
      .getEventsObservable()
      .subscribe(data => this.events = data);
  }

  ngOnInit() {
    this.getEvents();
  }

}

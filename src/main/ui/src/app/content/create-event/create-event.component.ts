import { Component, OnInit } from '@angular/core';
import Member from "../../model/Member";

import Event from "../../model/Event";
import {EventHttpService} from "../../service/event-http.service";


@Component({
  selector: 'app-create-event',
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.css']
})
export class CreateEventComponent implements OnInit {
  events: Event[];
  constructor(private eventHttpService: EventHttpService) { }

  ngOnInit() {
  }
  add(firstName: string, title: string, city: string, street: string, house: string): void {

    this.eventHttpService.addEvent({firstName,title, city, street,house } as Event)
      .subscribe(event => {
        this.events.push(event);
      });
  }
}

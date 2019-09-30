import {Component, Input, OnInit} from '@angular/core';
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
  @Input() member:Member;
  constructor(private eventHttpService: EventHttpService) { }

  ngOnInit() {
  }
  add(memberId: number, title: string, city: string, street: string, house: string): void {

    this.eventHttpService.addEvent({title, city, street,house } as Event,{} as Member)

      .subscribe(event => {
        this.events.push(event);
      });
  }
}

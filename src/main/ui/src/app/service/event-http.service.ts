import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import Event from "../model/Event";
import Member from "../model/Member";


@Injectable({
  providedIn: 'root'
})
export class EventHttpService {

  constructor(private httpClient: HttpClient) { }

  private eventsUrl = 'api/events';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getEventsObservable(): Observable<Event[]> {
    return this.httpClient.get<Event[]>(this.eventsUrl);
  }
  addEvent (event: Event, member: Member | number): Observable<Event> {
    const id = typeof member === 'number' ? member : member.id;
    const url = `${this.eventsUrl}/${id}`;
    return this.httpClient.post<Event>(url, event, this.httpOptions);
  }


}

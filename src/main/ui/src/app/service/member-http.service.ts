import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import Member from "../model/Member";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MemberHttpService {

  constructor(private httpClient: HttpClient) { }

  private membersUrl = 'api/members';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getMembersObservable(): Observable<Member[]> {
    return this.httpClient.get<Member[]>(this.membersUrl);
  }
  addMember (member: Member): Observable<Member> {
    return this.httpClient.post<Member>(this.membersUrl, member, this.httpOptions);
  }

  deleteMember (member: Member | number): Observable<Member> {
    const id = typeof member === 'number' ? member : member.id;
    const url = `${this.membersUrl}/${id}`;

    return this.httpClient.delete<Member>(url, this.httpOptions);
  }
}

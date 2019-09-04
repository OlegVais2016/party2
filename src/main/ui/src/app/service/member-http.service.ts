import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import Member from "../model/Member";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MemberHttpService {

  constructor(private httpClient: HttpClient) { }

  private membersUrl = 'api/member/members';  // URL to web api
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getMembersObservable(): Observable<Member[]> {
    return this.httpClient.get<Member[]>(this.membersUrl);
  }

}

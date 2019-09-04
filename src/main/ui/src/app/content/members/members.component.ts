import { Component, OnInit } from '@angular/core';
import Member from "../../model/Member";
import {MemberHttpService} from "../../service/member-http.service";

@Component({
  selector: 'app-members',
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.css']
})
export class MembersComponent implements OnInit {

  public members: Member [] = [];
  constructor(private memberHttpService: MemberHttpService) { }

  getMembers(){
    return this.memberHttpService
      .getMembersObservable()
      .subscribe(data => this.members == data)
  }

  ngOnInit() {
    this.getMembers()
  }

}

import { Component, OnInit } from '@angular/core';
import Member from "../../model/Member";
import {MemberHttpService} from "../../service/member-http.service";

@Component({
  selector: 'app-become-member',
  templateUrl: './become-member.component.html',
  styleUrls: ['./become-member.component.css']
})
export class BecomeMemberComponent implements OnInit {
  members: Member[];
  constructor(private memberHttpService: MemberHttpService) { }

  ngOnInit() {
  }
  add(email: string, password: string, firstName: string, lastName: string): void {

    this.memberHttpService.addMember({email,password, firstName, lastName } as Member)
      .subscribe(member => {
        this.members.push(member);
      });
  }
}

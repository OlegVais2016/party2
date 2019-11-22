import {Component, Input, OnInit} from '@angular/core';
import Member from "../../../model/Member";
import {Location} from "@angular/common";
import {MemberHttpService} from "../../../service/member-http.service";

@Component({
  selector: 'app-member-details',
  templateUrl: './member-details.component.html',
  styleUrls: ['./member-details.component.css']
})
export class MemberDetailsComponent implements OnInit {

  @Input() member: Member;

  constructor(
    private location: Location,
    private memberHttpService: MemberHttpService
  ) { }

  /*getHero(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.memberHttpService.(id)
      .subscribe(hero => this.hero = hero);
  }*/

  ngOnInit() {
  }
  goBack(): void {
    this.location.back();
  }
}

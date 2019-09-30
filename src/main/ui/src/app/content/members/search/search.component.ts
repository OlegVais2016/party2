import { Component, OnInit } from '@angular/core';
import Member from "../../../model/Member";
import {Observable, Subject} from "rxjs";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  members$: Observable<Member[]>;
  private searchTerms = new Subject<string>();

  constructor() { }

  // Push a search term into the observable stream.
  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit() {
  }

}

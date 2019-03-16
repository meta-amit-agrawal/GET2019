import { Component, OnInit, DoCheck } from '@angular/core';

import { DataService } from '../data.service';



@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {
  persons$: object;

  constructor(private data:DataService) { }
 
  ngOnInit() {
    this.fetch();
  }
  private fetch(){
    this.data.getPersons().subscribe(
      data => this.persons$ = data
    )
  }

}

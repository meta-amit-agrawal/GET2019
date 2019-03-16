import { Component, OnInit, Input } from '@angular/core';
import { Person } from '../person';


@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  
  @Input() person: Person;

  constructor() {
    
  }

  ngOnInit() {
    
  }

}

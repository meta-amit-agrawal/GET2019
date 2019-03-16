
import { Injectable } from '@angular/core';

import { Person } from './person';
import { Observable , of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class DataService {

  
  persons: Person[]=[
    {id:1, name: 'Akshat', contact: 7788994455, city:'Jaipur'},
    {id:2, name: 'Shubham', contact: 7788994455, city:'Mumbai'},
    {id:3, name: 'Rahul', contact: 7788994455, city:'Delhi'},
    {id:4, name: 'Nitesh', contact: 7788994455, city:'Jaipur'},
    {id:5, name: 'Joy', contact: 7788994455, city:'Ahmedabad'},
    {id:6, name: 'Jaya', contact: 7788994455, city:'Kolkata'},  
  ];
  
  counter = 6;
  constructor() { }   
  

  getPersons(): Observable<Person[]> {
    return of(this.persons);
  }

  getPerson(id: number): Observable<Person>{
    for(let person of this.persons){
      if(person.id == id){
        return of(person);
      }
    }
  }

  add(person: Person): Observable<any> {
    person.id = ++this.counter; 
    return of(this.persons.push({id:person.id,name:person.name,contact:person.contact,city:person.city}));
  }


  update(updatedPerson: Person): Observable<any> {
    let id = updatedPerson.id;
    let person;
    this.getPerson(id).subscribe(
      data => person = data
    );

    person.city=updatedPerson.city;
    person.name=updatedPerson.name;
    person.contact=updatedPerson.contact;
    return of(person);
  }
}

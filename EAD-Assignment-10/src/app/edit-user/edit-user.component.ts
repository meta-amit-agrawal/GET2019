import { Component, OnInit } from '@angular/core';
import { Person } from '../person';
import { DataService } from '../data.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
  person: Person ;
  submitted = false;      
  messageForm: FormGroup;
  
  personTobeUpdated = new Person();
  constructor(
    private dataService: DataService,
    private formBuilder: FormBuilder,
    private router: Router,
    private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.getPerson();
    this.messageForm = this.formBuilder.group({
      name: [this.person.name],
      contact: [this.person.contact],
      city: [this.person.city]
    });
  }


  private getPerson(){
    const id=+this.activatedRoute.snapshot.paramMap.get('id');
    this.dataService.getPerson(id)
      .subscribe(person => this.person = person as Person);
  }

  update(){
    this.submitted =true;
    if (this.messageForm.invalid) {
        return;
    }
    let person: Person = new Person();

    person.id = this.person.id;
    person.name=this.messageForm.controls.name.value;
    person.contact=this.messageForm.controls.contact.value;
    person.city=this.messageForm.controls.city.value;

    this.dataService.update(person).subscribe( data => {
      this.router.navigate(['home']);
    })    
  }
}

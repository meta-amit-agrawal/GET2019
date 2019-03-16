import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddUserComponent } from './add-user/add-user.component';
import { ContentComponent } from './content/content.component';
import { EditUserComponent } from './edit-user/edit-user.component';




const routes: Routes = [
  {path: '',redirectTo: '/home', pathMatch: "full"},
  {path:'home',component: ContentComponent},
  {path:'add',component: AddUserComponent}, 
  {path:'edit/:id',component: EditUserComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

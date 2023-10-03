import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewAdminComponent } from './new-admin/new-admin.component';
import { NewUserComponent } from './new-user/new-user.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { PropertiesComponent } from './properties/properties.component';
import { NewPropertyComponent } from './new-property/new-property.component';
import { AdminNavComponent } from './admin-nav/admin-nav.component';
import { UserNavComponent } from './user-nav/user-nav.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BookingComponent } from './booking/booking.component';
import { AboutComponent } from './about/about.component';
import { PropertyDetailComponent } from './property-detail/property-detail.component';
import { PropertUpdateComponent } from './propert-update/propert-update.component';
const routes: Routes = [
  {
    path:"",component:NavbarComponent
  },
  {
    path:"about",component:AboutComponent
  },
  {
    path:"propDetail/:id",component:PropertyDetailComponent
  },
  {
    path:"propUpdate/:id",component:PropertUpdateComponent
  },
  {
    path:"adminNav",component:AdminNavComponent
  },
  {
    path:"usernav",component:UserNavComponent
  },
  {
    path:"properties",component:PropertiesComponent
  },
  {
    path:"createadmin",component:NewAdminComponent
  },
  {
    path:"addproperty",component:NewPropertyComponent
  },
  {
    path:"createuser",component:NewUserComponent
  },
  {
    path:"loginadmin",component:LoginAdminComponent
  },
  {
    path:"loginuser",component:LoginUserComponent
  },
  {
    path:"sendbookingr",component:BookingComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

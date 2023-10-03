import {  NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { NewPropertyComponent } from './new-property/new-property.component';
import { NewAdminComponent } from './new-admin/new-admin.component';
import { NewUserComponent } from './new-user/new-user.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { PropertiesComponent } from './properties/properties.component';
import { AdminNavComponent } from './admin-nav/admin-nav.component';
import { UserNavComponent } from './user-nav/user-nav.component';
import { BookingComponent } from './booking/booking.component';
import { FooterComponent } from './footer/footer.component';
import { AboutComponent } from './about/about.component';
import { HeaderComponent } from './header/header.component';
import { PropertyDetailComponent } from './property-detail/property-detail.component';
import { PropertUpdateComponent } from './propert-update/propert-update.component';
import { ImagesComponent } from './images/images.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginUserComponent,
    LoginAdminComponent,
    NewPropertyComponent,
    NewAdminComponent,
    NewUserComponent,
    PropertiesComponent,
    AdminNavComponent,
    UserNavComponent,
    BookingComponent,
    FooterComponent,
    AboutComponent,
    HeaderComponent,
    PropertyDetailComponent,
    PropertUpdateComponent,
    ImagesComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CarListComponent } from './components/car-list/car-list.component';
import { CarModelsComponent } from './components/car-models/car-models.component';
import { CarDetailsComponent } from './components/car-details/car-details.component';
import { SearchComponent } from './components/search/search.component';
import { BookingDetailsComponent } from './components/booking-details/booking-details.component';
import { BookingSttatusComponent } from './components/booking-sttatus/booking-sttatus.component';
import { RentCarComponent } from './components/rent-car/rent-car.component';
import { CustomerRegistrationComponent } from './components/customer-registration/customer-registration.component';
import { LoginComponent } from './components/login/login.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { CustomerPageComponent } from './components/customer-page/customer-page.component';
import { CustomerProfileComponent } from './components/customer-profile/customer-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    CarListComponent,
    CarModelsComponent,
    CarDetailsComponent,
    SearchComponent,
    BookingDetailsComponent,
    BookingSttatusComponent,
    RentCarComponent,
    CustomerRegistrationComponent,
    LoginComponent,
    HomePageComponent,
    AboutUsComponent,
    ContactUsComponent,
    CustomerPageComponent,
    CustomerProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

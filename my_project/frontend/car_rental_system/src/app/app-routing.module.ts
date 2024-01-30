import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarListComponent } from './components/car-list/car-list.component';
import { CarDetailsComponent } from './components/car-details/car-details.component';
import { BookingDetailsComponent } from './components/booking-details/booking-details.component';
import { RentCarComponent } from './components/rent-car/rent-car.component';
import { CustomerRegistrationComponent } from './components/customer-registration/customer-registration.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginComponent } from './components/login/login.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { CustomerPageComponent } from './components/customer-page/customer-page.component';
import { CustomerProfileComponent } from './components/customer-profile/customer-profile.component';

const routes: Routes = [
  {path:'', component:HomePageComponent},
  {path:'home-page',component:HomePageComponent},
  {path:'customer-registration',component:CustomerRegistrationComponent},
  {path:'login',component:LoginComponent},
  {path:'about-us',component:AboutUsComponent},
  {path:'contact-us',component:ContactUsComponent},
  {path:'customer-page',component:CustomerPageComponent},
  {path:'customer-profile',component:CustomerProfileComponent},
  {path:'rentCar',component:RentCarComponent},
  {path:'booking-details', component:BookingDetailsComponent},
  {path:'car-models',component:CarListComponent},
  {path:'cars',component:CarListComponent},
  {path:'cars/:carId',component:CarListComponent},
  {path:'models/:modelId', component:CarListComponent},
  {path:'search/:keyword',component:CarListComponent},
  {path: '',redirectTo: '/cars', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

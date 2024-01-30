import { Component } from '@angular/core';
import { CarBooking } from '../../common/car-booking';
import { CarService } from '../../services/car.service';
import { BookingService } from '../../services/booking.service';

@Component({
  selector: 'app-booking-details',
  templateUrl: './booking-details.component.html',
  styleUrl: './booking-details.component.css'
})
export class BookingDetailsComponent {
  carBookings: CarBooking[] = [];
  totalPrice = 0.0;
  totalDays=0;

  constructor(private carService: BookingService) { }

  listCarDetails() {
    this.carBookings = this.carService.carBookings;
    this.carService.totalPrice.subscribe((data: number) => {
      this.totalPrice = data
    });

    this.carService.totalDays.subscribe((data: number) => {
      this.totalDays = data;
    });
    
    this.carService.computeCarTotal
  }

  ngOnInit() {
    this.listCarDetails();
  }
  incrementDays(theCarBooking:CarBooking){
    this.carService.carBooking(theCarBooking);
  }

  decrementDays(theCarBooking:CarBooking){
    this.carService.decrementDays(theCarBooking);
  }

  remove(theCarBooking: CarBooking){
    this.carService.remove(theCarBooking);
  }
}

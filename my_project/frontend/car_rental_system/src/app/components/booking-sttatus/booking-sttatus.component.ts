import { Component } from '@angular/core';
import { CarService } from '../../services/car.service';
import { BookingService } from '../../services/booking.service';

@Component({
  selector: 'app-booking-sttatus',
  templateUrl: './booking-sttatus.component.html',
  styleUrl: './booking-sttatus.component.css'
})
export class BookingSttatusComponent {

  totalPrice = 0.0;
  totalDays = 0;

  constructor(private carService: BookingService){}

  updateBookingStatus(){

    this.carService.totalPrice.subscribe((data: number) => {
      this.totalPrice = data;

    });
    this.carService.totalDays.subscribe((data: number) => {
      this.totalDays = data;
    });
  }

  ngOnInit(){
    this.updateBookingStatus();
  }

}

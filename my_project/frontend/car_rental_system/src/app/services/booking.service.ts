import { Injectable } from '@angular/core';
import { CarBooking } from '../common/car-booking';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  carBookings: CarBooking[] = [];

  totalDays: Subject<number> = new BehaviorSubject<number>(0);
  totalPrice: Subject<number> = new BehaviorSubject<number>(0);

  storage: Storage = sessionStorage

  constructor() {
    //let data = JSON.parse(this.storage.getItem('carBookings'))

    const data = this.storage.getItem('carBookings')
    let parsedData;
    if (data) {
      parsedData = JSON.parse(data)
    }
    if (data != null) {
      //this.carBookings=data;
      this.computeCarTotal();

    }
  }
  persistCarBooking() {
    this.storage.setItem('carBookings', JSON.stringify(this.carBookings));
  }
  //car Booking

  carBooking(theCarBooking: CarBooking) {
    console.log("carBooking of bookingservice")
   // console.log( JSON.stringify(theCarBooking))
    let alreadyExistsInBooking = false;
    let existingCarBookingIndex = -1;

    if (this.carBookings.length > 0) {
      existingCarBookingIndex = this.carBookings.findIndex(
        (tempCarBooking) => tempCarBooking.carId === theCarBooking.carId
      );
      //console.log("Existing :"+ JSON.stringify(existingCarBooking));


      alreadyExistsInBooking = existingCarBookingIndex != undefined;
    }
    if (alreadyExistsInBooking) {
    //  console.log("Existing :"+ JSON.stringify(existingCarBookingIndex));
    this.carBookings[existingCarBookingIndex].rentDays++;
     // existingCarBookingIndex.rentDays++;
    } else {
      this.carBookings.push(theCarBooking);
    }

    //calling cartitemtotal
    this.computeCarTotal();

  }
  computeCarTotal() {
    let totalPriceValue = 0;
    let totalDaysValue = 0;

    for (let currentBooking of this.carBookings) {
      totalPriceValue += currentBooking.rentDays * currentBooking.rentPrice;
      totalDaysValue += currentBooking.rentDays;
    }
    this.totalPrice.next(totalPriceValue);
    this.totalDays.next(totalDaysValue);

    this.persistCarBooking();
  }




  remove(theCarBooking: CarBooking) {
    let bookingIndex = this.carBookings.findIndex((carBooking) =>
      carBooking.carId === theCarBooking.carId
    );
    if (bookingIndex > -1) {
      this.carBookings.splice(bookingIndex, 1)
      this.computeCarTotal();
    }
  }
  decrementDays(theCarBooking: CarBooking) {
    theCarBooking.rentDays--;

    if (theCarBooking.rentDays === 0) {
      this.remove(theCarBooking);
    } else {
      this.computeCarTotal();
    }
  }

}






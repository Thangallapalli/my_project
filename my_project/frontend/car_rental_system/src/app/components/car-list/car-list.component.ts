import { Component, OnInit } from '@angular/core';
import { Car } from '../../common/car';
import { CarService } from '../../services/car.service';
import { ActivatedRoute } from '@angular/router';
import { CarBooking } from '../../common/car-booking';
import { BookingService } from '../../services/booking.service';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent {

  cars: Car[] = [];
  currentModelId: number | null | string = 1;
  searchMode: boolean = false;

  constructor(
    private carService: CarService,
    private route: ActivatedRoute,
    private  bookingService: BookingService
  ) { }

  ngOnInit() {
   // alert("Car List")
    this.route.paramMap.subscribe(() => {
      this.listCars() 
    });
  }

  listCars() {
    this.searchMode = this.route.snapshot.paramMap.has('keyword');

    if (this.searchMode) {
      this.handleSearchCars();
    } else {
      this.handleListCars();
    }
  }

  handleSearchCars() {
    const theKeyword: string | number | null = this.route.snapshot.paramMap.get('keyword');
    this.carService.searchCars(theKeyword).subscribe((data) => {
      this.cars = data;
    })
 
  }

  handleListCars() {
    const hashModelId: boolean = this.route.snapshot.paramMap.has('modelId');
   // alert(hashModelId)
    if (hashModelId) {
      this.currentModelId = this.route.snapshot.paramMap.get('modelId');
    } else {
      this.currentModelId = 1;
    }

    this.carService.getCarList(this.currentModelId).subscribe((data) => {
      this.cars = data;
    })
  }

  carBooking(theCar: Car) {

    const theCarBooking = new CarBooking(theCar);
    this.bookingService.carBooking(theCarBooking);
    console.log("carBooking of carlist")
  }
}
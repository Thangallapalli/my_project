import { Component } from '@angular/core';
import { Car } from '../../common/car';
import { CarService } from '../../services/car.service';
import { ActivatedRoute } from '@angular/router';
import { CarBooking } from '../../common/car-booking';
import { BookingService } from '../../services/booking.service';

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrl: './car-details.component.css'
})
export class CarDetailsComponent {
  car:Car=new Car();

  constructor(private service:CarService, private route: ActivatedRoute, private bookingService: BookingService){}

  ngOnInit(){
    this.route.paramMap.subscribe(()=>{
      this.handleCarDetails();
    })
  }

  handleCarDetails(){
    const theCarId: number |string | null = this.route.snapshot.paramMap.get("carId");
    this.service.getCar(theCarId).subscribe((data)=>{
      this.car = data;
    
  })
  }

  carBooking(theCar : Car){
    const theCarBooking = new CarBooking(theCar);
    this.service.carBooking(theCarBooking);
  }
}

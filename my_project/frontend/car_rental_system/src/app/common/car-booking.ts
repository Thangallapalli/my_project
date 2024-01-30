import { Car } from "./car";

export class CarBooking {
    carId:number;
    carNumber:number;
    model:string;
    imageUrl:string;
    rentPrice:number;
    rentDays:number;


    constructor(car: Car){
        this.carId = car.carId;
        this.carNumber = car.carNumber;
        this.model=car.model;
        this.imageUrl=car.imageUrl;
        this.rentPrice=car.rentPrice;
        this.rentDays=1;
    }

}

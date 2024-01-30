import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from '../common/car';
import { Models } from '../common/car-models';
import { CarBooking } from '../common/car-booking';


@Injectable({
  providedIn: 'root'
})
export class CarService {
  carBooking(theCarBooking: CarBooking) {
    throw new Error('Method not implemented.');
  }
  
  baseUrl = 'http://localhost:8181/myapp/api/car';
  modelUrl = 'http://localhost:8181/myapp/api/model';

 

  constructor(private http: HttpClient) { }


  getCarList(theModelId: number | null | string): Observable<Car[]> {
    const modelUrl = `${this.baseUrl}/carsByModels/${theModelId}`;
    return this.http.get<Car[]>(modelUrl);
  }

  getCarModels(): Observable<Models[]> {
    return this.http.get<Models[]>(this.modelUrl);
  }

  searchCars(theKeyword: string | null): Observable<Car[]> {
    const searchUrl = `${this.baseUrl}/search/${theKeyword}`;
    return this.http.get<Car[]>(searchUrl);
  }

  getCar(theCarId: number | string | null): Observable<Car> {
    const carUrl = `${this.baseUrl}/${theCarId}`;
    return this.http.get<Car>(carUrl);
  }
}
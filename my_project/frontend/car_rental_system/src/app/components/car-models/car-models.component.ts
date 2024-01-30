import { Component } from '@angular/core';
import { CarService } from '../../services/car.service';
import { Models } from '../../common/car-models';

@Component({
  selector: 'app-car-models',
  templateUrl: './car-models.component.html',
  styleUrl: './car-models.component.css'
})
export class CarModelsComponent {
  carModels:Models[];

  constructor(private carService: CarService){}

  ngOnInit(){
    this.listCarModels();
  }
  listCarModels(){
    this.carService.getCarModels().subscribe((data)=> {
      this.carModels=data;
    })
  }

}

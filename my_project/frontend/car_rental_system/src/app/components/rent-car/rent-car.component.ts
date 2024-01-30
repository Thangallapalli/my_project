import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RentCarService } from '../../services/rent-car.service';

@Component({
  selector: 'app-rent-car',
  templateUrl: './rent-car.component.html',
  styleUrl: './rent-car.component.css'
})
export class RentCarComponent {

  rentCarFormGroup:FormGroup
  creditCardMonths: number[];
  creditCardYears: number[];


  constructor(private formBuilder: FormBuilder,
    private rentCarService: RentCarService){
  
  }
  ngOnInit(){
    this.rentCarFormGroup=this.formBuilder.group({
      customer: this.formBuilder.group({
        firstName:[''],
        lastName:[''],
        email:[''],
        mobileNumber:[''],
        drivingLicense:[''],

      }),
      creditCard:this.formBuilder.group({
        cardType:[''],
        nameOnCard:[''],
        cardNumber:[''],
        securityCode:[''],
        expirationMonth:[''],
        expirationYear:[''],
      }),
    });

    const startMonth = new Date().getMonth()+1;
    console.log(startMonth);

    this.rentCarService.getCreditCardMonths(startMonth).subscribe((data) => {
      this.creditCardMonths = data;
    });

    this.rentCarService.getCreditCardYears().subscribe((data) => {
      this.creditCardYears = data;
    });
  }

  onSubmit(){
    console.log(this.rentCarFormGroup?.get('customer')?.value);
  console.log("Email Id:" +this.rentCarFormGroup?.get('customer')?.value.email);
  alert("booking succss")
  }
 
}


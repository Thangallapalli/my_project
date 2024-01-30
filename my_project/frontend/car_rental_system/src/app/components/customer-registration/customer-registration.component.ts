import { Component } from '@angular/core';
import { Customer } from '../../common/customer';
import { FormBuilder, Validators } from '@angular/forms';
import { CustomerService } from '../../services/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-registration',
  templateUrl: './customer-registration.component.html',
  styleUrl: './customer-registration.component.css'
})
export class CustomerRegistrationComponent {
  customer: Customer[];
  customerFormGroup: any;
  constructor(private formBuilder: FormBuilder, private service: CustomerService, private router: Router){}

  ngOnInit(){
    this.customerFormGroup = this.formBuilder.group({
      customerId:['', [Validators.required]],
      customerName: ['', [Validators.required, Validators.pattern('^[a-zA-Z]*$')]],
      password:['',[Validators.required]],
      gender:['',[Validators.required, Validators.pattern('^[a-zA-Z]*$')]],
      customerEmail:['', [Validators.required, Validators.email]],
      mobileNumber:['',[Validators.required, Validators.pattern('^[6-9][0-9]{9}$')]]
    });
  }
  addCustomer(){
    if(this.customerFormGroup.valid){
      this.service.saveCustomer(this.customerFormGroup.value).subscribe((data)=>{
        
        alert("Registration succssfully");
        this.router.navigate(['/login']);
      
      })
    }else{
      alert("please fill all the fields correctly")
    }
  }

}

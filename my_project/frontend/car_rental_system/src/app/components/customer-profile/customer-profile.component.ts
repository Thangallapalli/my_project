import { Component } from '@angular/core';
import { Customer } from '../../common/customer';
import { CustomerService } from '../../services/customer.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrl: './customer-profile.component.css'
})
export class CustomerProfileComponent {
customer : Customer = new Customer
currentCustomerId:number=1
constructor (private service: CustomerService, private router: ActivatedRoute){}
ngOnInit(){
  this.displayCustomerProfile();
}
displayCustomerProfile(){
this.service.getCustomer(this.currentCustomerId).subscribe((data)=>{
  this.customer = data;
})
}
}
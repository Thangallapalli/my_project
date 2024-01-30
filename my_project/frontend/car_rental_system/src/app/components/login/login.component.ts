import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Customer } from '../../common/customer';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  

  constructor(private customerService: CustomerService, private router: Router){}

  loginForm = new FormGroup({
    customerId: new FormControl('', [Validators.required]),
    customerEmail: new FormControl('',[Validators.required]),
    password: new FormControl('', [Validators.required])
  });
  login(insert: any){
    console.log(this.loginForm);
  }
  get customerId(){
    return this.loginForm.get('customerId');
  }
  get password(){
    return this.loginForm.get('password');
  }
  submit(){
    if(this.customerId?.value?.length === 0 || this.password?.value?.length === 0 || this.customerId?.invalid || this.password?.invalid){
      alert("enter valid details")
    }else{
      alert(JSON.stringify(this.loginForm.value))
      let customer: Customer = new Customer()
     
      customer.customerId = this.loginForm.value.customerId
      customer.customerEmail=this.loginForm.value.customerEmail
      customer.password = this.loginForm.value.password


      this.customerService.getCustomerUser(customer).subscribe(data => {
        console.log(data)
        this.customerService.getCustomerUser(customer).subscribe()
         localStorage.setItem('currentCustomer', JSON.stringify({customerId: this.customerId?.value}));
        alert("loged in")
        this.router.navigate(['/customer-page'])},
      error => {
        alert("invalid credentials")
      })
    }

  }
  }

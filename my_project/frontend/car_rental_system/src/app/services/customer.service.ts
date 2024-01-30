import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../common/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  baseUrl:string="http://localhost:8181/myapp/api/customer"

  constructor(private http:HttpClient) { }

  getCustomers():Observable<Customer[]>{
    return this.http.get<Customer[]>(this.baseUrl);
  }

  saveCustomer(customer:Customer):Observable<Customer>{
    return this.http.post<Customer>(this.baseUrl,customer);
  }
  deleteCustomer(customerId:number):Observable<any>{
    return this.http.delete(this.baseUrl+'/'+customerId);
  }

  getCustomer(customerId:number):Observable<Customer>{
    return this.http.get<Customer>(this.baseUrl+'/'+customerId);
  }

  updateCustomer(customer:Customer):Observable<any>{
    return this.http.put(this.baseUrl,customer);
  }
  getCustomerUser(data: Customer):Observable<any>{
    return this.http.post(this.baseUrl+ '/valid', data);
  }
}
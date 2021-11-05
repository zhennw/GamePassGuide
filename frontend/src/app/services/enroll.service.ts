import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { User } from '../models/user';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';
const BASE_API = environment.url;

@Injectable({
  providedIn: 'root'
})
export class EnrollService {

  constructor(private httpClient: HttpClient) { }

  enroll(fname: string, lname: string, email: string, username: string, password: string): Observable<any>{

        const body = JSON.stringify({'userFname':fname,'userLname':lname,'userName':username,'email':email,'userPassword':password});

        const httpOptions = {
          headers: new HttpHeaders({ 'Content-Type': 'application/json' })
        };

        const params = new HttpParams();
        // .append('fname', fname)
        // .append('lname', lname)
        // .append('username', username)
        // .append('email', email)
        // .append('password', password);
  
      return this.httpClient.post(BASE_API + 'register', body, httpOptions)

    
  }

  saveToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  saveUser(user: any): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }


}

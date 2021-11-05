import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService]
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  hide = true;
  loginInvalid = false;


  constructor(private loginService: LoginService, private _router: Router, private fb: FormBuilder) {
    this.loginForm = this.fb.group({
      email: ['', Validators.email],
      password: ['', Validators.required]
    });
   }

  ngOnInit(): void {
  }

  login(){
    if (this.loginForm.valid) {
      this.loginInvalid = true;
      const email = this.loginForm.get('email')?.value;
      const password = this.loginForm.get('password')?.value;

      this.loginService.login(email, password).subscribe(data => {
        if (data) {
          this.loginService.saveToken("myToken");
          this.loginService.saveUser(data);
          this.loginInvalid = false;
          this._router.navigate(["/"]);
        } else {
          this.loginInvalid = true;
        }
      })
    }
  }

}

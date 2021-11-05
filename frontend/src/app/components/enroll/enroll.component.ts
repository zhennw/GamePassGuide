import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { EnrollService } from 'src/app/services/enroll.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-enroll',
  templateUrl: './enroll.component.html',
  styleUrls: ['./enroll.component.css'],
  providers: [EnrollService]
})
export class EnrollComponent implements OnInit {
  enrollForm: FormGroup;
  hide = true;
  enrollInvalid = false;


  email: string = '';
  username: string = '';
  fname: string = '';
  lname: string = '';
  password: string = '';

  constructor(private enrollService: EnrollService, 
    private fb: FormBuilder,
    private _router: Router) {
    this.enrollForm = this.fb.group({
      fname: ['', Validators.required],
      lname: ['', Validators.required],
      email: ['', [Validators.email, Validators.required]],
      username: ['', Validators.required],
      password: ['', Validators.required]
    })
   }

  ngOnInit(): void {
  }

  enroll(){
    if(this.enrollForm.valid){
      this.enrollInvalid = true;
      const fname = this.enrollForm.get('fname')?.value;
      const lname = this.enrollForm.get('lname')?.value;
      const email = this.enrollForm.get('email')?.value;
      const username = this.enrollForm.get('username')?.value;
      const password = this.enrollForm.get('password')?.value;

      this.enrollService.enroll(fname, lname, email, username, password).subscribe(data => {
        if(data) {
          this.enrollService.saveToken("myToken");
          this.enrollService.saveUser(data);
          this._router.navigate(["/"]);
        } else {
          this.enrollInvalid = false;
        }
      })
    }


  }

}

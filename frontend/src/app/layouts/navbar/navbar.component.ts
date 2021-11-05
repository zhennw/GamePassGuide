import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isLoggedIn = false;
  user!: User;
  genres: any = ["action", "adventure", "fantasy", "horror", "soccer", "cricket"];
  platforms: any = ["xbox", "pc"];
  email: string = '';
  password: string = '';

  constructor(private loginService: LoginService, private _router: Router) { }

  ngOnInit(): void {
   this.isLoggedIn
    if (this.isLoggedIn) {
      this.user = this.loginService.getUser();
    }
  }

  loggedIn() {
    return this.loginService.getToken();
  }


  logout(): void {
    this.loginService.logout();
    this._router.navigate(["/"]);
  }

  dropDownClick(path: string, item: string) {
    this._router.navigate([path, item]);
  }

}

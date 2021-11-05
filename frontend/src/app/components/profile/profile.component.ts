import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { Game } from 'src/app/models/game';
import { User } from 'src/app/models/user';
import { GameService } from 'src/app/services/game.service';
import { LoginService } from 'src/app/services/login.service';
import { ProfileService } from 'src/app/services/profile.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit, OnDestroy {

  user!: User;
  city: string = '';
  country: string = '';
  favoriteGames: Game[];

  private _unsubscribeAll: Subject<any>;

  constructor(private loginService: LoginService, private profileService: ProfileService, private gameService: GameService) {
    this._unsubscribeAll = new Subject<any>();
    this.favoriteGames = this.gameService.getAllGames().slice(-8);
   }

  async ngOnInit(): Promise<void> {
    this.user = this.loginService.getUser();
    this.profileService.getLocation().subscribe((data: any) => {
      this.city = data.city;
      this.country = data.countryCode;
    })
  }

  ngOnDestroy(): void {
    this._unsubscribeAll.next();
    this._unsubscribeAll.complete();
  }

}

import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/models/game';
import { User } from 'src/app/models/user';
import { GameDetailsService } from 'src/app/services/game-details.service';
import { LoginService } from 'src/app/services/login.service';
import { GameService } from 'src/app/services/game.service';
import { ActivatedRoute } from '@angular/router';
import { Review } from 'src/app/models/review';
import { ReviewService } from 'src/app/services/review.service';



@Component({
  selector: 'app-game-details',
  templateUrl: './game-details.component.html',
  styleUrls: ['./game-details.component.css']
})


export class GameDetailsComponent implements OnInit {

  game!: Game;
  user!: User;
  reviews?: Review[];
  userLoggedIn = false;

  constructor(private gameDetailsService: GameDetailsService,
              private loginService: LoginService,
              private _route: ActivatedRoute,
              private gameService: GameService,
              private reviewService: ReviewService) { }

  writeReview(){
    this.gameDetailsService.writeReview(this.game, this.user);
  }

  ngOnInit(): void {
    this._route.paramMap.subscribe(async params => {
      const gameId = params.get('id');
      if (gameId) {
        this.game = this.gameService.getGameById(gameId);
        this.reviews = this.reviewService.getReviewsByGameId(gameId);
      }
    })
    const user = this.loginService.getUser();
    if(user.userId){
      this.userLoggedIn = true;
    } else {
      this.userLoggedIn = false;
    }
    this.user = user;
  }

}

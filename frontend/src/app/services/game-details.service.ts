import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Game } from '../models/game';
import { User } from '../models/user';


@Injectable({
  providedIn: 'root'
})
export class GameDetailsService {

  constructor(private _router: Router) { }

  getGame(): any {
    const game = window.sessionStorage.getItem('game');
    if (game) {
      return JSON.parse(game);
    }

    return {};
  }

    writeReview(game: Game, user: User){
      window.sessionStorage.setItem('game', JSON.stringify(game));
      this._router.navigate(['/write']);
    }

  }

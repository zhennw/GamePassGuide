import { _fixedSizeVirtualScrollStrategyFactory } from '@angular/cdk/scrolling';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Game } from '../models/game';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  date: string = '10/11/21;'

  games: Game[] = [
    {
      id: 1,
      title: 'Game Title 1',
      availableDate: this.date,
      availableEnd: this.date,
      imageUrl: 'https://gametracker-s3.s3.us-east-2.amazonaws.com/2141662.jpg',
      genre: 'action',
      isXbox: true,
      isPc: false
    },
    {
      id: 2,
      title: 'Game Title 2',
      availableDate: this.date,
      availableEnd: this.date,
      imageUrl: 'https://gametracker-s3.s3.us-east-2.amazonaws.com/2141662.jpg',
      genre: 'soccer',
      isXbox: true,
      isPc: false
    },
    {
      id: 3,
      title: 'Game Title 3',
      availableDate: this.date,
      availableEnd: this.date,
      imageUrl: 'https://gametracker-s3.s3.us-east-2.amazonaws.com/2141662.jpg',
      genre: 'thiller',
      isXbox: true,
      isPc: false
    },
    {
      id: 4,
      title: 'Game Title 4',
      availableDate: this.date,
      availableEnd: this.date,
      imageUrl: 'https://gametracker-s3.s3.us-east-2.amazonaws.com/2141662.jpg',
      genre: 'horror',
      isXbox: true,
      isPc: true
    },
    {
      id: 5,
      title: 'Game Title 5',
      availableDate: this.date,
      availableEnd: this.date,
      imageUrl: 'https://gametracker-s3.s3.us-east-2.amazonaws.com/2141662.jpg',
      genre: 'action',
      isXbox: true,
      isPc: true
    },
    {
      id: 6,
      title: 'Game Title 6',
      availableDate: this.date,
      availableEnd: this.date,
      imageUrl: 'https://gametracker-s3.s3.us-east-2.amazonaws.com/2141662.jpg',
      genre: 'racing',
      isXbox: true,
      isPc: false
    },
    {
      id: 7,
      title: 'Game Title 7',
      availableDate: this.date,
      availableEnd: this.date,
      imageUrl: 'https://gametracker-s3.s3.us-east-2.amazonaws.com/2141662.jpg',
      genre: 'action',
      isXbox: false,
      isPc: true
    },
    {
      id: 8,
      title: 'Game Title 8',
      availableDate: this.date,
      availableEnd: this.date,
      imageUrl: 'https://gametracker-s3.s3.us-east-2.amazonaws.com/2141662.jpg',
      genre: 'action',
      isXbox: false,
      isPc: true
    },
  ]

  constructor() {  }

  getAllGames(): Game[] {
    return this.games;
  }


  getGameById(gameId: string) {
    return this.games.filter((game: Game) => game.id === Number(gameId))[0];
  }

}

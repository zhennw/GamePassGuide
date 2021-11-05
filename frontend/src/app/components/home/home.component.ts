import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { OwlOptions } from 'ngx-owl-carousel-o';
import { Game } from 'src/app/models/game';
import { GameService } from 'src/app/services/game.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  trendingGames!: Game[];
  recentlyAddedGames!: Game[];
  featuredGames!: Game[];

  customOptions: OwlOptions = {
    loop: true,
    autoplay: true,
    center: true,
    dots: true,
    animateOut: 'fadeOut',
    responsive: {
      0: {
        items: 1,
      },
      600: {
        items: 1,
      },
      1000: {
        items: 1,
      }
    }
  }

  constructor(private gameService: GameService, private readonly http: HttpClient) { }

  ngOnInit(): void {
    this.trendingGames = this.gameService.getAllGames().slice(-4);
    this.recentlyAddedGames = this.gameService.getAllGames().slice(-4);
    this.featuredGames = this.gameService.getAllGames().slice(-3);
  }

}

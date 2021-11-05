import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Game } from '../models/game';
import { User } from '../models/user';

const BASE_API = environment.url;

@Injectable({
  providedIn: 'root'
})

export class WriteReviewService {



  constructor(private httpClient: HttpClient) { }

  submitReview(user: User, rating: number, review: string, game: Game): Observable<any>{

    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    const body = JSON.stringify({'reviewRating':rating, 'reviewBody':review, 'userId':user.userId, 'gameId': game.id});

    // const params = new HttpParams();
    // .append('email', email)
    // .append('userPassword', password);

    return this.httpClient.post(BASE_API + 'user/reviews', body, httpOptions);
  }
  //http://ptsv2.com/t/anazopyreo/post
}

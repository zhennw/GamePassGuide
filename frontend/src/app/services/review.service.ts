import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Review } from 'src/app/models/review';
// import { Review } from '../models/review';

const BASE_API = environment.url;

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  reviews: Review[] = [{'id': 0, 'rating': 0, 'body': '', 'userId': 0, 'gameId': 0}];

  constructor(private httpClient:HttpClient) { }

  getReviewsByGameId(gameId: string): Review[]{
    return this.reviews.filter((review: Review) => review.id === Number(gameId));
  }

  getAllReviews(): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    const body = JSON.stringify('');
  
    return this.httpClient.post(BASE_API + 'user/reviews', body, httpOptions);


  }
}

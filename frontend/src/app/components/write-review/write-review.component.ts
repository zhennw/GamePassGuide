import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/models/game';

import { GameDetailsService } from 'src/app/services/game-details.service';
import { LoginService } from 'src/app/services/login.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { WriteReviewService } from 'src/app/services/write-review.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-write-review',
  templateUrl: './write-review.component.html',
  styleUrls: ['./write-review.component.css']
})
export class WriteReviewComponent implements OnInit {
  reviewForm: FormGroup;
  reviewInvalid: boolean = false;
  selected: string = '';
  reviewMessage: string = '';

  constructor(private gameDetailsService: GameDetailsService,
              private writeReviewService: WriteReviewService,
              private loginService: LoginService,
              private fb: FormBuilder) {
    this.reviewForm = this.fb.group({
      rating: ['', Validators.required],
      review: ['', Validators.required]
    });

  }

  game: Game = {
    id: 1,
    title: '',
    availableDate: '',
    availableEnd: '',
    imageUrl: '',
    genre: '',
    isXbox: true,
    isPc: true
}

  submit(){
    if(this.reviewForm.valid){
      const user: User = this.loginService.getUser();
      const rating = this.reviewForm.get('rating')?.value;
      const review = this.reviewForm.get('review')?.value;
      this.writeReviewService.submitReview(user, rating, review, this.game).subscribe();
    }
  }

  ngOnInit(): void {
    this.game = this.gameDetailsService.getGame();
  }

}

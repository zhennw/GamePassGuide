import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EnrollComponent } from './components/enroll/enroll.component';
import { GameDetailsComponent } from './components/game-details/game-details.component';
import { GamesComponent } from './components/games/games.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';
import { WriteReviewComponent } from './components/write-review/write-review.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home', 
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'games',
    component: GamesComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'enroll',
    component: EnrollComponent
  },
  {
    path: 'profile',
    component: ProfileComponent
  },
  {
    path: 'games/:id',
    component: GameDetailsComponent
  },
  {
    path: 'write',
    component: WriteReviewComponent
  },
  {
    path: 'genres/:id',
    component: GamesComponent
  },
  {
    path: 'platforms/:id',
    component: GamesComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

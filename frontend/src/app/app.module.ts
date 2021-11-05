import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { FlexLayoutModule } from '@angular/flex-layout';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { GamesComponent } from './components/games/games.component';
import { MaterialModule } from './material/material.module';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { GenresComponent } from './components/genres/genres.component';
import { EnrollComponent } from './components/enroll/enroll.component';
import { ProfileComponent } from './components/profile/profile.component';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { FooterComponent } from './layouts/footer/footer.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { GameDetailsComponent } from './components/game-details/game-details.component';
import { WriteReviewComponent } from './components/write-review/write-review.component';
// import { RegisterComponent } from './components/register/register.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    GamesComponent,
    LoginComponent,
    HomeComponent,
    GenresComponent,
    EnrollComponent,
    ProfileComponent,
    FooterComponent,
    GameDetailsComponent,
    WriteReviewComponent,
    // RegisterComponent,
    EnrollComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    CarouselModule,
    FontAwesomeModule
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent,NavbarComponent]
})
export class AppModule { }

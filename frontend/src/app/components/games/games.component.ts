import { Component, OnInit, OnDestroy, ViewChild, ChangeDetectorRef } from '@angular/core';
import { Observable } from 'rxjs';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { Game } from 'src/app/models/game';
import { GameService } from 'src/app/services/game.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.css']
})

export class GamesComponent implements OnInit, OnDestroy {
  games!: Game[];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  
  obs!: Observable<any>;
  dataSource!: MatTableDataSource<Game>;
  title: string = 'Gamepass Now';


  constructor(
    private changeDetectorRef: ChangeDetectorRef,
    private _gameService: GameService,
    private _route: ActivatedRoute,
    private _router: Router
  ) {
  }


  async ngOnInit(): Promise<void> {
      this._route.paramMap.subscribe(async params => {
          const filter = params.get('id');
          if (filter) {
            this.title = filter;
            if (filter === 'xbox' || filter === 'pc') {
              if (filter === 'xbox') {
                this.games = await this._gameService.getAllGames().filter((game: Game) => game.isXbox === true);
              } else {
                this.games = await this._gameService.getAllGames().filter((game: Game) => game.isPc === true);
              }
            } else {
              this.games = await this._gameService.getAllGames().filter((game: Game) => game.genre === filter);
            }
          } else {
            this.games = await this._gameService.getAllGames();
          }
          this.dataSource = new MatTableDataSource<Game>(this.games);
          this.changeDetectorRef.detectChanges();
          this.dataSource.paginator = this.paginator;
          this.obs = this.dataSource.connect();
      })
  }

  getGameDetails(id: number){
    this._router.navigate(['games', id]);
  }

  ngOnDestroy(): void {
    if (this.dataSource) {
      this.dataSource.disconnect();
    }
  }

  applyFilter(event: Event): void {
    // get the input value
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
        this.dataSource.paginator.firstPage();
    }
}

}

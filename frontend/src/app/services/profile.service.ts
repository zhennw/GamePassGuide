import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService implements OnDestroy {

  private _unsubscribeAll: Subject<any>;


  constructor(private httpClient: HttpClient) {
    this._unsubscribeAll = new Subject<any>();
  }


getLocation() {
    let bdcApi = "https://api.bigdatacloud.net/data/reverse-geocode-client"

    navigator.geolocation.getCurrentPosition(
      (position) => {
        bdcApi = bdcApi
          + "?latitude=" + position.coords.latitude
          + "&longitude=" + position.coords.longitude
          + "&localityLanguage=en";
      },
      (err) => { Promise.reject(err) },
      {
        enableHighAccuracy: true,
        timeout: 5000,
        maximumAge: 0
      });
      return this.getApi(bdcApi);
  }

  ngOnDestroy(): void {
    this._unsubscribeAll.next();
    this._unsubscribeAll.complete();
  }

  private getApi(bdcApi: string) { 
    return this.httpClient.get(bdcApi);
  }
}

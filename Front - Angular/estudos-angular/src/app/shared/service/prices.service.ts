import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Inject } from '@angular/core';
import { Prices } from '../model/Prices.model';

@Injectable({ providedIn: 'root' })
export class PricesService {
  apiUrl = 'http://localhost:8080/api';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };
  constructor(private httpClient: HttpClient) {}

  public getPrices(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl + "/Cotacoes/Dolar" );
  }
  public getPricesAll(): Observable<any> {
    console.log(this.httpClient.get<any>(this.apiUrl + "/Cotacoes" ));
    return this.httpClient.get<any>(this.apiUrl + "/Cotacoes" );
  }
}

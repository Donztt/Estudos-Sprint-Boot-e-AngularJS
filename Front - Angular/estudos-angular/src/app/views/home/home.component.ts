import { Component, OnInit } from '@angular/core';
import {Prices} from 'src/app/shared/model/Prices.model';
import { Inject } from '@angular/core';
import { PricesService } from 'src/app/shared/service/prices.service'
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

price!: Prices;
pricesList!: Prices[];
displayedColumns: string[] = ['id', 'nome', 'valor','data'];

  constructor(
     public priceService: PricesService
  )
  {}

  ngOnInit(): void {
    this.getPrice();
    this.getPricesAll();
  }

  getPrice(){
    this.priceService.getPrices().subscribe(data => {
        this.price = data;
    });
  }
  getPricesAll(){
    this.priceService.getPricesAll().subscribe(data => {
        this.pricesList = data;
    });
  }
}

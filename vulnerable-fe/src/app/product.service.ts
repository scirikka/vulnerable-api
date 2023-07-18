import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product.model';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private apiUrl = 'http://localhost:8080/api/v1/products';

  constructor(private http: HttpClient) {}

  getProducts(size: number): Observable<Product[]> {
    let params = new HttpParams().set('size', size.toString());
    return this.http.get<Product[]>(this.apiUrl, { params });
  }
}

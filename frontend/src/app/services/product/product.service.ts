import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) {
  }

  getProducts(): Observable<Array<Product>> {
    return this.httpClient.get<Array<Product>>('http://192.168.1.120:9000/api/product');
  }

  createProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>('http://192.168.1.120:9000/api/product', product);
  }
}

import { Component } from '@angular/core';
import { ProductListComponent } from './components/product-list/product-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ProductListComponent],
  template: `<div class="container">
               <app-product-list></app-product-list>
             </div>`,
  styleUrls: ['./app.component.css']
})
export class AppComponent {}

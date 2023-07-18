import {Component, OnInit} from '@angular/core';
import {UserService} from './user.service';
import {User} from './user.model';
import {Product} from "./product.model";
import {ProductService} from "./product.service";
import {MatDialog} from "@angular/material/dialog";
import {BuyConfirmationDialogComponent} from "./buy-confirmation-dialog/buy-confirmation-dialog.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
})
export class AppComponent implements OnInit {
  user: User | null = null;
  products: Product[] = [];
  errorMessage: string | null = null;

  constructor (private userService: UserService,
               private productService: ProductService,
               private dialog: MatDialog) {
  }

  ngOnInit () {
    this.getUserDetails();
    this.getProducts();
  }

  getUserDetails () {
    const userId = 0;
    this.userService.getUserById(userId).subscribe(
      (user) => {
        this.user = user;
      },
      (error) => {
        this.errorMessage = 'Error fetching user details.';
      }
    );
  }

  updateUser () {
    if (this.user) {
      this.userService.updateUser(this.user.id, this.user).subscribe(
        (user) => {
          this.user = user;
          alert('User details updated successfully!');
        },
        (error) => {
          this.errorMessage = 'Error updating user details.';
        }
      );
    }
  }

  getProducts () {
    const size = 10;
    this.productService.getProducts(size).subscribe(
      (products) => {
        this.products = products;
      },
      (error) => {
        this.errorMessage = 'Error fetching products.';
      }
    );
  }

  openBuyConfirmationDialog () {
    this.dialog.open(BuyConfirmationDialogComponent);
  }

}

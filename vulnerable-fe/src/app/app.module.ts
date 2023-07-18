import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatDialogModule } from '@angular/material/dialog';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BuyConfirmationDialogComponent } from './buy-confirmation-dialog/buy-confirmation-dialog.component';

@NgModule({
  declarations: [AppComponent, BuyConfirmationDialogComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule, MatDialogModule, BrowserAnimationsModule], // Add MatDialogModule to the imports array
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

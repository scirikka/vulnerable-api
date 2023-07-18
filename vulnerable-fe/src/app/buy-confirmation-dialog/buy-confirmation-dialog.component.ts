import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-buy-confirmation-dialog',
  template: `
    <h2 mat-dialog-title>You bought the item!</h2>
    <div mat-dialog-actions>
      <button mat-button (click)="onCloseClick()">Close</button>
    </div>
  `,
})
export class BuyConfirmationDialogComponent {
  constructor(public dialogRef: MatDialogRef<BuyConfirmationDialogComponent>) {}

  onCloseClick(): void {
    this.dialogRef.close();
  }
}

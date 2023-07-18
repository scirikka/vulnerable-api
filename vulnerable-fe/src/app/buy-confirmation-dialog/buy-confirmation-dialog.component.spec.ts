import {ComponentFixture, TestBed} from '@angular/core/testing';

import {BuyConfirmationDialogComponent} from './buy-confirmation-dialog.component';

describe('BuyConfirmationDialogComponent', () => {
  let component: BuyConfirmationDialogComponent;
  let fixture: ComponentFixture<BuyConfirmationDialogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BuyConfirmationDialogComponent]
    });
    fixture = TestBed.createComponent(BuyConfirmationDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

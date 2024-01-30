import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingSttatusComponent } from './booking-sttatus.component';

describe('BookingSttatusComponent', () => {
  let component: BookingSttatusComponent;
  let fixture: ComponentFixture<BookingSttatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BookingSttatusComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BookingSttatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

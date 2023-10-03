import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PropertUpdateComponent } from './propert-update.component';

describe('PropertUpdateComponent', () => {
  let component: PropertUpdateComponent;
  let fixture: ComponentFixture<PropertUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PropertUpdateComponent]
    });
    fixture = TestBed.createComponent(PropertUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

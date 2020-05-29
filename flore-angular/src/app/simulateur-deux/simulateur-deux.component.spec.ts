import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SimulateurDeuxComponent } from './simulateur-deux.component';

describe('SimulateurDeuxComponent', () => {
  let component: SimulateurDeuxComponent;
  let fixture: ComponentFixture<SimulateurDeuxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SimulateurDeuxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SimulateurDeuxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

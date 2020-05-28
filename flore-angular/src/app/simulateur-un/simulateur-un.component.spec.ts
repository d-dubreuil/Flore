import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SimulateurUnComponent } from './simulateur-un.component';

describe('SimulateurUnComponent', () => {
  let component: SimulateurUnComponent;
  let fixture: ComponentFixture<SimulateurUnComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SimulateurUnComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SimulateurUnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

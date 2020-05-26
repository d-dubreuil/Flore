import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FicheFauneComponent } from './fiche-faune.component';

describe('FicheFauneComponent', () => {
  let component: FicheFauneComponent;
  let fixture: ComponentFixture<FicheFauneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FicheFauneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FicheFauneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

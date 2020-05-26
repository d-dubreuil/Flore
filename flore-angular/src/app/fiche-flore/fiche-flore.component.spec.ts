import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FicheFloreComponent } from './fiche-flore.component';

describe('FicheFloreComponent', () => {
  let component: FicheFloreComponent;
  let fixture: ComponentFixture<FicheFloreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FicheFloreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FicheFloreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

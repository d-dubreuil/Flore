import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulairePropositionComponent } from './formulaire-proposition.component';

describe('FormulairePropositionComponent', () => {
  let component: FormulairePropositionComponent;
  let fixture: ComponentFixture<FormulairePropositionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormulairePropositionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulairePropositionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

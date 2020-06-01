import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JardinEnvironnementComponent } from './jardin-environnement.component';

describe('JardinEnvironnementComponent', () => {
  let component: JardinEnvironnementComponent;
  let fixture: ComponentFixture<JardinEnvironnementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JardinEnvironnementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JardinEnvironnementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

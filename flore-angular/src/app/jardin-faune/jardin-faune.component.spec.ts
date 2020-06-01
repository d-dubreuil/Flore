import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JardinFauneComponent } from './jardin-faune.component';

describe('JardinFauneComponent', () => {
  let component: JardinFauneComponent;
  let fixture: ComponentFixture<JardinFauneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JardinFauneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JardinFauneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

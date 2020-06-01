import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JardinFloreComponent } from './jardin-flore.component';

describe('JardinFloreComponent', () => {
  let component: JardinFloreComponent;
  let fixture: ComponentFixture<JardinFloreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JardinFloreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JardinFloreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

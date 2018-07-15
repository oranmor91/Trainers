import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerProgramComponent } from './trainer-program.component';

describe('TrainerProgramComponent', () => {
  let component: TrainerProgramComponent;
  let fixture: ComponentFixture<TrainerProgramComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrainerProgramComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerProgramComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

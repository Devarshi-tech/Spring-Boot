import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MessageAlertsComponent } from './message-alerts.component';

describe('MessageAlertsComponent', () => {
  let component: MessageAlertsComponent;
  let fixture: ComponentFixture<MessageAlertsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MessageAlertsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MessageAlertsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

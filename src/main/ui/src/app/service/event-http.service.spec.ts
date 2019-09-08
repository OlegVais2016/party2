import { TestBed } from '@angular/core/testing';

import { EventHttpService } from './event-http.service';

describe('EventHttpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EventHttpService = TestBed.get(EventHttpService);
    expect(service).toBeTruthy();
  });
});

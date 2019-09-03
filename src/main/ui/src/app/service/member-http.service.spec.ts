import { TestBed } from '@angular/core/testing';

import { MemberHttpService } from './member-http.service';

describe('MemberHttpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MemberHttpService = TestBed.get(MemberHttpService);
    expect(service).toBeTruthy();
  });
});

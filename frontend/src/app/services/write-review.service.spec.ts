import { TestBed } from '@angular/core/testing';

import { WriteReviewService } from './write-review.service';

describe('WriteReviewService', () => {
  let service: WriteReviewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WriteReviewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

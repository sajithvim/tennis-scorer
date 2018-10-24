package com.dius.tennisscorer.unittests;

import org.junit.Before;
import org.junit.Test;

import com.dius.tennisscorer.score.GenericScorer;
import com.dius.tennisscorer.score.Scorer;

public class TestScorer {
	
	private Scorer scorer;
	
	@Before
	public void setup() {
		scorer = new GenericScorer();
	}
	
	@Test
	public void testWinRegularPoint() {
		
	}
	

}

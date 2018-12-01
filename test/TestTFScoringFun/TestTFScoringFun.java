package TestTFScoringFun;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import score.TFScoringFun;

public class TestTFScoringFun {
	
	 @Test
	    public void testScoreToken() {
	        String term = "";
	        int freq = 0;
	        TFScoringFun instance = new TFScoringFun();
	        double expResult = 0.0;
	        double result = instance.scoreToken(term, freq);
	        assertEquals(expResult, result, 0.0);
	        
	    }

}

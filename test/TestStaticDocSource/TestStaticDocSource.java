package TestStaticDocSource;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import score.TFScoringFun;
import tokenizer.IndexingTokenizer;
import tokenizer.Tokenizer;

public class TestStaticDocSource {
	@Test
	public void testStaticDocSource() {
		
		Tokenizer tok = new IndexingTokenizer();
		final String[] _documents = {
				"Qualcomm draws up plans to rebuff Broadcom's $103 billion offer: sources",
				"SoftBank is buying a chunk of Uber and it's state-of-the-art Taxi-hailing system for $10 billion",
				"Reuters: Qualcomm could reject Broadcom bid this week",
				"Bitcoin Price Could Reach $10000 by End of This Year, According to Various Tests",
				"Uber Board Strikes Agreement to Pave the Way for SoftBank Investment",
				"Boeing wins big 787 deal at Dubai Air Show, delivering surprising early blow to Airbus",
				"Bitcoin briefly drops 15% in rocky weekend amid controversy over digital currency's future: is it the end of Bitcoin?",
				"Dubai Air Show opens with Emirates' $15.1 billion Boeing buy",
				"Women climbed through McDonald's drive-thru window, attacked manager over chicken nugget dispute",
				"Fight erupts at Indianapolis McDonald's drive-thru over chicken nuggets order"
		};
		assertEquals("Failed String allocation", "Qualcomm draws up plans to rebuff Broadcom's $103 billion offer: sources", _documents[0]);
		
		
	}
	
	
	
	

}

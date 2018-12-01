package TestDocScore;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import index.DocScore;
import tokenizer.Tokenizer;
import tokenizer.IndexingTokenizer;
import tokenizer.SimpleTokenizer;

public class TestDocScore {

	@Test
	public void testConstructor() {
		double score1 = 5.7;
		int    docID1 = 1;
		String content1 = "words";
		
		DocScore ds = null;
		DocScore ds2 = null;
		assertEquals("failed null", ds, ds2);
	}

}

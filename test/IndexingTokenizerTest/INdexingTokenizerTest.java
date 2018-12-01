package IndexingTokenizerTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import tokenizer.Tokenizer;
import tokenizer.IndexingTokenizer;
import tokenizer.SimpleTokenizer;

public class INdexingTokenizerTest {

	@Test
	public void testIndexingTokenize() {
		Tokenizer tok = new IndexingTokenizer();
		ArrayList<String> tokens = tok.tokenize("High-tech solutions to new age problems.");
		assertEquals("Failed lowercase", "high-tech", tokens.get(0));
		assertEquals("Failed hyphen test", "high-tech", tokens.get(0));
	}

}

package TestSortedDocScore;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.TreeSet;

import index.SortedDocScore;

public class TestSort {

	@Test
	public void testSort() {
		SortedDocScore a = new SortedDocScore(3.452, 1, "Wow such a cool document");
		SortedDocScore b = new SortedDocScore(3.452, 2, "Amazing! This document is even cooler!");
		SortedDocScore c = new SortedDocScore(623.745345, 3,
				"That score! It's likes haven't been seen for a century at the very least");

		TreeSet<SortedDocScore> sort = new TreeSet();
		sort.add(a);
		sort.add(b);
		sort.add(c);

		Object[] sorted = sort.toArray();

		SortedDocScore[] expresult = new SortedDocScore[] { c, b, a };
		assertEquals("Failed sort", expresult[0], sorted[0]);

	}

}

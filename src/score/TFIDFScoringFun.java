package score;

import index.Index;

/**
 *
 * @author cooneyth
 */
public class TFIDFScoringFun implements TermScoringFun {

    private Index _index;

    @Override
    public void init(Index s) {
        _index = s;
    }

    @Override
    public double scoreToken(String term, int freq) {
        double n = (_index.getDocSource().getNumDocs());
        double dft = (_index.getDocumentFreq(term));
        return ((1.0 + (double) Math.log10( (double) freq)) * ((double) Math.log10( n/ dft)));
    }

}
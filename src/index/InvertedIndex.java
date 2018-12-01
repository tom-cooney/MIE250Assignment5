package index;

import io.DocSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.ArrayList;
import score.TermScoringFun;
import tokenizer.Tokenizer;

/**
 *
 * @author cooneyth
 */
public class InvertedIndex extends Index {

    private HashMap<String, HashMap<Integer, Integer>> _index;
    private HashMap<String, Integer> _docFreq;
    private HashMap<Integer, Double> _IDandScore;
    private TreeSet<SortedDocScore> _almostFinal;
    private ArrayList<DocScore> _final;
    private HashMap<Integer, Integer> _post;

    public InvertedIndex(DocSource doc_source, Tokenizer tokenizer, TermScoringFun scoring) {
        super(doc_source, tokenizer, scoring);
    }

    @Override
    public void buildIndex() {
        _index = new HashMap<String, HashMap<Integer, Integer>>();
        _docFreq = new HashMap<String, Integer>();

        for (int i = 0; i < _docSource.getNumDocs(); i++) { //loop through each doc
            for (String s : _tokenizer.tokenize(_docSource.getDoc(i))) {//loop through all words
                if (!_index.containsKey(s)) {
                    HashMap temp = new HashMap<>();
                    temp.put(i, 1);
                    _index.put(s, temp);//put word in index

                } else {
                    if (!_index.get(s).containsKey(i)) {//if word is in the doc
                        //termfreq++
                        _index.get(s).put(i, 1);
                    } else {//if word isnt in doc
                        //assign word a new DocID
                        _index.get(s).put(i, _index.get(s).get(i) + 1);
                    }
                }
            }
            //_docFreq.put(s, _index.get(s).size());
        }

        for (String str : _index.keySet()) {
            _docFreq.put(str, _index.get(str).size());
        }
    }

    @Override
    public Integer getDocumentFreq(String term) {
        return _docFreq.get(term);
    }
    
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for(String s : _index.keySet()) {
    		for(int i : _index.get(s).keySet()) {
    			sb.append(s + " , " + i);
    		}
    	}
    	return sb.toString();
    }
    

    @Override
    public ArrayList<DocScore> getSortedSearchResults(String query) {
        _IDandScore = new HashMap<Integer, Double>();
        _almostFinal = new TreeSet<SortedDocScore>();
        _final = new ArrayList<DocScore>();
        Integer termFrequency = 0;
        Double score = 0.0;
        for (String s : _tokenizer.tokenize(query)) {
            HashMap<Integer, Integer> _post = _index.get(s);
            if (_post != null) {
                for (Integer docID : _post.keySet()) {
                    termFrequency = _post.get(docID);
                    score = _IDandScore.get(docID);
                    if (score == null) {
                        score = 0.0D;
                    }
                    _IDandScore.put(docID, (Double) (score + _scoring.scoreToken(s, termFrequency)));
                }
            }
        }
        for (int arb : _IDandScore.keySet()) {
            double heShootsHeScores = _IDandScore.get(arb);
            _almostFinal.add(new SortedDocScore(heShootsHeScores, arb, _docSource.getDoc(arb)));
        }
        _final = new ArrayList(_almostFinal);
        return _final;
    }
}
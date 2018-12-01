package index;
import io.FileDocSource;
/**
 *
 * @author cooneyth
 */
public class SortedDocScore extends DocScore implements Comparable {

    public SortedDocScore(double score, int doc_id, String content) {
        super(score, doc_id, content);
    }

    //compare score
    @Override
    public int compareTo(Object o) {
        if (o instanceof SortedDocScore) {
            SortedDocScore d = (SortedDocScore) o;//cast
            double temp = _score - d.getScore();
            if (temp > 0) {
                return -1;
            }

            if (temp < 0) {
                return 1;
            }
            if (temp == 0) {
                //if score is even compare the contents
                return _content.compareTo(d._content);
                
                }
            
        } else 
        {
            return 854678;
        }
        return 854678;
    }
}
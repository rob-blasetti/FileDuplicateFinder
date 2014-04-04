package duplicateFinder;

/**
 * Created by leng on 2/04/2014.
 */
public class StringOutputter implements Outputter {
    private String result;

    @Override
    public void writeLine(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}

package duplicateFinder;

/**
 * Created by leng on 2/04/2014.
 */
public class ScreenOutput implements Outputter {

    @Override
    public void writeLine(String result) {

        System.out.println(result);
    }
}

package duplicateFinder;

import duplicateFinder.StringFormatter;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by leng on 2/04/2014.
 */
public class StringFormatterTest {
    private String expectedResult;
    private StringFormatter stringFormatter;
    private HashMap<String, ArrayList<String>> duplicatedFilePaths;

    @Before
    public void setup() {
        duplicatedFilePaths = new HashMap<String, ArrayList<String>>();
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("Path1");
        list1.add("Path2");

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Path3");
        list2.add("Path4");
        duplicatedFilePaths.put("key1", list1);
        duplicatedFilePaths.put("key2", list2);

        expectedResult = "=====================================================\nPath3\nPath4\n";
        expectedResult += "=====================================================\nPath1\nPath2\n";
        stringFormatter = new StringFormatter();

    }

    @Test
    public void shouldTheStringFormatterReturnExpectedResult() {

        String formatResult = stringFormatter.formatData(duplicatedFilePaths);
        Assert.assertTrue(formatResult.equals(expectedResult));
    }


    @Test
    public void shouldReturnEmptyStringWhenInputIsEmpty() {
        String result = stringFormatter.formatData(new HashMap<String, ArrayList<String>>());
        Assert.assertEquals("", result);
    }
}

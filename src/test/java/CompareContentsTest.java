import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 12/03/2014
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompareContentsTest {

    @Test
    public void testCompare(){
        List<String> list1=new ArrayList<String>();
        List<String> list2=new ArrayList<String>();
        list1.add("666");
        list2.add("666");
        CompareContents compareContents=new CompareContents(list1,list2);
         Assert.assertTrue(compareContents.compare());


    }
}

package duplicateFinder;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/04/2014
 * Time: 9:27 AM
 * To change this template use File | Settings | File Templates.
 */


public class GroupFilesBySizeTest {
    private GroupFilesBySize groupFilesBySize;

    @Before
    public void setUp(){
       groupFilesBySize=new GroupFilesBySize();
    }

    @Test
    public void shouldGroupFilesBySizeReturnExpectedDictionary(){

      Assert.assertEquals(groupFilesBySize.scanDirectoryWithGivenPath("/Users/user/Desktop/dir/").size(),3);

    }
    @Test
    public void shouldGroupFileBySizeReturnNullWhenEmptyPathIsGiven(){
       Assert.assertEquals(groupFilesBySize.scanDirectoryWithGivenPath(" "),null);
    }

}
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 12/03/2014
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompareContents {

    private List<String> arrayList1;
    private List<String> arrayList2;

    public CompareContents(List<String> list1, List<String> list2){
         arrayList1 = list1;
         arrayList2 = list2;

    }

    public boolean compare(){

        for(String line: arrayList1){
            for (String line1: arrayList2){
                if(!line.equals(line1)){
                    return false;
                }
            }
        }
    return true;
    }
}

package duplicateFinder;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/04/2014
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class PathInput {
    public PathInput() {
        requestInput();
    }

    private void requestInput() {
        System.out.println("Enter the folder to execute for duplicates:");
    }

    public String getUserPath() {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        return path;
    }

}
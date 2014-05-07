package duplicateFinder;

public class Main {

    public static void main(String[] args) throws Exception {
        PathInput pathInput = new PathInput();
        String pathToScan = pathInput.getUserPath();

        ScreenOutput outputter = new ScreenOutput();
        FileClassifierBySize2 fileClassifierBySize = new FileClassifierBySize2(new PathScanner(), new FileSizeReader());
        FileContentComparer fileContentComparer = new FileContentComparer(new FileStreamOpenerImplement());

        DuplicateFinder duplicateFinder = new DuplicateFinder(outputter, fileClassifierBySize, fileContentComparer);
        duplicateFinder.scan(pathToScan);
    }

}

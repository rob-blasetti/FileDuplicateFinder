package duplicateFinder;

public class Main {

    public static void main(String[] args) throws Exception {
        String pathToScan = args[0];

        ScreenOutput outputter = new ScreenOutput();
        FileClassifierBySize2 fileClassifierBySize = new FileClassifierBySize2(new PathScanner(), new FileSizeReader());
        FileContentComparer fileContentComparer = new FileContentComparer(new FileStreamOpenerImplement());
//
//        DuplicateFinderPrintProcessor duplicateFinderPrintProcessor = new DuplicateFinderPrintProcessor(outputter, fileClassifierBySize, fileContentComparer);
//        duplicateFinderPrintProcessor.execute(pathToScan);

        DuplicateFinderDeleteProcessor duplicateFinderDeleteProcessor = new DuplicateFinderDeleteProcessor(outputter, fileClassifierBySize, fileContentComparer, new DeleteFile());
        duplicateFinderDeleteProcessor.execute(pathToScan);
    }

}

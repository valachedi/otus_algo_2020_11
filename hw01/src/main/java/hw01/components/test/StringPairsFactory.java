package hw01.components.test;

import java.io.File;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import hw01.models.test.StringPair;

public class StringPairsFactory {
    private static int INDEX_START = 0;
    private static String PATTERN = "test.%d.%s";
    private static String EXT_IN = "in";
    private static String EXT_OUT = "out";

    private String path;


    public StringPairsFactory(String path) {
        this.path = path;
    }


    public List<StringPair> getStringPairs() {
        int index = INDEX_START;
        ArrayList<StringPair> filePairs = new ArrayList<>(10);

        while(true) {
            String fileShortNameIn = String.format(PATTERN, index, EXT_IN);
            String fileShortNameOut = String.format(PATTERN, index, EXT_OUT);
            String content1 = getContentFromResourcePath(this.path + File.separator + fileShortNameIn);
            String content2 = getContentFromResourcePath(this.path + File.separator + fileShortNameOut);

            if(content1 == null || content2 == null) {
                break;
            }

            filePairs.add(new StringPair(content1, content2));

            index++;
        }

        return filePairs;
    }


    private String getContentFromResourcePath(String resourcePath) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream(resourcePath);

        if(is == null) {
            return null;
        }

        String result = new BufferedReader(new InputStreamReader(is))
                                .lines()
                                .collect(Collectors.joining("\n"));

        return result;
    }
}

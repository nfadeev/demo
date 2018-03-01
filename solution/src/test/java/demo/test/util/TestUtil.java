package demo.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import demo.solution.leetcode.MedianOfTwoSortedArraysTest;

public class TestUtil {

    private TestUtil() {}
    
    public static <T> Collection<Object[]> loadTestData(String resourcePath, Class<T> dataClass, Function<T, Object[]> mapFunction) {
        List<T> list;
        try (InputStream stream = dataClass.getClassLoader()
                .getResourceAsStream(resourcePath)) {
            ObjectMapper mapper = new ObjectMapper();
            CollectionType listType = mapper.getTypeFactory().constructCollectionType(List.class, dataClass);
            list = mapper.readValue(stream, listType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list.stream().map(mapFunction).collect(Collectors.toList());
    }
    
    public static String decorateHeader(String header) {
        String emptyHeader = "----------------------------------------------------------------------------------------------------";
        if (header.isEmpty()) {
            return emptyHeader;
        }
        int freeSpace = emptyHeader.length() - header.length();
        if (freeSpace < 1) {
            return header;
        }
        if (freeSpace == 1) {
            return ' ' + header;
        }
        StringBuilder builder = new StringBuilder(emptyHeader);
        int startIndex = freeSpace / 2 + freeSpace % 2;
        builder.replace(startIndex - 1, startIndex, " ");
        builder.replace(startIndex, startIndex + header.length(), header);
        startIndex += header.length();
        builder.replace(startIndex, startIndex + 1, " ");
        return builder.toString();
    }
}

package demo.solution.leetcode;

import static demo.test.util.TestUtil.decorateHeader;
import static java.util.Arrays.asList;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import demo.test.util.TestUtil;
import lombok.Data;

@RunWith(Parameterized.class)
public class LongestPalindromicSubstringTest {

    @Parameters(name = "{0}")
    public static Collection<Object[]> getTestData() {
        return TestUtil.loadTestData("longest-palindromic-substring.json", 
                TestData.class, 
                data -> new Object[] {data.description, data.input, data.output});
    }

    private String description;
    private String input;
    private String[] output;
    
    public LongestPalindromicSubstringTest(String description, String input, String[] output) {
        this.description = description;
        this.input = input;
        this.output = output;
    }
    
    @Test
    public void test() {
        System.out.println(decorateHeader(description));
        String result = new LongestPalindromicSubstring().find(input);
        assertThat(asList(output), hasItem(result));
        System.out.println("Actual result: " + result);
        
    }

    @Data
    static class TestData {
       String description;
       String input;
       String[] output;
    }
}

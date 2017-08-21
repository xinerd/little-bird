package cn.fmachine.notify.service.impl;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Author: shin
 * Date: 8/19/17
 */
public class EmailRequestConverterTest {

    @Test
    public void reduceListToString() throws Exception {
        String[] myArray = {"a@a.com", "b@b.com", "c@c.com"};
        String result = Arrays.stream(myArray)
                .reduce("", (a, b) -> a + "," + b);
        Assert.assertEquals("a@a.com,b@b.com,c@c.com", result.substring(1));
    }

}
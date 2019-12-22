package com.donnatto.javatests.util;

// import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeatOnce() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void repeatMultipleTimes() {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void repeatZeroTimes() {
        Assert.assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeatNegativeTimes() {
        StringUtil.repeat("hola", -1);
    }

    @Test
    public void stringIsNotEmpty() {
        boolean response = StringUtil.isEmpty("abcd");
        Assert.assertFalse(response);
    }

    @Test
    public void stringIsEmpty() {
        boolean response = StringUtil.isEmpty("");
        Assert.assertTrue(response);
    }

    @Test
    public void stringIsNull() {
        boolean response = StringUtil.isEmpty(null);
        Assert.assertTrue(response);
    }

    @Test
    public void stringWithSpaces() {
        boolean response = StringUtil.isEmpty("      ");
        Assert.assertTrue(response);
    }
}
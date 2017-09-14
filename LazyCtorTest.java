package edu.gcccd.csis;

import org.junit.*;
import java.io.*;
import static org.junit.Assert.*;

public class LazyCtorTest {

    static final boolean use_cache = false;

    // runs before each textMethod
    @Before
    public void setUp() throws Exception {
        System.out.println("beforeMethod");
        if (use_cache) {
            // make sure instances are cached
            Assert.assertEquals(LazyCtor.getNumOfInstancesAllowed(), LazyCtor.getNumOfInstancesCreated());
            System.out.println(LazyCtor.getNumOfInstancesCreated());
        } else {
            // make sure instances are NOT cached
            Assert.assertEquals(0, LazyCtor.getNumOfInstancesCreated());
            System.out.println(LazyCtor.getNumOfInstancesCreated());
        }
    }

    // runs after each textMethod
    @After
    public void tearDown() throws Exception {
        System.out.println("afterMethod");
        System.out.println(LazyCtor.getNumOfInstancesCreated());
    }

    @Test
    public void testGetInstance() throws Exception {
        System.out.println("testGetInstance");
        // make sure, not more than K instances are generated
        for (int i = 0; i < LazyCtor.getNumOfInstancesAllowed(); i++) {
            LazyCtor y = LazyCtor.getInstance();
            Assert.assertEquals(i, y.getId());
        }
        Assert.assertNull(LazyCtor.getInstance());
        System.out.println(LazyCtor.getNumOfInstancesCreated());
    }
/*    @Test
    public void testToString()
    {
        LazyCtor lc = new LazyCtor(final int id);
        String expected =  "";
        Assert.assertEquals(expected, lc.toString());

    }*/
}
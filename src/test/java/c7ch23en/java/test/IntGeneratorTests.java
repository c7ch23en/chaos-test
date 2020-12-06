package c7ch23en.java.test;

import c7ch23en.java.test.util.Monitor;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @author c7ch23en
 */
public class IntGeneratorTests {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testNextInt() {
        int count = 1000;
        Set<Integer> values = new HashSet<>(count);
        Monitor monitor = Monitor.create();
        monitor.start();
        IntGenerator generator = new IntGenerator(count);
        for (int i = 0; i < count; i++)
            values.add(generator.nextInt());
        long elapsed = monitor.stop();
        logger.info(String.format("Time elapsed: %s(ns)", elapsed));
        Assert.assertEquals(count, values.size());
        for (Integer value : values) {
            Assert.assertTrue(value >= 1);
            Assert.assertTrue(value <= count);
        }
        try {
            generator.nextInt();
            Assert.fail("Unexpected");
        } catch (IntGenerator.NoValuesAvailableException e) {
            // expected
        }
    }

}

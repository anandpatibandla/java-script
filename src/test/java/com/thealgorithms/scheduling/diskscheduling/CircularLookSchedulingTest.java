package com.thealgorithms.scheduling.diskscheduling;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircularLookSchedulingTest {

    @Test
    public void testCircularLookScheduling_MovingUp() {
        CircularLookScheduling scheduling = new CircularLookScheduling(50, true, 200);
        List<Integer> requests = Arrays.asList(55, 58, 39, 18, 90, 160, 150);
        List<Integer> expected = Arrays.asList(55, 58, 90, 150, 160, 18, 39);

        List<Integer> result = scheduling.execute(requests);
        assertEquals(expected, result);
    }

    @Test
    public void testCircularLookScheduling_MovingDown() {
        CircularLookScheduling scheduling = new CircularLookScheduling(50, false, 200);
        List<Integer> requests = Arrays.asList(55, 58, 39, 18, 90, 160, 150);
        List<Integer> expected = Arrays.asList(39, 18, 160, 150, 90, 58, 55);

        List<Integer> result = scheduling.execute(requests);
        assertEquals(expected, result);
    }

    @Test
    public void testCircularLookScheduling_EmptyRequests() {
        CircularLookScheduling scheduling = new CircularLookScheduling(50, true, 200);
        List<Integer> requests = Arrays.asList();
        List<Integer> expected = Arrays.asList();

        List<Integer> result = scheduling.execute(requests);
        assertEquals(expected, result);
    }

    @Test
    public void testCircularLookScheduling_PrintStatus() {
        CircularLookScheduling scheduling = new CircularLookScheduling(50, true, 200);
        List<Integer> requests = Arrays.asList(55, 58, 39, 18, 90, 160, 150);
        List<Integer> result = scheduling.execute(requests);

        // Print the final status
        System.out.println("Final CircularLookScheduling Position: " + scheduling.getCurrentPosition());
        System.out.println("CircularLookScheduling Moving Up: " + scheduling.isMovingUp());

        // Print the order of request processing
        System.out.println("Request Order: " + result);
    }
}

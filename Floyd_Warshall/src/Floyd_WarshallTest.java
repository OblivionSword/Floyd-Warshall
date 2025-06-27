import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Floyd_WarshallTest {
	
	Floyd_Warshall FloydWarshall = new Floyd_Warshall();
	
	private static final Integer INF = Floyd_Warshall.INF;

	 @Test
	    void testSmallGraph() {
	        int[][] graph = {
	            {0, 4, 11},
	            {INF, 0, 2},
	            {3, INF, 0}
	        };
	        int[][] expected = {
	            {0, 4, 6},
	            {5, 0, 2},
	            {3, 7, 0}
	        };
	        int[][] result = FloydWarshall.floydWarshall(graph);
	        assertMatrixEquals(expected, result);
	    }

	    @Test
	    void testDisconnectedGraph() {
	        int[][] graph = {
	            {0, 2, INF},
	            {INF, 0, INF},
	            {INF, INF, 0}
	        };
	        int[][] expected = {
	            {0, 2, INF},
	            {INF, 0, INF},
	            {INF, INF, 0}
	        };
	        assertMatrixEquals(expected, FloydWarshall.floydWarshall(graph));
	    }

	    @Test
	    void testNegativeWeights() {
	        int[][] graph = {
	        		{0, 2, INF},
	        	    {INF, 0, -2},
	        	    {1, INF, 0}
	        };
	        int[][] expected = {
	        		{0, 2, 0},
	                {-1, 0, -2},
	                {1, 3, 0}
	        };
	        assertMatrixEquals(expected, FloydWarshall.floydWarshall(graph));
	    }

	    @Test
	    void testNegativeCycleDetection() {
	        int[][] graph = {
	            {0, 1, INF},
	            {INF, 0, -1},
	            {-1, INF, 0}
	        };
	        int[][] result = FloydWarshall.floydWarshall(graph);
	        boolean hasNegativeCycle = false;
	        for (int i = 0; i < result.length; i++) {
	            if (result[i][i] < 0) {
	                hasNegativeCycle = true;
	                break;
	            }
	        }
	        assertTrue(hasNegativeCycle, "Graph should have a negative cycle");
	    }

	    @Test
	    void testZeroEdgeWeights() {
	        int[][] graph = {
	            {0, 0, 5},
	            {INF, 0, 0},
	            {INF, INF, 0}
	        };
	        int[][] expected = {
	            {0, 0, 0},
	            {INF, 0, 0},
	            {INF, INF, 0}
	        };
	        assertMatrixEquals(expected, FloydWarshall.floydWarshall(graph));
	    }

	    @Test
	    void testSingleNode() {
	        int[][] graph = {
	            {0}
	        };
	        int[][] expected = {
	            {0}
	        };
	        assertMatrixEquals(expected, FloydWarshall.floydWarshall(graph));
	    }

	    @Test
	    void testEmptyGraph() {
	        int[][] graph = {};
	        int[][] expected = {};
	        assertMatrixEquals(expected, FloydWarshall.floydWarshall(graph));
	    }
    /**
     * Utility method for matrix comparison.
     */
    private void assertMatrixEquals(int[][] expected, int[][] actual) {
        assertEquals(expected.length, actual.length, "Row count mismatch");
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], "Mismatch at row " + i);
        }
    }
}



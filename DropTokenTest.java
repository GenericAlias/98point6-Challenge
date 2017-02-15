import static org.junit.Assert.*;

/**
 * Created by danialchowdhry on 2/14/17.
 */
public class DropTokenTest {

    @org.junit.Test
    // Test to make sure placements and wins are calculated correctly
    public void placeTest1() throws Exception {
        int[][] testArr = {{0,0,0,0},{1,1,2,0},{2,2,1,0},{2,2,1,0}};
        DropToken testGame = new DropToken(testArr);
        assertEquals(testGame.place(3,1), 0);
        assertEquals(testGame.place(0,1), 1);
        assertEquals(testGame.place(3,1), 0);
        assertEquals(testGame.place(3,2), 0);
        assertEquals(testGame.place(3,2), 1);
        assertEquals(testGame.place(0,2), -1);
        assertEquals(testGame.place(1,2), 0);
        assertEquals(testGame.place(1,2), -1);
        assertEquals(testGame.place(2,2), 0);
    }

    @org.junit.Test
    public void placeTest2() throws Exception {
        int[][] testArr = {{0,0,0,0},{2,2,2,0},{1,1,1,0},{1,1,1,0}};
        DropToken testGame = new DropToken(testArr);
        assertEquals(testGame.place(3,2), 0);
        assertEquals(testGame.place(3,2), 0);
        assertEquals(testGame.place(3,2), 1);
        assertEquals(testGame.place(3,1), 0);
    }
}
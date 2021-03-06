import exception.InvalidPositionException;
import models.Position;
import models.SquareTableTop;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

public class TestSquareBoard {

    @Mock
    private Position mockPosition;
    private SquareTableTop board;

    @Before
    public void setup() {
        board = new SquareTableTop(5, 5);
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = InvalidPositionException.class)
    public void testInvalidPositionWhenRobotPlacedOutside() throws InvalidPositionException {
        when(mockPosition.getX()).thenReturn(10);
        when(mockPosition.getY()).thenReturn(10);

        assertFalse(board.isValidPosition(mockPosition));
    }

    @Test
    public void testValidPositionWhenRobotPlacedWithinTheBoard() throws InvalidPositionException {
        when(mockPosition.getX()).thenReturn(1);
        when(mockPosition.getY()).thenReturn(1);

        assertTrue(board.isValidPosition(mockPosition));
    }

    @Test(expected = InvalidPositionException.class)
    public void testInvalidPositionWhenRobotHavingNegativeValue() throws InvalidPositionException {
        when(mockPosition.getX()).thenReturn(-1);
        when(mockPosition.getY()).thenReturn(-1);

        assertFalse(board.isValidPosition(mockPosition));
    }
}

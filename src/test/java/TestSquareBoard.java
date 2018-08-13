import Models.Position;
import Models.SquareTableTop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

    @Test
    public void testInvalidPositionWhenRobotPlacedOutside() {
        when(mockPosition.getX()).thenReturn(10);
        when(mockPosition.getY()).thenReturn(10);

        Assert.assertFalse(board.isValidPosition(mockPosition));
    }

    @Test
    public void testValidPositionWhenRobotPlacedWithinTheBoard() {
        when(mockPosition.getX()).thenReturn(1);
        when(mockPosition.getY()).thenReturn(1);

        Assert.assertTrue(board.isValidPosition(mockPosition));
    }

    @Test
    public void testInvalidPositionWhenRobotHavingNegativeValue() {
        when(mockPosition.getX()).thenReturn(-1);
        when(mockPosition.getY()).thenReturn(-1);

        Assert.assertFalse(board.isValidPosition(mockPosition));
    }
}

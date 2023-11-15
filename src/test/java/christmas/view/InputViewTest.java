package christmas.view;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {

    private final InputView inputView = new InputView();

    @Test
    void readDate_유효한_날짜를_입력하면_올바른_값을_반환한다() {
        // Given
        provideInput("15");

        // When
        int result = inputView.readDate();

        // Then
        assertEquals(15, result);
    }

    private void provideInput(String data) {
        InputStream input = new ByteArrayInputStream(data.getBytes());
        System.setIn(input);
    }
}
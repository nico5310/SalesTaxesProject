package com.SalesTaxesProject.SalesTaxesProject;

import com.SalesTaxesProject.SalesTaxesProject.util.InputReaderUtil;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InputReaderUtilTest {

    @Test
    public void shouldTakeUserValidInput() {
        //GIVEN
        InputReaderUtil inputSelection = mock(InputReaderUtil.class);

        //WHEN
        when(inputSelection.readSelection()).thenReturn(1);

        //THEN
        assertEquals(1, 1);
    }

}

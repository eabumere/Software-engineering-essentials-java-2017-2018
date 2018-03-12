package de.tum.in.www1.seecx;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniversityAppTest {

    @Test
    public void testButtonText() {
        UniversityApp app = new UniversityApp();
        String buttonText = app.getButtonText();
        assertEquals("getButtonText() should return SEECx","SEECx", buttonText);
    }
}

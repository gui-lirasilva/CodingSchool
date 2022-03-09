package com.coddingSchool.helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelperCsvTest {

    @Test
    void isActive__methodShouldReturnTrueIfRecieveAtiva() {
        assertTrue(HelperCsv.isActive("ATIVA"));
    }

    @Test
    void isActive__methodShouldReturnFalseIfDontRecieveAtiva() {
        assertFalse(HelperCsv.isActive(""));
    }

    @Test
    void isVisible__methodShouldReturnTrueIfRecievePublica() {
        assertTrue(HelperCsv.isVisible("PÚBLICA"));
    }

    @Test
    void isVisible__methodShouldReturnFalseIfDontRecievePublica() {
        assertFalse(HelperCsv.isVisible(""));
    }

    @Test
    void isPublic__methodShouldReturnPublicoIfRecieveTrue() {
        assertEquals("PÚBLICO",HelperCsv.isPublic(true));
    }

    @Test
    void isPublic__methodShouldReturnPrivadoIfRecieveFalse() {
        assertEquals("PRIVADO",HelperCsv.isPublic(false));
    }

    @Test
    void isActive__methodShouldReturnAtivaIfRecieveTrue() {
        assertEquals("ATIVA",HelperCsv.isActive(true));
    }

    @Test
    void isActive__methodShouldReturnInativaIfRecieveFalse() {
        assertEquals("INATIVA",HelperCsv.isActive(false));
    }

    @Test
    void transformToInteger__methodShouldReturnZeroIfRecieveAEmptyString() {
        assertEquals(0, HelperCsv.transformToInteger(""));
    }

    @Test
    void transformToInteger__methodShouldReturnAIntegerNumberIfRecieveAStringNumber() {
        assertEquals(5, HelperCsv.transformToInteger("5"));
    }

    @Test
    void transformToInteger__methodDontAcceptOneLetterOrNotNumberCaracter() {
        assertThrows(NumberFormatException.class, ()-> HelperCsv.transformToInteger("a"));
    }
}
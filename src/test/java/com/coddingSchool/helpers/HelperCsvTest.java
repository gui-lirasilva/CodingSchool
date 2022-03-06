package com.coddingSchool.helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelperCsvTest {

    @Test
    void isActive_MethodShouldReturnTrueIfRecieve_ATIVA() {
        assertTrue(HelperCsv.isActive("ATIVA"));
    }

    @Test
    void isActive_MethodShouldReturnFalseIfDontRecieve_ATIVA() {
        assertFalse(HelperCsv.isActive(""));
    }

    @Test
    void isVisible_MethodShouldReturnTrueIfRecieve_PUBLICA() {
        assertTrue(HelperCsv.isVisible("PÚBLICA"));
    }

    @Test
    void isVisible_MethodShouldReturnFalseIfDontRecieve_PUBLICA() {
        assertFalse(HelperCsv.isVisible(""));
    }

    @Test
    void isPublic_MethodShouldReturn_PUBLICO_IfRecieveTrue() {
        assertEquals("PÚBLICO",HelperCsv.isPublic(true));
    }

    @Test
    void isPublic_MethodShouldReturn_PRIVADO_IfRecieveFalse() {
        assertEquals("PRIVADO",HelperCsv.isPublic(false));
    }

    @Test
    void isActive_MethodShouldReturn_ATIVA_IfRecieveTrue() {
        assertEquals("ATIVA",HelperCsv.isActive(true));
    }

    @Test
    void isActive_MethodShouldReturn_INATIVA_IfRecieveFalse() {
        assertEquals("INATIVA",HelperCsv.isActive(false));
    }

    @Test
    void transformToInteger_MethodShouldReturnZeroIfRecieveAEmptyString() {
        assertEquals(0, HelperCsv.transformToInteger(""));
    }

    @Test
    void transformToInteger_MethodShouldReturnAIntegerNumberIfRecieveAStringNumber() {
        assertEquals(5, HelperCsv.transformToInteger("5"));
    }

    @Test
    void transformToInteger_MethodDontAcceptOneLetterOrNotNumberCaracter() {
        assertThrows(NumberFormatException.class, ()-> HelperCsv.transformToInteger("a"));
    }
}
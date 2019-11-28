package com.kondrashov.demo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тестируем сервис запускающий тестирование")
public class TestServiceImplTest {

    @DisplayName("Тесты запускаются")
    @Test
    void shouldHaveCorrectConstructor() {
        assertTrue(true);
    }

}

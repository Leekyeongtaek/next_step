package com.kt_company.market.exemple;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class LegacyCalculatorTest {

    @Test
    @DisplayName("코드에 따라 다른 방법으로 계산하기.")
    public void calTest() {
        String code = "CALC_D";
        long originValue = 10000L;
        long result = LegacyCalculator.calculate(code, originValue);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("코드에 따라 다른 방법 계산. Enum 사용")
    public void calEnumTest() {
        CalculatorType calculatorType = CalculatorType.CALC_A;
        long originValue = 10000L;
        long result = calculatorType.calculate(originValue);
        assertThat(result).isEqualTo(10000);

        long result2 = CalculatorType.CALC_B.calculate(originValue);
        assertThat(result2).isEqualTo(100000);
    }

}
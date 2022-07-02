package com.kt_company.market.exemple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

@SpringBootTest
class TableStatusTest {

    @Test
    @DisplayName("오리진 테이블에서 조회한 값을 다른 2개 테이블에 등록한다.")
    public void tableStatusTest() throws Exception {

        //given
        String originValue = "Y";

        //when
        String table1Value = TableStatus.Y.getTable1Value();
        boolean table2Value = TableStatus.Y.isTable2Value();

        //then
        assertThat("1").isEqualTo(table1Value);
        assertThat(true).isEqualTo(table2Value);
    }

}
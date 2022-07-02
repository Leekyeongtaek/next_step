package com.kt_company.market.exemple;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PayGroupTest {

    @Test
    public void payGroupTest() {
        PayType payType = PayType.COUPON;
        PayGroup findPayGroup = PayGroup.findByPayCode(payType);

        assertThat(findPayGroup.getTitle()).isEqualTo("기타");
    }

}

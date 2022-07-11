package com.kt_company.market.mybatis.zigzag.service;

import com.kt_company.market.mybatis.zigzag.util.HttpClientZigzag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final HttpClientZigzag httpClientZigzag;

    private final String accessKey = "69a35e30-e2f4-4aa0-88df-6f6dae10eb7e";
    private final String secretKey = "8034d4ad0118d92daa8cdb80cc0265654db2db8e";

    private final String categoryGraphQlQuery = "query GetCategory { "
        + "category { id name children "
        + "{ id name children "
        + "{ id name children "
        + "{ id name } "
        + "} } } }";

    /**
     * 지그재그 카테고리 조회.
     */
    public void getZigzagCategory () {
//        httpClientZigzag.post();
    }


}

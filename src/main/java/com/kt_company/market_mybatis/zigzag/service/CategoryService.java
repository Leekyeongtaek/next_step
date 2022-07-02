package com.kt_company.market_mybatis.zigzag.service;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final String accessKey = "69a35e30-e2f4-4aa0-88df-6f6dae10eb7e";
    private final String secretKey = "8034d4ad0118d92daa8cdb80cc0265654db2db8e";

    private final String categoryGraphQlQuery = "query GetCategory { "
        + "category { id name children "
        + "{ id name children "
        + "{ id name children "
        + "{ id name } "
        + "} } } }";



}

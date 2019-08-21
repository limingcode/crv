package com.crv.erais.service;

import com.crv.erais.model.Test;

import java.util.List;

/**
 * @author zph
 * @date 2019-08-21
 */
public interface TestService {

    /**
     * test清单
     * @return test的list集合
     */
    List<Test> testList();
}

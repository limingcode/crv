package com.crv.erais.service.impl;

import com.crv.erais.dao.TestDao;
import com.crv.erais.model.Test;
import com.crv.erais.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zph
 * @date 2019-08-21
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> testList() {
        return testDao.testList();
    }
}

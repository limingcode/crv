package com.crv.erais.dao;

import com.crv.erais.model.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zph
 * @date 2019-08-21
 */
@Mapper
@Repository
public interface TestDao {

    /**
     * 此处为打架子使用，实际开发请使用XML模式
     * test清单
     * @return test的list集合
     */
    @Select("select id ,name from erais_test")
    List<Test> testList();
}

package com.x2yu.demo.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * @Author: x2yu
 * @Date: 2019/8/12 14:47
 * @Describable：基础数据访问配置和数据访问层
 */

@NoRepositoryBean
public interface BaseRepository<T,I extends Serializable> extends PagingAndSortingRepository<T,I>, JpaSpecificationExecutor<T> {

}

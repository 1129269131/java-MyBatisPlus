package com.mp.mapper;

import com.mp.entity.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author weiyunhui
 * @since 2019-09-01
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    int  deleteAll();

}

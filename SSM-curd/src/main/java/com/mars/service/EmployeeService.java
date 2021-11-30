package com.mars.service;

import com.mars.bean.Employee;
import com.mars.bean.EmployeeExample;
import com.mars.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:EmployeeService
 * Package:com.mars.service
 * Description:
 *
 * @Date:2021/11/28 21:08
 * @Author:Mars
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 查询所有用户
     * @return
     */
    public List<Employee> getAll() {

        return employeeMapper.selectByExampleWithDept(null);
    }

    /**
     * 保存员工方法
     *
     * @param employee
     */
    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    /**
     * 检验用户是否存在
     * @param empName
     */
    public boolean checkUser(String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long l = employeeMapper.countByExample(example);
        return l == 0;
    }
}

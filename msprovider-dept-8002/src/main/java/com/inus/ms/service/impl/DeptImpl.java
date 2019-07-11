
package com.inus.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inus.ms.dao.DeptDao;
import com.inus.ms.entities.Dept;
import com.inus.ms.service.DeptService;

@ Service
@ Transactional
public class DeptImpl implements DeptService
{

    @ Autowired
    private DeptDao deptDao;

    @ Override
    public boolean add(Dept dept)
    {
        return deptDao.add(dept);
    }

    @ Override
    public Dept get(int no)
    {
        return deptDao.getById(no);
    }

    @ Override
    public List<Dept> list()
    {
        return deptDao.getAll();
    }

}

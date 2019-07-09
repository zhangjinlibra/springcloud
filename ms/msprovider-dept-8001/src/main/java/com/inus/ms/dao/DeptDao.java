
package com.inus.ms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.inus.ms.entities.Dept;

@ Mapper
public interface DeptDao
{

    public boolean add(Dept dept);

    public Dept getById(int no);

    public List<Dept> getAll();

}

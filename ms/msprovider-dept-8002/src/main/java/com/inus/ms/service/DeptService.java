
package com.inus.ms.service;

import java.util.List;

import com.inus.ms.entities.Dept;

public interface DeptService
{

    public boolean add(Dept dept);

    public Dept get(int no);

    public List<Dept> list();

}

package com.xu.mybatis.service;

import com.xu.mybatis.Entity.Entity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EntityService {
   public Entity findById(int id);
   public void insert(Entity entity);
}

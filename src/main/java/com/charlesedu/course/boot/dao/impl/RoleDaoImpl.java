package com.charlesedu.course.boot.dao.impl;

import org.springframework.stereotype.Repository;

import com.charlesedu.course.boot.dao.AbstractDao;
import com.charlesedu.course.boot.dao.RoleDao;
import com.charlesedu.course.boot.domain.Role;

@Repository
public class RoleDaoImpl extends AbstractDao<Role, Long> implements RoleDao {
	
}

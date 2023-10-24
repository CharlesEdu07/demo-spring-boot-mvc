package com.charlesedu.course.boot.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.charlesedu.course.boot.dao.AbstractDao;
import com.charlesedu.course.boot.dao.RoleDao;
import com.charlesedu.course.boot.domain.Role;
import com.charlesedu.course.boot.util.PaginationUtil;

@Repository
public class RoleDaoImpl extends AbstractDao<Role, Long> implements RoleDao {
    public PaginationUtil<Role> paginationSearch(int page, String sort, String property) {
        int length = 5;
        int start = (page - 1) * length;

        String jpql = "select r from Role r order by r." + property + " " + sort;

        List<Role> roles = getEntityManager()
                .createQuery(jpql, Role.class)
                .setFirstResult(start).setMaxResults(length).getResultList();

        long totalRecords = count();
        long pagesTotal = (totalRecords + (length - 1)) / length;

        return new PaginationUtil<Role>(length, page, pagesTotal, sort, property, roles);
    }

    public long count() {
        return getEntityManager().createQuery("select count(*) from Role", Long.class).getSingleResult();
    }
}

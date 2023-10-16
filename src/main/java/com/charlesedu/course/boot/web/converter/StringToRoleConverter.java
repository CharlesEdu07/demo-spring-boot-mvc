package com.charlesedu.course.boot.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.charlesedu.course.boot.domain.Role;
import com.charlesedu.course.boot.service.RoleService;

@Component
public class StringToRoleConverter implements Converter<String, Role> {
	
    @Autowired
	private RoleService service;

	@Override
	public Role convert(String text) {
		if (text.isEmpty()) {
			return null;
		}

		Long id = Long.valueOf(text);
		
		return service.findById(id);
	}
}

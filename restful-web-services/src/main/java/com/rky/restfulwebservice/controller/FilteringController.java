package com.rky.restfulwebservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rky.restfulwebservice.beans.FilterBean;

@RestController
public class FilteringController {
	
	
	@GetMapping("filter")
	public MappingJacksonValue getFilterBean() {
		
		FilterBean filterBean = new FilterBean("value1", "value2", "value3");
		return getFilteredValue(filterBean, "field1", "field2");
	}
	
	@GetMapping("filterList")
	public MappingJacksonValue getFilterBeanList(){
		
		List<FilterBean> filterBeanList = Arrays.asList(new FilterBean("value1", "value2", "value3"),new FilterBean("value11", "value22", "value33"));
		return getFilteredValue(filterBeanList, "field3");
		
	}
	
	
	
	public MappingJacksonValue getFilteredValue(Object obj, String... strs) {
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(strs);
		FilterProvider filters = new SimpleFilterProvider().addFilter("filterBeanClass", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(obj);
		mapping.setFilters(filters);
		
		return mapping;
	}

	
	
}

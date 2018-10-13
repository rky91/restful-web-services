package com.rky.restfulwebservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rky.restfulwebservice.beans.FilterBean;

@RestController
public class FilteringController {
	
	
	@GetMapping("filter")
	public FilterBean getFilterBean() {
		return new FilterBean("value1", "value2", "value3");
	}
	
	@GetMapping("filterList")
	public List<FilterBean> getFilterBeanList(){
		return Arrays.asList(new FilterBean("value1", "value2", "value3"),new FilterBean("value11", "value22", "value33"));
	}

}

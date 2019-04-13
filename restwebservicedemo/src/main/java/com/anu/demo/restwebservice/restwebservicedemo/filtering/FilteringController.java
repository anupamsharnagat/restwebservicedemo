package com.anu.demo.restwebservice.restwebservicedemo.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/retrieveFilter")
	public MappingJacksonValue retrieveFilterDTO()
	{
		FilterDTO objFilterDTO=new FilterDTO("field1","field2","field3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters= new SimpleFilterProvider().addFilter("filterDtoFilter", filter );
		
		MappingJacksonValue mapping = new MappingJacksonValue(objFilterDTO);
		
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/retrieveFilterList")
	public MappingJacksonValue retrieveFilterDTOList()
	{
		List<FilterDTO> list= Arrays.asList(new FilterDTO("field1","field2","field3"),new FilterDTO("field1","field2","field3"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters= new SimpleFilterProvider().addFilter("filterDtoFilter", filter );
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	

}

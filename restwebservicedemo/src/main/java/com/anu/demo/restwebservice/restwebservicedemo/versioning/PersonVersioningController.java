package com.anu.demo.restwebservice.restwebservicedemo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	//URI versioning
	@GetMapping("v1/person")
	public PersonV1 personv1()
	{
		return new PersonV1("Anupam Sharnagat");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personv2()
	{
		return new PersonV2(new Name("Anupam","Sharnagat"));
	}
	
	//Params versioning
	
	@GetMapping(value="/person/param",params="version1")
	public PersonV1 paramV1()
	{
		return new PersonV1("Anupam Sharnagat");
	}
	
	@GetMapping(value="/person/param",params="version2")
	public PersonV2 paramV2()
	{
		return new PersonV2(new Name("Anupam","Sharnagat"));
	}
	
	//Header versioning
	@GetMapping(value="/person/header",headers ="X-API-VERSION=1")
	public PersonV1 headerV1()
	{
		return new PersonV1("Anupam Sharnagat");
	}
	
	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public PersonV2 headerV2()
	{
		return new PersonV2(new Name("Anupam","Sharnagat"));
	}
	
	//MIME type versioning
	
	@GetMapping(value="/person/produces",produces ="application/vnd.company.app-v1+json")
	public PersonV1 producerV1()
	{
		return new PersonV1("Anupam Sharnagat");
	}
	
	@GetMapping(value="/person/produces",produces ="application/vnd.company.app-v2+json")
	public PersonV2 producerV2()
	{
		return new PersonV2(new Name("Anupam","Sharnagat"));
	}

}

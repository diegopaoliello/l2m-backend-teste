package com.l2m.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.l2m.entity.SampleEntity;
import com.l2m.service.SampleService;

@RestController
@RequestMapping("/")
public class SampleController {

	@Autowired
	private SampleService sampleService;

	@GetMapping
	public SampleEntity hello() {
		return sampleService.helloWorld();
	}
}
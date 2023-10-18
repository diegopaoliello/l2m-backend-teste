package com.l2m.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.l2m.entity.SampleEntity;
import com.l2m.repository.SampleRepository;

@Service
public class SampleService extends AbstractService<SampleEntity, SampleRepository> {

	@Value("${spring.application.name}")
	private String applicationName;

	public SampleService() {
		super(SampleEntity.class);
	}

	public SampleEntity helloWorld() {
		return salvar(SampleEntity.builder().mensagem("Hello, Worlda! Application Name: " + applicationName)
				.infoDb(repository.findInfoDb()).build());
	}
}
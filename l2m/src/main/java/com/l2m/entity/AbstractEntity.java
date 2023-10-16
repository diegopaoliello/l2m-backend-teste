package com.l2m.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer id;

	@Column(nullable = false, name = "data_cadastro", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy:HH:mm")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private LocalDateTime dataCadastro;

	@Column(nullable = false, name = "data_atualizacao")
	@JsonFormat(pattern = "dd/MM/yyyy:HH:mm")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private LocalDateTime dataAtualizacao;

	@PrePersist
	public void beforeSave() {
		setDataCadastro(LocalDateTime.now());
		setDataAtualizacao(LocalDateTime.now());
	}

	@PreUpdate
	public void beforeUpdate() {
		setDataAtualizacao(LocalDateTime.now());
	}
}

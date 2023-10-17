package com.l2m.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SampleEntity extends AbstractEntity {
	@Column(nullable = false, length = 100)
	@NotEmpty(message = "{campo.descricao.obrigatorio}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String mensagem;
	
	@Column(nullable = false, length = 200)
	@NotEmpty(message = "{campo.descricao.obrigatorio}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String infoDb;
}


package com.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.domain.Endereco;
import com.senai.domain.repositories.EnderecoRepository;

@SpringBootTest
public class EnderecoTest {
	
	@Autowired
	EnderecoRepository enderecoRepo;
	
	@Test
	void Endereco() {
		Endereco end = new Endereco();
		end.setId(null);
		end.setLogradouro("Rua das Pitanga");
		end.setNumero("431");
		end.setComplemento("");
		end.setBairro("Roosevelt");
		end.setCep("00992214");
		enderecoRepo.save(end);
	}
	
	@Test
	public void listaEndereco() {
		List<Endereco> list = enderecoRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void idEndereco() {
		Endereco endereco = enderecoRepo.findById(1).get();
		assertEquals("322", endereco.getNumero());
	}
	
	@Test
	public void updateEndereco() {
		Endereco endereco = enderecoRepo.findById(2).get();
		endereco.setNumero("156");
		enderecoRepo.save(endereco);
		assertNotEquals("245", endereco.getNumero());
	}
	
	@Test
	public void deleteEndereco() {
		enderecoRepo.deleteById(2);
		assertThat(enderecoRepo.existsById(2));
	}

}

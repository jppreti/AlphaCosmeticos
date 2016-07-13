package br.com.compdevbooks.alphacosmetics.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClienteEntityTest {

	ClienteEntity entity;
	
	@Before
	public final void initialize(){
		entity = new ClienteEntity(1L,"Maria Cristina da Silta","mariacris@gmail.com","6512345678");
	}
	
	@Test
	public final void testValidarInstantiated() {
		entity = new ClienteEntity();
		assertNotNull(entity.validar());		
	}

	@Test
	public final void testValidarNome() {
		entity.setNome(null);
		assertNotNull(entity.validar());
		
		entity.setNome("");
		assertNotNull(entity.validar());
		
		entity.setNome("     ");
		assertNotNull(entity.validar());
		
		//Menos de 5 caracteres
		entity.setNome("Jose");
		assertNotNull(entity.validar());
		
		//Mais de 60 caracteres
		entity.setNome("1111111111222222222233333333334444444444555555555566666666667");
		assertNotNull(entity.validar());
	}
	
	@Test
	public final void testValidarEmail() {
		entity.setEmail(null);
		assertNotNull(entity.validar());
		
		entity.setEmail("");
		assertNotNull(entity.validar());
		
		entity.setEmail("     ");
		assertNotNull(entity.validar());
		
		entity.setEmail("emailinvalido");
		assertNotNull(entity.validar());
	}
	
	@Test
	public final void testValidarTelefone() {
		entity.setTelefone(null);
		assertNull(entity.validar());
		
		entity.setTelefone("");
		assertNull(entity.validar());
		
		entity.setTelefone("     ");
		assertNull(entity.validar());
		
		entity.setTelefone("651234567");
		assertNotNull(entity.validar());
		
		entity.setTelefone("6512345678");
		assertNull(entity.validar());
	}
	
	
}

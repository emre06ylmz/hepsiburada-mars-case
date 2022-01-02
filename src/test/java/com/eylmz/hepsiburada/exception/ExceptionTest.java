package com.eylmz.hepsiburada.exception;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExceptionTest {

	@Test
	public void givenWrongCommandException_WhenCreated_ThenShouldReturnNotNul() throws WrongRoverCommandException {
		WrongRoverCommandException wrongCommandException = new WrongRoverCommandException("wrong command");
		assertNotNull(wrongCommandException);
	}

	@Test
	public void givenWrongDirectionException_WhenCreated_ThenShouldReturnNotNul() throws WrongRoverCommandException {
		WrongDirectionException wrongDirectionException = new WrongDirectionException("wrong direction");
		assertNotNull(wrongDirectionException);
	}

}

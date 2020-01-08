package testJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import events.Validator;
import exception.ExceptionData;

class ValidatorTest {
	Validator validator = new Validator();
	@Test
	void testValiteDateBook() {
		HashMap<String,String> bookHashMap = new HashMap<String, String>();
		bookHashMap.put("Tittle", "Prueba");
		bookHashMap.put("ISBN", "1234567890123");
		bookHashMap.put("NumPages", "150");
		HashMap<String,String> bookHashMapFalse = new HashMap<String, String>();
		bookHashMapFalse.put("Tittle", "Prueblg65a");
		bookHashMapFalse.put("ISBN", "12345623");
		bookHashMapFalse.put("NumPages", "1ncx0");
		try {
			assertTrue(this.validator.valiteDateBook(bookHashMap).isResult());
			assertFalse(this.validator.valiteDateBook(bookHashMapFalse).isResult());
		} catch (ExceptionData e) {
		}
	}

	@Test
	void testValidateGestor() {
		String numOne = "100";
		String numTwo = "54";
		String numThree = "gasga";
		String numFour = "-12";
		
		try {
			assertTrue(this.validator.validateGestor(numOne).isResult());
			assertTrue(this.validator.validateGestor(numTwo).isResult());
			assertFalse(this.validator.validateGestor(numThree).isResult());
			assertFalse(this.validator.validateGestor(numFour).isResult());
		} catch (ExceptionData e) {
		}
		
		
	}

	

}

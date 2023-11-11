import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverterTest_STUDENT {

	MorseCodeConverter convert;
	
	@BeforeEach
	void setUp() throws Exception {
		convert = new MorseCodeConverter();
	}

	@AfterEach
	void tearDown() throws Exception {
		convert = null;
	}

	@Test
	void testConverter() {
		File file = new File("src/Daisy.txt");
		
		assertEquals("test morsecode", convert.convertToEnglish("- . ... - / -- --- .-. ... . -.-. --- -.. ."));
		try {
			assertEquals("give me your answer do", convert.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

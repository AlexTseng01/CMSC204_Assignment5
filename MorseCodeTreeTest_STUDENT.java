import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTest_STUDENT {

	private MorseCodeTree tree;
	
	@BeforeEach
	void setUp() throws Exception {
		tree = new MorseCodeTree();
	}

	@AfterEach
	void tearDown() throws Exception {
		tree = null;
	}

	@Test
	void testTree() {
		assertEquals("e", tree.fetch("."));
		assertEquals("k", tree.fetch("-.-"));
		assertEquals("j", tree.fetch(".---"));
		assertEquals("q", tree.fetch("--.-"));
	}

}

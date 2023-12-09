package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestOpStack {

	@Test
	void testConstructor() {
		OpStack testStack = new OpStack();
		assertNotNull(testStack);
	}

}

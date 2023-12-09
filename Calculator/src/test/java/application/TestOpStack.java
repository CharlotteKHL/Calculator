package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {
	
	OpStack testStack;
	
	@BeforeEach
	void initialise() {
		testStack = new OpStack();
	}

	//Test1
	@Test
	void testConstructor() {
		assertNotNull(testStack);
	}

	//Test2
	@Test
	void testSize() {
		assertEquals(0,testStack.size(), "Test an empty stack has size 0");
	}

}

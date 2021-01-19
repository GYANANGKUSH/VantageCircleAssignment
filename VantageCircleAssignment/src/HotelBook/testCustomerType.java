package HotelBook;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import HotelBook.HotelBooking;

class testCustomerType {

	@Test
	void test() {
//		HotelBooking obj = new HotelBooking();
//		class object need not be created since the method is static and is called in a static way
		boolean out = HotelBooking.checkCustomerType("reward");
		assertEquals(true, out);
	}
}

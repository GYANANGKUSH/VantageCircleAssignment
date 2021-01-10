package HotelBook;

import static org.junit.jupiter.api.Assertions.*;
import HotelBook.HotelBooking;
import org.junit.jupiter.api.Test;

class testBookDate {

	@Test
	void test() {
		boolean out = HotelBooking.checkDate("31/10/2020");
		assertEquals(true, out);
	}

}

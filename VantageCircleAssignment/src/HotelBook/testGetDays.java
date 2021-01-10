package HotelBook;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import HotelBook.HotelBooking;

class testGetDays {

	@Test
	void test() throws Exception{
		String[] out = HotelBooking.getDays("10/01/2021", 2);
		String[] eq = {"Sun","Mon"};
		for(int i=0; i<2; i++) {
			assertEquals(eq[i],out[i]);
		}
	}

}

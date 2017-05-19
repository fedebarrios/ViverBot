package viverbot.Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangoNumericoTest {

	@Test
	public void testRangoNumerico() {
		RangoNumerico r =  new RangoNumerico(10.0, 20.0);
		assertEquals(r.getMinimo(), new Double(10.0));
		assertEquals(r.getMaximo(), new Double(20.0));
	}
	
	@Test
	public void testEquals() {
		RangoNumerico r =  new RangoNumerico(10.0, 20.0);
		RangoNumerico r2 =  new RangoNumerico(10.0, 20.0);
		RangoNumerico r3 =  new RangoNumerico(4.0, 20.0);
		RangoNumerico r4 =  new RangoNumerico(10.0, 32.0);
		RangoNumerico r5 =  new RangoNumerico(5.0, 15.0);
		Object o =  new Object();
		assertEquals(r,r2);
		assertNotEquals(r,r3);
		assertNotEquals(r,r4);
		assertNotEquals(r,r5);
		assertNotEquals(r,o);


		




	
	}

}

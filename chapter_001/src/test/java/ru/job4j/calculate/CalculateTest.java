package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Test.
 *@author Denis Unuchak
 *@since 05.12.2018
 *@version 0.0
 */
public class CalculateTest {
	/**
	 *Test echo.
	 */
	@Test
	public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Petr Arsentev";
		String expect = "Echo, echo, echo : Petr Arsentev";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}

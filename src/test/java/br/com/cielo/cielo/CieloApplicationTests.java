package br.com.cielo.cielo;

import br.com.cielo.cielo.controller.ExtratoControllerTest;
import br.com.cielo.cielo.service.ExtratoServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		ExtratoControllerTest.class,
		ExtratoServiceTest.class
})
public class CieloApplicationTests {

	@Test
	public void contextLoads() {
	}

}


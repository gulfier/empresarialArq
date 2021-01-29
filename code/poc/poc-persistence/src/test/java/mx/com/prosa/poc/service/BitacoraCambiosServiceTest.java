package mx.com.prosa.poc.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;




@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional
@Ignore
public class BitacoraCambiosServiceTest
{

  @Autowired
  private BitacoraCambiosService bitacoraCambiosService;

  @Test
  public void testSave()
  {
   // bitacoraCambiosService.save( siteTO );

    //Assert.assertNotNull( baseDatos );

  }

  
}

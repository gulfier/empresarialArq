package mx.com.prosa.poc.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.BitacoraCambiosTO;
import mx.com.prosa.poc.to.PagingRequestTO;
import org.junit.Assert;




@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional
@Ignore
public class BitacoraCambiosServiceTest
{

  @Autowired
  private BitacoraCambiosService bitacoraCambiosService;

  @Test
  public void testUpdate()
  {
	  
	  PagingRequestTO<BitacoraCambiosTO> request = new PagingRequestTO<>();
      bitacoraCambiosService.findAll(request);

    Assert.assertNotNull( request );

  }

  
}

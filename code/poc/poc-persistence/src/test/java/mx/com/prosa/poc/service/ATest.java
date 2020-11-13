package mx.com.prosa.poc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import com.google.gson.Gson;

public class ATest
{

  @Test
  public void test()
  {
    List<Integer> a = Arrays.asList( 1, 2, 3 );
    List<Integer> b = Arrays.asList( 3, 4, 5 );

    
    Gson gson = new Gson();
    List<Integer> c = new ArrayList<>( CollectionUtils.removeAll( a, b ) );
    System.out.println("Eliminar"+ gson.toJson( c ) );

    List<Integer> d = new ArrayList<>( CollectionUtils.removeAll( b, a ) );
    System.out.println("Agregar"+ gson.toJson( d ) );
  }

}

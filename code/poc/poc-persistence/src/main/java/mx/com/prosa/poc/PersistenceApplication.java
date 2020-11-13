package mx.com.prosa.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase para inicializar el contexto de la aplicacion de spring boot
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@SpringBootApplication
public class PersistenceApplication
{

  /**
   * Main class
   * @param args
   */
  public static void main( String[] args )
  {
    SpringApplication.run( PersistenceApplication.class, args );
  }

}

package mx.com.prosa.poc.to;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Transfer object de servicios de TI
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Getter
@Setter
public class ITServiceTO extends BaseTO
{

  private static final long serialVersionUID = 8737029923435946176L;
  private List<BaseTO> applications;
}

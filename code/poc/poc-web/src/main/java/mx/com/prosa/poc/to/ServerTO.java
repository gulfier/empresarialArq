package mx.com.prosa.poc.to;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Transfer object de servidores
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Getter
@Setter
public class ServerTO extends BaseTO
{

  private static final long serialVersionUID = -5373086118792740518L;
  private List<BaseTO> applications;
}

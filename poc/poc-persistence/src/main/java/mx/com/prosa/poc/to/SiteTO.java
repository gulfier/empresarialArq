package mx.com.prosa.poc.to;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Transfer object de sitios
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Getter
@Setter
public class SiteTO extends BaseTO
{

  private static final long serialVersionUID = 6844642665904947290L;
  private List<BaseTO> applications;
}

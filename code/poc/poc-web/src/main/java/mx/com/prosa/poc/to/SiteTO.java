package mx.com.prosa.poc.to;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
  @JsonInclude(Include.NON_NULL)
  private List<BaseTO> applications;
}

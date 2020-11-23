package mx.com.prosa.poc.to;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Transfer object de aplicaciones
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Getter
@Setter
public class ApplicationTO extends BaseTO
{

  private static final long serialVersionUID = 1465765437163307228L;
  private String comment;
  private BaseTO site;
  private BaseTO itService;
  private List<BaseTO> servers;
}

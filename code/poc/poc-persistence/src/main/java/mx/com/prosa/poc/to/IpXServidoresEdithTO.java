package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IpXServidoresEdithTO extends BaseTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5611964884880118483L;
	private TblIpXServidoresTO table;
	private TblIpXServidoresTO update;
}

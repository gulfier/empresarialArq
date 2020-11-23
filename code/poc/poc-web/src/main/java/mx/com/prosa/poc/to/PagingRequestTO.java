package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;

/**
 * Consulta paginada de {@link mx.com.prosa.poc.to.BaseTO}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 * @param <T> Objeto base
 */
@Getter
@Setter
public class PagingRequestTO<T extends BaseTO>
{
	private T search;
	private int page;
	private int size;
	private String sortBy;
	private Direction direction;
	protected String ip;
	protected String user;
	protected String token;
	  
	public T getSearch() {
		return search;
	}

	public void setSearch(T search) {
		this.search = search;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getSortBy() {
		return sortBy;
	}
	
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

	/**
	   * Enumeracion para la direccion de la consulta paginada
	   * 
	   * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
	   */
	public enum Direction{
		  ASC, DESC
	};
}

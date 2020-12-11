package mx.com.prosa.poc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.CompareToBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity class de la tabla K_SITE
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Entity
@Table(name = "TBL_BITACORA_CAMBIOS")
@Getter
@Setter
public class BitacoraCambiosDO  implements Serializable
{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
  @Column(name = "PK_ID_BITACORA")
  private Long id;
  
  @Column(name = "DS_CODIGO")
  private String dsCodigo;
  
  @Column(name = "DS_FECHA")
  private Date fecha;
  
  @Column(name = "DS_DESCRIPCION")
  private String dsDescripcion;
  
  @Column(name = "DS_TIPO")
  private String dsTipo;
  

  @Column(name = "DS_AUTOR")
  private String dsAutor;
  

  @Column(name = "DS_CAMBIO_ACTUAL")
  private String dsCambioActual;
  

  @Column(name = "DS_CAMBIO_ANTERIOR")
  private String dsCambioAnterior;
  
  @Column(name = "ID_ESTATUS")
  private Integer dsEstatus;
  
  
  
  /**
   * {@inheritDoc}
   */
  public int compareTo( BitacoraCambiosDO that )
  {
    return new CompareToBuilder().append( this.id, that.id ).toComparison();
  } 

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((dsAutor == null) ? 0 : dsAutor.hashCode());
	result = prime * result + ((dsCambioActual == null) ? 0 : dsCambioActual.hashCode());
	result = prime * result + ((dsCambioAnterior == null) ? 0 : dsCambioAnterior.hashCode());
	result = prime * result + ((dsCodigo == null) ? 0 : dsCodigo.hashCode());
	result = prime * result + ((dsDescripcion == null) ? 0 : dsDescripcion.hashCode());
	result = prime * result + ((dsEstatus == null) ? 0 : dsEstatus.hashCode());
	result = prime * result + ((dsTipo == null) ? 0 : dsTipo.hashCode());
	result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	BitacoraCambiosDO other = (BitacoraCambiosDO) obj;
	if (dsAutor == null) {
		if (other.dsAutor != null)
			return false;
	} else if (!dsAutor.equals(other.dsAutor))
		return false;
	if (dsCambioActual == null) {
		if (other.dsCambioActual != null)
			return false;
	} else if (!dsCambioActual.equals(other.dsCambioActual))
		return false;
	if (dsCambioAnterior == null) {
		if (other.dsCambioAnterior != null)
			return false;
	} else if (!dsCambioAnterior.equals(other.dsCambioAnterior))
		return false;
	if (dsCodigo == null) {
		if (other.dsCodigo != null)
			return false;
	} else if (!dsCodigo.equals(other.dsCodigo))
		return false;
	if (dsDescripcion == null) {
		if (other.dsDescripcion != null)
			return false;
	} else if (!dsDescripcion.equals(other.dsDescripcion))
		return false;
	if (dsEstatus == null) {
		if (other.dsEstatus != null)
			return false;
	} else if (!dsEstatus.equals(other.dsEstatus))
		return false;
	if (dsTipo == null) {
		if (other.dsTipo != null)
			return false;
	} else if (!dsTipo.equals(other.dsTipo))
		return false;
	if (fecha == null) {
		if (other.fecha != null)
			return false;
	} else if (!fecha.equals(other.fecha))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}





}

package mx.com.prosa.poc.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import mx.com.prosa.poc.to.PagingRequestTO;

/**
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public final class PagingRequestUtil
{

  private PagingRequestUtil()
  {
    // Se ofusca el constructor
  }

  /**
   * Extrae los parametros de paginacion del request
   * 
   * @param request
   * @return
   */
  public static PageRequest extractPaging( PagingRequestTO<?> request )
  {
    int page = 0;
    int size = 10;
    Sort sotById = Sort.by( Sort.Direction.DESC, "id" );
    Sort sort = Sort.by( Sort.Direction.DESC, "modified" ).and( sotById );

    if( request != null )
    {
      if( page >= 0 )
      {
        page = request.getPage();
      }

      if( request.getSize() > 0 )
      {
        size = request.getSize();
      }

      if( StringUtils.isNoneBlank( request.getSortBy() ) )
      {
        if( request.getDirection() != null && request.getDirection().equals( PagingRequestTO.Direction.ASC ) )
        {
          sort = Sort.by( Sort.Direction.ASC, request.getSortBy() );
        }
        else
        {
          sort = Sort.by( Sort.Direction.DESC, request.getSortBy() );
        }
      }
    }

    return PageRequest.of( page, size, sort );
  }
}

package co.edu.usbcali.viajesusb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.SQLException;
import java.util.List;

import co.edu.usbcali.viajesusb.domain.Destino;

/**
 * 
 * @ClassName:  DestinoRepository   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   7/09/2021 9:55:26 a.�m.      
 * @Copyright:  USB
 */

public interface DestinoRepository extends JpaRepository <Destino, Long> {
	
	/**
	 * 
	 * @Title: findByTipoDestino_Codigo   
	   * @Description: TODO 
	 * @param: @param codigoTipoDestino
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Destino>      
	 * @throws
	 */
	
	public Destino findByCodigo(String codigo) throws Exception;
	
	
	public List<Destino> findByTipoDestino_Codigo(String codigoTipoDestino) throws SQLException;
	

	/**
	 * 
	 * @Title: findByEstado   
	 * @Description: Retorna una pagina de la lista de destinos por estado
	 * @param: @param estado
	 * @param: @param pageable
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Page<Destino>      
	 * @throws
	 */
	public List<Destino> findByEstado(String estado) throws SQLException;
	
	
	

}

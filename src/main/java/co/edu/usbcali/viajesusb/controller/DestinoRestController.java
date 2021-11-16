/**  
 * @Title:  DestinoRestController.java   
 * @Package co.edu.usbcali.viajesusb.controller   
 * @Description: description   
 * @author: Carlos Garaicoa     
 * @date:   12/10/2021 10:33:48 a.�m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.mapper.DestinoMapper;
import co.edu.usbcali.viajesusb.service.DestinoService;

/**   
 * @ClassName:  DestinoRestController   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   12/10/2021 10:33:48 a.�m.      
 * @Copyright:  USB
 */
@RestController
@RequestMapping("/api/destino")
@CrossOrigin()
public class DestinoRestController {

	@Autowired
	private DestinoService destinoService;
	
	@Autowired
	private DestinoMapper destinoMapper;
	
	@PostMapping("/guardarDestino")
	public ResponseEntity<?> guardarDestino(@RequestBody DestinoDTO destinoDTO){
		
		try {
			
			Destino destino =destinoService.guardarDestino(destinoDTO);
			
			return ResponseEntity.ok(destinoMapper.destinoToDestinoDTO(destino));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
	
	@PutMapping("/actualizarDestino")
	public ResponseEntity<?> actualizarDestino(@RequestBody DestinoDTO destinoDTO){
		try {
			
			Destino destino =destinoService.actualizarDestino(destinoDTO);
			return ResponseEntity.ok(destinoMapper.destinoToDestinoDTO(destino));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
	
	@DeleteMapping("/eliminarDestino/{codigo}")
	public ResponseEntity<?> eliminarDestino(@PathVariable("codigo")String codigo){
		
		try {
			
			Destino destino= destinoService.findByCodigo(codigo);
			
			destinoService.eliminarDestino(destino.getIdDest());
			
			return ResponseEntity.ok("Se eliminó satisfcatoriamente");
			
			} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	
	@GetMapping("/findDestinoPorCodigoTipoDestino")
	public ResponseEntity<?> findByCodigo(@RequestParam("codigo")String codigo){
		
		try {
			
			List<Destino> lstDestinos=destinoService.findByTipoDestino_Codigo(codigo);
			return ResponseEntity.ok().body(destinoMapper.ListDestinoToListDestinoDTO(lstDestinos));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping("/findDestinoPorEstado")
	public ResponseEntity<?> findByEstado(@RequestParam("estado") String estado){
		
		try {
			
			List<Destino> lstDestinos=destinoService.findByEstado(estado);
			return ResponseEntity.ok().body(destinoMapper.ListDestinoToListDestinoDTO(lstDestinos));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	
	
}

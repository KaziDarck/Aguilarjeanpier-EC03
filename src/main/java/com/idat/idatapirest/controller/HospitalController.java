package com.idat.idatapirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.idatapirest.dto.HospitalRequestDTO;
import com.idat.idatapirest.dto.HospitalResponseDTO;
import com.idat.idatapirest.service.HospitalService;


@RestController
@RequestMapping("/hospital/v1")
public class HospitalController {
	@Autowired
	private HospitalService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<HospitalResponseDTO>>listar(){
		
		return new ResponseEntity<List<HospitalResponseDTO>>(service.listarHospital(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody HospitalRequestDTO producto){
		service.guardarHospital(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		HospitalResponseDTO product = service.HospitalById(id);
		if(product != null) {
			service.eliminarHospital(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}

}

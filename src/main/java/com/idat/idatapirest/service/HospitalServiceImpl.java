package com.idat.idatapirest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idatapirest.dto.HospitalRequestDTO;
import com.idat.idatapirest.dto.HospitalResponseDTO;
import com.idat.idatapirest.model.Hospital;
import com.idat.idatapirest.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepository repository;
	
	@Override
	public void guardarHospital(HospitalRequestDTO p) {
		// TODO Auto-generated method stub
		Hospital hospital = new Hospital();
		hospital.setDescripcion(p.getDescripcionHospital());
		hospital.setNombre(p.getNombreHospital());
		hospital.setDistrito(p.getDistritoHospital());
		hospital.setIdHospital(p.getIdHospital());
		repository.save(hospital);
	}

	@Override
	public void eliminarHospital(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void editarHospital(HospitalRequestDTO p) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<HospitalResponseDTO> listarHospital() {

		List<Hospital> hospital = repository.findAll();
		List<HospitalResponseDTO> dto = new ArrayList<HospitalResponseDTO>();
		HospitalResponseDTO hospitalDTO = null;
		
		for (Hospital c : hospital) {
			hospitalDTO = new HospitalResponseDTO();
			hospitalDTO.setIdHospital(c.getIdHospital());
			hospitalDTO.setNombrehospital(c.getNombre());
			hospitalDTO.setDescripcionhospital(c.getDescripcion());
			hospitalDTO.setDistritohospital(c.getDistrito());
			dto.add(hospitalDTO);
		}
		
		return dto;
	}

	@Override
	public HospitalResponseDTO HospitalById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

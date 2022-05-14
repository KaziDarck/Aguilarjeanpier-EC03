package com.idat.idatapirest.service;

import java.util.List;

import com.idat.idatapirest.dto.HospitalRequestDTO;
import com.idat.idatapirest.dto.HospitalResponseDTO;

public interface HospitalService {

	public void guardarHospital(HospitalRequestDTO p);
	public void eliminarHospital(Integer id);
	public void editarHospital(HospitalRequestDTO p);
	public List<HospitalResponseDTO> listarHospital();
	public HospitalResponseDTO HospitalById(Integer id);
}


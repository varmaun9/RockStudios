package com.rockstudios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rockstudios.dao.ProgramRepository;
import com.rockstudios.domain.Program;
/*
*@Author Sankar
*/
@Component
public class ProgramService implements IProgramService{

	@Autowired
	private ProgramRepository programRepository;
	@Override
	public Program create(Program program) {
		// TODO Auto-generated method stub
		return programRepository.save(program);
	}

	@Override
	public void deleteProgram(String programId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Program getProgram(String programId) {
		// TODO Auto-generated method stub
		 return programRepository.findOne(programId);
	}

	@Override
	public List<Program> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Program updateProgram(Program program) {
		// TODO Auto-generated method stub
	return programRepository.save(program);
	}

}

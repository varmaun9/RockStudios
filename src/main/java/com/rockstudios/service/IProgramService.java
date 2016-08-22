package com.rockstudios.service;

import java.util.List;

import com.rockstudios.domain.Program;
/*
*@Author Sankar
*/
public interface IProgramService {
	
	Program create(Program program);

	void deleteProgram(String programId);

	Program getProgram(String programId);

	List<Program> getAll();

	Program updateProgram(Program program);
}

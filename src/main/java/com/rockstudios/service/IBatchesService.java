package com.rockstudios.service;

import java.util.List;

import com.rockstudios.domain.Batches;
/*
*@Author Sankar
*/
public interface IBatchesService {
	
	Batches create(Batches batches);

	void deleteBatches(String batchesId);

	Batches getBatches(String batchesId);

	List<Batches> getAll();

	Batches updateBatches(Batches batches);
}

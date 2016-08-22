package com.rockstudios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rockstudios.dao.BatchesRepository;
import com.rockstudios.domain.Batches;
/*
*@Author Sankar
*/
@Component
public class BatchesService implements IBatchesService{

	@Autowired
	private BatchesRepository batchesRepository;
	@Override
	public Batches create(Batches batches) {
		// TODO Auto-generated method stub
		return batchesRepository.save(batches);
	}

	@Override
	public void deleteBatches(String batchesId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Batches getBatches(String batchesId) {
		// TODO Auto-generated method stub
		 return batchesRepository.findOne(batchesId);
	}

	@Override
	public List<Batches> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Batches updateBatches(Batches batches) {
		// TODO Auto-generated method stub
	return batchesRepository.save(batches);
	}

}

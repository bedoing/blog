package org.bedoing.service.impl;

import org.bedoing.entity.Dict;
import org.bedoing.repository.DictRepository;
import org.bedoing.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommonService implements ICommonService{

	@Autowired
	private DictRepository dictRepository;

	@Override
	public List<Dict> findAllDict() {
		return (List<Dict>) dictRepository.findAll();
	}
	
	
}

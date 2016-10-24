package org.bedoing.blog.service.impl;

import org.bedoing.blog.entity.Dict;
import org.bedoing.blog.repository.DictRepository;
import org.bedoing.blog.service.ICommonService;
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

package com.halcyon.file_manage.annotations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.halcyon.file_manage.model.Chemicalwmnotes;
import com.halcyon.file_manage.model.Chemicalwmstock;
import com.halcyon.file_manage.service.ChemicalwmnotesService;
import com.halcyon.file_manage.service.ChemicalwmstockService;

@Component // 注意 这里必须有
public class StartAllJobInit {

	protected Logger logger = LoggerFactory.getLogger(StartAllJobInit.class);

	@Resource
	private ChemicalwmnotesService notesService;
	@Resource
	private ChemicalwmstockService stockService;

	@PostConstruct // 构造函数之后执行
	public void init() {
		logger.info("spring boot started.");
	}

	@SuppressWarnings("unused")
	public void startJob() {
		List<Chemicalwmnotes> chemicalwmnotes = notesService.selectAll();
		Map<String, Chemicalwmnotes> materalMap = new HashMap<String, Chemicalwmnotes>();

		for (Chemicalwmnotes material : chemicalwmnotes) {
			materalMap.put(material.getMaterialno(), material);
		}

		StorageContainer.getContainer().refreshMateral(materalMap);

		List<Chemicalwmstock> chemicalwmstock = stockService.selectAll();
		StorageContainer.getContainer().refreshStorage(chemicalwmstock);

		StorageContainer container = StorageContainer.getContainer();
	}
}
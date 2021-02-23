package com.halcyon.file_manage.service;
import java.util.List;

import com.halcyon.file_manage.core.Service;
import com.halcyon.file_manage.model.Materials;
import com.halcyon.file_manage.model.SearchType;


/**
 * Created on 2021/01/09.
 */
public interface MaterialsService extends Service<Materials> {

	List<Materials> selectByLikeName(SearchType searchType);
}

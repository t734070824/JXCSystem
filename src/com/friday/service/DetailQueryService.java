package com.friday.service;

import java.util.List;

public interface DetailQueryService {
	List<Object> queryDetail(String dId, String table) throws Exception;
}

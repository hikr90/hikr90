package com.intr.svcImpl;

import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intr.dao.RestAPIDao;
import com.intr.svc.RestAPIService;
import com.intr.svc.UtilService;

@Service
public class RestAPIServiceImpl implements RestAPIService{
	//
	@Autowired
	RestAPIDao restDao;
	
	@Autowired
	UtilService utilService;
	
    private final Logger logger = LoggerFactory.getLogger(getClass());

    // ��ȹ� ��� ��ȸ
	public String intrRestInqy1010(String reqObj) throws Exception {
		//
		List<HashMap<String, Object>> defaultList = null;
		HashMap<String, Object> paramMap = null;
		String jStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// JSON To Map
			//--------------------------------------------------------------------------------------------
			paramMap = this.intrRestInqy1011(reqObj);
			
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			defaultList = restDao.intrRestInqy1011(paramMap);
			
			//--------------------------------------------------------------------------------------------
			// ��� ó��
			//--------------------------------------------------------------------------------------------
			jStr = this.intrRestInqy1012(paramMap, defaultList);
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return jStr;
	}
	
	// JSON To Map
	public HashMap<String, Object> intrRestInqy1011(String reqObj) throws Exception {
		//
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		//
		try {
			//
			if(!utilService.isNull(reqObj)) {
				//
				paramMap = objMapper.readValue(reqObj, HashMap.class);
				//
				if(utilService.isNull((String)paramMap.get("pageNo")) || utilService.isNull((String)paramMap.get("pageSize"))) {
					paramMap.put("pageNo", 1);
					paramMap.put("pageSize", 5);
				}
			}  else {
				paramMap.put("pageNo", 1);
				paramMap.put("pageSize", 5);
			}
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return paramMap;
	}
	
	// List To JSON
	public String intrRestInqy1012(HashMap<String, Object> paramMap, List<HashMap<String, Object>> defaultList) throws Exception {
		//
		String jStr = "";
		HashMap<String, Object> tempMap = null;
		JSONObject jObj = null;
		JSONObject headObj = new JSONObject();
		//
		try {
			//--------------------------------------------------------------------------------------------
			// JSON ó��
			//--------------------------------------------------------------------------------------------
			if(!defaultList.isEmpty()) {
				//
				headObj.put("contId", utilService.isNull((String)paramMap.get("contId"))?"":(String)paramMap.get("contId"));
				//
				for(int i=0;i<defaultList.size();i++) {
						//
						tempMap = new HashMap<String, Object>();
						tempMap = defaultList.get(i);
						//
						for(String key : tempMap.keySet()) {
							//
							jObj = new JSONObject();
							jObj.put(key, (String)tempMap.get(key));
						}
				}
				//
				System.out.println("kth jObj : "+jObj.toString());
				
			} else {
				throw new Exception("�����Ͱ� �������� �ʽ��ϴ�.");
			}
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return jStr;
	}
	
	// ��ȹ� �� ��ȸ
	public String intrRestInqy1020(String contId) throws Exception {
		//
		String jStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ȹ� �� ��ȸ
			//--------------------------------------------------------------------------------------------

			//--------------------------------------------------------------------------------------------
			// ��� ó��
			//--------------------------------------------------------------------------------------------
			
		} catch (Exception e) {
			//
			throw new Exception(e.getMessage());
		}
		//
		return jStr;
	}
}

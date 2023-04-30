package com.korea.json;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import util.Util;
import vo.JsonVO;

@Controller
public class JsonMakerController {
	
	// 
	@RequestMapping(value="/")
	public String json() {
		
		return Util.Json.VIEW_PATH + "json.jsp";
	} 
	
	/* VO TO JSON */
	@RequestMapping("/vo_to_json.do")
	@ResponseBody
	public String ajax_to_json() {
		//
		String resStr = "";
		
		JsonVO vo = new JsonVO();
		vo.setCheckYn("Y");
		
		//
		resStr = String.format("[{'res':'%s'}]",vo.getCheckYn());
		
		return resStr;
	}
	
	// MAP TO JSON
	@RequestMapping("/map_to_json.do")
	@ResponseBody
	public Map<String, Object> map_to_json(){
		//
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "홍길동");
		map.put("age", "20");
		// 
		Map<String, String> tellMap = new HashMap<String, String>();
		tellMap.put("tel", "02-111-1111");
		tellMap.put("phone","010-111-2222");
		
		// MAP에 MAP을 넣는 경우 넣는 MAP의 받는 타입을 OBJECT로 해줘야한다.
		map.put("tel",tellMap);
		
		return map;
	}	
	
	/* JSON OBJECT
		- 서버에서 직접 한글을 보내는 경우, REQUSETMAPPING의 PROCEDURE속성으로 인코딩을 지정해줘야한다.
		- 서버에서 JSON객체를 사용하는 경우 있어야하는 라이브러리

		- POM.XML에 추가하거나 라이브러리 저장하여 사용한다.
		- GSON (JSONARRAY / JSONOBJECT) 라이브러리로도 진행할 수 있다.
		
		# JSONARRAY
			- JSON객체를 저장하는 배열
			
		# JSONTOSTRING
			- 객체를 JSON형태의 문자열로 변경
			- STRING으로 사용해도 무방하다.
	 */
	@RequestMapping(value="/json_object.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8\r\n")
	@ResponseBody
	public String jsonObject(){
		//
		JSONObject totalObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonInfo = null;
		
		// 생성한 JSON 객체는 MAP 형태처럼 사용할 수 있다.
		jsonInfo = new JSONObject();
		jsonInfo.put("name", "홍길동");
		jsonInfo.put("age", 20);
		
		// JSONARRAY 추가
		jsonArr.add(jsonInfo);
		
		//
		jsonInfo = new JSONObject();
		jsonInfo.put("name", "김길동");
		jsonInfo.put("age", 30);
		
		// JSONARRAY 추가
		jsonArr.add(jsonInfo);
		
		// JSONARRAY를 TOTALOBJ의 객체에 저장 후 문자열로 변경
		totalObj.put("jsonArr", jsonArr);
		String jsonData = totalObj.toJSONString();
		
		return jsonData;
	}	
}

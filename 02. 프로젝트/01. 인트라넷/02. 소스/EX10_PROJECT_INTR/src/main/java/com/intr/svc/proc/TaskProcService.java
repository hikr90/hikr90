package com.intr.svc.proc;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

public interface TaskProcService {
	// 업무일지
	String intrTaskProc101010(Model model, List<HashMap<String,Object>> paramList); // 등록
}

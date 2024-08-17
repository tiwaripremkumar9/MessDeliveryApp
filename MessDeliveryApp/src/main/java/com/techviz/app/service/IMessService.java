package com.techviz.app.service;

import com.techviz.app.dto.MessDTO;
import com.techviz.app.pojos.Mess;

public interface IMessService {
	
	public MessDTO registerMess(Mess mess);
	public String deleteMess(int id);

}

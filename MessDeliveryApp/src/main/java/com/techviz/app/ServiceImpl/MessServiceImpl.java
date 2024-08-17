package com.techviz.app.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techviz.app.dto.MessDTO;
import com.techviz.app.pojos.Food;
import com.techviz.app.pojos.Mess;
import com.techviz.app.pojos.Order;
import com.techviz.app.repository.MessRepository;
import com.techviz.app.service.IMessService;

@Service
public class MessServiceImpl implements IMessService {
	
	@Autowired
	private MessRepository messRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public MessDTO registerMess(Mess mess) {
		MessDTO messDTO = null;
		if(mess != null) {
			List<Food> foodList = mess.getFoods();
			for(Food food: foodList) {
				food.setMess(mess);
			}
			Mess newMess = messRepo.save(mess);
			messDTO = modelMapper.map(newMess, MessDTO.class);
		}
		return messDTO;
		
	}

	@Override
	public String deleteMess(int id) {
		Mess mess = null;
		Optional<Mess> messOptional = messRepo.findById(id);
		if(messOptional.isPresent()) {
			mess = messOptional.get();
			messRepo.delete(mess);
		}
		return "Mess with id: "+mess.getId()+" Deleted.";
	}
	

}

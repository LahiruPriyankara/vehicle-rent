package com.lhu.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lhu.vehicle_rent_backend.DTO.User;
import com.lhu.vehicle_rent_backend.DTO.Vehicle;
import com.lhu.vehicle_rent_backend.businessLogic.UserMgnBl;

@Controller
@RequestMapping(value = "main")
public class HomeController {
	private static final Log log = LogFactory.getLog(HomeController.class);

	@Autowired
	private UserMgnBl userMgnBl;

	@RequestMapping(value = "home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		log.debug("Enter | home");
		//List<Vehicle> ;
		mv.addObject("vehicles", userMgnBl.getVehicles());        
		return mv;
	}

	@ModelAttribute("user")
	public User modelUser() {
		return new User();
	}

	@ModelAttribute("vehicle")
	public Vehicle modelVehicle() {
		return new Vehicle();
	}

	@ModelAttribute("statusList")
	public List statusList() {
		List<String> list = new ArrayList();
		list.add("ACTIVE");
		list.add("INACTIVE");
		return list;
	}
	
	@ModelAttribute("roleList")
	public List roleList() {
		List<String> list = new ArrayList();
		list.add("ADMIN");
		list.add("SUPPLIER");
		list.add("CUSTOMER");
		return list;
	}
	
	@ModelAttribute("vehicleTypeList")
	public List vehicleTypeList() {
		List<String> list = new ArrayList();
		list.add("BUS");
		list.add("VAN");
		list.add("CAR");
		list.add("THREE WEELER");
		return list;
	}

}

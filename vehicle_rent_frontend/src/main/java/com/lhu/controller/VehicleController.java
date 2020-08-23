package com.lhu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhu.imageProcess.ImageUpload;
import com.lhu.vehicle_rent_backend.DTO.User;
import com.lhu.vehicle_rent_backend.DTO.Vehicle;
import com.lhu.vehicle_rent_backend.businessLogic.UserMgnBl;

@Controller
@RequestMapping(value = "vehicle")
public class VehicleController {
	private static final Log log = LogFactory.getLog(VehicleController.class);

	@Autowired
	private UserMgnBl userMgnBl;

	@RequestMapping(value = "addNew")
	public String addNew(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult results, Model model,
			HttpServletRequest request) {
		log.debug("Enter | addNew");
		try {
			// new ImageValidate().validate(user, results);
			if (!results.hasErrors()) {
				ImageUpload.uploadFile(request, vehicle.getFile(), vehicle.getImage(), 1);
				User loggedUser = request.getSession().getAttribute("userInfo") != null
						? (User) request.getSession().getAttribute("userInfo") : new User();
				vehicle.setUser(loggedUser);
				userMgnBl.addVehicle(vehicle);
			} else {
				return "index";
			}
			vehicle = new Vehicle();
			log.debug("Left | addNew");
			return "redirect:/main/home";
		} catch (Exception e) {
			log.debug("Exception : " + e);
			return "index";
		}
	}
	
	@RequestMapping(value = "update")
	public String update(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult results, Model model,
			HttpServletRequest request) {
		log.debug("Enter | update");
		try {System.out.println("Updation Obj  "+vehicle.toString());
		boolean isDelete = ((String) request.getParameter("actionType")).equalsIgnoreCase("delete") ? true : false;
		System.out.println("Updation isDelete  "+isDelete);
			// new ImageValidate().validate(user, results);
			/*if (!results.hasErrors()) {
				ImageUpload.uploadFile(request, vehicle.getFile(), vehicle.getImage(), 1);
				User loggedUser = request.getSession().getAttribute("userInfo") != null
						? (User) request.getSession().getAttribute("userInfo") : new User();
				vehicle.setUser(loggedUser);
				userMgnBl.addVehicle(vehicle);
			} else {
				return "index";
			}*/
			vehicle = new Vehicle();
			log.debug("Left | update");
			return "redirect:/main/home";
		} catch (Exception e) {
			log.debug("Exception : " + e);
			return "index";
		}
	}

	@RequestMapping(value = "getVehicleInfo/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Vehicle getVehicle(@PathVariable("id") String id, HttpServletRequest request) {
		log.debug("Enter | getVehicle");
		try {
			log.debug("Info | ID : " + id);
			Vehicle vehicle = new Vehicle();
			if (id != null && !id.equalsIgnoreCase("")) {
				vehicle = userMgnBl.getVehicle(Integer.parseInt(id));
				System.out.println("VehicleController.getVehicle  |  SUCCESS.." + vehicle.to_String());
			}
			request.getSession().setAttribute("vehicleInfo", vehicle);
			return vehicle;
		} catch (Exception e) {
			log.debug("Exception : " + e);
			return new Vehicle();
		}
	}
/*
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
*/
}

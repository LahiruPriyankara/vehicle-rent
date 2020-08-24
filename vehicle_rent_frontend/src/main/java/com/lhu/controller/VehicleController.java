package com.lhu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.lhu.imageProcess.ImageValidate;
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
			request.getSession().setAttribute("vehicleUser", vehicle.getUser());
			return vehicle;
		} catch (Exception e) {
			log.debug("Exception : " + e);
			return new Vehicle();
		}
	}
	
	@RequestMapping(value = "update")
	public String update(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult results, Model model,HttpServletRequest request) {
		log.debug("Enter | update");
		HttpSession session = request.getSession();
		boolean isSuccess = false;
		try {
			if((session.getAttribute("vehicleUser") != null) && (session.getAttribute("vehicleUser")!= null)){
				User vehicleUser = (User) (session.getAttribute("vehicleUser"));
				vehicle.setUser(vehicleUser);
			    System.out.println("Updation Obj  "+vehicle.toString());
		        boolean isDelete = ((String) request.getParameter("actionType")).equalsIgnoreCase("delete") ? true : false;
		        System.out.println("Updation isDelete  "+isDelete);
		        
		        if (isDelete) {
					isSuccess = userMgnBl.deleteVehicle(vehicle);
				}else{
					isSuccess = userMgnBl.updateVehicle(vehicle);
				}
				
		        
			/*new ImageValidate().validate(user, results);
			if (!results.hasErrors()) {
				ImageUpload.uploadFile(request, vehicle.getFile(), vehicle.getImage(), 1);
				User loggedUser = request.getSession().getAttribute("userInfo") != null
						? (User) request.getSession().getAttribute("userInfo") : new User();
				vehicle.setUser(loggedUser);
				userMgnBl.addVehicle(vehicle);
			} else {
				return "index";
			}*/
			}
			System.out.println("isSuccess  " + isSuccess);
			log.debug("Left | update");
			//return "redirect:/main/home";
			return "index";
		} catch (Exception e) {
			log.debug("Exception : " + e);
			return "index";
		}
	}

	

}

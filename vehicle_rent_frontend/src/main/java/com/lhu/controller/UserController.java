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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lhu.imageProcess.ImageUpload;
import com.lhu.imageProcess.ImageValidate;
import com.lhu.vehicle_rent_backend.DTO.User;
import com.lhu.vehicle_rent_backend.DTO.Vehicle;
import com.lhu.vehicle_rent_backend.businessLogic.UserMgnBl;

@Controller
@RequestMapping(value = "User")
public class UserController {
	private static final Log log = LogFactory.getLog(UserController.class);

	@Autowired
	private UserMgnBl userMgnBl;

	@RequestMapping(value = "singIn")
	public ModelAndView singIn(@Valid @ModelAttribute("user") User user, BindingResult results, Model model,
			HttpServletRequest request) {
		log.debug("Enter | singIn");
		ModelAndView mv = new ModelAndView("index");
		User loggedUser = userMgnBl.getUser(user.getEmail(), user.getPassword());
		if (loggedUser != null) {
			log.debug("Logging Success...");
		} else {
			log.debug("Logging Fail...");
		}
		user = new User();

		log.debug("Left | singIn");
		return mv;
	}

	@RequestMapping(value = "singUp")
	public ModelAndView singUp(@Valid @ModelAttribute("user") User user, BindingResult results, Model model,
			HttpServletRequest request) {
		log.debug("Enter | singUp");
		ModelAndView mv = new ModelAndView("index");

		if (userMgnBl.getUser(user.getEmail(), null) != null) {
			log.debug("Info | There are some validation errors");
			results.rejectValue("email", null, "This email is already available,try with new one!");
		} else {
			if (!user.getPassword().toLowerCase().equalsIgnoreCase(user.getConfirmPassword().toLowerCase())) {
				results.rejectValue("confirmPassword", null, "Not match with givenn password!");
			}
			new ImageValidate().validate(user, results);
			if (!results.hasErrors()) {
				ImageUpload.uploadFile(request, user.getFile(), user.getImage(), 0);
				userMgnBl.addUser(user);
				user = new User();
			} else {
				log.debug("Info | There are some validation errors");
				user.setConfirmPassword("");
			}
		}

		log.debug("Left | singUp");
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

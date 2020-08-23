package com.lhu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lhu.vehicle_rent_backend.DTO.Book;
import com.lhu.vehicle_rent_backend.DTO.User;
import com.lhu.vehicle_rent_backend.DTO.Vehicle;
import com.lhu.vehicle_rent_backend.businessLogic.UserMgnBl;

@Controller
@RequestMapping(value = "main")
public class HomeController {
	private static final Log log = LogFactory.getLog(HomeController.class);

	@Autowired
	private UserMgnBl userMgnBl;

	public static User loggedUser = new User();
	public static Vehicle vehicel = new Vehicle();
	public static List<String> statuslist = new ArrayList();
	public static List<String> rTypelist = new ArrayList();
	public static List<String> vTypelist = new ArrayList();
	public static Book book = new Book();

	@RequestMapping(value = "home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		log.debug("Enter | home");
		// List<Vehicle> ;
		mv.addObject("vehicles", userMgnBl.getVehicles());
		return mv;
	}

	@ModelAttribute("user")
	public User modelUser(HttpServletRequest request) {
		/*
		 * HttpSession session = request.getSession(); boolean isLog =
		 * session.getAttribute("loggedUser") != null ? (boolean)
		 * session.getAttribute("loggedUser") : false; if (isLog) { loggedUser =
		 * session.getAttribute("userInfo") != null ? (User)
		 * (session.getAttribute("userInfo")) : new User(); }
		 */
		return loggedUser;
	}

	@RequestMapping(value = "getAvilbleVehicleData")
	public ModelAndView getAvilbleVehicleData() {
		ModelAndView mv = new ModelAndView("homePageContext/availableVehicle");
		log.debug("Enter | home");
		// List<Vehicle> ;
		mv.addObject("vehicles", userMgnBl.getVehicles());
		return mv;
	}
	
	@RequestMapping(value = "getUserProfileData")
	public ModelAndView getUserProfileData() {
		ModelAndView mv = new ModelAndView("user/userBookingAndUploadedVehicle");
		log.debug("Enter | home");
		// List<Vehicle> ;
		//mv.addObject("vehicles", userMgnBl.getVehicles());
		return mv;
	}

	@ModelAttribute("vehicle")
	public Vehicle modelVehicle() {
		return vehicel;
	}

	@ModelAttribute("statusList")
	public List statusList() {
		statuslist = new ArrayList();
		statuslist.add("ACTIVE");
		statuslist.add("INACTIVE");
		return statuslist;
	}

	@ModelAttribute("roleList")
	public List roleList() {
		List<String> rTypelist = new ArrayList();
		rTypelist.add("ADMIN");
		rTypelist.add("SUPPLIER");
		rTypelist.add("CUSTOMER");
		return rTypelist;
	}

	@ModelAttribute("vehicleTypeList")
	public List vehicleTypeList() {
		vTypelist = new ArrayList();
		vTypelist.add("BUS");
		vTypelist.add("VAN");
		vTypelist.add("CAR");
		vTypelist.add("THREE WEELER");
		return vTypelist;
	}

	@ModelAttribute("book")
	public Book modelBook() {
		return book;
	}

}

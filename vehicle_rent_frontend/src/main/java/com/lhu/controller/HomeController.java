package com.lhu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		try {
			log.debug("Enter | home");
			List<Vehicle> vList = userMgnBl.getVehicles(null);
			System.out.println("main.home .......................... "+vList.size());
			mv.addObject("vehicles", vList);
		} catch (Exception e) {
			log.debug("Exception : " + e);
		}
		return mv;
	}

	@ModelAttribute("user")
	public User modelUser(HttpServletRequest request) {
		try {
			/*
			 * HttpSession session = request.getSession(); boolean isLog =
			 * session.getAttribute("loggedUser") != null ? (boolean)
			 * session.getAttribute("loggedUser") : false; if (isLog) {
			 * loggedUser = session.getAttribute("userInfo") != null ? (User)
			 * (session.getAttribute("userInfo")) : new User(); }
			 */
			return loggedUser;
		} catch (Exception e) {
			log.debug("Exception : " + e);
			return loggedUser;
		}
	}

	@RequestMapping(value = "getAvilbleVehicleData")
	public ModelAndView getAvilbleVehicleData() {
		ModelAndView mv = new ModelAndView("homePageContext/availableVehicle");
		try {
			log.debug("Enter | home");
			mv.addObject("vehicles", userMgnBl.getVehicles(null));

		} catch (Exception e) {
			log.debug("Exception : " + e);
		}
		return mv;
	}

	@RequestMapping(value = "getUserProfileData")
	public ModelAndView getUserProfileData(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("user/userBookingAndUploadedVehicle");
		try {
			log.debug("Enter | home");
			//int uID = Integer.parseInt(id);
			HttpSession session = request.getSession();
			User user = session.getAttribute("userInfo") != null ? (User) (session.getAttribute("userInfo")): new User();
			System.out.println("user : "+user.toString());
			List<Vehicle> vList = userMgnBl.getVehicles(user);
			List<Book> bList = userMgnBl.getBooks(user);
			System.out.println("vList  : "+vList.size()+"  | bList  : "+bList.size());
			mv.addObject("vehicles", vList);
			mv.addObject("books", bList);

		} catch (Exception e) {
			log.debug("Exception : " + e);
		}
		return mv;
	}
	
	@RequestMapping(value = "getAllSysDataForAdmin")
	public ModelAndView getAllSysDataForAdmin(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("user/userBookingAndUploadedVehicle");
		try {
			log.debug("Enter | home");
			//int uID = Integer.parseInt(id);
			HttpSession session = request.getSession();
			User user = session.getAttribute("userInfo") != null ? (User) (session.getAttribute("userInfo")): new User();
			System.out.println("user : "+user.toString());
			List<Vehicle> vList = userMgnBl.getVehicles(null);
			List<Book> bList = userMgnBl.getBooks(null);
			System.out.println("vList  : "+vList.size()+"  | bList  : "+bList.size());
			mv.addObject("vehicles", vList);
			mv.addObject("books", bList);

		} catch (Exception e) {
			log.debug("Exception : " + e);
		}
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

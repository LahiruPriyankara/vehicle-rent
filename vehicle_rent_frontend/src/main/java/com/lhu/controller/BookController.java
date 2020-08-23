package com.lhu.controller;

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

import com.lhu.vehicle_rent_backend.DTO.Book;
import com.lhu.vehicle_rent_backend.DTO.User;
import com.lhu.vehicle_rent_backend.DTO.Vehicle;
import com.lhu.vehicle_rent_backend.businessLogic.UserMgnBl;

@Controller
@RequestMapping(value = "book")
public class BookController {
	private static final Log log = LogFactory.getLog(BookController.class);

	@Autowired
	private UserMgnBl userMgnBl;

	@RequestMapping(value = "addNewBooking")
	public String addNewBooking(Model model, HttpServletRequest request) {
		log.debug("Enter | addNewBooking");
		Book newBooking = new Book();
		try {
			User loggedUser = request.getSession().getAttribute("userInfo") != null
					? (User) request.getSession().getAttribute("userInfo") : new User();
			Vehicle vehiclefo = request.getSession().getAttribute("vehiclefo") != null
					? (Vehicle) request.getSession().getAttribute("vehiclefo") : new Vehicle();

			newBooking.setUser(loggedUser);
			newBooking.setVehicle(vehiclefo);
			
			newBooking.setDuration(request.getParameter("dKm"));
			newBooking.setDays(request.getParameter("days"));
			newBooking.setPickUpPoint(request.getParameter("pPoint"));
	        newBooking.setPickOffPoint(request.getParameter("dPoint"));
	        newBooking.setDatetime(request.getParameter("dateTime"));
	        newBooking.setStatus("PENDING");
	        newBooking.setWithDriver(((String)request.getParameter("withOrWithOutDriver")).equalsIgnoreCase("withDriver")?true:false);
	        newBooking.setAvgCost(request.getParameter("aCost"));
	        
	        System.out.println("Booking Obj..."+newBooking.toString());
			boolean isSuccess = userMgnBl.addBook(newBooking);
			System.out.println("Successfully added..."+isSuccess);
			log.debug("Left | addNewBooking : " + isSuccess);
			return "redirect:/main/home";
		} catch (Exception e) {
			log.debug("Exception : " + e);
			return "index";
		}
	}
	
	
	@RequestMapping(value = "getBookInfo/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Book getBook(@PathVariable("id") String id, HttpServletRequest request) {
		log.debug("Enter | getBook");
		try {
			log.debug("Info | ID : " + id);
			Book book = new Book();
			if (id != null && !id.equalsIgnoreCase("")) {
				book = userMgnBl.getBook(Integer.parseInt(id));
				System.out.println("VehicleController.getVehicle  |  SUCCESS.." + book.to_String());
			}
			request.getSession().setAttribute("bookInfo", book);
			return book;
		} catch (Exception e) {
			log.debug("Exception : " + e);
			return new Book();
		}
	}
	
	@RequestMapping(value = "update")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult results, Model model,
			HttpServletRequest request) {
		log.debug("Enter | update");
		try {System.out.println("Updation Obj  "+book.toString());
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
		    book = new Book();
			log.debug("Left | update");
			return "redirect:/main/home";
		} catch (Exception e) {
			log.debug("Exception : " + e);
			return "index";
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

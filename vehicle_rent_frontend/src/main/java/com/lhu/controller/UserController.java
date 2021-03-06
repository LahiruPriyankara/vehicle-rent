package com.lhu.controller;

import java.util.ArrayList;
import java.util.List;

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

	User loggedUser = new User();
	Vehicle vehicel = new Vehicle();
	List<String> statuslist = new ArrayList();
	List<String> rTypelist = new ArrayList();
	List<String> vTypelist = new ArrayList();

	@RequestMapping(value = "singIn")
	public String singIn(@Valid @ModelAttribute("user") User user, BindingResult results, Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("onAction", "singIn");
		session.setAttribute("hasValidationError", false);
		try {
			log.debug("Enter | singIn");
			ModelAndView mv = new ModelAndView("index");
			User loggedUser = userMgnBl.getUser(user.getEmail(), user.getPassword());
			if (loggedUser != null) {

				loggedUser.setPassword("");
				loggedUser.setConfirmPassword("");
				loggedUser.setConfirmPassword2("");
				// System.out.println(""+loggedUser.to_String());
				HomeController.loggedUser = loggedUser;
				session.setAttribute("userInfo", loggedUser);
				session.setAttribute("isloggedUser", true);
				log.debug("Logging Success...");
			} else {
				log.debug("Logging Fail...");
				session.setAttribute("hasValidationError", true);
			}
			log.debug("Left | singIn");
			return "redirect:/main/home";
		} catch (Exception e) {
			log.debug("Exception : " + e);
			session.setAttribute("hasValidationError", true);
			return "index";
		}
	}

	@RequestMapping(value = "singUp")
	public String singUp(@Valid @ModelAttribute("user") User user, BindingResult results, Model model,
			HttpServletRequest request) {
		log.debug("Enter | singUp");
		try {
			user.setRole("C");
			if (userMgnBl.getUser(user.getEmail(), null) != null) {
				log.debug("Info | There are some validation errors");
				results.rejectValue("email", null, "This email is already taken,try with new one!");
			} else {
				if (!user.getPassword().toLowerCase().equalsIgnoreCase(user.getConfirmPassword().toLowerCase())) {
					results.rejectValue("confirmPassword", null, "Not match with givenn password!");
				}
				new ImageValidate().validate(user, results);
				if (!results.hasErrors()) {
					ImageUpload.uploadFile(request, user.getFile(), user.getImage(), 0);
					userMgnBl.addUser(user);
					log.debug("Info | Sucessfully added");
				} else {
					log.debug("Info | There are some validation errors");
				}
			}

			log.debug("Left | singUp");
			return "redirect:/User/singIn";
		} catch (Exception e) {
			log.debug("Exception : " + e);
			return "index";
		}
	}

	@RequestMapping(value = "singOff")
	public String singOff(HttpServletRequest request) {
		log.debug("Enter | singOff");
		try {
			// ModelAndView mv = new ModelAndView("index");
			HttpSession session = request.getSession();
			log.debug("Info | loggedUser : " + loggedUser);
			if (loggedUser != null) {
				session.removeAttribute("userInfo");
				session.removeAttribute("isloggedUser");
				session.removeAttribute("hasValidationError");
				session.removeAttribute("onAction");

				HomeController.loggedUser = new User();
				HomeController.vehicel = new Vehicle();
				HomeController.statuslist = new ArrayList();
				HomeController.rTypelist = new ArrayList();
				HomeController.vTypelist = new ArrayList();
				log.debug("SingOff Success...");
			} else {
				log.debug("SingOff Fail...");
			}
			log.debug("Left | singOff");
			return "redirect:/User/singIn";
		} catch (Exception e) {
			log.debug("Exception : " + e);
			return "index";
		}
	}

	@RequestMapping(value = "edit")
	public String edit(@Valid @ModelAttribute("user") User user, BindingResult results, Model model,HttpServletRequest request) {
		log.debug("Enter | edit");
		boolean isSuccess = false;
		HttpSession session = request.getSession();
		try {
			boolean isDelete = ((String) request.getParameter("actionType")).equalsIgnoreCase("delete") ? true : false;
			User oldUser = userMgnBl.getUser(user.getEmail(), null);
			if (oldUser != null) {
				/*boolean hasError = false;
				if (!oldUser.getPassword().equalsIgnoreCase(user.getPassword())) {
					results.rejectValue("confirmPassword", null, "Wrong password!");
					hasError = true;
				}
				if (!user.getConfirmPassword().equalsIgnoreCase("") || !user.getConfirmPassword2().equalsIgnoreCase("")) {
					if (user.getConfirmPassword().equalsIgnoreCase(user.getConfirmPassword2())) {
						if (!oldUser.getPassword().equalsIgnoreCase(user.getConfirmPassword()) || !oldUser.getConfirmPassword().equalsIgnoreCase(user.getConfirmPassword2())) {
							results.rejectValue("confirmPassword", null, "New passwords are not match!");
							hasError = true;
						}
					}else{
						results.rejectValue("confirmPassword", null, "New password are not match!");
						hasError = true;
					}
					
				}else{
					if (oldUser.getTp().equalsIgnoreCase(user.getTp())
							&& oldUser.getImage().equalsIgnoreCase(user.getImage())
							&& oldUser.getName().equalsIgnoreCase(user.getName())
							&& oldUser.getPassword().equalsIgnoreCase(user.getConfirmPassword())) {
						results.rejectValue("notModify", null, "Please change a value!");
						hasError = true;
					}
				}
				
				if (hasError) {
					throw new Exception("Validation Error");
				}
				*/
				
				System.out.println("Updation Obj  " + user.toString());
				if (isDelete) {
					/*if(!user.getPassword().equalsIgnoreCase(user.getConfirmPassword())){
						throw new Exception("Wrong Password.");
					}*/
					isSuccess = userMgnBl.deleteUser(user);
				}else{
					user.setPassword(user.getConfirmPassword());
					isSuccess = userMgnBl.updateUser(user);
				}
				User loggedUser = userMgnBl.getUser(user.getEmail(), user.getPassword())!=null?userMgnBl.getUser(user.getEmail(), user.getPassword()):new User();
				session.setAttribute("userInfo", loggedUser);
				System.out.println("isSuccess  " + isSuccess);
				
				/*new ImageValidate().validate(user, results);
				if (!results.hasErrors()) {
					ImageUpload.uploadFile(request, user.getFile(), user.getImage(), 0);
					if (isDelete) {
						userMgnBl.deleteUser(user);
					} else {
						userMgnBl.updateUser(user);
					}
					log.debug("Info | Sucessfully added");
				} else {
					log.debug("Info | There are some validation errors");
				}*/

			} else {
				throw new Exception("Data Fetching Error");
			}

			log.debug("Left | edit");
			return "redirect:/User/singIn";
			//return "index";
		} catch (Exception e) {
			log.debug("Exception : " + e);
			return "index";
		}
	}

	/*
	 * @ModelAttribute("user") public User modelUser(HttpServletRequest request)
	 * { HttpSession session = request.getSession(); boolean isLog =
	 * session.getAttribute("loggedUser") != null ? (boolean)
	 * session.getAttribute("loggedUser") : false; if (isLog) { loggedUser =
	 * session.getAttribute("userInfo") != null ? (User)
	 * (session.getAttribute("userInfo")) : new User(); } return loggedUser; }
	 * 
	 * @ModelAttribute("vehicle") public Vehicle modelVehicle() { return
	 * vehicel; }
	 * 
	 * @ModelAttribute("statusList") public List statusList() { statuslist = new
	 * ArrayList(); statuslist.add("ACTIVE"); statuslist.add("INACTIVE"); return
	 * statuslist; }
	 * 
	 * @ModelAttribute("roleList") public List roleList() { List<String>
	 * rTypelist = new ArrayList(); rTypelist.add("ADMIN");
	 * rTypelist.add("SUPPLIER"); rTypelist.add("CUSTOMER"); return rTypelist; }
	 * 
	 * @ModelAttribute("vehicleTypeList") public List vehicleTypeList() {
	 * vTypelist = new ArrayList(); vTypelist.add("BUS"); vTypelist.add("VAN");
	 * vTypelist.add("CAR"); vTypelist.add("THREE WEELER"); return vTypelist; }
	 */
}

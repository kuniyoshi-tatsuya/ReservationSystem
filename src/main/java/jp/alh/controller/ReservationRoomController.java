package jp.alh.controller;


import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.alh.dto.LocationDto;
import jp.alh.dto.ReservationDto;
import jp.alh.dto.TimeDto;
import jp.alh.dto.UserDto;
import jp.alh.form.DateForm;
import jp.alh.form.ReservationForm;
import jp.alh.service.LocationService;
import jp.alh.service.ReservationService;
import jp.alh.service.TimeService;

@Controller
public class ReservationRoomController {
	
	@Autowired
	LocationService locationService;
	@Autowired
	TimeService timeService;
	@Autowired
	ReservationService reservationService;
	
    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public String reservation(Model model, @ModelAttribute DateForm dateForm, @PathVariable int id, HttpSession session) {
    	
    	LocationDto location = locationService.getSelectedLocation(id);
    	UserDto loginUser = (UserDto)session.getAttribute("loginUser");
    	List<ReservationDto> reservations = reservationService.getAllReservation();
    	List<String> minutes = timeService.getAllTime().stream().map(TimeDto::getMinutes).collect(Collectors.toList());
    	ReservationForm reservationForm = new ReservationForm();
    	    	
    	reservationForm.setUserId(String.valueOf(loginUser.getId()));
    	reservationForm.setLocationId(String.valueOf(id));
    	reservationForm.setReservedDate(dateForm.getSelectedDate());
    	
    	model.addAttribute("location", location);
    	model.addAttribute("loginUser", loginUser);
    	model.addAttribute("minutes", minutes);
    	model.addAttribute("reservationForm", reservationForm);
    	model.addAttribute("reservations", reservations);
    	
        return "reservation";
    }
    
    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.POST)
    public String reservation(Model model, @ModelAttribute ReservationForm reservationForm) {
    	
    	reservationService.registerReservation(reservationForm);
    	
        return "redirect:/home";
    }
    
    
}
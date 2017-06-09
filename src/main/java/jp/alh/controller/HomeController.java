package jp.alh.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.alh.dto.LocationDto;
import jp.alh.form.DateForm;
import jp.alh.service.LocationService;

@Controller
public class HomeController {
	
	@Autowired
	private LocationService locationService;
		
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute DateForm dateForm) throws ParseException{
    	
    	DateForm aroundDate = getAroundDate(dateForm);
    	List<LocationDto> locationsDto = locationService.getAllLocation();
    	
    	model.addAttribute("aroundDate", aroundDate);
    	model.addAttribute("selectedDate", aroundDate.getSelectedDate());
    	model.addAttribute("locations", locationsDto);
    	
        return "home";
    }
    
    public DateForm getAroundDate(DateForm dateForm) throws ParseException{
    	
    	DateForm aroundDate = new DateForm();
    	Date date = new Date();
    	DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    	Calendar calendar = Calendar.getInstance();
    	
    	if(dateForm == null) calendar.setTime(date);
    	else if(dateForm.getPreviousDate() != null) calendar.setTime(format.parse(dateForm.getPreviousDate()));
    	else if(dateForm.getNextDate() != null) calendar.setTime(format.parse(dateForm.getNextDate()));
    	
    	aroundDate.setSelectedDate(format.format(calendar.getTime())); //selectedDate
    	
    	calendar.add(Calendar.DATE, -1);
    	aroundDate.setPreviousDate(format.format(calendar.getTime())); //previousDate
    	
    	calendar.add(Calendar.DATE, 2);
    	aroundDate.setNextDate(new SimpleDateFormat("yyyy/MM/dd").format(calendar.getTime())); //nextDate
    	
    	return aroundDate;
    }
    
}
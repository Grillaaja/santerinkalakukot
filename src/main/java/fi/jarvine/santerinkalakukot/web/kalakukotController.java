package fi.jarvine.santerinkalakukot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.jarvine.santerinkalakukot.domain.KalakukkoRepository;

@Controller
public class kalakukotController {
	
	@Autowired
	private KalakukkoRepository kkrepository;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		return "frontpage";
	}
	
	@RequestMapping(value="/testi", method = RequestMethod.GET)
	public String testi() {
		return "testi";
	}
	
	@RequestMapping(value="/listentities", method = RequestMethod.POST)
	public String listing(Model model) {
		model.addAttribute("kalakukot", kkrepository.findAll());
		return "listentities";
	}
	
}

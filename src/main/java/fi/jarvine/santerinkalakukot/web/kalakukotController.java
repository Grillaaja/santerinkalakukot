package fi.jarvine.santerinkalakukot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.jarvine.santerinkalakukot.domain.Kalakukko;
import fi.jarvine.santerinkalakukot.domain.KalakukkoRepository;
import fi.jarvine.santerinkalakukot.domain.SpecieRepository;

@Controller
public class kalakukotController {
	
	@Autowired
	private KalakukkoRepository kkrepository;
	@Autowired
	private SpecieRepository srepository;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		return "frontpage";
	}
	
	@RequestMapping(value="/testi", method = RequestMethod.GET)
	public String testi() {
		return "testi";
	}
	
	@RequestMapping(value="/listentities", method = RequestMethod.GET)
	public String listing(Model model) {
		model.addAttribute("kalakukot", kkrepository.findAll());
		return "listentities";
	}
	
	@RequestMapping(value="/map/{id}", method = RequestMethod.GET)
	public String showMap(@PathVariable("id") Long kalakukkoId, Model model) {
		model.addAttribute("kalakukko", kkrepository.findById(kalakukkoId));
		return "geomap";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteEntity(@PathVariable("id") Long kalakukkoId, Model model){
		kkrepository.deleteById(kalakukkoId);
		return "redirect:../listentities";
	}
	
	@RequestMapping(value = "/add")
	public String addEntity(Model model) {
		model.addAttribute("kalakukko", new Kalakukko());
		model.addAttribute("species", srepository.findAll());
		return "addentity";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Kalakukko kalakukko) {
		kkrepository.save(kalakukko);
		return "redirect:listentities";
	}
	
}

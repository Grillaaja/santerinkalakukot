package fi.jarvine.santerinkalakukot.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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
	
	@RequestMapping(value = "/fishcocks", method = RequestMethod.GET)
	public @ResponseBody List<Kalakukko> entityListRest(){
		return(List<Kalakukko>) kkrepository.findAll();
	}
	
	@RequestMapping(value = "/entity/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Kalakukko> findEntityRest(@PathVariable("id") Long entityId){
		return kkrepository.findById(entityId);
	}
	
	@RequestMapping(value="/map/{id}", method = RequestMethod.GET)
	public String showMap(@PathVariable("id") Long kalakukkoId, Model model) {
		model.addAttribute("kalakukko", kkrepository.findById(kalakukkoId).get());
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
		kalakukko.setLinkki("https://www.latlong.net/c/?lat=" + kalakukko.getLatitude() + "&long=" + kalakukko.getLongitude());
		kkrepository.save(kalakukko);
		return "redirect:listentities";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editEntity(@PathVariable("id") Long entityId, Model model){
		model.addAttribute("kalakukko", kkrepository.findById(entityId));
		model.addAttribute("species", srepository.findAll());
		return "editentity";
	}
	
}

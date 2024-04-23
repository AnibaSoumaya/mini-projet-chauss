package com.soumaya.chaussures.controllers;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soumaya.chaussures.entities.Chaussure;
import com.soumaya.chaussures.service.ChaussureService;

@Controller
public class ChaussureController {

	@Autowired
	ChaussureService chaussureService;
	@RequestMapping("/ListeChaussures")
	public String listeProduits(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Chaussure> chausss = chaussureService.getAllChaussuresParPage(page, size);
	modelMap.addAttribute("chaussures", chausss);
	modelMap.addAttribute("pages", new int[chausss.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeChaussures";
	}
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createChaussure";
	}
	@RequestMapping("/saveChaussure")
	public String saveProduit(@ModelAttribute("chaussure") Chaussure chaussure,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date));
	chaussure.setDateCreation(dateCreation);
	Chaussure saveProduit = chaussureService.saveChaussure(chaussure);
	String msg ="chaussure enregistré avec Id "+saveProduit.getIdChaussure();
	modelMap.addAttribute("msg", msg);
	return "createChaussure";
	}
	@RequestMapping("/supprimerChaussure")
	public String supprimerChaussure(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	
	{
		chaussureService.deleteChaussureById(id);
		Page<Chaussure> chausss = chaussureService.getAllChaussuresParPage(page, size);
		modelMap.addAttribute("chaussures", chausss);
		modelMap.addAttribute("pages", new int[chausss.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeChaussures";
	}
	@RequestMapping("/modifierChaussure")
	public String editerChaussure(@RequestParam("id") Long id,
	ModelMap modelMap)
	{
		Chaussure c= chaussureService.getChaussure(id);
	modelMap.addAttribute("chaussure", c);
	return "editerChaussure";
	}
	@RequestMapping("/updateChaussure")
	public String updateChaussure(@ModelAttribute("chaussure") Chaussure
	chaussure, @RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date));
	chaussure.setDateCreation(dateCreation);
	chaussureService.updateChaussure(chaussure);
	List<Chaussure> chausss = chaussureService.getAllChaussures();
	modelMap.addAttribute("chaussures", chausss);
	return "listeChaussures";
	}
}

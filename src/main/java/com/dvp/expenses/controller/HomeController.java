package com.dvp.expenses.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dvp.expenses.model.ExpenseReport;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@PersistenceContext
	EntityManager em;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Secured("ROLE_USER")
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "expenses";
	}
	
	@RequestMapping(value="/expense", method=RequestMethod.GET)
	public ModelAndView expenses(ModelAndView mv) {
		Query qry = em.createQuery("select e from ExpenseReport e");
		@SuppressWarnings("unchecked")
		List<ExpenseReport> result = qry.getResultList();
		mv.addObject("reports", result);
		mv.setViewName("expenses");
		
		return mv;
	}
}


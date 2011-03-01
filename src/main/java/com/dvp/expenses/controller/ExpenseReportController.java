package com.dvp.expenses.controller;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dvp.expenses.model.ExpenseLine;
import com.dvp.expenses.model.ExpenseReport;
import com.jesper.music.model.Album;

@Controller
public class ExpenseReportController {

	
	private static final Logger logger = LoggerFactory.getLogger(ExpenseReportController.class);
	
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@ModelAttribute("expensereport")
	public ExpenseReport init(@PathVariable String id) {
		if(id.equals("new")) {
			return new ExpenseReport();
		}
		ExpenseReport er;
		TypedQuery<ExpenseReport> qry = em.createQuery("select e From ExpenseReport e, IN(e.lines) l where e.Id = :id", ExpenseReport.class);
		qry.setParameter("id",id);
		try {
			er = qry.getSingleResult();
		}
		catch(NoResultException nrex) {
			er = em.find(ExpenseReport.class, id);
		}
		er.getLines();
		return er;//em.find(ExpenseReport.class, id);
	}
	
	@RequestMapping(value="/expense/{id}", method=RequestMethod.GET)
	public ModelAndView expensedetail(ModelAndView mv, @ModelAttribute ExpenseReport expensereport) {
		mv.addObject(expensereport);
		mv.setViewName("expensereport_detail");
		return mv;
	}
	
	@Transactional
	@RequestMapping(value="/expense/{id}", method=RequestMethod.POST)
	public String saveExpense(ModelAndView mv, @ModelAttribute ExpenseReport expensereport) {
		if(expensereport.getId().equals("") || expensereport.getId() == null) {
			em.persist(expensereport);
			expensereport = em.merge(expensereport); //getting back the autogenerated id
		}
		else {
			ExpenseReport expr = em.find(ExpenseReport.class, expensereport.getId());
			expr.setName(expensereport.getName());
			expr.setReportDate(expensereport.getReportDate());
			em.merge(expr);	
		}
		return "redirect:/expense/"+expensereport.getId();
	}
	
	@Transactional
	@RequestMapping(value="/expense/{id}/delete", method=RequestMethod.GET)
	public String deleteReport(ModelAndView mv, @PathVariable String id) {
		ExpenseReport er = em.find(ExpenseReport.class, id);
		em.remove(er);
		return "redirect:/expense/";
	}
	
}
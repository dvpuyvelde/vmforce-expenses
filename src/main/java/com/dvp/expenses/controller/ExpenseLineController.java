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


@Controller
public class ExpenseLineController {

	@PersistenceContext
	EntityManager em;
	
	private static final Logger logger = LoggerFactory.getLogger(ExpenseReportController.class);
	
	@ModelAttribute
	public ExpenseLine newLine() {
		return new ExpenseLine();
	}
	ExpenseReport er;
	
	@RequestMapping(value="/expenselines/{reportid}", method=RequestMethod.GET)
	public ModelAndView showlines(ModelAndView mv,@PathVariable String reportid, @ModelAttribute ExpenseLine newline) {
		List<ExpenseLine> lines;
		//Query qry = em.createQuery("select e from ExpenseLine e where e.expenseReport.id =:reportid").setParameter("reportid", reportid);
		
		/**TypedQuery<ExpenseReport> qry = em.createQuery("select e From ExpenseReport e, IN(e.lines) l where e.Id = :id", ExpenseReport.class);
		qry.setParameter("id",reportid);
		try {
			er = qry.getSingleResult();
		}
		catch(NoResultException nrex) {
			er = em.find(ExpenseReport.class, reportid);
		}**/
		
		er = em.find(ExpenseReport.class, reportid);
		mv.addObject("er",er);
		lines = er.getLines();//qry.getResultList();
		mv.addObject("lines", lines);
		mv.addObject("newline", newline);
		mv.setViewName("expenselinesdetail");
		return mv;
	}
	
	@Transactional
	@RequestMapping(value="/expenselines/{reportid}", method=RequestMethod.POST)
	public String addline(ModelAndView mv, @ModelAttribute ExpenseLine line) {
		line.setExpenseReport(er);		
		em.persist(line);
		return "redirect:/expense/"+er.getId();
	}
	
	@Transactional
	@RequestMapping(value="/expenselines/{lineid}/delete", method=RequestMethod.GET)
	public String deleteline(ModelAndView mv, @PathVariable String lineid) {
		ExpenseLine l = em.find(ExpenseLine.class, lineid);
		em.remove(l);
		return "redirect:/expense/"+er.getId();
	}
	
}

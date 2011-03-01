package com.dvp.expenses.model;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.FetchGroup;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class ExpenseReport {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String Id;
	private String Name;
	@DateTimeFormat(iso=ISO.DATE)
	private Date reportDate;
	@OneToMany(mappedBy="expenseReport", fetch=FetchType.EAGER, cascade={CascadeType.REMOVE})
	private List<ExpenseLine> lines;
	
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public List<ExpenseLine> getLines() {
		return lines;
	}
	public void setLines(List<ExpenseLine> lines) {
		this.lines = lines;
	}
	
	
	
}

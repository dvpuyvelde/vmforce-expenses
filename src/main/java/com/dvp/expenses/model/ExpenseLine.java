package com.dvp.expenses.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class ExpenseLine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String Id;
	private String name;
	
	@DateTimeFormat(iso=ISO.DATE)
	private Date expenseDate;
	private String description;
	private Double amount;
	
	@ManyToOne
	private ExpenseReport expenseReport;
	
	public ExpenseReport getExpenseReport() {
		return expenseReport;
	}
	public void setExpenseReport(ExpenseReport expenseReport) {
		this.expenseReport = expenseReport;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}

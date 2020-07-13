package moneytap.billshare.controller;

import moneytap.billshare.Service.ExpenseService;
import moneytap.billshare.conversion.ExpensetoExpesnseForm;
import moneytap.billshare.model.Expenses;
import moneytap.billshare.model.ExpensesForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ExpenseController {
    private ExpenseService expenseService;
    private ExpensetoExpesnseForm expensetoExpesnseForm;
    @Autowired
    public void setExpenseService(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @Autowired
    public void setExpensetoExpesnseForm(ExpensetoExpesnseForm expensetoExpesnseForm) {
        this.expensetoExpesnseForm = expensetoExpesnseForm;
    }
    @RequestMapping({"/expenses/list", "/expenses"})
    public String listExpenses(Model model){
        model.addAttribute("Expenses", expenseService.listall());
        return "expense/list";
    }
    @RequestMapping("expenses/add")
    public String addExpense(Model model){
        model.addAttribute("ExpenseForm",new ExpensesForm());
        return "expense/expenseForm";
    }
    @RequestMapping(value = "/expenses",method = RequestMethod.POST)
    public String saveExpenseForm(@Valid ExpensesForm expensesForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "expense/expenseForm";
        }
        Expenses savedExpenses =expenseService.saveExpenseForm(expensesForm);
        return "redirect:/expense/show/" + savedExpenses.getId();
    }

    @RequestMapping("expense/show/{id}")
    public String getExpenses(@PathVariable String id,Model model){
        model.addAttribute("Expenses",expenseService.getById(Integer.valueOf(id)));
        return "expense/show";
    }
}

package moneytap.billshare.conversion;

import moneytap.billshare.model.Expenses;
import moneytap.billshare.model.ExpensesForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExpensetoExpesnseForm implements Converter<Expenses, ExpensesForm> {
    @Override
    public ExpensesForm convert(Expenses expenses){
        ExpensesForm expensesForm=new ExpensesForm();
        expensesForm.setId(expenses.getId());
        expensesForm.setExpense_details(expenses.getExpense_details());
        expensesForm.setPrice(expenses.getPrice());
        return expensesForm;
    }
}

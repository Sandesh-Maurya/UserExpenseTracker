package moneytap.billshare.conversion;

import moneytap.billshare.model.Expenses;
import moneytap.billshare.model.ExpensesForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
@Component
public class ExpenseFormtoExpense implements Converter<ExpensesForm, Expenses> {
    @Override
    public Expenses convert(ExpensesForm expensesForm){
        Expenses expenses=new Expenses();
        if(expensesForm.getId()!=null && !StringUtils.isEmpty(expensesForm.getId())){
            expenses.setId(new Integer(expensesForm.getId()));
        }
        expenses.setExpense_details(expensesForm.getExpense_details());
        expenses.setPrice(expensesForm.getPrice());
        return expenses;
    }
}

package moneytap.billshare.Service;

import moneytap.billshare.model.Expenses;
import moneytap.billshare.model.ExpensesForm;

import java.util.List;

public interface ExpenseService {
    List<Expenses> listall();
    Expenses getById(Integer id);
    Expenses save(Expenses expense);
//    Void Delete(Integer id);
    Expenses saveExpenseForm(ExpensesForm userEntry);
}

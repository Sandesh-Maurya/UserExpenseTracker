package moneytap.billshare.Service;

import moneytap.billshare.UserRepository.expense_repository;
import moneytap.billshare.conversion.ExpenseFormtoExpense;
import moneytap.billshare.model.Expenses;
import moneytap.billshare.model.ExpensesForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseServiceImp implements ExpenseService {
    private expense_repository Expense_Repo;
    private ExpenseFormtoExpense user_entry_expense;
    @Autowired
    public ExpenseServiceImp(expense_repository Expense_Repo, ExpenseFormtoExpense user_entry_expense) {
        this.Expense_Repo = Expense_Repo;
        this.user_entry_expense = user_entry_expense;
    }
    @Override
    public List<Expenses> listall(){
        List<Expenses> expenses=new ArrayList<>();
        Expense_Repo.findAll().forEach(expenses::add);
        return expenses;

    }
    @Override
    public Expenses getById(Integer id){
            return Expense_Repo.findById(id).orElse(null);

    }

    @Override
    public Expenses save(Expenses expense){
        Expense_Repo.save(expense);
        return expense;
    }
    @Override
    public Expenses saveExpenseForm(ExpensesForm expensesForm){
        Expenses saveExpense=save(user_entry_expense.convert(expensesForm));
        System.out.println("Expense id " +saveExpense.getId());
        return saveExpense;

    }
}

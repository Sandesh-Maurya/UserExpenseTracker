package moneytap.billshare.UserRepository;
import org.springframework.data.repository.CrudRepository;
import moneytap.billshare.model.Expenses;

public interface expense_repository extends CrudRepository<Expenses, Integer> {
}

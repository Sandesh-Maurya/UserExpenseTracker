package moneytap.billshare.model;

public class ExpensesForm {
    private Integer id;
    private Integer Price;
    private String expense_details;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public String getExpense_details() {
        return expense_details;
    }

    public void setExpense_details(String expense_details) {
        this.expense_details = expense_details;
    }
}

package task7;

public class Transaction {
	Integer Amount;
	String Category;
	
	public Transaction(Integer amount, String category) {
		Amount = amount;
		Category = category;
	}
	
	@Override
	public String toString() {
		return "Category: " + Category + ": " + Amount;
	}
	
	/*public String getCategory() {
		return Category;
	}
	
	public Integer getAmount() {
		return Amount;
	}*/
	
}

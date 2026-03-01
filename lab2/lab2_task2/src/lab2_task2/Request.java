package lab2_task2;

public class Request {
	int id;
	String question;
	
	public Request() {
		//id = 0;
		question = "";
	}
	
	public Request(int id, String question) {
		this.id = id;
		this.question = question;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", question=" + question + "]";
	}

	public String work() {
		String answer = "Absolutely useful answer to the request: id " + id;		
		return answer;
	}
}

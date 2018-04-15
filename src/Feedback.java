
public class Feedback {
	static int count=1;
int feedbackID;
String feedback;
public void read() {
	
}

public int getFeedbackID() {
	return feedbackID;
}
public void setFeedbackID() {
	
	this.feedbackID = count;
	count++;
}
public String getFeedback() {
	return feedback;
}
public void write(String feedback) {
	this.feedback = feedback;
	setFeedbackID();
}
}


public class ETeacher {
	public static void main (String[] args) {
		DbTeacher db = new DbTeacher();
		db.nextQuestion();
		System.out.println ("This is the random record: ");
		System.out.println(db.getAnswer());
		System.out.println(db.getQuestion());
	}

}

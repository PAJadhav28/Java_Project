

public class Answer
{
	static DatabaseInterface di;

	static
	{
		di=new DatabaseInterface();
	}

	public static boolean checkAnswer(Integer id,String ans)
	{
		boolean status=false;
		if(di.getAnswer(id.intValue()).equals(ans))
			status=true;
		return status;
	}
	static String checkAnswer(Integer id)
	{
		return di.getAnswer(id.intValue());
	}
	/*public static void main(String []args)
	{
		System.out.println(Answer.checkAnswer(new Integer(10)));
	}*/
}
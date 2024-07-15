


public class Question 
{
	int id;
	String question;
	String opt1;
	String opt2;
	String opt3;
	String opt4;
	String answer;

	public Question()
	{
		id=0;
		question=new String();
		opt1=new String();
		opt2=new String();
		opt3=new String();
		opt4=new String();
		answer=new String();
	}

	public void setID(int id)
	{
		this.id=id;
	}
	public void setQuestion(String question)
	{
		this.question=question;
	}
	public void setOption1(String opt1)
	{
		this.opt1=opt1;
	}
	public void setOption2(String opt2)
	{
		this.opt2=opt2;
	}
	public void setOption3(String opt3)
	{
		this.opt3=opt3;
	}
	public void setOption4(String opt4)
	{
		this.opt4=opt4;
	}
	public void setAnswer(String answer)
	{
		this.answer=answer;
	}
	public int getId()
	{
		return id;
	}
	public String getQuestion()
	{
		return question;
	}
	public String getOpt1()
	{
		return opt1;
	}
	public String getOpt2()
	{
		return opt2;
	}
	public String getOpt3()
	{
		return opt3;
	}
	public String getOpt4()
	{
		return opt4;
	}
	public String getAnswer()
	{
		return answer;
	}

	public String toString()
	{
		return("\n Question "+question+"\n 1 "+opt1+"\n 2 "+opt2+"\n 3 "+opt3+"\n 4 "+opt4);
	}
}


import javax.swing.*;

public class Timer extends Thread
{
	MathQuiz q = null;  
	
	Timer(MathQuiz in_q)
	{
		q = in_q;
	}
	
	public void run()
	{
		try
		{
			sleep(30000);
			q.setVisible(false);
			JOptionPane.showMessageDialog(null, "Your score is: " + q.getScore());
			
			System.exit(0);
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong");
		}
	}
}
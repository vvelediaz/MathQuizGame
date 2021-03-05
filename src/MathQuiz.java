import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import java.util.Calendar;

public class MathQuiz extends JFrame implements ActionListener, Runnable
{
	// Create all components
	private final int FRAME_WIDTH = 300, FRAME_HEIGHT = 500;
	private JButton one, two, three, four, five, six,
		seven, eight, nine, zero, negative, enter;
	private JPanel topPanel, middlePanel, bottomPanel;
	private JTextArea textArea;
	private String userAnswer = "";
	private int score = 0, rightAnswer = 0;
	
	// Create constructor
	MathQuiz()
	{
		// Set components of frame
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new GridLayout(3, 1));
		
		// Create the buttons and set listeners
		one = new JButton("1");
		one.setActionCommand("one");
		one.addActionListener(this);
		two = new JButton("2");
		two.setActionCommand("two");
		two.addActionListener(this);
		three = new JButton("3");
		three.setActionCommand("three");
		three.addActionListener(this);
		four = new JButton("4");
		four.setActionCommand("four");
		four.addActionListener(this);
		five = new JButton("5");
		five.setActionCommand("five");
		five.addActionListener(this);
		six = new JButton("6");
		six.setActionCommand("six");
		six.addActionListener(this);
		seven = new JButton("7");
		seven.setActionCommand("seven");
		seven.addActionListener(this);
		eight = new JButton("8");
		eight.setActionCommand("eight");
		eight.addActionListener(this);
		nine = new JButton("9");
		nine.setActionCommand("nine");
		nine.addActionListener(this);
		zero = new JButton("0");
		zero.setActionCommand("zero");
		zero.addActionListener(this);
		negative = new JButton("-");
		negative.setActionCommand("negative");
		negative.addActionListener(this);
		enter = new JButton("Enter");
		enter.setActionCommand("enter");
		enter.addActionListener(this);
		
		//Create and set JPanels
		topPanel = new JPanel();
		middlePanel = new JPanel();
		bottomPanel = new JPanel();
		
		topPanel.setLayout(new GridLayout(1, 1));
		middlePanel.setLayout(new GridLayout(2, 3));
		bottomPanel.setLayout(new GridLayout(2, 3));
		
		//Create JTextArea and set font
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 60));
		textArea.setEditable(false);
		
		//Add components to panel
		topPanel.add(textArea, BorderLayout.CENTER);
		middlePanel.add(seven);
		middlePanel.add(eight);
		middlePanel.add(nine);
		middlePanel.add(four);
		middlePanel.add(five);
		middlePanel.add(six);
		bottomPanel.add(one);
		bottomPanel.add(two);
		bottomPanel.add(three);
		bottomPanel.add(zero);
		bottomPanel.add(negative);
		bottomPanel.add(enter);
		
		//Add panels to frame
		add(topPanel);
		add(middlePanel);
		add(bottomPanel);
	}

	public void generateRandomProblem()
	{
		Random rand = new Random();
		int number = rand.nextInt(9) + 1;
		int number2 = rand.nextInt(9) + 1;
		int number3 = rand.nextInt(2);
		char operation = ' ';
		
		if(number3 == 0)
		{
			operation = '+';
			rightAnswer = number + number2;
		}	
		else
		{
			operation = '-';
			rightAnswer = number - number2;
		}
		String areaText = "" + number + " " + operation + " " + number2 + " = ";
		
		textArea.setText(areaText);
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void run()
	{
		generateRandomProblem();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("one"))
		{
			textArea.append("1");
			userAnswer = userAnswer + "1";	
		}
		if(e.getActionCommand().equals("two"))
		{
			textArea.append("2");
			userAnswer = userAnswer + "2";
		}
		if(e.getActionCommand().equals("three"))
		{
			textArea.append("3");
			userAnswer = userAnswer + "3";
		}
		if(e.getActionCommand().equals("four"))
		{
			textArea.append("4");
			userAnswer = userAnswer + "4";
		}
		if(e.getActionCommand().equals("five"))
		{
			textArea.append("5");
			userAnswer = userAnswer + "5";
		}
		if(e.getActionCommand().equals("six"))
		{
			textArea.append("6");
			userAnswer = userAnswer + "6";
		}
		if(e.getActionCommand().equals("seven"))
		{
			textArea.append("7");
			userAnswer = userAnswer + "7";	
		}
		if(e.getActionCommand().equals("eight"))
		{
			textArea.append("8");
			userAnswer = userAnswer + "8";
		}
		if(e.getActionCommand().equals("nine"))
		{
			textArea.append("9");
			userAnswer = userAnswer + "9";
		}
		if(e.getActionCommand().equals("zero"))
		{
			textArea.append("0");
			userAnswer = userAnswer + "0";
		}
		if(e.getActionCommand().equals("negative"))
		{
			textArea.append("-");
			userAnswer = userAnswer + "-";
		}
		if(e.getActionCommand().equals("enter"))
		{
			int userValue = new Integer(userAnswer);
			
			if (userValue == rightAnswer)
				score++;

			userAnswer = "";
			generateRandomProblem();
		}
	
	}
}
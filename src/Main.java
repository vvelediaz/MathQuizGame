/*
	Main class:
		. Create static JFrame startFrame
		. Create static MathQuiz quiz
		
		main method
			. Set startFrame size and properties with 2, 1 GridLayout
			. Make a new JButton that says "Go!"
			. Set button action command to "button" and to Main action listener
			. Create JPanels labelPanel and buttonPanel
			. Set labelPanel to Boxlayout and bottomPanel to FlowLayout
			. Create JLabels label1, label2, and label3 and set message using each label as a line
			. Add labels to labelPanel
			. Add button to buttonPanel
			. Add labelPanel and buttonPanel to startFrame and set visible to true
		
		actionPerformed mathod
			. Set startFrame visibility to false
			. Create new thread called timer with new Timer in constructor with quiz in Timer constructor
			. Create new thread called quizThread and set to quiz in thread constructor
			. Start quizThread and timer with start() method
	
	MathQuiz class
		. Extend JFrame and implement ActionListener and Runnable
		. Create private final int FRAME_WIDTH and FRAME_HEIGHT and set to 300
		. Create private JButtons one, two, three, four, five, six, seven, eight, 
			nine, zero, negative, and enter
		. Create private JPanels topPane;l, middlePanel, and bottomPanel
		. Create private JTextArea textArea
		. Create private String userAnswer and set to ""
		. Create private int score and rightAnswer and set to 0
		
		MathQuiz default constructor
			. Set frame properties with 3, 1 GridLayout
			. Create each number showing corresponding number and setting action command 
				to name of number and add them to action listener
			. Initialize topPanel, middlePanel, and bottomPanel
			. Set GridLayout with 1, 1 on topPanel, and 2, 3 on middlePanel and bottomPanel
			. Initialize textArea 
			. Set textArea font Arial, plain, size 60
			. Set textArea to non editable
			. Add textArea to topPanel
			. Add seven, eight, nine, four, five, and six to middlePanel in that order
			. Add one, two, three, zero negative, and enter to bottomPanel
			. Add topPanel, middlePanel, and bottomPanel to frame
		
		generateRandomProblem method
			. Create Random object called rand
			. Create ints number and number2 and set to randomNumber from 0 to 9
			. Set int number3 to either 1 or 0
			. Create char operation and set to ' '
			. If nummber3 is 0, set operation to '+' and set rightAnswer to number + number2
			. Else, set operation to '-' and rightAnswer to number - number2
			. Create String areaText and set to "" + number + " " + operation + " " + number2 + " = "
			. Set textArea to areaText
	
		getScore method
			. return score
	
		run method
			. Run generateRandomProblem method
			. Set frame visibilty to true
		
		actionPerformed method
			. If actioncommand is from a number button or "-", append corresponding number
				or "-" to textArea and userAnswer
			. If actioncommand is from enter button, create new integer userValue from userAnswer
			. If userValue is equal to rightAnswer, increment score by one
			. Set rightAnswer to ""
			. run generateRandomProblem method
	
	Timer class
		. Extend Thread
		. Create MathQuiz q and set to null
		
		Timer constructor with MathQuiz in_q in constructor
			. Set q equal to in_q
		
		run method
			. In try block, sleep for 30 seconds, set q visiblity to true, and show score using JOptionPane,
				exit program
			. In catch block, print to user something went wrong
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main implements ActionListener
{
	static JFrame startFrame = new JFrame();
	static MathQuiz quiz = new MathQuiz();
	
    public static void main(String[] args)
    {	
		startFrame.setSize(310, 300);
		startFrame.setLocationRelativeTo(null);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.setResizable(false);
		startFrame.setLayout(new GridLayout(2, 1));
		
		JButton button = new JButton("Go!");
		button.setActionCommand("button");	
		button.addActionListener(new Main());
		
		JPanel labelPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
		buttonPanel.setLayout(new FlowLayout());
		
		JLabel label1 = new JLabel("                  Welcome to the Math Quiz Game.", SwingConstants.CENTER);
		JLabel label2 = new JLabel("You'll answer simple math problems for 30 seconds.", SwingConstants.CENTER);
		JLabel label3 = new JLabel("          You'll be given a score after time runs out.", SwingConstants.CENTER);
		
		labelPanel.add(label1);
		labelPanel.add(label2);
		labelPanel.add(label3);
		buttonPanel.add(button);
		
		startFrame.add(labelPanel);
		startFrame.add(buttonPanel);
		startFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	startFrame.setVisible(false);
    	Thread timer = new Thread(new Timer(quiz));
    	Thread quizThread = new Thread(quiz);
    	
    	quizThread.start();
    	timer.start();
    }	
}
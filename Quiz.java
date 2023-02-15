package QuizApp;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Quiz implements ActionListener {


    String[] questions = {
                            "Where's UNC located?",
                            "What is the mascot of UNC?",
                            "When was UNC established?",
                            "How many libraries does UNC have?",
                            "What's the biggest library in UNC?",
                            "What's the oldest building in UNC?",
                            "What's the signature structure in UNC?",
                            "Which athletics team has the most trophies?"
                         };
    String[][] options = {
                            {"US", "Ghana", "UK", "Russia"},
                            {"Ramses", "Bear", "Goat", "Hen"},
                            {"1798", "1789", "1732", "1745"},
                            {"9", "11", "12", "10"},
                            {"Public Health", "Davis", "UL", "Wilson"},
                            {"Old Well", "Old West", "Bell Tower", "Old East"},
                            {"Bell Tower", "Genome Science Building", "Old Well", "Wilson Library"},
                            {"Men Basketball", "Women Basketball", "Women Soccer", "Men Football"}
                         };
    char[] answers = {'A', 'A', 'B', 'D', 'B', 'D', 'C', 'C'};
    char guess;
    char answer;
    int index;
    int correct_guess = 0;
    int totalQuestions = questions.length;
    float result;
    int seconds = 10;
    int button_x = 30;
    int opt_Y_offset = 5;
    int optA_y = 150;
    int optB_y = 240;
    int optC_y = 330;
    int optD_y = 430;

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();

    JLabel answerLabelA = new JLabel();
    JLabel answerLabelB = new JLabel();
    JLabel answerLabelC = new JLabel();
    JLabel answerLabelD = new JLabel();
    JLabel secondsLeft = new JLabel();
    JTextField numberRight = new JTextField();
    JTextField percentage = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            secondsLeft.setText(String.valueOf(seconds));
            if (seconds <= 0){
                displayAnswer();
            }
        }
    });

    public Quiz(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(1, 51, 27));
        frame.setLayout(null);
        frame.setResizable(false);


        textField.setBounds(0, 0, 650, 50);
        textField.setBackground(new Color(0, 0, 0));
        textField.setForeground(new Color(4, 140, 25));
        textField.setFont(new Font("MV Bo", Font.BOLD, 40));
        textField.setBorder(BorderFactory.createBevelBorder(2));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        textField.setText("Question 1");

        textArea.setBounds(0, 50, 650, 70);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(255, 255, 255));
        textArea.setForeground(new Color(50, 50, 50));
        textArea.setFont(new Font("Serif", Font.BOLD, 30));
        textArea.setBorder(BorderFactory.createBevelBorder(2));
        textArea.setEditable(false);

        buttonA.setBounds(button_x, optA_y, 80, 80);
        buttonA.setFont(new Font("Ink Free", Font.BOLD, 30));
        buttonA.setFocusPainted(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(button_x, optB_y, 80, 80);
        buttonB.setFont(new Font("Ink Free", Font.BOLD, 30));
        buttonB.setFocusPainted(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(button_x, optC_y, 80, 80);
        buttonC.setFont(new Font("Ink Free", Font.BOLD, 30));
        buttonC.setFocusPainted(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(button_x, optD_y, 80, 80);
        buttonD.setFont(new Font("Ink Free", Font.BOLD, 30));
        buttonD.setFocusPainted(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answerLabelA.setBounds(button_x + 150, 140, 500, 100);
        answerLabelA.setBackground(new Color(1, 51, 27));
        answerLabelA.setForeground(new Color(6, 243, 26));
        answerLabelA.setFont(new Font("Serif", Font.PLAIN, 30));
        answerLabelA.setText("Testing label 1");

        answerLabelB.setBounds(button_x + 150, optB_y + opt_Y_offset, 500, 100);
        answerLabelB.setBackground(new Color(1, 51, 27));
        answerLabelB.setForeground(new Color(6, 243, 26));
        answerLabelB.setFont(new Font("Serif", Font.PLAIN, 30));
        answerLabelB.setText("Testing label 2");

        answerLabelC.setBounds(button_x + 150, optC_y + opt_Y_offset, 500, 100);
        answerLabelC.setBackground(new Color(1, 51, 27));
        answerLabelC.setForeground(new Color(6, 243, 26));
        answerLabelC.setFont(new Font("Serif", Font.PLAIN, 30));
        answerLabelC.setText("Testing label 3");

        answerLabelD.setBounds(button_x + 150,  optD_y + opt_Y_offset, 500, 100);
        answerLabelD.setBackground(new Color(1, 51, 27));
        answerLabelD.setForeground(new Color(16, 243, 26));
        answerLabelD.setFont(new Font("Serif", Font.PLAIN, 30));
        answerLabelD.setText("Testing label 4");

        secondsLeft.setBounds(555, 510, 90, 80);
        secondsLeft.setBackground(new Color(4, 35, 0));
        secondsLeft.setForeground(new Color(255, 0, 0));
        secondsLeft.setFont(new Font("Dialog", Font.BOLD, 30));
        secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));

        numberRight.setBounds(255, 255, 200, 100);
        numberRight.setBackground(new Color(50, 50, 50));
        numberRight.setForeground(new Color(50, 255, 0));
        numberRight.setFont(new Font("Dialog", Font.BOLD, 30));
        numberRight.setHorizontalAlignment(JTextField.CENTER);
        numberRight.setEditable(false);

        percentage.setBounds(245, 325, 220, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Dialog", Font.BOLD, 20));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);


//        frame.add(numberRight);
//        frame.add(percentage);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(answerLabelA);
        frame.add(answerLabelB);
        frame.add(answerLabelC);
        frame.add(answerLabelD);
        frame.add(secondsLeft);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();
    }

    public void nextQuestion(){
        if (index >= totalQuestions){
            results();
        }
        else{
            textField.setText("Question " + (index + 1));
            textArea.setText(questions[index]);
            answerLabelA.setText(options[index][0]);
            answerLabelB.setText(options[index][1]);
            answerLabelC.setText(options[index][2]);
            answerLabelD.setText(options[index][3]);
            timer.start();

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA){
            answer = 'A';
            if (answer == answers[index]){
                correct_guess++;
            }
        }
        if (e.getSource() == buttonB){
            answer = 'B';
            if (answer == answers[index]){
                correct_guess++;
            }
        }
        if (e.getSource() == buttonC){
            answer = 'C';
            if (answer == answers[index]){
                correct_guess++;
            }
        }
        if (e.getSource() == buttonD){
            answer = 'D';
            if (answer == answers[index]){
                correct_guess++;
            }
        }

        displayAnswer();
    }

    public void displayAnswer(){
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers[index] != 'A'){
            answerLabelA.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'B'){
            answerLabelB.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'C'){
            answerLabelC.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'D'){
            answerLabelD.setForeground(new Color(255, 0, 0));

        }

        Timer pause = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerLabelA.setForeground(new Color(25, 255, 0));
                answerLabelB.setForeground(new Color(25, 255, 0));
                answerLabelC.setForeground(new Color(25, 255, 0));
                answerLabelD.setForeground(new Color(25, 255, 0));

                answer = ' ';
                seconds = 10;
                secondsLeft.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;

                nextQuestion();

            }
        });

        pause.setRepeats(false);
        pause.start();

    }
    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = ((float)correct_guess / totalQuestions) * 100;

        textField.setText("RESULTS:");
        textArea.setText("");
        answerLabelA.setText("");
        answerLabelB.setText("");
        answerLabelC.setText("");
        answerLabelD.setText("");

//        numberRight.setText(correct_guess + "/" + totalQuestions);
        percentage.setText("You scored " + result + "%");

        frame.add(percentage);
//        frame.remove(buttonA);
//        frame.remove(buttonB);
//        frame.remove(buttonD);
//        frame.remove(buttonC);
//        frame.add(numberRight);

    }
}

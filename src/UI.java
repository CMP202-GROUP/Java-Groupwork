package src;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class UI extends Physics {
    // Shared components
    JFrame mainFrame;
    JLabel pageHeading;

    JTextField firstValue;
    JLabel firstValueLabel;

    JTextField secondValue;
    JLabel secondValueLabel;

    JTextField thirdValue;
    JLabel thirdValueLabel;

    JButton calculateBtn;

    // Functions
    Physics physics = new Physics();

    // Main page components
    JButton kineticBtn;
    JButton potentialBtn;
    JButton linearBtn;
    JButton workdoneBtn;

    // Result components
    JLabel resultLabel;
    JButton resultCloseBtn;

    final JPanel mainOptionPanel = new JPanel();

    // Kinetic page components
    final JPanel kineticPanel = new JPanel();

    // Potential page components
    final JPanel potentialPanel = new JPanel();

    // Linear page components
    final JPanel linearPanel = new JPanel();

    // Workdone page components
    final JPanel workdonePanel = new JPanel();

    // Result page components
    final JPanel resultPanel = new JPanel();

    public UI() {
        // Initialize the mainFrame
        mainFrame = new JFrame("Physics Calculator");
        mainFrame.setLayout(new GridLayout(2, 1));

        // Page heading
        pageHeading = new JLabel("Select calculation to perform", SwingConstants.CENTER);

        // Define components (3 buttons)
        kineticBtn = new JButton("Kinetic Energy");
        potentialBtn = new JButton("Potential Energy");
        linearBtn = new JButton("Linear Momentum");
        workdoneBtn = new JButton("Work Done");

        // Add components functionality
        kineticBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                KineticUI();
            }
        });

        potentialBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PotentialUI();
            }
        });

        linearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LinearUI();
            }
        });

        workdoneBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WorkdoneUI();
            }
        });

        // Add components to mainOptionsPanel
        mainOptionPanel.add(kineticBtn);
        mainOptionPanel.add(potentialBtn);
        mainOptionPanel.add(linearBtn);
        mainOptionPanel.add(workdoneBtn);

        // Add panels to the mainFrame
        mainFrame.add(pageHeading);
        mainFrame.add(mainOptionPanel);

        // Set mainFrame prefferences
        mainFrame.setPreferredSize(new Dimension(500, 200));
        mainFrame.pack();
        mainFrame.setResizable(false);

        // Display mainFrame
        mainFrame.setVisible(true);
    }

    // Display Kinetic page
    public void KineticUI() {
        // Hide mainOptionPanel & set new heading
        mainOptionPanel.setVisible(false);
        pageHeading.setText("Please provide values:");

        // Define components (3 textField & 1 Button)
        firstValueLabel = new JLabel("Mass (g)");
        firstValue = new JTextField("", 3);
        firstValue.setPreferredSize(new Dimension(5, 25));

        secondValueLabel = new JLabel("Velocity (m/s)");
        secondValue = new JTextField("", 3);
        secondValue.setPreferredSize(new Dimension(5, 25));

        calculateBtn = new JButton("CALCULATE");
        calculateBtn.setPreferredSize(new Dimension(120, 25));

        // Perform calculation
        calculateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String massString = firstValue.getText();
                Float mass = Float.parseFloat(massString);

                String velocityString = secondValue.getText();
                Float velocity = Float.parseFloat(velocityString);

                Float result = physics.getKineticEnergy(mass, velocity);

                ResultUI(result, "kinetic");
            }
        });

        // Add components to kineticPanel
        kineticPanel.add(firstValueLabel);
        kineticPanel.add(firstValue);

        kineticPanel.add(secondValueLabel);
        kineticPanel.add(secondValue);

        kineticPanel.add(calculateBtn);

        // Add kineticPanel to mainFrame
        kineticPanel.setLayout(new FlowLayout());
        mainFrame.add(kineticPanel);
        mainFrame.setLayout(new GridLayout(4, 1));

        // Display kineticPanel
        kineticPanel.setVisible(true);
    }

    // Display linear momentum page
    public void LinearUI() {
        // Hide mainOptionPanel & set new heading
        mainOptionPanel.setVisible(false);
        pageHeading.setText("Please provide values:");

        // Define components (3 textField & 1 Button)
        firstValueLabel = new JLabel("Mass (g)");
        firstValue = new JTextField("", 3);
        firstValue.setPreferredSize(new Dimension(5, 25));

        secondValueLabel = new JLabel("Velocity (m/s)");
        secondValue = new JTextField("", 3);
        secondValue.setPreferredSize(new Dimension(5, 25));

        calculateBtn = new JButton("CALCULATE");
        calculateBtn.setPreferredSize(new Dimension(120, 25));

        // Perform calculation
        calculateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String massString = firstValue.getText();
                Float mass = Float.parseFloat(massString);

                String velocityString = secondValue.getText();
                Float velocity = Float.parseFloat(velocityString);

                Float result = physics.getLinearMomentum(mass, velocity);

                ResultUI(result, "linear");
            }
        });

        // Add components to kineticPanel
        linearPanel.add(firstValueLabel);
        linearPanel.add(firstValue);

        linearPanel.add(secondValueLabel);
        linearPanel.add(secondValue);

        linearPanel.add(calculateBtn);

        // Add kineticPanel to mainFrame
        linearPanel.setLayout(new FlowLayout());
        mainFrame.add(linearPanel);
        mainFrame.setLayout(new GridLayout(4, 1));

        // Display kineticPanel
        linearPanel.setVisible(true);
    }

    // Display potential page
    public void PotentialUI() {

        // Hide mainOptionPanel & set new heading
        mainOptionPanel.setVisible(false);

        pageHeading.setText("Please provide values:");

        // Define components (3 textField & 1 Button)
        firstValueLabel = new JLabel("Mass (g)");
        firstValue = new JTextField("", 3);
        firstValue.setPreferredSize(new Dimension(5, 25));

        secondValueLabel = new JLabel("Height (m)");
        secondValue = new JTextField("", 3);
        secondValue.setPreferredSize(new Dimension(5, 25));

        calculateBtn = new JButton("CALCULATE");
        calculateBtn.setPreferredSize(new Dimension(120, 25));

        // Perform calculation
        calculateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String massString = firstValue.getText();
                Float mass = Float.parseFloat(massString);

                String heightString = secondValue.getText();
                Float height = Float.parseFloat(heightString);
                Float result = physics.getPotentialEnergy(mass, height);

                ResultUI(result, "potential");
            }
        });

        potentialPanel.setLayout(new FlowLayout());

        // Add components to potentialPanel
        potentialPanel.add(firstValueLabel);
        potentialPanel.add(firstValue);

        potentialPanel.add(secondValueLabel);
        potentialPanel.add(secondValue);

        potentialPanel.add(calculateBtn);

        // Add potentialPanel to mainFrame
        potentialPanel.setLayout(new FlowLayout());
        mainFrame.add(potentialPanel);
        mainFrame.setLayout(new GridLayout(4, 1));

        // Display potentialPanel
        potentialPanel.setVisible(true);
    }

    // Display workdone page
    public void WorkdoneUI() {

        // Hide mainOptionPanel & set new heading
        mainOptionPanel.setVisible(false);

        pageHeading.setText("Please provide values:");

        // Define components (3 textField & 1 Button)
        firstValueLabel = new JLabel("Mass (g)");
        firstValue = new JTextField("", 3);
        firstValue.setPreferredSize(new Dimension(5, 25));

        secondValueLabel = new JLabel("Acceleration (m/s^2)");
        secondValue = new JTextField("", 3);
        secondValue.setPreferredSize(new Dimension(5, 25));

        thirdValueLabel = new JLabel("Distance (m)");
        thirdValue = new JTextField("", 3);
        thirdValue.setPreferredSize(new Dimension(5, 25));

        calculateBtn = new JButton("CALCULATE");
        calculateBtn.setPreferredSize(new Dimension(120, 25));

        // Perform calculation
        calculateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String massString = firstValue.getText();
                Float mass = Float.parseFloat(massString);

                String accelerationString = secondValue.getText();
                Float acceleration = Float.parseFloat(accelerationString);

                String distanceString = thirdValue.getText();
                Float distance = Float.parseFloat(distanceString);
                Float result = physics.getWorkdone(mass, acceleration, distance);

                ResultUI(result, "Workdone");
            }
        });

        workdonePanel.setLayout(new FlowLayout());

        // Add components to workdonePanel
        workdonePanel.add(firstValueLabel);
        workdonePanel.add(firstValue);

        workdonePanel.add(secondValueLabel);
        workdonePanel.add(secondValue);

        workdonePanel.add(thirdValueLabel);
        workdonePanel.add(thirdValue);

        workdonePanel.add(calculateBtn);

        // Add workdonePanel to mainFrame
        workdonePanel.setLayout(new FlowLayout());
        mainFrame.add(workdonePanel);
        mainFrame.setLayout(new GridLayout(4, 1));

        // Display workdonePanel
        workdonePanel.setVisible(true);
    }

    // Display result page
    public void ResultUI(Float result, String invoker) {
        pageHeading.setText("Results:");

        if (invoker == "kinetic") {
            kineticPanel.setVisible(false);
            String stringResult = Float.toString(result) + " m/s square";
            resultLabel = new JLabel(stringResult);

        } else if (invoker == "potential") {
            potentialPanel.setVisible(false);
            String stringResult = Float.toString(result) + " Joules";
            resultLabel = new JLabel(stringResult);

        } else if (invoker == "linear") {
            linearPanel.setVisible(false);
            String stringResult = Float.toString(result) + " g m/s";
            resultLabel = new JLabel(stringResult);
        } else {
            workdonePanel.setVisible(false);
            String stringResult = Float.toString(result) + " Joules";
            resultLabel = new JLabel(stringResult);
        }

        resultCloseBtn = new JButton("CLOSE");
        resultPanel.add(resultLabel);
        resultPanel.add(resultCloseBtn);
        resultPanel.setLayout(new FlowLayout());
        mainFrame.add(resultPanel);
        mainFrame.setLayout(new GridLayout(5, 1));
    }
}

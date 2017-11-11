package initial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class DayOne extends JPanel implements ActionListener {
	private JLabel heightLabel = new JLabel("Height(Inches)");
	private JTextField heightField = new JTextField(4);

	private JLabel weightLabel = new JLabel("Weight(Pounds)");
	private JTextField weightField = new JTextField(4);

	private JLabel pushUpLabel = new JLabel("Push Ups");
	private JTextField pushUpField = new JTextField(4);

	private JLabel sitUpLabel = new JLabel("Sit Ups");
	private JTextField sitUpField = new JTextField(4);

	private JLabel runLabel = new JLabel("Run");
	private JLabel runDistanceLabel = new JLabel("Distance(Miles)");
	private JLabel runTimeLabel = new JLabel("Time(Minutes)");
	private JTextField runDistanceField = new JTextField(10);
	private JTextField runTimeField = new JTextField(10);

	private JLabel bmiLabel = new JLabel("Body Mass Index (BMI): ");;
	private JLabel bmiEvalLabel = new JLabel("");

	private JLabel recommendLabel = new JLabel("Recommendation for the First Week");
	private JLabel pushUpRecommendLabel = new JLabel("Push Ups: ");;
	private JLabel sitUpRecommendLabel = new JLabel("Sit Ups: ");;

	private JButton calculateButton = new JButton("Calculate");

	@Override
	public void actionPerformed(ActionEvent event){
		double height = Double.parseDouble(heightField.getText());
		double weight = Double.parseDouble(weightField.getText());
		double pushups = Integer.parseInt(pushUpField.getText());
		double situps = Integer.parseInt(sitUpField.getText());
		double distance = Double.parseDouble(runDistanceField.getText());
		double time = Double.parseDouble(runTimeField.getText());

		double bmi = (weight / (height * height)) * 703;

		if(bmi < 18.5) {
			bmiEvalLabel.setText("You are underweight");
			pushups *= 1.20;
			situps *= 1.20;
		}
		else if(bmi <= 24.9) {
			bmiEvalLabel.setText("Congratulations! You are within a healthy weight range.");
			pushups *= 1.15;
			situps *= 1.15;
		}
		else if(bmi <= 29.9) {
			bmiEvalLabel.setText("You are overweight");
			pushups *= 1.20;
			situps *= 1.20;
		}
		else {
			bmiEvalLabel.setText("You are obese");
			pushups *= 1.25;
			situps *= 1.25;
		}

		DecimalFormat value = new DecimalFormat("#.#");
		bmiLabel.setText("Body Mass Index (BMI): " + value.format(bmi));
		pushUpRecommendLabel.setText("Push Ups: " + (int)pushups);
		sitUpRecommendLabel.setText("Sit Ups: " + (int)situps);
	}

	public DayOne() {
		calculateButton.addActionListener(this);
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;

		add(heightLabel, gbc);
		gbc.gridy++;
		add(weightLabel, gbc);
		gbc.gridy++;
		add(pushUpLabel, gbc);
		gbc.gridy++;
		add(sitUpLabel, gbc);
		gbc.gridy++;
		add(runLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;

		add(heightField, gbc);
		gbc.gridy++;
		add(weightField, gbc);
		gbc.gridy++;
		add(pushUpField, gbc);
		gbc.gridy++;
		add(sitUpField, gbc);

		gbc.gridy++;
		gbc.gridwidth = 1;

		add(runDistanceField, gbc);
		gbc.gridy++;
		add(runDistanceLabel, gbc);
		gbc.gridx++;

		add(runTimeLabel, gbc);
		gbc.gridy--;
		add(runTimeField, gbc);

		gbc.gridx = 0;
		gbc.gridy += 2;
		gbc.gridwidth = 3;

		add(bmiLabel, gbc);
		gbc.gridy++;
		add(bmiEvalLabel, gbc);
		gbc.gridy++;
		add(recommendLabel, gbc);
		gbc.gridy++;
		add(pushUpRecommendLabel, gbc);
		gbc.gridy++;
		add(sitUpRecommendLabel, gbc);

		gbc.gridx = 2;
		gbc.gridy++;

		add(calculateButton, gbc);
	}
}

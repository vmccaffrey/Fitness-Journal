package initial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class DayOne extends JPanel implements ActionListener {
	private JLabel ageLabel = new JLabel("Age");
	private JTextField ageField = new JTextField(4);

	private JLabel sexLabel = new JLabel("Sex");
	private JTextField sexField = new JTextField(4);

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

	private double getPushupMax(int age, String sex) {
		sex = sex.toLowerCase();
		double maxMult = 2;
		int max = 71;

		if(sex.equals("male") || sex.equals("m")) {
			if (age <= 21) {
				max *= 1 * maxMult;
			}
			else if (age <= 26) {
				max *= 1.045 * maxMult;
			}
			else if (age <= 31) {
				max *= 1.09 * maxMult;
			}
			else if (age <= 36) {
				max *= 1.045 * maxMult;
			}
			else if (age <= 41) {
				max *= 1.02 * maxMult;
			}
			else if (age <= 50) {
				max *= 0.90 * maxMult;
			}
			else if (age <= 60) {
				max *= 0.75 * maxMult;
			}
			else if (age <= 70) {
				max *= 0.6 * maxMult;
			}
			else {
				max *= 0.5 * maxMult;
			}
		}
		else {
			max = 42;

			if (age <= 21) {
				max *= 1 * maxMult;
			}
			else if (age <= 26) {
				max *= 1.10 * maxMult;
			}
			else if (age <= 31) {
				max *= 1.20 * maxMult;
			}
			else if (age <= 36) {
				max *= 1.10 * maxMult;
			}
			else if (age <= 41) {
				max *= 0.95 * maxMult;
			}
			else if (age <= 50) {
				max *= 0.80 * maxMult;
			}
			else if (age <= 60) {
				max *= 0.60 * maxMult;
			}
			else if (age <= 70) {
				max *= 0.50 * maxMult;
			}
			else {
				max *= 0.40 * maxMult;
			}
		}

		return max;
	}

	private double getSitupMax(int age, String sex) {
		sex = sex.toLowerCase();
		double maxMult = 2;
		int max = 80;

		if(sex.equals("male") || sex.equals("m")) {
			if (age <= 21) {
				max *= 1 * maxMult;
			}
			else if (age <= 26) {
				max *= 1.02 * maxMult;
			}
			else if (age <= 31) {
				max *= 1.04 * maxMult;
			}
			else if (age <= 36) {
				max *= 0.96 * maxMult;
			}
			else if (age <= 41) {
				max *= 0.96 * maxMult;
			}
			else if (age <= 50) {
				max *= 0.88 * maxMult;
			}
			else if (age <= 60) {
				max *= 0.80 * maxMult;
			}
			else if (age <= 70) {
				max *= 0.75 * maxMult;
			}
			else {
				max *= 0.65 * maxMult;
			}
		}

		return max;
	}
	private double getRunningTimeMax(int age, String sex, double distance, double time) {
		sex = sex.toLowerCase();
		double maxMult = 0.7;
		double max = 6.5;
		double ageMult;

		if(sex.equals("male") || sex.equals("m")) {
			if (age <= 21) {
				ageMult = 1;
			}
			else if (age <= 26) {
				ageMult = 1;
			}
			else if (age <= 31) {
				ageMult = 1.025;
			}
			else if (age <= 36) {
				ageMult = 1.025;
			}
			else if (age <= 41) {
				ageMult = 1.05;
			}
			else if (age <= 50) {
				ageMult = 1.12;
			}
			else if (age <= 60) {
				ageMult = 1.20;
			}
			else if (age <= 70) {
				ageMult = 1.28;
			}
			else {
				ageMult = 1.35;
			}
		}
		else {
			max = 7.8;

			if (age <= 21) {
				ageMult = 1;
			}
			else if (age <= 26) {
				ageMult = 1;
			}
			else if (age <= 31) {
				ageMult = 1.02;
			}
			else if (age <= 36) {
				ageMult = 1.025;
			}
			else if (age <= 41) {
				ageMult = 1.07;
			}
			else if (age <= 50) {
				ageMult = 1.15;
			}
			else if (age <= 60) {
				ageMult = 1.25;
			}
			else if (age <= 70) {
				ageMult = 1.35;
			}
			else {
				ageMult = 1.55;
			}
		}
		max *= ageMult * maxMult;

		DecimalFormat two = new DecimalFormat(".##");
		System.out.println(time + "\n" + distance + "\n" + max + "\n" + maxMult + "\n" + max * distance);

		if(time / distance < max) {
			return Double.parseDouble(two.format(max * distance));
		}
		else {
			return  Double.parseDouble(two.format(time));
		}
	}

	@Override
	public void actionPerformed(ActionEvent event){
		int age = Integer.parseInt(ageField.getText());
		String sex = sexField.getText();
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

		if(pushups > getPushupMax(age, sex)) {
			pushups = getPushupMax(age, sex);
		}
		if(situps > getSitupMax(age, sex)) {
			situps = getSitupMax(age, sex);
		}

		time = getRunningTimeMax(age, sex, distance, time);
		runTimeField.setText(String.valueOf(time));

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


		add(ageLabel, gbc);
		gbc.gridy++;
		add(sexLabel, gbc);
		gbc.gridy++;
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


		add(ageField, gbc);
		gbc.gridy++;
		add(sexField,gbc);
		gbc.gridy++;
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

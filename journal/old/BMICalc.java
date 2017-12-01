//package old;
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author ASUS
// */
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//public class BMICalc extends javax.swing.JFrame {
//
//    /**
//     * Creates new form old.BMICalc
//     */
//
//
//     // Variables declaration
//    private JTextField distancerun;
//    private JTextField distancetime;
//    private JTextField height;
//    private JButton jButton1;
//    private JLabel weightLabel;
//    private JLabel heightLabel;
//    private JLabel situpLabel;
//    private JLabel pushupLabel;
//    private JLabel distanceRunLabel;
//    private JLabel distanceTimeLabel;
//    private JLabel jLabel7;
//    private JTextField pushups;
//    private JTextField result;
//    private JTextField situps;
//    private JTextField weight;
//    String Height, Weight, sit, push, distance, tim;
//    // End of variables declaration
//
//    public BMICalc() {
//        createcomp();
//    }
//
//
//    private void createcomp() {
//        weightLabel = new JLabel();
//        heightLabel = new JLabel();
//        situpLabel = new JLabel();
//        pushupLabel = new JLabel();
//        distanceRunLabel = new JLabel();
//        distanceTimeLabel = new JLabel();
//
//        weight = new  JTextField();
//        height = new  JTextField();
//        situps = new  JTextField();
//        pushups = new  JTextField();
//        distancerun = new JTextField();
//        distancetime = new JTextField();
//
//        jButton1 = new JButton();
//        jLabel7 = new JLabel();
//
//        result = new JTextField();
//
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        weightLabel.setText("Weight (Pounds)");
//
//        weight.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                weightActionPerformed(evt);
//            }
//        });
//
//        heightLabel.setText("Height (Inches)");
//
//        situpLabel.setText("Sit ups");
//
//        pushupLabel.setText("Push ups");
//
//        distanceRunLabel.setText("Distance run");
//
//        distanceTimeLabel.setText("Distance time");
//
//        jButton1.setText("Calculate BMI");
//        jButton1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                jButton1ActionPerformed(evt);
//            }
//        });
//
//        result.setEditable(false);
//
//        jLabel7.setText("BMI");
//
//        GroupLayout layout = new GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createSequentialGroup()
//                        .addGap(54, 54, 54)
//                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                            .addComponent(weightLabel)
//                            .addComponent(heightLabel)
//                            .addComponent(situpLabel)
//                            .addComponent(pushupLabel)
//                            .addComponent(distanceRunLabel)
//                            .addComponent(distanceTimeLabel))
//                        .addGap(45, 45, 45)
//                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
//                            .addComponent(weight, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
//                            .addComponent(height)
//                            .addComponent(situps)
//                            .addComponent(pushups)
//                            .addComponent(distancerun)
//                            .addComponent(distancetime))
//                        .addGap(0, 0, Short.MAX_VALUE))
//                    .addGroup(layout.createSequentialGroup()
//                        .addGap(115, 115, 115)
//                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
//                        .addGap(26, 26, 26)
//                        .addComponent(result, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
//                .addContainerGap())
//            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addGap(0, 0, Short.MAX_VALUE)
//                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
//                .addGap(51, 51, 51))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(28, 28, 28)
//                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(weightLabel)
//                    .addComponent(weight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                .addGap(23, 23, 23)
//                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(heightLabel)
//                    .addComponent(height, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                .addGap(29, 29, 29)
//                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(situpLabel)
//                    .addComponent(situps, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                .addGap(30, 30, 30)
//                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(pushupLabel)
//                    .addComponent(pushups, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                .addGap(20, 20, 20)
//                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(distanceRunLabel)
//                    .addComponent(distancerun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                .addGap(23, 23, 23)
//                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                    .addComponent(distanceTimeLabel)
//                    .addComponent(distancetime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addComponent(jLabel7)
//                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(jButton1)
//                    .addComponent(result, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                .addGap(23, 23, 23))
//        );
//
//        pack();
//    }// </editor-fold>
//
//    private void weightActionPerformed(ActionEvent evt) {
//
//    }
//
//    private void jButton1ActionPerformed(ActionEvent evt) {
//
//
//
//
//        Height = height.getText();
//        Weight = weight.getText();//declare the Height string with Jtext height
//        sit = situps.getText();
//        push = pushups.getText();
//        distance = distancerun.getText();
//        tim = distancetime.getText();
//
//        double number1 = Double.parseDouble(Height);
//        double number2 = Double.parseDouble(Weight);//exception may come out
//        double sit3 = Double.parseDouble(sit);
//        double push3 = Double.parseDouble(push);
//
//        double Bmi =number2*703/(number1*number1);
//
//        result.setText(Double.toString(Bmi));
//
//
//
//
//         JFrame frame=new JFrame();
//        frame.setMinimumSize(new Dimension(800, 600));
//        frame.setSize(800, 600);
//
//       if (Bmi>25)
//	{
//            System.out.println("\n\nYou are somewhat overweight.");
//            System.out.println("\n\nRecommendation of the Week");
//
//            push3 = push3*1.1f;
//            sit3 =  (int)(sit3*1.1);
//
//            JOptionPane.showMessageDialog(frame, "BMI = " + Bmi +  "\n\nBMI Evaluation"+  "\n\nYou are somewhat overweight." + "\n\nRecommendaton of the Week" + "\n\nPush up." + push + "number" + "\n\nSit up." + sit + "number");
//
//            System.out.println("\n\nPush up." + push + "number");
//            System.out.println("\n\nSit up." + sit + "number");
//            }
//
//
//          else if (Bmi<18.5)
//         {
//           System.out.println("\n\nYou are somewhat underweight.");
//           System.out.println("\n\nRecommendaton of the Week");
//
//             push3 = push3*0.8f;
//
//             sit3=(int) (sit3*0.8);
//
//             JOptionPane.showMessageDialog(frame, "BMI = " + Bmi +  "\n\nBMI Evaluation"+  "\n\nYou are somewhat underweight." + "\n\nRecommendaton of the Week" + "\n\nPush up." + push + "number" + "\n\nSit up." + sit + "number");
//
//           }
//
//        else if (Bmi>18.5 && Bmi <25)
//           {
//
//           System.out.println("\n\nCongratulations! You are within a healthy weight range.");
//
//             push3=push3*1.09f;
//             sit3= (int) (sit3*1.09);
//
//            System.out.println("\n\nRecommendaton of the Week");
//            System.out.println("\n\nPush up :" + push + " number");
//            System.out.println("\n\nSit up :" + sit + " number");
//
//            JOptionPane.showMessageDialog(frame, "BMI = " + Bmi +  "\n\nBMI Evaluation"+  "\n\nCongratulations! You are within a healthy weight range." + "\n\nRecommendaton of the Week" + "\n\nPush up." + push + "number" + "\n\nSit up." + sit + "number");
//
//            }
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//
//
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new BMICalc().setVisible(true);
//            }
//        });
//    }
//}

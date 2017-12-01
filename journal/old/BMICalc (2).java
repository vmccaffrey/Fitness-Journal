
import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue.*;
import java.awt.event.*;
public class BMICalc extends javax.swing.JFrame {

    /**
     * Creates new form BMICalc
     */


    // Variables declaration
    private JTextField distancerun;
    private JTextField distancetime;
    private JTextField yearage;
    private JTextField height;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;

    private JTextField pushups;
    private JTextField result;
    private JTextField situps;
    private JTextField weight;

    String Height, Weight, sit, push, distance, tim, age;
    // End of variables declaration

    public BMICalc() {
        createcomp();
    }


    private void createcomp() {

        jLabel1 = new JLabel();
        weight = new  JTextField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        height = new  JTextField();
        situps = new  JTextField();
        pushups = new  JTextField();
        distancerun = new JTextField();
        distancetime = new JTextField();
        yearage = new JTextField();//added
        jButton1 = new JButton();
        result = new JTextField();
        jLabel7 = new JLabel();
        jLabel8 =new  JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Weight (Pounds)");

        weight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                weightActionPerformed(evt);
            }
        });

        jLabel3.setText("Height (Inches)");

        jLabel4.setText("Sit ups");

        jLabel5.setText("Push ups");

        jLabel6.setText("Distance run");

        jLabel8.setText("Distance time");
        jLabel1.setText("Age");


        jButton1.setText("Calculate BMI");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        result.setEditable(false);

        jLabel7.setText("BMI");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel8))
                                                .addGap(45, 45, 45)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(weight, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                                        .addComponent(height)
                                                        .addComponent(situps)
                                                        .addComponent(pushups)
                                                        .addComponent(distancerun)
                                                        .addComponent(distancetime)
                                                        .addComponent(yearage) )
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(115, 115, 115)
                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(result, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(yearage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(weight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(height, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(situps, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(pushups, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(distancerun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(distancetime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(result, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>

    private void weightActionPerformed(ActionEvent evt) {

    }

    private void jButton1ActionPerformed(ActionEvent evt) {




        Height = height.getText();
        Weight = weight.getText();//declare the Height string with Jtext height
        sit = situps.getText();
        push = pushups.getText();
        distance = distancerun.getText();
        tim = distancetime.getText();
        age =yearage.getText();

        double number1 = Double.parseDouble(Height);
        double number2 = Double.parseDouble(Weight);//exception may come out
        int sit3 = Integer.parseInt(sit);
        int push3 = Integer.parseInt(push);

        int val_age = Integer.parseInt(age);

        double Bmi =number2*703/(number1*number1);

        result.setText(Double.toString(Bmi));




        JFrame frame=new JFrame();
        frame.setSize(1000, 600);

        if (Bmi>25)
        {

            double  push_rate=0;
            double  sit_rate=0;
            if (val_age<=35)//no change
            {
                push_rate= 1;
                sit_rate=1;
            }
            else if (val_age >= 35 && val_age<=53)
            {
                push_rate= 0.88;
                sit_rate=0.88;
            }
            else if (val_age >= 53)
            {
                push_rate= 0.71;
                sit_rate=0.71;
            }

            System.out.println("\n\nYou are somewhat overweight.");
            System.out.println("\n\nPlease set goals and focus on lifestyle.");
            System.out.println("\n\nEat more vegetables and fruits instead of high-calorie foods.");
            System.out.println("\n\nRecommendaton of the Week");




            push3 = (int)(push3*1.16*push_rate);
            sit3 =  (int)(sit3*1.16*sit_rate);

            JOptionPane.showMessageDialog(frame, "BMI = " + Bmi +  "\n\nBMI Evaluation"+  "\n\nYou are somewhat overweight." + "\n\nPlease set goals and focus on lifestyle." + "\n\nEat more vegetables and fruits instead of high-calorie foods." + "\n\nRecommendaton of the Week" + "\n\nPush up: " + push3 + " number" + "\n\nSit up: " + sit3 + " number" );

            System.out.println("\n\nPush up." + push3 + "number");
            System.out.println("\n\nSit up." + sit3 + "number");


        }


        else if (Bmi<18.5)
        {
            double  push_rate=0;
            double  sit_rate=0;
            if (val_age<=35)//no change
            {
                push_rate= 1;
                sit_rate=1;
            }
            else if (val_age >= 35 && val_age<=53)
            {
                push_rate= 0.87;
                sit_rate=0.87;
            }
            else if (val_age >= 53 )
            {
                push_rate= 0.68;
                sit_rate=0.68;
            }
            System.out.println("\n\nYou are somewhat underweight.");
            System.out.println("\n\nPlease set goals and focus on lifestyle.");
            System.out.println("\n\nTake more appropriate amount of protein and Calories.");
            System.out.println("\n\nRecommendaton of the Week");

            push3 = (int)(push3*0.83*push_rate);
            sit3=(int) (sit3*0.83*sit_rate);

            JOptionPane.showMessageDialog(frame, "BMI = " + Bmi +  "\n\nBMI Evaluation"+  "\n\nYou are somewhat underweight." + "\n\nPlease set goals and focus on lifestyle." + "\n\nTake more appropriate amount of protein and Calories." + "\n\nRecommendaton of the Week" + "\n\nPush up: " + push3 + " number" + "\n\nSit up: " + sit3 + " number");

        }

        else if (Bmi>18.5 && Bmi <25)
        {

            double  push_rate=0;
            double  sit_rate=0;
            if ( val_age<=35)//no change
            {
                push_rate= 1;
                sit_rate=1;
            }
            else if (val_age >= 35 && val_age<=53)
            {
                push_rate= 0.87;
                sit_rate=0.87;
            }
            else if (val_age >= 53 )
            {
                push_rate= 0.68;
                sit_rate=0.68;
            }

            System.out.println("\n\nCongratulations! You are within a healthy weight range.");
            System.out.println("\n\nPlease set goals and focus on lifestyle.");
            System.out.println("\n\nKeep healthy diet.");
            push3=(int) (push3*1.04*push_rate);
            sit3= (int) (sit3*1.04*sit_rate);

            System.out.println("\n\nRecommendaton of the Week");
            System.out.println("\n\nPush up :" + push3 + " number");
            System.out.println("\n\nSit up :" + sit3 + " number");

            JOptionPane.showMessageDialog(frame, "BMI = " + Bmi +  "\n\nBMI Evaluation"+  "\n\nCongratulations! You are within a healthy weight range." + "\n\nPlease set goals and focus on lifestyle." + "\n\nKeep healthy diet." + "\n\nRecommendaton of the Week" + "\n\nPush up: " + push3 + " number" + "\n\nSit up: " + sit3 + " number");

        }


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BMICalc().setVisible(true);
            }
        });
    }


}

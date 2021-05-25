import sun.plugin2.message.Message;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends JFrame {
    JTextField yearText;
    JTextField monthText;
    JTextField dayText;
    JTextArea txtMessage;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                   // frame.setVisible(true);
                    UIManager.setLookAndFeel(new org.jvnet.substance.skin.SubstanceAutumnLookAndFeel());

                    Client frame = new Client();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e);
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Client() {
        JFrame  jframe = new JFrame("The next Day");
        jframe.setSize(370,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        JPanel panel = new JPanel();
        jframe.add(panel);

        panel.setLayout(null);
        JLabel titleLabel = new JLabel("   请输入   年 月 日：");
        titleLabel.setBounds(60,10,200,25);
        titleLabel.setFont(new Font("黑体",Font.PLAIN,18));
        panel.add(titleLabel);

        JLabel yearLabel = new JLabel("年：");
        yearLabel.setBounds(65,40,80,25);
        yearLabel.setFont(new Font("黑体",Font.PLAIN,18));
        panel.add(yearLabel);

        yearText = new JTextField(20);
        yearText.setBounds(100,40,150,25);
        yearText.setFont(new Font("Times New Roman",Font.PLAIN,18));
        panel.add(yearText);

        JLabel monthLabel = new JLabel("月：");
        monthLabel.setBounds(65,70,80,25);
        monthLabel.setFont(new Font("黑体",Font.PLAIN,18));
        panel.add(monthLabel);

        monthText = new JTextField(20);
        monthText.setBounds(100,70,150,25);
        monthText.setFont(new Font("Times New Roman",Font.PLAIN,18));
        panel.add(monthText);

        JLabel dayLabel = new JLabel("日：");
        dayLabel.setBounds(65,100,80,25);
        dayLabel.setFont(new Font("黑体",Font.PLAIN,18));
        panel.add(dayLabel);

        dayText = new JTextField(20);
        dayText.setBounds(100,100,150,25);
        dayText.setFont(new Font("Times New Roman",Font.PLAIN,18));
        panel.add(dayText);

        JLabel txtLabel = new JLabel("下一天：");
        txtLabel.setBounds(30,130,80,25);
        txtLabel.setFont(new Font("黑体",Font.PLAIN,18));
        panel.add(txtLabel);

        txtMessage = new JTextArea();
        txtMessage.setBackground(Color.white);
        txtMessage.setBounds(100,130,150,25);
        txtMessage.setFont(new Font("黑体",Font.PLAIN,18));
        panel.add(txtMessage);

        JButton nextday = new JButton("NextDay");
        nextday.setBounds(30,170,110,30);
        nextday.setFont(new Font("Times New Roman",Font.PLAIN,17));
        panel.add(nextday);

        JButton Clean = new JButton("Clear");
        Clean.setBounds(160,170,100,30);
        Clean.setFont(new Font("Times New Roman",Font.PLAIN,18));
        panel.add(Clean);
         nextday.addActionListener(new buttonListener());
         Clean.addActionListener(new CleanListener());
        jframe.setVisible(true);
    }
    static String nextDay(int year,int month,int day){
        String s="";
        if(year>2050||year<1900)
        { s="错误！年份无效！";
        return s;
        }else if(month>12||month<1){
            s="错误！月份无效！";
            return s;
        }else if(day<1||day>31){
            s="错误！天数无效！";
            return s;
        }
        if(month == 1 ) {
            if(day == 1) {
                System.out.println("下一天"+year+"年"+month+"月"+(day+1)+"日");

                s=year+"年"+month+"月"+(day+1)+"日";
                return s;
            }else if(day == 31) {
                System.out.println("下一天"+year+"年"+(month+1)+"月"+"1日");
                s=year+"年"+(month+1)+"月"+"1日";
                return s;
            }else {
                System.out.println("下一天："+year+"年"+month+"月"+(day+1)+"日");
                s=year+"年"+month+"月"+(day+1)+"日";
                return s;
            }
        }else if(month == 4||month == 6|| month == 9 ||month == 11) {
            if(day == 1) {
                System.out.println("下一天"+year+"年"+month+"月"+(day+1)+"日");
                s=year+"年"+month+"月"+(day+1)+"日";
                return s;
            }else if(day == 30) {
                System.out.println("下一天"+year+"年"+(month+1)+"月"+"1日");
                s=year+"年"+(month+1)+"月"+"1日";
                return s;
            }else {
                System.out.println("下一天："+year+"年"+month+"月"+(day+1)+"日");
                s=year+"年"+month+"月"+(day+1)+"日";
                return s;
            }
        }else if(month == 2) {
            if(day>29)
            {
                s="错误！输入不合法!";
                return s;
            }
            if(year % 4 == 0 && year % 100 !=0 ||year % 400 ==0 ) {
                if(day == 1) {
                    System.out.println("下一天"+year+"年"+month+"月"+(day+1)+"日");
                    s=year+"年"+month+"月"+(day+1)+"日";
                    return s;
                }else if(day == 29) {
                    System.out.println("下一天"+year+"年"+(month+1)+"月"+"1日");
                    s=year+"年"+(month+1)+"月"+"1日";
                    return s;
                }else {
                    System.out.println("下一天"+year+"年"+month+"月"+(day+1)+"日");
                    s=year+"年"+month+"月"+(day+1)+"日";
                    return s;
                }
            }else {
                if(day == 1) {
                    System.out.println("下一天"+year+"年"+month+"月"+(day+1)+"日");
                    s=year+"年"+month+"月"+(day+1)+"日";
                    return s;
                }else if(day == 28) {
                    System.out.println("下一天"+year+"年"+(month+1)+"月"+"1日");
                    s=year+"年"+(month+1)+"月"+"1日";
                    return s;
                }else if(day==29){
                    s="错误!此年份不是闰年";
                    return s;
                } else{
                    System.out.println("下一天"+year+"年"+month+"月"+(day+1)+"日");
                    s=year+"年"+month+"月"+(day+1)+"日";
                    return s;
                }
            }

        }else if(month == 3) {
            if(day == 1) {
                if(year % 4 ==0 && year % 100 !=0||year % 400 ==0) {
                    System.out.println("下一天："+year+"年"+month+"月"+(day+1)+"日");
                    s=year+"年"+month+"月"+(day+1)+"日";
                    return s;
                }else {
                    System.out.println("下一天："+year+"年"+month+"月"+(day+1)+"日");
                    s=year+"年"+month+"月"+(day+1)+"日";
                    return s;
                }
            }else if(day == 31) {
                System.out.println("下一天："+year+"年"+(month+1)+"月"+"1日");
                s=year+"年"+(month+1)+"月"+"1日";
                return s;
            }else {
                System.out.println("下一天："+year+"年"+month+"月"+(day+1)+"日");
                s=year+"年"+month+"月"+(day+1)+"日";
                return s;
            }

        }else if(month == 5 || month == 7 || month == 10)  {
            if(day == 1) {
                System.out.println("下一天："+year+"年"+month+"月"+(day+1)+"日");
                s=year+"年"+month+"月"+(day+1)+"日";
                return s;
            }else if(day == 31) {
                System.out.println("下一天："+year+"年"+(month+1)+"月"+"1日");
                s=year+"年"+(month+1)+"月"+"1日";
                return s;
            }else {
                System.out.println("下一天："+year+"年"+month+"月"+(day+1)+"日");
                s=year+"年"+month+"月"+(day+1)+"日";
                return s;
            }
        }
        else if(month == 12) {
            if(day == 1) {
                System.out.println("下一天："+year+"年"+month+"月"+(day+1)+"日");
                s=year+"年"+month+"月"+(day+1)+"日";
                return s;
            }else if(day == 31) {
                System.out.println("下一天："+(year+1)+"年"+"1月"+"1日");
                s=(year+1)+"年"+"1月"+"1日";
                return s;
            }else {
                System.out.println("下一天："+year+"年"+month+"月"+(day+1)+"日");
                s=year+"年"+month+"月"+(day+1)+"日";
                return s;
            }
        }
        return " ";
    }

    class buttonListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
                int year = Integer.parseInt(yearText.getText());
                int month= Integer.parseInt(monthText.getText());
                int day = Integer.parseInt(dayText.getText());
                String nd = nextDay(year,month,day);
                txtMessage.setText(nd);
        }
    }
    class CleanListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            yearText.setText("");
            monthText.setText("");
            dayText.setText("");
            txtMessage.setText("");
        }
    }
}



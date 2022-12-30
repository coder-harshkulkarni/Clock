import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Frame extends JFrame {
    Calendar calendar;

    // reference link for SimpleDateFormat
    // https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#text :)
    SimpleDateFormat timeFormat = new SimpleDateFormat("hh : mm : ss  a");
    SimpleDateFormat dayFormat = new SimpleDateFormat(" EEEE ");
    SimpleDateFormat dateFormat = new SimpleDateFormat("d - M - y");
    JLabel timeLabel = new JLabel(); // JLabel for set time
    JLabel dayLabel = new JLabel(); // JLabel for set day
    JLabel dateLabel = new JLabel(); // JLabel for set date
    String time;
    String day;
    String date;

    Frame() {
        // Time label start
        timeLabel.setPreferredSize(new Dimension(450, 100));
        timeLabel.setFont(new Font("Chilanka", Font.BOLD, 50));
        timeLabel.setBackground(Color.ORANGE);
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        // Time label end

        // day label start
        dayLabel.setPreferredSize(new Dimension(450, 100));
        dayLabel.setFont(new Font("Chilanka", Font.ITALIC, 50));
        dayLabel.setBackground(Color.WHITE);
        dayLabel.setForeground(Color.BLUE);
        dayLabel.setOpaque(true);
        dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dayLabel.setVerticalAlignment(SwingConstants.CENTER);
        // day label end

        // date label start
        dateLabel.setPreferredSize(new Dimension(450, 100));
        dateLabel.setFont(new Font("Chilanka", Font.PLAIN, 50));
        dateLabel.setBackground(Color.GREEN);
        dateLabel.setOpaque(true);
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setVerticalAlignment(SwingConstants.CENTER);
        // date label end

        // adding components inside frame start
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        // adding components inside frame start

        // JFrame start
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Harsh Clock Application");
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        this.setSize(450, 320);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        // JFrame end

        setTime(); // call setTime method for updating time by 1000 millisecond
    }

    // setTime method update time, day and date by 1000 milliseconds
    // setTime method start
    public void setTime() {
        while (true) {
            // time string get current time from SimpleDateFormat
            // time string start
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            // time string end

            // day string get current day from SimpleDateFormat
            // day string start
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            // day string end

            // date string get current date from SimpleDateFormat
            // date string start
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            // date string end

            // Thread slow down the loop
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    // setTime method end

}

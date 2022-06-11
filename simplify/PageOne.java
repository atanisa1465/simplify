
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.net.*;
import java.text.SimpleDateFormat;

public class PageOne extends javax.swing.JPanel {
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private int complete = Main.user.getNumC();
    private int progress = Main.user.getNum();
    private javax.swing.JLabel longBreakLabel;
    private javax.swing.JTextField longBreakTime;
    private javax.swing.JButton pause;
    protected javax.swing.JPanel pomodoroPanel;
    private javax.swing.JTextField pomodoroTime;
    private javax.swing.JLabel pomodoroTimeLabel;
    private javax.swing.JButton reset;
    private javax.swing.JLabel shortBreakLabel;
    private javax.swing.JTextField shortBreakTime;
    private javax.swing.JButton start;
    private javax.swing.JLabel timeElapsed;
    private javax.swing.JLabel timerLabel;
    public User here;
    ArrayList<String> filesJava;
    Timer timer;
    int pomodoroNo;
    boolean paused;

    public PageOne(User u) {
        here = u;
        initComponents();
    }
             
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pomodoroPanel = new javax.swing.JPanel();

        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        pomodoroPanel = new javax.swing.JPanel();
        pomodoroTimeLabel = new javax.swing.JLabel();
        shortBreakLabel = new javax.swing.JLabel();
        longBreakLabel = new javax.swing.JLabel();
        pause = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        timerLabel = new javax.swing.JLabel();
        timeElapsed = new javax.swing.JLabel();
        pomodoroTime = new javax.swing.JTextField();
        shortBreakTime = new javax.swing.JTextField();
        longBreakTime = new javax.swing.JTextField();
        start = new javax.swing.JButton();

        pomodoroPanel.setBackground(new java.awt.Color(240, 251, 252));
        pomodoroPanel.setToolTipText("");

        pomodoroTimeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        pomodoroTimeLabel.setForeground(new java.awt.Color(0, 0, 0));
        pomodoroTimeLabel.setText("Pomodoro Time: ");

        shortBreakLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        shortBreakLabel.setForeground(new java.awt.Color(0, 0, 0));
        shortBreakLabel.setText("Short Break Time: ");

        longBreakLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); 
        longBreakLabel.setForeground(new java.awt.Color(0, 0, 0));
        longBreakLabel.setText("Long Break Time:");

        pause.setFont(new java.awt.Font("Lucida Grande", 0, 11)); 
        pause.setText("Pause");
        pause.setDoubleBuffered(true);
        pause.setEnabled(false);
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Lucida Grande", 0, 11)); 
        reset.setText("Reset");
        reset.setEnabled(false);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        timerLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); 
        timerLabel.setText("Timer: ");

        timeElapsed.setFont(new java.awt.Font("Lucida Grande", 0, 12)); 
        timeElapsed.setText("0:00:00");

        pomodoroTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pomodoroTime.setText("0:25:00");
        pomodoroTime.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        pomodoroTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pomodoroTimeActionPerformed(evt);
            }
        });

        shortBreakTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        shortBreakTime.setText("0:05:00");
        shortBreakTime.setFont(new java.awt.Font("Lucida Grande", 0, 12)); 

        longBreakTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        longBreakTime.setText("0:30:00");
        longBreakTime.setFont(new java.awt.Font("Lucida Grande", 0, 12)); 

        start.setFont(new java.awt.Font("Lucida Grande", 0, 11)); 
        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        JLabel[] labels = {jLabel8, jLabel9, jLabel10, jLabel11, jLabel12, jLabel13};
        ArrayList<JLabel> myLabels = new ArrayList<JLabel>();
        for (JLabel label : labels) { myLabels.add(label); }
        for (JLabel lab : myLabels) { lab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); }

        setBackground(new java.awt.Color(245, 247, 251));
        setDoubleBuffered(false);
        jPanel1.setBackground(new java.awt.Color(246, 232, 253));

        javax.swing.GroupLayout pomodoroPanelLayout = new javax.swing.GroupLayout(pomodoroPanel);
        pomodoroPanel.setLayout(pomodoroPanelLayout);

        pomodoroPanelLayout.setHorizontalGroup(
            pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pomodoroPanelLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pomodoroPanelLayout.createSequentialGroup()
                        .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pomodoroPanelLayout.createSequentialGroup()
                                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pomodoroTimeLabel)
                                    .addComponent(longBreakLabel)
                                    .addComponent(shortBreakLabel))
                                .addGap(30, 30, 30)
                                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(longBreakTime, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(shortBreakTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                        .addComponent(pomodoroTime, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(pomodoroPanelLayout.createSequentialGroup()
                                .addComponent(timerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timeElapsed)
                                .addGap(60, 60, 60)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pomodoroPanelLayout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addComponent(start)
                        .addGap(5, 5, 5)
                        .addComponent(pause)
                        .addGap(5, 5, 5)
                        //.addGap(18, 18, 18)
                        .addComponent(reset)
                        .addGap(40, 40, 40))))
        );

        pomodoroPanelLayout.setVerticalGroup(
            pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pomodoroPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pomodoroTimeLabel)
                    .addComponent(pomodoroTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shortBreakLabel)
                    .addComponent(shortBreakTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(longBreakLabel)
                    .addComponent(longBreakTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timerLabel)
                    .addComponent(timeElapsed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addGroup(pomodoroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(start)
                    .addComponent(reset)
                    .addComponent(pause))
                .addGap(0, 0, 0))
        );
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBackground(new java.awt.Color(252, 239, 255));
        jLabel8.setText("Humanities");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel18.setBackground(new java.awt.Color(254, 232, 233));
        jLabel11.setText("Life & Physical Sciences");
        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(41, 41, 41))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(24, 24, 24))
        );

        jPanel9.setBackground(new java.awt.Color(250, 242, 233));
        jLabel10.setText("English Language Arts");
        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(50, 50, 50))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(26, 26, 26))
        );

        jPanel22.setBackground(new java.awt.Color(218, 211, 253));
        jLabel9.setText("Mathematics");
        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(84, 84, 84))
        );

        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel9)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(214, 250, 221));
        jLabel13.setText("Life Skills");
        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(26, 26, 26))
        );

        jPanel20.setBackground(new java.awt.Color(214, 237, 250));
        jLabel12.setText("Personal Finances");
        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(63, 63, 63))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel12)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Learning Resources");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome " + here.firstName());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jButton6.setFont(new java.awt.Font("Lucida Grande", 0, 10)); 
        jButton6.setText("-");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Lucida Grande", 0, 10)); 
        jButton7.setText("+");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel6.setText("courses complete");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 60)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("" + here.getNumC());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );


        javax.swing.GroupLayout pomodoroTimeLayout = new javax.swing.GroupLayout(pomodoroTime);
        pomodoroTime.setLayout(pomodoroTimeLayout);
        pomodoroTimeLayout.setHorizontalGroup(
            pomodoroTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
        pomodoroTimeLayout.setVerticalGroup(
            pomodoroTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat();
                sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
                sdf.applyPattern("EEE, d MMM yyyy hh:mm:ss a");
                sdf.format(Calendar.getInstance().getTime());
                String time = sdf.format(new Date());
                jLabel3.setText(time);
            }
        }, 0, 1000);
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));


        ArrayList<String> images = new ArrayList<String>();
        // images.add("lib/pink.png");
        // images.add("lib/green.jpg");
        // images.add("lib/blue.jpg");

        images.add("lib/IMG-6039.jpg");
        images.add("lib/IMG-6037.JPG");
        images.add("lib/IMG-6036.JPG");

        String[] label14 = {"Fundamentals of<br>Digital Marketing", "Take the free Fundamentals<br>of Digital Marketing Course<br>offered by Google. "};
        String[] label15 = {"Artificial Intelligence<br>With Python", "Gain expertise in one<br>of the fastest-growing<br>domains of computer science"};
        String[] label16 = {"Machine Learning<br>for Healthcare", "Understand the intersection<br>between computer science<br>and healthcare"};
        String[] label17 = {"Leading Change in<br>Health Informatics", "Pivot your career in<br>the direction of big<br>data and health IT"};
        String[] label18 = {"Python Basics for<br>Data Science", "A beginner-friendly<br>introduction to Python<br>for Data Science"};
        String[] label19 = {"The Science of<br>Social Happiness", "Learn science-based<br>principles and practices for a<br>happy, meaningful life"};

        String[][] courses = {label14, label15, label16, label17, label18, label19};

        ImageIcon one = new ImageIcon(images.get(0));
        jLabel14 = new JLabel() {
            public void paintComponent(Graphics g) {
                g.drawImage(one.getImage(), 0, 0, null);
                super.paintComponent(g);
            }
        };
        jLabel14.setOpaque(false);
        jLabel18 = new JLabel() {
            public void paintComponent(Graphics g) {
                g.drawImage(one.getImage(), 0, 0, null);
                super.paintComponent(g);
            }
        };
        jLabel18.setOpaque(false);

        ImageIcon two = new ImageIcon(images.get(1));
        jLabel15 = new JLabel() {
            public void paintComponent(Graphics g) {
                g.drawImage(two.getImage(), 0, 0, null);
                super.paintComponent(g);
            }
        };
        jLabel15.setOpaque(false);
        jLabel19 = new JLabel() {
            public void paintComponent(Graphics g) {
                g.drawImage(two.getImage(), 0, 0, null);
                super.paintComponent(g);
            }
        };
        jLabel19.setOpaque(false);

        ImageIcon three = new ImageIcon(images.get(2));
        jLabel16 = new JLabel() {
            public void paintComponent(Graphics g) {
                g.drawImage(three.getImage(), 0, 0, null);
                super.paintComponent(g);
            }
        };
        jLabel16.setOpaque(false);
        jLabel17 = new JLabel() {
            public void paintComponent(Graphics g) {
                g.drawImage(three.getImage(), 0, 0, null);
                super.paintComponent(g);
            }
        };
        jLabel17.setOpaque(false);

        JLabel[] coursesList = {jLabel14, jLabel15, jLabel16, jLabel17, jLabel18, jLabel19};
        for (int i = 0; i < coursesList.length; i++) {
            coursesList[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            coursesList[i].setFont(new java.awt.Font("Lucida Grande", 1, 14));
            coursesList[i].setText("<html><body>"+ courses[i][0] +"</body></html>");
            coursesList[i].setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }

        jLabel14.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel14.setText("<html><body>" + courses[0][1]+"</body></html>");
                jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 12));
                jLabel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                try { Desktop.getDesktop().browse(new URI("https://learndigital.withgoogle.com/digitalgarage/course/digital-marketing")); } 
                catch (Exception e1) { }
            }
            public void mouseExited(MouseEvent evt) {
                jLabel14.setText("<html><body>" + courses[0][0]+"</body></html>");
                jLabel14.setFont(new java.awt.Font("Lucida Grande", 1, 14));
                jLabel14.setBorder(null);
            }
         });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel15.setText("<html><body>" + courses[1][1]+"</body></html>");
                jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 12));
                jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                try { Desktop.getDesktop().browse(new URI("https://pll.harvard.edu/course/cs50s-introduction-artificial-intelligence-python?delta=0")); } 
                catch (Exception e1) { }
            }
            public void mouseExited(MouseEvent evt) {
                jLabel15.setText("<html><body>" + courses[1][0]+"</body></html>");
                jLabel15.setFont(new java.awt.Font("Lucida Grande", 1, 14));
                jLabel15.setBorder(null);
            }
         });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel16.setText("<html><body>" + courses[2][1]+"</body></html>");
                jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 12));
                jLabel16.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                try { Desktop.getDesktop().browse(new URI("https://www.coursera.org/learn/fundamental-machine-learning-healthcare")); } 
                catch (Exception e1) {}
            }
            public void mouseExited(MouseEvent evt) {
                jLabel16.setText("<html><body>" + courses[2][0]+"</body></html>");
                jLabel16.setFont(new java.awt.Font("Lucida Grande", 1, 14));
                jLabel16.setBorder(null);
            }
         });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel17.setText("<html><body>" + courses[3][1]+"</body></html>");
                jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 12));
                jLabel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                try { Desktop.getDesktop().browse(new URI("https://www.coursera.org/learn/leading-change-health-informatics")); } 
                catch (Exception e1) { }
            }
            public void mouseExited(MouseEvent evt) {
                jLabel17.setText("<html><body>" + courses[3][0]+"</body></html>");
                jLabel17.setFont(new java.awt.Font("Lucida Grande", 1, 14));
                jLabel17.setBorder(null);
            }
         });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel18.setText("<html><body>" + courses[4][1]+"</body></html>");
                jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 12));
                jLabel18.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                try { Desktop.getDesktop().browse(new URI("https://www.edx.org/course/python-basics-for-data-science")); } 
                catch (Exception e1) {}
            }
            public void mouseExited(MouseEvent evt) {
                jLabel18.setText("<html><body>" + courses[4][0]+"</body></html>");
                jLabel18.setFont(new java.awt.Font("Lucida Grande", 1, 14));
                jLabel18.setBorder(null);
            }
         });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel19.setText("<html><body>" + courses[5][1]+"</body></html>");
                jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 12));
                jLabel19.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                try { Desktop.getDesktop().browse(new URI("https://www.coursera.org/learn/the-science-of-well-being")); } 
                catch (Exception e1) {}
            }
            public void mouseExited(MouseEvent evt) {
                jLabel19.setText("<html><body>" + courses[5][0]+"</body></html>");
                jLabel19.setFont(new java.awt.Font("Lucida Grande", 1, 14));
                jLabel19.setBorder(null);
            }
         });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(151, 132));

        jButton5.setFont(new java.awt.Font("Lucida Grande", 0, 10)); 
        jButton5.setText("-");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Lucida Grande", 0, 10)); 
        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("courses in progress");

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 0, 60)); 
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("" + here.getNum());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(225, 225, 225)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(pomodoroPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap(5, Short.MAX_VALUE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createSequentialGroup()
                        .addComponent(pomodoroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0))
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                //.addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try { Desktop.getDesktop().browse(new URI("https://www.khanacademy.org/humanities")); } 
                catch (Exception e1) { }
            }
        });
        jLabel9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try { Desktop.getDesktop().browse(new URI("https://www.khanacademy.org/math")); } 
                catch (Exception e1) { }
            }
        });
        jLabel10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try { Desktop.getDesktop().browse(new URI("https://www.khanacademy.org/ela")); } 
                catch (Exception e1) { }
            }
        });
        jLabel11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try { Desktop.getDesktop().browse(new URI("https://www.khanacademy.org/science")); } 
                catch (Exception e1) { }
            }
        });
        jLabel12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try { Desktop.getDesktop().browse(new URI("https://www.khanacademy.org/college-careers-more/personal-finance")); } 
                catch (Exception e1) { }
            }
        });
        jLabel13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try { Desktop.getDesktop().browse(new URI("https://www.khanacademy.org/college-careers-more")); } 
                catch (Exception e1) { }
            }
        }); 
        filesJava = new ArrayList<String>();
         filesJava.add("PageOne.java");
         filesJava.add("PageTwo.java");
         filesJava.add("CalendarApp.java");  
         filesJava.add("SimplePaintPanel.java");
         ArrayList<String> fileCopy = filesJava;
         alphabetizeSelectionList(fileCopy);
         ArrayList<String> fileCopy1 = filesJava;
         alphabetizeInsertionList(fileCopy1);
    }      
    
    public void setTime(int time) {   
            
            long timeNow = 1000*time;
            long second = (timeNow / 1000) % 60;
            long minute = (timeNow / (1000 * 60)) % 60;
            long hour = (timeNow / (1000 * 60 * 60)) % 24;
            timeElapsed.setText(String.format("%02d:%02d:%02d", hour, minute, second));
    }
    public void pomodoroTimer() {  
        timer = new Timer();
        timer.schedule(new TimerTask() {
        int counter = 0;
        String [] customTime = pomodoroTime.getText().split(":");
        int counterLimit = Integer.parseInt(customTime[0])*60*60 + Integer.parseInt(customTime[1])*60+Integer.parseInt(customTime[2]);
        @Override
        public void run() {   
            if(!paused) { 
            ++counter;
            setTime(counter);
            if(counter == counterLimit && pomodoroNo < 4) {   
                timer.cancel();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,"You have completed a pomodoro! Take a short break!");
                shortBreakTimer();
                pomodoroNo ++;
            } else if (counter == counterLimit && pomodoroNo == 4) {
                timer.cancel();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,"You have completed 4 pomodoros! Take a long break!");
                longBreakTimer();
            }
            }   }},0,1000);
    }

    public void shortBreakTimer() {   
    timer = new Timer();
    timer.schedule(new TimerTask()  {
    int counter = 0;
    String [] customTime = shortBreakTime.getText().split(":");
    int counterLimit = Integer.parseInt(customTime[0])*60*60 + Integer.parseInt(customTime[1])*60+Integer.parseInt(customTime[2]);

    @Override
    public void run() {   
        if (!paused) {
        ++counter;
        setTime(counter);
        if(counter == counterLimit) {  
            timer.cancel();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Time up! Resume work.");
            pomodoroTimer();
        }}}},0,1000); 
    }
    
    public void longBreakTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
        int counter = 0;
        String [] customTime = longBreakTime.getText().split(":");
        int counterLimit = Integer.parseInt(customTime[0])*60*60 + Integer.parseInt(customTime[1])*60+
                 Integer.parseInt(customTime[2]);
        @Override
        public void run() {  
            if(!paused) {
                ++counter;
                setTime(counter);
                if(counter == counterLimit) {   
                    timer.cancel();
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null,"Time up! Resume work.");
                    pomodoroNo = 1;
                    pomodoroTimer();
                }}}},0,1000);
    } 
    
    private void startActionPerformed(java.awt.event.ActionEvent evt) {
       pause.setEnabled(true);
       reset.setEnabled(true);
       pomodoroTimer();
       pomodoroNo = 1;
       paused = false;
    }

    private void pomodoroTimeActionPerformed(java.awt.event.ActionEvent evt) {}
    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {      
        if(!paused) {
            paused = true;
            pause.setText("Play");
            reset.setEnabled(false);
        } else {
            paused = false;
            pause.setText("Pause");
            reset.setEnabled(true);
        }
    }

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {
        timer.cancel();
        timeElapsed.setText("00:00:00");
        pause.setEnabled(false);
        reset.setEnabled(false);
    }
                                  
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {        
        if (progress < 9) { 
            Main.user.setNum(++progress);
            here.setNum(progress);
            jLabel21.setText("" + here.getNum()); 
        }
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) { 
        if (progress != 0) { 
            Main.user.setNum(--progress);
            here.setNum(progress);
            jLabel21.setText("" + here.getNum()); 
        }
    }                                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (complete != 0) { 
            Main.user.setNumC(--complete); 
            here.setNumC(complete);
            jLabel7.setText("" + here.getNumC()); 
        }
    }                                        

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {        
        if (complete < 9) { 
            Main.user.setNumC(++complete); 
            here.setNumC(complete);
            jLabel7.setText("" + here.getNumC()); 
        }                                 
    }


    
    //Selection Sort: String ArrayList
    public static void alphabetizeSelectionList(ArrayList<String> toSort) {
        int count = 0; //statement execution count
        for(int i = 0; i < toSort.size() - 1; i++) {
        int minVal = i; 
        toSort.set(i, toSort.get(i).toLowerCase());
        for(int j = i + 1; j < toSort.size(); j++) {
            toSort.set(j, toSort.get(j).toLowerCase());
            if (toSort.get(j).compareTo(toSort.get(minVal)) < 0) { minVal = j; }
        }
        if(i != minVal) {
            String temp = toSort.get(minVal);
            toSort.set(minVal, toSort.get(i));
            toSort.set(i, temp);
            count++;
        }
        }
  }

  //Insertion Sort: String ArrayList
    public static void alphabetizeInsertionList(ArrayList<String> toSort) {
        for (int i = 0; i < toSort.size(); i++) { toSort.set(i, toSort.get(i).toLowerCase()); }
        int count = 0; //statement execution count
        for (int i = 1; i < toSort.size(); i++) {
            String check = toSort.get(i);
            int j = i - 1;
            while(j >= 0 && (check.compareTo(toSort.get(j)) < 0)) {
                toSort.set(j+1, toSort.get(j));
                j--;
            }
            toSort.set(j+1, check);
            count++;
        }
    }

}
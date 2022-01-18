import javax.swing.ImageIcon;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeannie
 */
public class frmLizardSpock extends javax.swing.JFrame {
    
    //create new ImageIcons
    ImageIcon rock = new ImageIcon(getClass().getResource("rock.png"));
    ImageIcon paper = new ImageIcon(getClass().getResource("paper.png"));
    ImageIcon scissors = new ImageIcon(getClass().getResource("scissors.jpg"));
    ImageIcon lizard = new ImageIcon(getClass().getResource("lizard.png"));
    ImageIcon spock = new ImageIcon(getClass().getResource("spock.jpg"));
    ImageIcon transparent = new ImageIcon(getClass().getResource("trans.png"));
    ImageIcon circle = new ImageIcon(getClass().getResource("circle.png"));
    
    //create String array
    String[]choice = {"Rock","Paper","Scissors","Lizard","Spock"};
    
    //declares variables
    int compChoice;
    int userChoice;
    int wins, ties, losses;
    int round=1;
    int result;
    String sentence;
       
    
    /**
     * Creates new form frmLizardSpock
     */
    public frmLizardSpock() {
        initComponents();
        lblName.setVisible(false);
        txtName.setVisible(false);
        btnSave.setVisible(false);
        
        //makes the rock button border invisible
        btnRock.setOpaque(false);
        btnRock.setContentAreaFilled(false);
        btnRock.setBorderPainted(false);

        //makes the paper button border invisible
        btnPaper.setOpaque(false);
        btnPaper.setContentAreaFilled(false);
        btnPaper.setBorderPainted(false);

        //makes the scissors button border invisible
        btnScissors.setOpaque(false);
        btnScissors.setContentAreaFilled(false);
        btnScissors.setBorderPainted(false);

        //makes the lizard button border invisible
        btnLizard.setOpaque(false);
        btnLizard.setContentAreaFilled(false);
        btnLizard.setBorderPainted(false);

        //makes the spock button border invisible
        btnSpock.setOpaque(false);
        btnSpock.setContentAreaFilled(false);
        btnSpock.setBorderPainted(false);
        
        /*if (wins==5|losses==5){
            //program pauses for 2 seconds
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
            this.setVisible(false);
            new frmStart().setVisible(true);
        }*/
    }
     
    public void WinOrLose(int win, int lose){
               
        if (win==5){
            
            //displays winning messages
            lblHeader.setText("You Win!");
            lblInstr1.setText("Enter your name and click 'save' to save");
            lblInstr.setText("your score. Click 'reset' to start a new game.");
            
            //makes a label, text field and button visible
            lblName.setVisible(true);
            txtName.setVisible(true);
            btnSave.setVisible(true);
            
            //disables buttons
            btnRock.setEnabled(false);
            btnPaper.setEnabled(false);
            btnScissors.setEnabled(false);
            btnLizard.setEnabled(false);
            btnSpock.setEnabled(false);
                                   
        }
        else if (lose==5){
            
            //displays losing messages
            lblHeader.setText("Computer Wins.");
            lblInstr1.setText("");
            lblInstr.setText("Click 'reset' to start a new game.");
            
            //disables buttons
            btnRock.setEnabled(false);
            btnPaper.setEnabled(false);
            btnScissors.setEnabled(false);
            btnLizard.setEnabled(false);
            btnSpock.setEnabled(false);
            
                       
        }
    }
    
    /**
     *
     * @param a
     */
    public void setUserIcon(int a){
        
        //set icon corresponding to player choice
        if (a==1){
            lblUserOutput.setIcon(rock);
        }
        else if (a==2){
            lblUserOutput.setIcon(paper);
        }
        else if (a==3){
            lblUserOutput.setIcon(scissors);
        }
        else if (a==4){
            lblUserOutput.setIcon(lizard);
        }
        else{
            lblUserOutput.setIcon(spock);
        }
    }
    
    /**
     *
     * @param a
     */
    public void setCompIcon(int a){
        //set icon corresponding to computer choice
        if (a==1){
            lblComputerOutput.setIcon(rock);
        }
        else if (a==2){
            lblComputerOutput.setIcon(paper);
        }
        else if (a==3){
            lblComputerOutput.setIcon(scissors);
        }
        else if (a==4){
            lblComputerOutput.setIcon(lizard);
        }
        else{
            lblComputerOutput.setIcon(spock);
        }
    }
        
    public static String getSentence(int first, int second){
       //displays corresponding message to user
       if (first==second){
           return("Tie.");
       } 
       else if(first==1&second==3|second==1&first==3){
           return("Rock crushes scissors.");
       }
       else if(first==1&second==4|second==1&first==4){
           return("Rock crushes lizard.");
       }
       else if(first==1&second==2|second==1&first==2){
           return("Paper covers rock.");
       }
       else if(first==5&second==2|second==5&first==2){
           return("Paper disproves spock.");
       }
       else if(first==3&second==2|second==3&first==2){
           return("Scissors cuts paper.");
       }
       else if(first==3&second==4|second==3&first==4){
           return("Scissors decapitates lizard.");
       }
       else if(first==4&second==2|second==4&first==2){
           return("Lizard eats paper.");
       }
       else if(first==4&second==5|second==4&first==5){
           return("Lizard poisons spock.");
       }
       else if(first==5&second==1|second==5&first==1){
           return("Spock vaporizes rock.");
       }
       else{
           return("Spock smashes scissors.");
       }
    }
    
    public static int Result(int first, int second){
        
        //returns 1 for win, -1 for loss and 0 for tie
        if (first==1){
            if (second==2|second==5){
                return -1;
            }
            if (second==3|second==4){
                return 1;
            }
            if (second==first){
                return 0;
            }
        }
        else if (first==2){
            if (second==3|second==4){
                return -1;
            }
            if (second==1|second==5){
                return 1;
            }
            if (second==first){
                return 0;
            }            
        }
        else if (first==3){
            if (second==1|second==5){
                return -1;
            }
            if (second==2|second==4){
                return 1;
            }
            if (second==first){
                return 0;
            }
        }
        else if (first==4){
            if (second==1|second==3){
                return -1;
            }
            if (second==2|second==5){
                return 1;
            }
            if (second==first){
                return 0;
            }
        }
        else if (first==5){
            if (second==2|second==4){
                return -1;
            }
            if (second==1|second==3){
                return 1;
            }
            if (second==first){
                return 0;
            }
        }
        return 0;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRock = new javax.swing.JButton();
        btnPaper = new javax.swing.JButton();
        btnScissors = new javax.swing.JButton();
        btnLizard = new javax.swing.JButton();
        btnSpock = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        lblComputer = new javax.swing.JLabel();
        lblUserOutput = new javax.swing.JLabel();
        lblComputerOutput = new javax.swing.JLabel();
        lblInstr = new javax.swing.JLabel();
        lblYou = new javax.swing.JLabel();
        lblW = new javax.swing.JLabel();
        lblT = new javax.swing.JLabel();
        lblL = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        lblOutput = new javax.swing.JLabel();
        lblInstr1 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnLeaderBoards = new javax.swing.JButton();
        btnReset1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rock.png"))); // NOI18N
        btnRock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRockActionPerformed(evt);
            }
        });

        btnPaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paper.png"))); // NOI18N
        btnPaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaperActionPerformed(evt);
            }
        });

        btnScissors.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scissors.jpg"))); // NOI18N
        btnScissors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScissorsActionPerformed(evt);
            }
        });

        btnLizard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lizard.png"))); // NOI18N
        btnLizard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLizardActionPerformed(evt);
            }
        });

        btnSpock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spock.jpg"))); // NOI18N
        btnSpock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpockActionPerformed(evt);
            }
        });

        lblHeader.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 150)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(0, 102, 102));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("ROUND 1");

        lblComputer.setFont(new java.awt.Font("Courier New", 0, 48)); // NOI18N
        lblComputer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComputer.setText("Computer:");

        lblUserOutput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/circle.png"))); // NOI18N

        lblComputerOutput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/circle.png"))); // NOI18N

        lblInstr.setFont(new java.awt.Font("Courier New", 0, 48)); // NOI18N
        lblInstr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInstr.setText("Please make your selection:");

        lblYou.setFont(new java.awt.Font("Courier New", 0, 48)); // NOI18N
        lblYou.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblYou.setText("You:");

        lblW.setFont(new java.awt.Font("Courier New", 0, 48)); // NOI18N
        lblW.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblW.setText("Wins: 0");

        lblT.setFont(new java.awt.Font("Courier New", 0, 48)); // NOI18N
        lblT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblT.setText("Ties: 0");

        lblL.setFont(new java.awt.Font("Courier New", 0, 48)); // NOI18N
        lblL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblL.setText("Losses: 0");

        lblName.setFont(new java.awt.Font("Courier New", 0, 48)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Name:");

        txtName.setFont(new java.awt.Font("Courier Prime", 0, 48)); // NOI18N

        btnReset.setFont(new java.awt.Font("Courier Prime", 0, 48)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        lblOutput.setFont(new java.awt.Font("Courier New", 0, 48)); // NOI18N
        lblOutput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblInstr1.setFont(new java.awt.Font("Courier New", 0, 48)); // NOI18N
        lblInstr1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInstr1.setText("First to five wins.");

        btnSave.setFont(new java.awt.Font("Courier Prime", 0, 48)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnLeaderBoards.setFont(new java.awt.Font("Courier Prime", 0, 36)); // NOI18N
        btnLeaderBoards.setText("LEADERBOARD");
        btnLeaderBoards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaderBoardsActionPerformed(evt);
            }
        });

        btnReset1.setFont(new java.awt.Font("Courier Prime", 0, 48)); // NOI18N
        btnReset1.setText("End Game");
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(550, 550, 550)
                                .addComponent(lblUserOutput))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(379, 379, 379)
                                .addComponent(lblYou, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(lblComputerOutput))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblComputer, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(615, 615, 615)
                        .addComponent(lblOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnRock)
                        .addGap(18, 18, 18)
                        .addComponent(btnPaper)
                        .addGap(18, 18, 18)
                        .addComponent(btnScissors)
                        .addGap(18, 18, 18)
                        .addComponent(btnLizard)
                        .addGap(18, 18, 18)
                        .addComponent(btnSpock))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(462, 462, 462)
                                .addComponent(lblW, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(120, 120, 120)
                                .addComponent(lblT, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblL, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInstr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInstr1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 1899, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeaderBoards, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnLeaderBoards, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(lblInstr1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblInstr, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSpock)
                            .addComponent(btnLizard)
                            .addComponent(btnScissors)
                            .addComponent(btnPaper)
                            .addComponent(btnRock))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblComputer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblYou, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUserOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblComputerOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(lblOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblW, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblT, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblL, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(145, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReset1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(48, 48, 48))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRockActionPerformed
        round++;//increments round
        userChoice = 1; //the choice of Rock is represented by the integer 1
        compChoice = (int)Math.round(Math.random()*4+1); //generates a number between 1 and 5
        lblYou.setText("You: "+choice[userChoice-1]); //displays user choice
        lblComputer.setText("Computer: "+choice[compChoice-1]); //displays computer choice
        
        result = Result(userChoice, compChoice);//calls the Result method to determine game results
        
        sentence = getSentence(userChoice, compChoice); //calls the getSentence method
        lblOutput.setText(sentence);//displays text through the lblOutput label
        setUserIcon(userChoice);//sets icon to match user choice
        setCompIcon(compChoice);//sets icon to match computer choice
        
        if (result==1){
            wins++;
            lblW.setText("Wins: "+wins);//displays number of wins
        }
        else if (result==-1){
            losses++;
            lblL.setText("Losses: "+losses);//displays number of losses
        }
        else{
            ties++;
            lblT.setText("Ties: "+ties);//displays number of ties
        }
        
        lblHeader.setText("ROUND "+round);//displays new round number
        
        WinOrLose(wins, losses);//checks if player has won or lost
        
    }//GEN-LAST:event_btnRockActionPerformed

    private void btnPaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaperActionPerformed
        round++;
        userChoice = 2; //the choice of Paper is represented by the integer 2
        compChoice = (int)Math.round(Math.random()*4+1); //generates a number between 1 and 5
        lblYou.setText("You: "+choice[userChoice-1]); //displays user choice
        lblComputer.setText("Computer: "+choice[compChoice-1]); //displays computer choice
        
        result = Result(userChoice, compChoice);//calls the Result method to determine game results
        
        sentence = getSentence(userChoice, compChoice); //calls the getSentence method
        lblOutput.setText(sentence);//displays text through the lblOutput label
        setUserIcon(userChoice);//sets icon to match user choice
        setCompIcon(compChoice);//sets icon to match computer choice
        
        if (result==1){
            wins++;
            lblW.setText("Wins: "+wins);//displays number of wins
        }
        else if (result==-1){
            losses++;
            lblL.setText("Losses: "+losses);//displays number of losses
        }
        else{
            ties++;
            lblT.setText("Ties: "+ties);//displays number of ties
        }
        
        lblHeader.setText("ROUND "+round);//displays new round number
        
        WinOrLose(wins, losses);//checks if player has won or lost
        
    }//GEN-LAST:event_btnPaperActionPerformed

    private void btnScissorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScissorsActionPerformed
        round++;
        userChoice = 3; //the choice of Scissors is represented by the array integer 3
        compChoice = (int)Math.round(Math.random()*4+1); //generates a number between 1 and 5
        lblYou.setText("You: "+choice[userChoice-1]); //displays user choice
        lblComputer.setText("Computer: "+choice[compChoice-1]); //displays computer choice
        
        result = Result(userChoice, compChoice);//calls the Result method to determine game results
        
        sentence = getSentence(userChoice, compChoice); //calls the getSentence method
        lblOutput.setText(sentence);//displays text through the lblOutput label
        setUserIcon(userChoice);//sets icon to match user choice
        setCompIcon(compChoice);//sets icon to match computer choice
        
        if (result==1){
            wins++;
            lblW.setText("Wins: "+wins);//displays number of wins
        }
        else if (result==-1){
            losses++;
            lblL.setText("Losses: "+losses);//displays number of losses
        }
        else{
            ties++;
            lblT.setText("Ties: "+ties);//displays number of ties
        }
        
        lblHeader.setText("ROUND "+round);//displays new round number
        
        WinOrLose(wins, losses);//checks if player has won or lost
        
    }//GEN-LAST:event_btnScissorsActionPerformed

    private void btnLizardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLizardActionPerformed
        round++;
        userChoice = 4; //the choice of Lizard is represented by the array integer 4
        compChoice = (int)Math.round(Math.random()*4+1); //generates a number between 1 and 5
        lblYou.setText("You: "+choice[userChoice-1]); //displays user choice
        lblComputer.setText("Computer: "+choice[compChoice-1]); //displays computer choice
        
        result = Result(userChoice, compChoice);//calls the Result method to determine game results
        
        sentence = getSentence(userChoice, compChoice); //calls the getSentence method
        lblOutput.setText(sentence);//displays text through the lblOutput label
        setUserIcon(userChoice);//sets icon to match user choice
        setCompIcon(compChoice);//sets icon to match computer choice
        
        if (result==1){
            wins++;
            lblW.setText("Wins: "+wins);//displays number of wins
        }
        else if (result==-1){
            losses++;
            lblL.setText("Losses: "+losses);//displays number of losses
        }
        else{
            ties++;
            lblT.setText("Ties: "+ties);//displays number of ties
        }
        
        lblHeader.setText("ROUND "+round);//displays new round number
        
        WinOrLose(wins, losses);//checks if player has won or lost
        
    }//GEN-LAST:event_btnLizardActionPerformed

    private void btnSpockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpockActionPerformed
        round++;
        userChoice = 5; //the choice of Spock is represented by the array integer 5
        compChoice = (int)Math.round(Math.random()*4+1); //generates a number between 1 and 5
        lblYou.setText("You: "+choice[userChoice-1]); //displays user choice
        lblComputer.setText("Computer: "+choice[compChoice-1]); //displays computer choice
        
        result = Result(userChoice, compChoice);//calls the Result method to determine game results
        
        sentence = getSentence(userChoice, compChoice); //calls the getSentence method
        lblOutput.setText(sentence);//displays text through the lblOutput label
        setUserIcon(userChoice);//sets icon to match user choice
        setCompIcon(compChoice);//sets icon to match computer choice
        
        if (result==1){
            wins++;
            lblW.setText("Wins: "+wins);//displays number of wins
        }
        else if (result==-1){
            losses++;
            lblL.setText("Losses: "+losses);//displays number of losses
        }
        else{
            ties++;
            lblT.setText("Ties: "+ties);//displays number of ties
        }
        
        lblHeader.setText("ROUND "+round);//displays new round number
        
        WinOrLose(wins, losses);//checks if player has won or lost
        
        
        
    }//GEN-LAST:event_btnSpockActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        
        //enables buttons
        btnRock.setEnabled(true);
        btnPaper.setEnabled(true);
        btnScissors.setEnabled(true);
        btnLizard.setEnabled(true);
        btnSpock.setEnabled(true);
        
        //reset integer variables of wins, losses, and ties
        wins=0;
        losses=0;
        ties=0;
        round=1;
        
        //reset labels for wins, losses and ties
        lblW.setText("Wins: "+wins);//displays number of wins
        lblL.setText("Losses: "+losses);//displays number of losses
        lblT.setText("Ties: "+ties);//displays number of ties
        
        //reset icons
        lblUserOutput.setIcon(circle);
        lblComputerOutput.setIcon(circle);
        
        //reset labels, buttons, and textfields
        lblName.setVisible(false);
        txtName.setVisible(false);
        btnSave.setVisible(false);
        
        //reset instruction labels and header
        lblHeader.setText("ROUND 1");
        lblInstr1.setText("First to five wins.");
        lblInstr.setText("Please make your selection:");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnLeaderBoardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaderBoardsActionPerformed
        //changes visible form
        this.setVisible(false);
        new frmLeaderBoards().setVisible(true);
    }//GEN-LAST:event_btnLeaderBoardsActionPerformed

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        //changes visible form
        this.setVisible(false);
        new frmEndScreen().setVisible(true);
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String name = txtName.getText();//retrieves name from user input
        String score = String.valueOf(round);//retrieves score from the round it took user to beat the computer
        
        //saves player score to scores.txt
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("scores.txt", true))){
            bw.write(name);
            bw.newLine();
            bw.write(score);
            bw.newLine();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLizardSpock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLizardSpock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLizardSpock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLizardSpock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLizardSpock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLeaderBoards;
    private javax.swing.JButton btnLizard;
    private javax.swing.JButton btnPaper;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnRock;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnScissors;
    private javax.swing.JButton btnSpock;
    private javax.swing.JLabel lblComputer;
    private javax.swing.JLabel lblComputerOutput;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblInstr;
    private javax.swing.JLabel lblInstr1;
    private javax.swing.JLabel lblL;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOutput;
    private javax.swing.JLabel lblT;
    private javax.swing.JLabel lblUserOutput;
    private javax.swing.JLabel lblW;
    private javax.swing.JLabel lblYou;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

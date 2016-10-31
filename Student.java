/****************************************************************
   PROGRAM:   ARITHMETIC CHALLENGE GAME
   AUTHOR:    Huitian Zhang
   STUDENT:   1100038016
   DUE DATE:  19/09/2016

   FUNCTION:  an arithmetic challenge game involving an instructor and student

   INPUT:     Challenging mathematical questions for the student.

   OUTPUT:    Doubly linked list of all questions, sorted lists, binary trees,
              behavioral graph of student and questions for the students.

   NOTES:     
****************************************************************/
package arithmeticchallengegame;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Student extends javax.swing.JPanel {

    //CHAT RELATED ---------------------------    
    private Socket socket = null;               /*Socket used to connect to server*/
    private DataInputStream console = null;     /*Input stream to receive questions from server/instructor*/
    private DataOutputStream streamOut = null;  /*Output stream to send answers out/ check answers*/
    private ClientThread2 client2 = null;       /*Clients separate thread*/
    private String serverName = "localhost";    /*Name of the server*/
    private int serverPort = 4445;              /*Server port Number*/
    private String Answer;                      /*Answer given by the student*/
    //----------------------------------------
    public Student() {
        initComponents();
        getParameters();
    }
/****************************************************************

   FUNCTION:   Connect

   ARGUMENTS:  Server name, server port

   RETURNS:    NONE

   NOTES:      Connects to the server specifying the name and connecting to the same server port the server is listening to.
****************************************************************/
public void connect(String serverName, int serverPort)
    {
        println("Establishing connection. Please wait ...");
        try
        {
            socket = new Socket(serverName, serverPort);
            println("Connected: " + socket);
            jpConnect.setBackground(java.awt.Color.cyan);
            open();
        }
        catch (UnknownHostException uhe)
        {
            println("Host unknown: " + uhe.getMessage());
        }
        catch (IOException ioe)
        {
            println("Unexpected exception: " + ioe.getMessage());
        }
    }

/****************************************************************

   FUNCTION:   Send

   ARGUMENTS:  None

   RETURNS:    None

   NOTES:      Will send message from the student.
****************************************************************/
    private void send()
    {
        try
        {
            streamOut.writeUTF("1+1=2");
            streamOut.flush();
        }
        catch (IOException ioe)
        {
            println("Sending error: " + ioe.getMessage());
            close();
        }
    }
    
/****************************************************************

   FUNCTION:   Handle

   ARGUMENTS:  Msg (string)

   RETURNS:    None

   NOTES:      Receives message from the server and splits it up based on a comma, sets the question in the text box and a prompt in the label.
****************************************************************/
    public void handle(String msg)
    {
        String[] Data = msg.split(",");
        String question = Data[0];
        String ans = Data[1];
        
        if (question.equals(".bye"))
        {
            println("Good bye. Press EXIT button to exit ...");
            close();
        }
        else
        {
            println(question);
            txtQuestion.setText(question.substring(6));
            Answer = ans;
            lblFeedback.setForeground(Color.black);
            lblFeedback.setText("Answer the question...");
        }
    }

/****************************************************************

   FUNCTION:   Open

   ARGUMENTS:  None

   RETURNS:    None

   NOTES:      Creates a new output stream for writing out to.
****************************************************************/
    public void open()
    {
        try
        {
            streamOut = new DataOutputStream(socket.getOutputStream());
            client2 = new ClientThread2(this, socket);
        }
        catch (IOException ioe)
        {
            println("Error opening output stream: " + ioe);
        }
    }

/****************************************************************

   FUNCTION:   Close

   ARGUMENTS:  None

   RETURNS:    None

   NOTES:      Closes the output stream and socket.
****************************************************************/
    public void close()
    {
        try
        {
            if (streamOut != null)
            {
                streamOut.close();
            }
            if (socket != null)
            {
                socket.close();
            }
        }
        catch (IOException ioe)
        {
            println("Error closing ...");
        }
        client2.close();
        client2.stop();
    }

/****************************************************************

   FUNCTION:   Print Message

   ARGUMENTS:  Message (string)

   RETURNS:    None

   NOTES:      Prints the message in the label.
****************************************************************/
    void println(String msg)
    {
        //display.appendText(msg + "\n");
        lblMsg.setText(msg);
    }

/****************************************************************

   FUNCTION:   Get Parameters

   ARGUMENTS:  None

   RETURNS:    None

   NOTES:      Gets parameters.
****************************************************************/
    public void getParameters()
    {
//        serverName = getParameter("host");
//        serverPort = Integer.parseInt(getParameter("port"));
        
        serverName = "localhost";
        serverPort = 4445;        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStudent = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        txtQuestion = new javax.swing.JTextField();
        txtAnswer = new javax.swing.JTextField();
        jpConnect = new javax.swing.JPanel();
        btnConnect = new javax.swing.JButton();
        lblFeedbackInfo = new javax.swing.JLabel();
        lblFeedback = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        lblMsg = new javax.swing.JLabel();

        lblStudent.setText("Student");
        lblStudent.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setText("Enter Your Answer and Click Submit");

        jLabel3.setText("Question");

        jLabel4.setText("Answer");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jpConnect.setBackground(new java.awt.Color(102, 102, 255));
        jpConnect.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));

        btnConnect.setText("Connect");
        btnConnect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConnectMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpConnectLayout = new javax.swing.GroupLayout(jpConnect);
        jpConnect.setLayout(jpConnectLayout);
        jpConnectLayout.setHorizontalGroup(
            jpConnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConnectLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConnect)
                .addContainerGap())
        );
        jpConnectLayout.setVerticalGroup(
            jpConnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConnectLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(btnConnect)
                .addGap(23, 23, 23))
        );

        lblFeedbackInfo.setText("Feedback:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFeedbackInfo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblFeedback)
                                            .addComponent(txtAnswer))))))
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpConnect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpConnect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btnSubmit)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFeedbackInfo)
                    .addComponent(lblFeedback))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblMsg.setText("*Message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(lblStudent)
                .addContainerGap(222, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblMsg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(lblMsg))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnConnectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConnectMouseClicked
    connect(serverName, serverPort);
    }//GEN-LAST:event_btnConnectMouseClicked

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
Submit();
    }//GEN-LAST:event_btnSubmitActionPerformed
   
/****************************************************************

   FUNCTION:   Submit

   ARGUMENTS:  None

   RETURNS:    None

   NOTES:      Compares the student answer with the actual answer ensures the format is float
****************************************************************/
    private void Submit()
    {
    String StudentAnswer = txtAnswer.getText();
    
    if(txtAnswer.getText().contains("."))
    {
        CheckAns(StudentAnswer);
    }    
    else
    {
        StudentAnswer = txtAnswer.getText()+".0";
        CheckAns(StudentAnswer);
    }

    }
    
/****************************************************************

   FUNCTION:   Check Answer

   ARGUMENTS:  Student Answer (string)

   RETURNS:    None

   NOTES:      Compares the values as floats and sets feedback if it is correct or not.
****************************************************************/
    private void CheckAns(String _studentAnswer)
    {
    Float studentAns = Float.parseFloat(_studentAnswer);
    Float actualAns = Float.parseFloat(Answer);
    int Verdict = Float.compare(studentAns, actualAns);
    
    if (Verdict == 0)
    {
        lblFeedback.setForeground(Color.GREEN);
        lblFeedback.setText("CORRECT!");
    }
    else
    {
        lblFeedback.setForeground(Color.RED);
        lblFeedback.setText("WRONG!");
    }
    }
    //END SUBMIT

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpConnect;
    private javax.swing.JLabel lblFeedback;
    private javax.swing.JLabel lblFeedbackInfo;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblStudent;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtQuestion;
    // End of variables declaration//GEN-END:variables
}

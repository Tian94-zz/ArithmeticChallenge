/****************************************************************
   PROGRAM:   ARITHMETIC CHALLENGE GAME
   AUTHOR:    Huitian Zhang
   STUDENT:   1100038016
   DUE DATE:  19/09/2016

   FUNCTION:  an arithmetic challenge game involving an instructor and student

   INPUT:     Challenging mathematical questions for the student.

   OUTPUT:    Doubly linked list of all questions, sorted lists, binary trees,
              behavioral graph of student and questions for the students.

   NOTES:     SERVERTHREAD IS USED FOR THE SERVER TO RECEIVE OR SEND MESSAGES
   CLASS:     SERVER THREAD
****************************************************************/
package arithmeticchallengegame;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.*;
import java.io.*;

public class ServerThread extends Thread{
    private Server server = null;                   /*Server which will be specified later*/
    private Socket socket = null;                   /*Socket which will also be specified later*/
    private int ID = -1;                            /*ID which will be used for clients*/
    private DataInputStream streamIn = null;        /*Data stream for receiving messages*/
    private DataOutputStream streamOut = null;      /*Data stream for sending out messages/responses*/

/****************************************************************

   FUNCTION:   Create Server Thread

   ARGUMENTS:  Server, Socket

   RETURNS:    Running Server Thread

   NOTES:      Sets the server thread properties.
****************************************************************/
    public ServerThread(Server _server, Socket _socket)
    {
        super();
        server = _server;
        socket = _socket;
        ID = socket.getPort();
    }

/****************************************************************

   FUNCTION:   Send

   ARGUMENTS:  Message (string)

   RETURNS:    NONE

   NOTES:      Writes out the message in UTF Format, then flushes the stream.
   * 
****************************************************************/
    public void send(String msg)
    {
        try
        {
            streamOut.writeUTF(msg);
            streamOut.flush();
        }
        catch (IOException ioe)
        {
            System.out.println(ID + " ERROR sending: " + ioe.getMessage());
            server.remove(ID);
            stop();
        }
    }

/****************************************************************

   FUNCTION:   GET ID

   ARGUMENTS:  NONE

   RETURNS:    ID

   NOTES:      NONE
****************************************************************/
    public int getID()
    {
        return ID;
    }

/****************************************************************

   FUNCTION:   RUN

   ARGUMENTS:  NONE

   RETURNS:   NONE

   NOTES:      Runs the server thread while reading in the incoming messages.
****************************************************************/
    public void run()
    {
        System.out.println("Server Thread " + ID + " running.");
        while (true)
        {
            try
            {
                server.handle(ID, streamIn.readUTF());
            }
            catch (IOException ioe)
            {
                System.out.println(ID + " ERROR reading: " + ioe.getMessage());
                server.remove(ID);
                stop();
            }
        }
    }

/****************************************************************

   FUNCTION:   Open

   ARGUMENTS:  NONE

   RETURNS:    NONE

   NOTES:      Creates a new input stream and output stream based off the socket specifications.
****************************************************************/
    public void open() throws IOException
    {
        streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        streamOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

/****************************************************************

   FUNCTION:   Close

   ARGUMENTS:  NONE

   RETURNS:    NONE

   NOTES:      Closes Everything
****************************************************************/
    public void close() throws IOException
    {
        if (socket != null)
        {
            socket.close();
        }
        if (streamIn != null)
        {
            streamIn.close();
        }
        if (streamOut != null)
        {
            streamOut.close();
        }
    }
}

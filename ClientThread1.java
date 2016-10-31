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
   CLASS:     CLIENT THREAD
****************************************************************/
package arithmeticchallengegame;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author student
 */
public class ClientThread1 extends Thread{
   
    private Socket socket = null;               /*Creates new socket for thread*/
    private Instructor client1 = null;          /*Creates new instructor class*/
    private DataInputStream streamIn = null;    /*Data stream for inputs*/

/****************************************************************

   FUNCTION:   Create Client Thread

   ARGUMENTS:  Instructor, socket

   RETURNS:    none

   NOTES:      Creates the client thread using an instructor and socket class, ensures the thread is open and starts.
****************************************************************/
    public ClientThread1(Instructor _client1, Socket _socket)
    {
        client1 = _client1;
        socket = _socket;
        open();
        start();
    }
    
/****************************************************************

   FUNCTION:   Open

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Opens the input stream or throws exception and closes
****************************************************************/
    public void open()
    {
        try
        {
            streamIn = new DataInputStream(socket.getInputStream());
        }
        catch (IOException ioe)
        {
            System.out.println("Error getting input stream: " + ioe);
            //client1.stop();
            client1.close();
        }
    }

/****************************************************************

   FUNCTION:   Close

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Closes the stream
****************************************************************/
    public void close()
    {
        try
        {
            if (streamIn != null)
            {
                streamIn.close();
            }
        }
        catch (IOException ioe)
        {
            System.out.println("Error closing input stream: " + ioe);
        }
    }
    
/****************************************************************

   FUNCTION:   Run

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Always runs, using an instructor.java class as the client which contains a handle() method, the handle method is used to read from the stream
****************************************************************/
    public void run()
    {
        while (true)
        {
            try
            {
                client1.handle(streamIn.readUTF());
            }
            catch (IOException ioe)
            {
                System.out.println("Listening error: " + ioe.getMessage());
                //client1.stop();
                client1.close();
            }
        }
    }
} 

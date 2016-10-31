/****************************************************************
   PROGRAM:   ARITHMETIC CHALLENGE GAME
   AUTHOR:    Huitian Zhang
   STUDENT:   1100038016
   DUE DATE:  19/09/2016

   FUNCTION:  an arithmetic challenge game involving an instructor and student

   INPUT:     Challenging mathematical questions for the student.

   OUTPUT:    Doubly linked list of all questions, sorted lists, binary trees,
              behavioral graph of student and questions for the students.

   NOTES:     THIS SERVER CLASS RECEIVES QUESTIONS FROM THE TEACHER AND SENDS IT TO THE STUDENT
   CLASS:     SERVER
****************************************************************/
package arithmeticchallengegame;

import java.net.*;
import java.io.*;

public class Server implements Runnable {
    private ServerThread clients[] = new ServerThread[50];  /*Creates an array of 50 server threads, meaning 50 clients are able to connect to the server*/
    private ServerSocket server = null;                     /*Creates a server socket which is bound to a port to listen to incoming messages*/
    private Thread thread = null;                           /*Creates a thread for the server*/
    private int clientCount = 0;                            /*Index of how many clients are connected*/
    
/****************************************************************

   FUNCTION:   Create Server

   ARGUMENTS:  Port Number

   RETURNS:    Running Server

   NOTES:      Creates a new server which connects to a server socket which listens to a specific port number.
****************************************************************/
    public Server(int port)
    {
        try
        {
            System.out.println("Binding to port " + port + ", please wait  ...");
            server = new ServerSocket(port);
            System.out.println("Server started: " + server);
            start();
        }
        catch (IOException ioe)
        {
            System.out.println("Can not bind to port " + port + ": " + ioe.getMessage());
        }
    }
    
/****************************************************************

   FUNCTION:   Runs the server

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Will constantly loop and try to listen to connecting clients, will add a thread if a client attempts to connect.
****************************************************************/
    public void run()
    {
        while (thread != null)
        {
            try
            {
                System.out.println("Waiting for a client ...");
                addThread(server.accept());
            }
            catch (IOException ioe)
            {
                System.out.println("Server accept error: " + ioe);
                stop();
            }
        }
    }

/****************************************************************

   FUNCTION:   Starts Thread

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      If the thread is empty it will start the thread.
****************************************************************/
    public void start()
    {
        if (thread == null)
        {
            thread = new Thread(this);
            thread.start();
        }
    }

/****************************************************************

   FUNCTION:   Stops Thread

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      If the thread isn't null it will stop the thread/set it to null to stop it.
****************************************************************/
    public void stop()
    {
        if (thread != null)
        {
            thread.stop();
            thread = null;
        }
    }
    
/****************************************************************

   FUNCTION:   Finds a client based on ID

   ARGUMENTS:  Client ID(int)

   RETURNS:    Returns the ID or returns a number indicating ID doesn't exist.

   NOTES:      Loops through the clients and tries to find a match with their ID's
****************************************************************/
    private int findClient(int ID)
    {
        for (int i = 0; i < clientCount; i++)
        {
            if (clients[i].getID() == ID)
            {
                return i;
            }
        }
        return -1;
    }
    
/****************************************************************

   FUNCTION:   Handle

   ARGUMENTS:  ID (int), input (string)

   RETURNS:    none

   NOTES:      If a client sends .bye it will remove the client. Or else it will send all the clients the message/input
****************************************************************/
    public synchronized void handle(int ID, String input)
    {
        if (input.equals(".bye"))
        {
            clients[findClient(ID)].send(".bye");
            remove(ID);
        }
        else
        {
            for (int i = 0; i < clientCount; i++)
            {
                //if(clients[i].getID() != ID)
                clients[i].send(ID + ": " + input);
            }
        }
    }

/****************************************************************

   FUNCTION:   Remove ID

   ARGUMENTS:  ID (int)

   RETURNS:    none

   NOTES:      Finds the client ID, removes it from the array and makes the array length correct, terminates the client.
****************************************************************/
    public synchronized void remove(int ID)
    {
        int pos = findClient(ID);
        if (pos >= 0)
        {
            ServerThread toTerminate = clients[pos];
            System.out.println("Removing client thread " + ID + " at " + pos);
            if (pos < clientCount - 1)
            {
                for (int i = pos + 1; i < clientCount; i++)
                {
                    clients[i - 1] = clients[i];
                }
            }
            clientCount--;
            try
            {
                toTerminate.close();
            }
            catch (IOException ioe)
            {
                System.out.println("Error closing thread: " + ioe);
            }
        }
    }

/****************************************************************

   FUNCTION:   Add Thread
   
   ARGUMENTS:  Socket(socket)

   RETURNS:    none

   NOTES:      Creates a new server thread which will use the given socket. Adds a new client to the client array.
****************************************************************/
    private void addThread(Socket socket)
    {
        if (clientCount < clients.length)
        {
            System.out.println("Client accepted: " + socket);
            clients[clientCount] = new ServerThread(this, socket);
            try
            {
                clients[clientCount].open();
                clients[clientCount].start();
                clientCount++;
            }
            catch (IOException ioe)
            {
                System.out.println("Error opening thread: " + ioe);
            }
        }
        else
        {
            System.out.println("Client refused: maximum " + clients.length + " reached.");
        }
    }

/****************************************************************

   FUNCTION:   Main Function

   ARGUMENTS:  String args[]

   RETURNS:    none

   NOTES:      Will create a new server with the specified port number of 4445.
****************************************************************/
    public static void main(String args[])
    {
        Server server;
        if (args.length != 1)
        {
            //System.out.println("Usage: java ChatServer port");
            server = new Server(4445);
        }
        else
        {
            server = new Server(Integer.parseInt(args[0]));
        }
    }

}


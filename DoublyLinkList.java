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
   CLASS:     Doubly Linked List
****************************************************************/
package arithmeticchallengegame;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class DoublyLinkList<E> {
    private DNode<E> head;          /*The Head Node*/
    private DNode<E> tail;          /*The Tail Node */
    private int size;               /*Size of the linked list */

    
/****************************************************************

   FUNCTION:   Create Doubly Link List

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Default constructor for creating DLL, setting head and tail to null and size to 0
****************************************************************/
    public DoublyLinkList()
    {
    head = new DNode<E>(null,null,null,null);
    tail = new DNode<E>(null, null, null,null);
    size=0;

    //set references
    head.setNext(tail);
    tail.setPrev(head);
    }
    
/****************************************************************

   FUNCTION:   Get Next

   ARGUMENTS:  Reference Node

   RETURNS:    none

   NOTES:      Returns the next node based on the reference node
****************************************************************/
    private DNode<E> getNext(DNode<E> referenceNode) throws Exception{
    if (referenceNode == tail)
    {
    throw new Exception("Reference Node cannot be equal to the tail");
    }
    return referenceNode.getNext();
    }
    
/****************************************************************

   FUNCTION:   Get Previous

   ARGUMENTS:  Reference Node

   RETURNS:    none

   NOTES:      Returns Next Node based on the reference node
****************************************************************/
    private DNode<E> getPrevious(DNode<E> referenceNode) throws Exception
    {
        if (referenceNode == head)
        {
        throw new Exception("Reference Node cannot be equal to the head");
        }
        return referenceNode.getPrev();
    }
    
/****************************************************************

   FUNCTION:   Add Node Before

   ARGUMENTS:  Reference Node, Element, Question

   RETURNS:    none

   NOTES:      Adds a node before the current node
****************************************************************/
    private void addBefore(DNode<E> referenceNode, E element, Question Q)
    {
        try {
            DNode<E> prevNode = this.getPrevious(referenceNode);
            
            DNode<E> newNode = new DNode<E>(element, prevNode, referenceNode, Q);
            referenceNode.setPrev(newNode);
            prevNode.setNext(newNode);
            size++;
        } catch (Exception ex) {
            Logger.getLogger(DoublyLinkList.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
/****************************************************************

   FUNCTION:   Add Node After

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Adds a node after the current node
****************************************************************/
private void addAfter(DNode<E> referenceNode, E element, Question Q){
        try {
            DNode<E> nextNode = this.getNext(referenceNode);
            //Start setting the reference
            DNode<E> newNode = new DNode<E>(element, referenceNode, nextNode, Q);
            referenceNode.setNext(newNode);
            nextNode.setPrev(newNode);
            size++;
        } catch (Exception ex) {
            Logger.getLogger(DoublyLinkList.class.getName()).log(Level.SEVERE, null, ex);
        }

}

/****************************************************************

   FUNCTION:   Add First Node

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Adds the head node
****************************************************************/
public void addFirst(E Element, Question Q)
{
this.addAfter(head, Element, Q);
}

/****************************************************************

   FUNCTION:   Add Last Node

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Adds the tail node
****************************************************************/
public void addLast (E Element, Question Q)
{
this.addBefore(tail, Element, Q);
}

/****************************************************************

   FUNCTION:   Remove Node

   ARGUMENTS:  none

   RETURNS:    RemoveNode

   NOTES:      Sets the node you want to be removed as the remove node then sets the previous and next to correct nodes than subtracts the size by 1
****************************************************************/
private E remove(DNode<E> removeNode){
        try {
            DNode<E> prevNode = this.getPrevious(removeNode); //Node1
            DNode<E> nextNode = this.getNext(removeNode); //Node2
            //Dereference the node which is removed
            removeNode.setPrev(null);
            removeNode.setNext(null);
            //Set the other references
            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
            size--;
            //return the stored element of the removeNode
           
        } catch (Exception ex) {
            Logger.getLogger(DoublyLinkList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return removeNode.getElement();
}


/****************************************************************

   FUNCTION:   Remove last

   ARGUMENTS:  none

   RETURNS:    Element

   NOTES:      Removes the last element of the doubly linked list
****************************************************************/
public E removeLast() throws Exception{
	//Check if the DLL list is empty
	if(this.isEmpty())
		throw new Exception("Double Linked list is empty, cannot remove element");
	
	//Else, get the Node before the tail
	DNode<E> tempNode = this.getPrevious(tail);
	
	//Remove tempNode
	return this.remove(tempNode);
}

/****************************************************************

   FUNCTION:   Remove First

   ARGUMENTS:  none

   RETURNS:    Element

   NOTES:      Removes the first element of the doubly linked list
****************************************************************/
public E removeFirst() throws Exception{
	//Check if the DLL list is empty
	if(this.isEmpty())
		throw new Exception("Double Linked list is empty, cannot remove element");
	
	//Else, get the Node after the head
	DNode<E> tempNode = this.getNext(head);
	
	//Remove tempNode
	return this.remove(tempNode);
}

/****************************************************************

   FUNCTION:   Is the List Empty

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Checks if the DLL is empty and returns true or false
****************************************************************/
    private boolean isEmpty() {
        if (size==0){
        return true;
        }
        return false;
    }
    
/****************************************************************

   FUNCTION:   Get List Size

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Returns the size of the current list
****************************************************************/
    public int Size()
    {
    return this.size;
    }
    
/****************************************************************

   FUNCTION:   Convert List Elements To String

   ARGUMENTS:  none

   RETURNS:    String of list elements

   NOTES:      A string representation of the DLL, returns element only and not question content however
****************************************************************/
    public String toString(){
            String s = "HEAD";

            DNode<E> probe = head.getNext();
            while(probe!= tail){
                    s += probe + " ";
                    probe = probe.getNext();
            }

            s += "TAIL";

            return s;
    }

/****************************************************************

   FUNCTION:   Convert List Questions To String

   ARGUMENTS:  none

   RETURNS:    string of question elements

   NOTES:      Returns the properties of the question element which is the question and the answer in string format
****************************************************************/
     public String QuestionToString(){
            String s = "HEAD";
            DNode<E> probe = head.getNext();
            
            while(probe!= tail){
                    s += " <-> " + probe.getQuestion().FirstNumber + " " + probe.getQuestion().Operator + " " + probe.getQuestion().SecondNumber + " " + probe.getQuestion().Equals + " " + probe.getQuestion().Answer;
                    probe = probe.getNext();
            }

            s += " <-> TAIL";

            return s;
    }
}
    
    
    
    



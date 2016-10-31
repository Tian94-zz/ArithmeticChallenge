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
   CLASS:     DNODE
****************************************************************/
package arithmeticchallengegame;


    public class DNode<E>
    {
    DNode<E> prevNode;              /*PreviousNode Property*/
    DNode<E> nextNode;              /*NextNode Property*/
    E element;                      /*The element of the node (has a number but content not accessable)*/
    Question Q;                     /*Question, which is the actual data stored and can be accessed*/
    
    
/****************************************************************

   FUNCTION:   Create a DNode

   ARGUMENTS:  Element, Previous Node, Next Node, Actual Data/Question

   RETURNS:    none

   NOTES:      Essentially sets up all the properties of the DNode
****************************************************************/
    public DNode(E element, DNode<E> prevNode, DNode<E> nextNode, Question Qdata)
    {
    this.prevNode = prevNode;
    this.nextNode = nextNode;
    this.element = element;
    this.Q = Qdata;
    }

/****************************************************************

   FUNCTION:   Returns Element

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Returns the element of the current node but cannot access contents
****************************************************************/
    public E getElement()
    {
    return this.element;
    }

/****************************************************************

   FUNCTION:   Returns Question

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Returns question of the current node, can access properties and contents
****************************************************************/
    public Question getQuestion()
    {
    return this.Q;
    }

/****************************************************************

   FUNCTION:   Set Element

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Gets rid of the old element and sets a new specified one
****************************************************************/
    public void setElement (E newElement)
    {
    this.element = newElement;
    }
    
/****************************************************************

   FUNCTION:   Get Previous

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Gets the previous node of the current node
****************************************************************/
    public DNode<E> getPrev()
    {
    return prevNode;
    }
    
/****************************************************************

   FUNCTION:   Set Previous

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Sets the previous node of the current node
****************************************************************/
    public void setPrev(DNode<E> newPrev)
    {
        this.prevNode = newPrev;
    }

/****************************************************************

   FUNCTION:   Get Next

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Get next node of current node
****************************************************************/
    public DNode<E> getNext()
    {
    return nextNode;
    }

/****************************************************************

   FUNCTION:   Set Next

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Sets Next Node of current node
****************************************************************/
    public void setNext(DNode<E> newNext)
    {
    this.nextNode = newNext;
    }
    
/****************************************************************

   FUNCTION:   To String

   ARGUMENTS:  none

   RETURNS:    none

   NOTES:      Returns the element in string format or returns null
****************************************************************/
    @Override
    public String toString()
    {
    if (element == null)
    {
    return null;
    }
    else 
    {
        return element.toString();
    }
    }
}


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
   CLASS:     BINARY TREE
****************************************************************/

package arithmeticchallengegame;

public class BinaryTree {
    DNode root;                     /*The rootnode of the tree */
    String Traverse = "";           /*The total string of the binary tree once it has been traversed through */
    
/****************************************************************

   FUNCTION:   Add Node

   ARGUMENTS:  Object Question, Node Previous, Node Next, Question QuestionData

   RETURNS:    none

   NOTES:      Adds a new node by setting the previous node, next node and question data 
****************************************************************/
	public void addNode(Object Question, DNode prevNode, DNode nextNode, Question Qdata) {

		// Create a new Node and initialize it

		DNode newNode = new DNode(Question, prevNode, nextNode, Qdata);

		// If there is no root this becomes root

		if (root == null) {

			root = newNode;

		} else {

			// Set root as the Node we will start
			// with as we traverse the tree

			DNode focusNode = root;

			// Future parent for our new Node

			DNode parent;

			while (true) {

				// root is the top parent so we start
				// there

				parent = focusNode;

				// Check if the new node should go on
				// the left side of the parent node
                                double key = Double.parseDouble(Qdata.Answer);
                                double focus = Double.parseDouble(focusNode.getQuestion().Answer);
                                
                                
				if (key < focus){

					// Switch focus to the left child

					focusNode = focusNode.prevNode;

					// If the left child has no children

					if (focusNode == null) {

						// then place the new node on the left of it

						parent.prevNode = newNode;
						return; // All Done

					}

				} else { // If we get here put the node on the right

					focusNode = focusNode.nextNode;

					// If the right child has no children

					if (focusNode == null) {

						// then place the new node on the right of it

						parent.nextNode = newNode;
						return; // All Done

					}

				}

			}
		}

	}
    
/****************************************************************

   FUNCTION:   In Order Traverse of Tree

   ARGUMENTS:  Node focusNode

   RETURNS:    none

   NOTES:      	All nodes are visited in ascending order
                Recursion is used to go to one node and
                then go to its child nodes and so forth
****************************************************************/



	public String inOrderTraverseTree(DNode focusNode) {
		if (focusNode != null) {

                    inOrderTraverseTree(focusNode.prevNode);

			// Visit the currently focused on node

			System.out.println(focusNode.Q.Answer);
                        String Question = "(" + focusNode.Q.FirstNumber + focusNode.Q.Operator + focusNode.Q.SecondNumber + ")";//Code used to create the string which is set in the textbox on instructor page                        
                        Traverse = Traverse + Question + focusNode.Q.Answer + ",   ";//Concatenates both question and answer to one.
			// Traverse the right node

			inOrderTraverseTree(focusNode.nextNode);
                }
                return Traverse;                
	}

/****************************************************************

   FUNCTION:   Clears the traverse string

   ARGUMENTS:  Node focusNode

   RETURNS:    none

   NOTES:      Essentially clears the traverse string or else it'll keep adding on instead of new sorting
****************************************************************/
        public String InOrderTraverse(DNode _focusNode)
        {
        Traverse="";
         return inOrderTraverseTree(_focusNode);
        }

/****************************************************************

   FUNCTION:   Pre Order Traverse of Tree

   ARGUMENTS:  Node focusNode

   RETURNS:    none

   NOTES:      	All nodes are visited in ascending order
                Recursion is used to go to one node and
                then go to its child nodes and so forth
****************************************************************/
	public String preorderTraverseTree(DNode focusNode) {
		if (focusNode != null) {

			System.out.println(focusNode.Q.Answer);
                        String Question = "(" + focusNode.Q.FirstNumber + focusNode.Q.Operator + focusNode.Q.SecondNumber + ")";                       
                        Traverse = Traverse + Question + focusNode.Q.Answer + ",   ";
                        
			preorderTraverseTree(focusNode.prevNode);
			preorderTraverseTree(focusNode.nextNode);
		}
                 return Traverse;
	}

/****************************************************************

   FUNCTION:   Clears the traverse string

   ARGUMENTS:  Node focusNode

   RETURNS:    none

   NOTES:      Essentially clears the traverse string or else it'll keep adding on instead of new sorting
****************************************************************/
        public String PreOrderTraverse(DNode _focusNode)
        {
            Traverse="";
            return preorderTraverseTree(_focusNode);
        }

/****************************************************************

   FUNCTION:   Post Order Traverse

   ARGUMENTS:  Node focusNode

   RETURNS:    none

   NOTES:      refer above
****************************************************************/
	public String postOrderTraverseTree(DNode focusNode) {    
		if (focusNode != null) {

			postOrderTraverseTree(focusNode.prevNode);
			postOrderTraverseTree(focusNode.nextNode);

			System.out.println(focusNode.Q.Answer);
                        String Question = "(" + focusNode.Q.FirstNumber + focusNode.Q.Operator + focusNode.Q.SecondNumber + ")";                        
                        Traverse = Traverse + Question + focusNode.Q.Answer + ",   ";
		}
                return Traverse;
	}
        
        public String PostOrderTraverse(DNode _focusNode)
        {
        Traverse="";
        return postOrderTraverseTree(_focusNode);
        }
        
/****************************************************************

   FUNCTION:   Find Node

   ARGUMENTS:  Node focusNode

   RETURNS:    none

   NOTES:      Finds node based on the question data
****************************************************************/
	public DNode findNode(Question Qdata) {

		// Start at the top of the tree

		DNode focusNode = root;

		// While we haven't found the Node
		// keep looking

		while (Integer.parseInt(focusNode.Q.Answer) != Integer.parseInt(Qdata.Answer)) {

			// If we should search to the left

			if (Integer.parseInt(Qdata.Answer) < Integer.parseInt(focusNode.Q.Answer)) {

				// Shift the focus Node to the left child

				focusNode = focusNode.prevNode;

			} else {

				// Shift the focus Node to the right child

				focusNode = focusNode.nextNode;

			}

			// The node wasn't found

			if (focusNode == null)
				return null;

		}

		return focusNode;

	}
}

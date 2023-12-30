package syntaxTree;

import tokenizer.*;
import java.util.*;

/**
This class is a subclass of SyntaxTree and represents the 
structure of the grammar rule for the Block non-terminal.  

      Block --> lcbT StmtList rcbT

STATE:

The state in this class includes one data member

   LinkedList<StmtST> list
   
which represents the list of object references for the 
statements in a PDef list.
      
INTERFACE:

The interface of this class includes a constructor. 
    
   BlockST(LinkedList<StmtST> l) 
   
HELPER METHODS:
   
There are no helper methods.
   
CLASS INVARIANT:  

    list.size() >= 1
    
The fact that the size of list is >=1 is because StmtList 
is required to have at least one element.
              
@author J. Mead -- September '08
*/

public class BlockST extends StmtST {
  // Class Invariant: list.size() >= 1
  private LinkedList<StmtST> list;
	
	
	// Constructor
	public BlockST(LinkedList<StmtST> l) 
  {  list = l;  }
    
  public void traverseST() { 
     // for (StmtST st : list)
     //     st.traverseST(); 
     System.out.println("BlockST");

  }

@Override
public String toString(String pad) {
   // TODO Auto-generated method stub
   throw new UnsupportedOperationException("Unimplemented method 'toString'");
}
	
}

package presentation.tip;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import presentation.mycomp.MyTextField;
 
public class DoubleField extends MyTextField {
  
     public DoubleField(int cols) {
         super(cols);
     }
  
     protected Document createDefaultModel() {
         return new NumberDocument(this);
     }
  
     static class NumberDocument extends PlainDocument {
    	 DoubleField doubleField;
  
         public NumberDocument(DoubleField doubleField) {
			this.doubleField = doubleField;
		}

		public void insertString(int offs, String str, AttributeSet a) 
             throws BadLocationException {
             if (str == null) {
                 return;
             }
             char[] upper = str.toCharArray();
             char[] temp = new char[upper.length];
             for (int i = 0; i < upper.length; i++) {
                if((upper[i] >= '0' && upper[i] <= '9')) {
                    temp[i] = upper[i];
                } else if(upper[i] == '.'){
                	if(!doubleField.getText().contains("."))
                		temp[i] = upper[i];
                }
                	
             }
             super.insertString(offs, new String(temp).trim(), a);
         }
     }
 }


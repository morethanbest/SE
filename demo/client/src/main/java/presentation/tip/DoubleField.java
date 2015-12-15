package presentation.tip;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
 
public class DoubleField extends JTextField {
  
     public DoubleField(int cols) {
         super(cols);
     }
  
     protected Document createDefaultModel() {
         return new NumberDocument();
     }
  
     static class NumberDocument extends PlainDocument {
  
         public void insertString(int offs, String str, AttributeSet a) 
             throws BadLocationException {
             if (str == null) {
                 return;
             }
             char[] upper = str.toCharArray();
             char[] temp = new char[upper.length];
             for (int i = 0; i < upper.length; i++) {
                if((upper[i] >= '0' && upper[i] <= '9')||upper[i]=='.') {
                    temp[i] = upper[i];
                }
             }
             super.insertString(offs, new String(temp).trim(), a);
         }
     }
 }


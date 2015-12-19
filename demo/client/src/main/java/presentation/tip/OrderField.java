package presentation.tip;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class OrderField extends JTextField {

	public OrderField(int cols) {
		super(cols);
	}

	protected Document createDefaultModel() {
		return new NumberDocument(this);
	}

	static class NumberDocument extends PlainDocument {
		OrderField orderField;

		public NumberDocument(OrderField orderField) {
			this.orderField = orderField;
		}

		public void insertString(int offs, String str, AttributeSet a)
				throws BadLocationException {
			if (str == null) {
				return;
			}
			char[] upper = str.toCharArray();
			char[] temp = new char[upper.length];
			for (int i = 0; i < upper.length; i++) {
				if ((upper[i] >= '0' && upper[i] <= '9')) {
					if (orderField.getText().length() + upper.length <= 10)
						temp[i] = upper[i];
				}
			}
			super.insertString(offs, new String(temp).trim(), a);
		}
	}

}

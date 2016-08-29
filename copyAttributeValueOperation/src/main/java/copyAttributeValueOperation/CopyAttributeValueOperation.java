package copyAttributeValueOperation;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

import ro.sync.ecss.extensions.api.ArgumentDescriptor;
import ro.sync.ecss.extensions.api.ArgumentsMap;
import ro.sync.ecss.extensions.api.AuthorAccess;
import ro.sync.ecss.extensions.api.AuthorOperation;
import ro.sync.ecss.extensions.api.AuthorOperationException;
import ro.sync.ecss.extensions.api.node.AttrValue;
import ro.sync.ecss.extensions.api.node.AuthorElement;
import ro.sync.ecss.extensions.api.node.AuthorNode;

/**
 * Implementation of Interface AuthorOperation. This Class implements a custom Oxygen operation
 * that gets the value of @xml:id and copies it to the clipboard.
 * 
 * @author Cindy Brinkmann
 * @version 1.0
 * @since 2015-06-10
 * Digitales Familiennamenwoerterbuch Deutschlands (DFD)
 * TU Darmstadt, Akademie der Wissenschaften und der Literatur Mainz
 */
public class CopyAttributeValueOperation implements AuthorOperation {
	

	public void doOperation(AuthorAccess authorAccess, ArgumentsMap args)
			throws IllegalArgumentException, AuthorOperationException {
		
		if(authorAccess.getWorkspaceAccess().isStandalone()){
			
			//Position des Cursors
			int caretOffset = authorAccess.getEditorAccess().getCaretOffset();
			try {
				//Node an der Position des Cursors
				AuthorNode nodeAtOffset = authorAccess.getDocumentController().getNodeAtOffset(caretOffset);
				if (nodeAtOffset != null && nodeAtOffset instanceof AuthorElement){
					AuthorElement element = (AuthorElement) nodeAtOffset;
					//wenn sich der Cursor im Element anchor befindet: Bedeutungs-ID
					if("anchor".equals(element.getLocalName())){
						String value = element.getAttribute("xml:id").getValue();
						copyToClipboard(value);
						
						JOptionPane.showMessageDialog(null, "Die Bedeutungs-ID " + value +
								 " wurde in die Zwischenablage kopiert.");
					}
					else { //wenn sich der Cursor an einer anderen Stelle befindet: Artikel-ID
						AttrValue value = authorAccess.getDocumentController().getAuthorDocumentNode().getRootElement().getAttribute("xml:id");
						copyToClipboard(value.getValue());
						
						JOptionPane.showMessageDialog(null, "Die Artikel-ID " + value.getValue() +
								 " wurde in die Zwischenablage kopiert.");
					}
				}
				
			} catch (BadLocationException e) {
				JOptionPane.showMessageDialog(null, "Es konnte keine Artikel- oder Bedeutungs-ID kopiert werden.");
			}
		}
		
	}
	
	/**
	 * Copies the @input String to the clipboard.
	 * @param input The String that gets copied to the clipboard.
	 */
	public void copyToClipboard(String input){
		// http://stackoverflow.com/questions/6710350/copying-text-to-the-clipboard-using-java
		StringSelection stringSelection = new StringSelection(input);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
	}

	public ArgumentDescriptor[] getArguments() {
		return null;
	}

	public String getDescription() {
		return "Kopiert den Wert eines @xml:id Attributs im Wurzelelement oder in einem <anchor>-Element in die Zwischenablage.\n" +
				"Dieses Plugin dient dem Gebrauch im Projekt \"Digitales Familiennamenwörterbuch Deutschlands\" (DFD) der Akademie der Wissenschaften und der Literatur | Mainz. Jede Installation oder Nutzung, die nicht im Rahmen des Projekts erfolgt, bedarf der vorherigen Zustimmung. Wenden Sie sich dazu bitte per E-Mail an dfd@adwmainz.de oder nutzen Sie unser Kontaktformular unter www.familiennamenwoerterbuch.de.";
	}

}

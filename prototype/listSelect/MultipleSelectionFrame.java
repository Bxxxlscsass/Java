package empresa;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MultipleSelectionFrame extends JFrame{
	private final JList<String> colorJList; //lista para armazenar nomes
	private final JList<String> copyJList; //lista para armazenar copys
	private final JButton copyJButton;; //Botão par acopiar nomes selecionados 
	private static final String[] colorNames = {"Black", "Blue", "Cyan", 
			"Dark Gray", "Gray", "Green", "Ligth Gray", "Magenta", "Orange",
			"Pink", "Red", "White", "Yellow"};
	
	//construtor MultipleSelectionFrame
	public MultipleSelectionFrame() {
		super("Multiple Selection Lists");
		setLayout(new FlowLayout());
		
		colorJList = new JList<String>(colorNames); //listas de nomes
		colorJList.setVisibleRowCount(5); //mostra cinco linhas 
		colorJList.setSelectionMode(
				ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(colorJList)); //adiciona lista scrollpane
		
		copyJButton = new JButton("Copy >>>");
		copyJButton.addActionListener(
				new ActionListener() //classe interna anômina 
				{
					//trata evento botão 
					@Override
					public void actionPerformed(ActionEvent event) {
						//coloca valores selecionados na copyJList 
						copyJList.setListData(
								colorJList.getSelectedValuesList().toArray(
										new String[0]));
						
					}
			}
		);
		add(copyJButton);
		
		copyJList = new JList<String>(); //lista para armazenamento de nomes 
        copyJList.setVisibleRowCount(5); //mostrar 5 linhas 
        copyJList.setFixedCellWidth(100); //configura a largura
        copyJList.setFixedCellHeight(15); //configurar a altura 
        copyJList.setSelectionMode(
        		ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        add(new JScrollPane(copyJList)); //adiciona lista com scrollpane 
	}
} //fim de classe

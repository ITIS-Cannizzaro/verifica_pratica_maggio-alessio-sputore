import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class ListaNumeri extends JFrame implements ActionListener {
	
	//aggiungo un nuovo frame di tipo JFrame
	
	JTextArea numero=new JTextArea();
	JTextArea visualizza=new JTextArea();
	
	JLabel Numero=new JLabel("Inserisci il numero: ");
	JLabel Visualizza= new JLabel("Ecco la lista: ");
	
	JButton Aggiungi=new JButton("Aggiungi");
	JButton Rimuovi=new JButton("Rimuovi");
	JButton Stampa=new JButton("Stampa");
	
	ArrayList lista=new ArrayList();

	public ListaNumeri() {
		super("Lista ordinata di numeri.");
		this.lista=lista;
		//dichiaro JFrame e attributi del secondo frame (text area e bottone per conferma)
		//tra gli attributi lascio setVisible(false)
		
		Container cont=this.getContentPane();
		cont.setLayout(new FlowLayout());
		
		cont.add(Numero);
		cont.add(numero);
		numero.setPreferredSize(new Dimension(250,25));
		cont.add(Visualizza);
		cont.add(visualizza);
		visualizza.setPreferredSize(new Dimension(250,25));
		cont.add(Aggiungi);
		Aggiungi.addActionListener(e -> Aggiungi());
		//cont.add(Rimuovi);
		//Rimuovi.addActionListener(e -> Rimuovi());
		cont.add(Stampa);
		Stampa.addActionListener(e -> Stampa());
		
		setSize(300,300);
		setVisible(true);
	}
	public int getNum(int n) {
		return (int)lista.get(n);
	}
	
	public void Aggiungi() {
		int n=Integer.parseInt(numero.getText());
		lista.add(n);
		for (int x=0; x<lista.size(); x++) {
			int m=getNum(x);
			if (n<m) {
				int l=m;
				lista.set(x,n);
				n=l;
				x++;
			}
			if(n>m||n==m)
				lista.set(x,n);
		}
		numero.setText("");
	}
	public void Stampa() {
		System.out.println(lista);
	}
	
	//creo la classe rimuovi, che renderà il secondo frame visibile tramite setVisible(true) al click del bottone e tramite codice remove rimuovo il numero all'intenro dell'array
	
	@Override
	public void actionPerformed (ActionEvent e) {
		if (e.getSource()==Aggiungi) {
			Aggiungi();
		}
		/*if (e.getSource()==Rimuovi) {
			Rimuovi();
		}*/
		if (e.getSource()==Stampa) {
			Stampa();
		}
	}
}

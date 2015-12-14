package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Entidades.Alfil;
import Entidades.Caballo;
import Entidades.Jugador;
import Entidades.Partida;
import Entidades.Peon;
import Entidades.Reina;
import Entidades.Rey;
import Entidades.Torre;
import Negocio.*;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TableroInterfaz extends JFrame {
	
	    ArrayList<Peon> peones=new ArrayList<Peon>();
    	ArrayList<Alfil> alfiles=new ArrayList<Alfil>();
    	ArrayList<Caballo> caballos=new ArrayList<Caballo>();
    	ArrayList<Reina> reinas=new ArrayList<Reina>();
    	ArrayList<Rey> reyes=new ArrayList<Rey>();
    	ArrayList<Torre> torres=new ArrayList<Torre>();
    	Partida partida=new Partida();
    	Jugador jugador1, jugador2;
    	int idPartidaSeleccionada;
    	String turno="Blanco"; 
    	
    	
    	AlfilLogic alfilLogic=new AlfilLogic();
    	CaballoLogic caballoLogic=new CaballoLogic();
    	PartidaLogic partidaLogic=new PartidaLogic();
    	JugadorLogic jugadorLogic=new JugadorLogic();
    	PeonLogic peonLogic=new PeonLogic();
    	ReinaLogic reinaLogic=new ReinaLogic();
    	ReyLogic reyLogic=new ReyLogic();
    	TorreLogic torreLogic=new TorreLogic();
    	
    	private JTextField textColumnaActual;
    	private JTextField textFilaActual;
    	private JTextField textFilaProxima;
    	private JTextField textColumnaProxima;
    	JFrame frame = new JFrame("Ajedrez");
    	private JPanel arrayPanel[][] = new JPanel[8][8];
    	
	    public TableroInterfaz(Jugador j1, Jugador j2){
	    	jugador1=j1;
	    	jugador2=j2;
	    	boolean ban_tipo=true;
	    	buildBoard(ban_tipo);
	    }
	    
	    public TableroInterfaz(int idSeleccionada){
	    	recuperarPartida(idSeleccionada);
	    }
	    
	    
	    public void buildBoard (boolean ban_tipo_par)
	    {	
	    	if(ban_tipo_par)
	    	{
	    	getTableroInicial();
	    	}
	    	JPanel pan= new JPanel();
	    	JPanel pane= new JPanel();
	    	JPanel pane1= new JPanel();
	        
	        Dimension dim;
	        dim=super.getToolkit().getScreenSize();
	        frame.setSize(dim);
	        frame.getContentPane().setLayout(new BorderLayout());
	        
	        
	        JLabel lblFilaActual = new JLabel("Fila Actual");
			lblFilaActual.setBounds(10, 11, 57, 14);
			
			JLabel lblColumnaActual = new JLabel("Columna Actual");
			lblColumnaActual.setBounds(10, 36, 81, 14);
			
			textColumnaActual = new JTextField();
			textColumnaActual.setBounds(101, 33, 86, 20);
			
			textColumnaActual.setColumns(10);
			
			textFilaActual = new JTextField();
			textFilaActual.setBounds(101, 8, 86, 20);
			
			textFilaActual.setColumns(10);
			
			JLabel lblFilaProxima = new JLabel("Fila Proxima");
			lblFilaProxima.setBounds(10, 61, 81, 14);
			
			JLabel lblColumnaProxima = new JLabel("Columna Proxima");
			lblColumnaProxima.setBounds(10, 86, 93, 14);
			
			textFilaProxima = new JTextField();
			textFilaProxima.setBounds(101, 58, 86, 20);
			textFilaProxima.setColumns(10);
			
			textColumnaProxima = new JTextField();
			textColumnaProxima.setBounds(101, 83, 86, 20);
			textColumnaProxima.setColumns(10);
			
			JButton btnRealizarMovimiento = new JButton("Realizar Movimiento");
			btnRealizarMovimiento.setBounds(76, 129, 127, 23);
			btnRealizarMovimiento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					int filaActual, columnaActual, filaProxima, columnaProxima;
					if(textFilaActual.getText().equalsIgnoreCase("") || textColumnaActual.getText().equalsIgnoreCase("") || 
							textFilaProxima.getText().equalsIgnoreCase("") || textColumnaProxima.getText().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null, "Complete todos los campos","Advertencia",JOptionPane.WARNING_MESSAGE);
					}else{
						
						
						filaActual=Integer.parseInt(textFilaActual.getText());
						columnaActual=Integer.parseInt(textColumnaActual.getText());
						filaProxima=Integer.parseInt(textFilaProxima.getText());
						columnaProxima=Integer.parseInt(textColumnaProxima.getText());
						if (actualizarTablero(filaActual,columnaActual,filaProxima,columnaProxima))
						{
							
							JOptionPane.showMessageDialog(null, "Movimiento Incorrecto","Advertencia",JOptionPane.WARNING_MESSAGE);
						}
						else 
						{
							turno=quienjuega();
						}
						}
						
							
						
						
					}
					
				
			});
			
			
			JButton btnGuardarPartida = new JButton("Guardar y Salir");
			btnGuardarPartida.setBounds(76, 129, 127, 23);
			btnGuardarPartida.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					guardarPartida();
					System.exit(0);
				}
			});
	        
			
			frame.getContentPane().add(pane, BorderLayout.SOUTH);
			pane.add(btnGuardarPartida);
	        frame.getContentPane().add(pane1, BorderLayout.NORTH);
	        pane1.add(new JLabel("Jugador 1 :"+jugador1.getApellido()+"  Jugador 2 : "+jugador2.getApellido()));
	        pane1.add(lblFilaActual);
			pane1.add(textFilaActual);
			pane1.add(lblColumnaActual);
			pane1.add(textColumnaActual);
			pane1.add(lblFilaProxima);
			pane1.add(textFilaProxima);
			pane1.add(lblColumnaProxima);
			pane1.add(textColumnaProxima);
			pane1.add(btnRealizarMovimiento);
	        frame.getContentPane().add(pan, BorderLayout.CENTER);
	        
	        pan.setLayout(new GridLayout(8,8));
	        //frame.getContentPane().setLayout(new GridLayout(8, 9));

	        for (int i = 0; i < 8; i++) {
	          for (int j = 0; j < 8; j++) {
	        	  arrayPanel[i][j] = new JPanel();

	             if ((i + j) % 2 == 0) arrayPanel[i][j].setBackground(Color.gray);
	              else arrayPanel[i][j].setBackground(Color.white);
	             pan.add(arrayPanel[i][j]);
	            //frame.getContentPane().add(arrayPanel[i][j]);
	          }
	        }
	        
	        if(ban_tipo_par){

	        arrayPanel[0][0].add(new JLabel(new ImageIcon("src\\images\\torreblanco.png")));
	        arrayPanel[0][1].add(new JLabel(new ImageIcon("src\\images\\caballoblanco.png")));
	        arrayPanel[0][2].add(new JLabel(new ImageIcon("src\\images\\alfilblanco.png")));
	        arrayPanel[0][3].add(new JLabel(new ImageIcon("src\\images\\reyblanco.png")));
	        arrayPanel[0][4].add(new JLabel(new ImageIcon("src\\images\\reinablanco.png")));
	        arrayPanel[0][5].add(new JLabel(new ImageIcon("src\\images\\alfilblanco.png")));
	        arrayPanel[0][6].add(new JLabel(new ImageIcon("src\\images\\caballoblanco.png")));
	        arrayPanel[0][7].add(new JLabel(new ImageIcon("src\\images\\torreblanco.png")));

	        arrayPanel[7][0].add(new JLabel(new ImageIcon("src\\images\\torrenegro.png")));
	        arrayPanel[7][1].add(new JLabel(new ImageIcon("src\\images\\caballonegro.png")));
	        arrayPanel[7][2].add(new JLabel(new ImageIcon("src\\images\\alfilnegro.png")));
	        arrayPanel[7][3].add(new JLabel(new ImageIcon("src\\images\\reynegro.png")));
	        arrayPanel[7][4].add(new JLabel(new ImageIcon("src\\images\\reinanegro.png")));
	        arrayPanel[7][5].add(new JLabel(new ImageIcon("src\\images\\alfilnegro.png")));
	        arrayPanel[7][6].add(new JLabel(new ImageIcon("src\\images\\caballonegro.png")));
	        arrayPanel[7][7].add(new JLabel(new ImageIcon("src\\images\\torrenegro.png")));

	        for (int i = 0; i < 8; i++) {
	          arrayPanel[1][i].add(new JLabel(new ImageIcon("src\\images\\peonblanco.png")));
	          arrayPanel[6][i].add(new JLabel(new ImageIcon("src\\images\\peonnegro.png")));
	        }
	        }
	        else{
	        	for (int i = 0; i < 4; i++) {
	        		System.out.print(torres.get(i).isState()); 
	        		System.out.print("paso ");
		        	if(torres.get(i).isState())
		        	{
		        		int fila,columna;
			        	columna=torres.get(i).getColumna();
			        	fila=torres.get(i).getFila();
		        		if(i<2){arrayPanel[fila][columna].add(new JLabel(new ImageIcon("src\\images\\torreblanco.png")));}
		        		else{arrayPanel[fila][columna].add(new JLabel(new ImageIcon("src\\images\\torrenegro.png")));}
		        	}
		        	if(caballos.get(i).isState())
		        	{
		        		int fila,columna;
				        columna=caballos.get(i).getColumna();
				        fila=caballos.get(i).getFila(); 
				        if(i<2){arrayPanel[fila][columna].add(new JLabel(new ImageIcon("src\\images\\caballoblanco.png")));}
		        		else{arrayPanel[fila][columna].add(new JLabel(new ImageIcon("src\\images\\caballonegro.png")));}
		        	}
		        
		        	if(alfiles.get(i).isState())
		        	{
		        		int fila,columna;
				        columna=alfiles.get(i).getColumna();
				        fila=alfiles.get(i).getFila();
		        		if(i<2){arrayPanel[fila][columna].add(new JLabel(new ImageIcon("src\\images\\alfilblanco.png")));}
		        		else{arrayPanel[fila][columna].add(new JLabel(new ImageIcon("src\\images\\alfilnegro.png")));}
		        	}
		        	
	        	}
		        
	        	for (int i = 0; i < 2; i++) {
		        	if(reyes.get(i).isState())
		        	{
		        		int fila,columna;
			        	columna=reyes.get(i).getColumna();
			        	fila=reyes.get(i).getFila();
			        	if(i<1){arrayPanel[fila][columna].add(new JLabel(new ImageIcon("src\\images\\reyblanco.png")));}
		        		else{arrayPanel[fila][columna].add(new JLabel(new ImageIcon("src\\images\\reynegro.png")));}
		        	}
		        	if(reinas.get(i).isState())
		        	{
		        		int fila,columna;
			        	columna=reinas.get(i).getColumna();
			        	fila=reinas.get(i).getFila();
			        	if(i<1){arrayPanel[fila][columna].add(new JLabel(new ImageIcon("src\\images\\reinablanco.png")));}
		        		else{arrayPanel[fila][columna].add(new JLabel(new ImageIcon("src\\images\\reinanegro.png")));}
		        	}
	        	}

		        for (int i = 0; i < 16; i++) {
		        	if(peones.get(i).isState())
		        	{
		        	int fila,columna;
		        	columna=peones.get(i).getColumna();
		        	fila=peones.get(i).getFila();
		        	if(i<8){arrayPanel[fila][columna].add(new JLabel(new ImageIcon("src\\images\\peonblanco.png")));}
	        		else{arrayPanel[fila][columna].add(new JLabel(new ImageIcon("src\\images\\peonnegro.png")));} 
		        	}
		        }
	        	
	        }
	        
	        
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null); //center screen
	        frame.setVisible(true);
	    }
	    
	    public void getTableroInicial()
	    {	
	    	int idNueva=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el id de la partida a crear: ",JOptionPane.INFORMATION_MESSAGE));
	    	partida.setId(idNueva);
	    	partida.setJ1(jugador1.getDni());
	    	partida.setJ2(jugador2.getDni());
	    	
	    	for(int i=0;i<16;i++){
	    		Peon p=new Peon();
	    		p.setId(i);
	    		if(i<8){
	    		p.setColor("Blanco");
	    		p.setFila(1);
	    		p.setColumna(i);
	    		
	    		}
	    		else{p.setColor("Negro");
	    		p.setFila(6);
	    		p.setColumna(i-8);}
	    		p.setState(true);
	    		p.setId_partida(partida.getId());
	    		peones.add(p);
	    	}
	    	
	    	for(int i=0;i<4;i++){
	    		Alfil p=new Alfil();
	    		p.setId(i);
	    		if(i<2){
	    		p.setColor("Blanco");
	    		p.setFila(0);
	    		if(i==0)
	    		{p.setColumna(2);}
	    		if(i==1)
	    		{p.setColumna(5);}		
	    			    		
	    		}
	    		else{p.setColor("Negro");
	    		p.setFila(7);
	    		if(i==2)
	    		{p.setColumna(2);}
	    		if(i==3)
	    		{p.setColumna(5);}
	    		}
	    		p.setState(true);
	    		p.setId_partida(partida.getId());
	    		alfiles.add(p);
	    		
	    	}
	    	
	    	for(int i=0;i<4;i++){
	    		Caballo p=new Caballo();
	    		p.setId(i);
	    		if(i<2){
	    		p.setColor("Blanco");
	    		p.setFila(0);
	    		if(i==0)
	    		{p.setColumna(1);}
	    		if(i==1)
	    		{p.setColumna(6);}		
	    			    		
	    		}
	    		else{p.setColor("Negro");
	    		p.setFila(7);
	    		if(i==2)
	    		{p.setColumna(1);}
	    		if(i==3)
	    		{p.setColumna(6);}
	    		}
	    		p.setState(true);
	    		p.setId_partida(partida.getId());
	    		caballos.add(p);
	    		
	    	}
	    	
	    	for(int i=0;i<4;i++){
	    		Torre p=new Torre();
	    		p.setId(i);
	    		if(i<2){
	    		p.setColor("Blanco");
	    		p.setFila(0);
	    		if(i==0)
	    		{p.setColumna(0);}
	    		if(i==1)
	    		{p.setColumna(7);}		
	    			    		
	    		}
	    		else{p.setColor("Negro");
	    		p.setFila(7);
	    		if(i==2)
	    		{p.setColumna(0);}
	    		if(i==3)
	    		{p.setColumna(7);}
	    		}
	    		p.setState(true);
	    		p.setId_partida(partida.getId());
	    		torres.add(p);
	    		
	    	}
	    	
	    	for(int i=0;i<2;i++){
	    		Rey p=new Rey();
	    		p.setId(i);
	    		if(i<1){
	    		p.setColor("Blanco");
	    		p.setFila(0);
	    		p.setColumna(3);	
	    			    		
	    		}
	    		else{p.setColor("Negro");
	    		p.setFila(7);
	    		p.setColumna(3);
	    		}
	    		p.setState(true);
	    		p.setId_partida(partida.getId());
	    		reyes.add(p);
	    		
	    		
	    	}
	    	
	    	for(int i=0;i<2;i++){
	    		Reina p=new Reina();
	    		p.setId(i);
	    		if(i<1){
	    		p.setColor("Blanco");
	    		p.setFila(0);
	    		p.setColumna(4);	
	    			    		
	    		}
	    		else{p.setColor("Negro");
	    		p.setFila(7);
	    		p.setColumna(4);
	    		}
	    		p.setState(true);
	    		p.setId_partida(partida.getId());
	    		reinas.add(p);
	    		
	    		
	    	}
	    	
	    	
	    }
	    
	    private String quienjuega(){
			String color;
			if(turno=="Blanco"){
	    	color="Negro";
			} else{color="Blanco" ;}
	    	return color;
		}
	    
	    public boolean actualizarTablero(int filaActual,int columnaActual,int filaProxima,int columnaProxima){
	    	int x=0;
	    	boolean ban_pieza=true;
	    	while(x<16)
	    	{
	    		
	    		if(peones.get(x).getFila()==filaActual && peones.get(x).getColumna()==columnaActual && peones.get(x).isState() && (peones.get(x).getColor()==turno))
	    		{
	    			
	    			ban_pieza=false;
	    			if(peones.get(x).validarMovimiento(filaActual, columnaActual, filaProxima, columnaProxima))
	    			{
	    				comerficha(filaProxima,columnaProxima);
	    				System.out.print("PeonEntro");
	    				peones.get(x).setFila(filaProxima);
	    				peones.get(x).setColumna(columnaProxima);
	    				arrayPanel[filaActual][columnaActual].removeAll();
	    				arrayPanel[filaActual][columnaActual].repaint();
	    				if(turno=="Blanco"){arrayPanel[filaProxima][columnaProxima].add(new JLabel(new ImageIcon("src\\images\\peonblanco.png"))).repaint();}
	    				else{arrayPanel[filaProxima][columnaProxima].add(new JLabel(new ImageIcon("src\\images\\peonnegro.png"))).repaint();}
	    				arrayPanel[filaProxima][columnaProxima].setVisible(true);
	    					 				
	    			}			
	    		}
	    		x++;
	    	}
	    	x=0;
	    	
	    	if(ban_pieza)
	    	{
	    		while( x<4)
		    	{
		    		if(torres.get(x).getFila()==filaActual && torres.get(x).getColumna()==columnaActual && torres.get(x).isState() && (torres.get(x).getColor()==turno))
		    		{
		    			System.out.print("Torre");
		    			ban_pieza=false;
		    			if(torres.get(x).validarMovimiento(filaActual, columnaActual, filaProxima, columnaProxima))
		    			{
		    				comerficha(filaProxima,columnaProxima);
		    				System.out.print("TorreEntro");
		    				torres.get(x).setFila(filaProxima);
		    				torres.get(x).setColumna(columnaProxima);
		    				arrayPanel[filaActual][columnaActual].removeAll();
		    				arrayPanel[filaActual][columnaActual].repaint();
		    				if(turno=="Blanco"){arrayPanel[filaProxima][columnaProxima].add(new JLabel(new ImageIcon("src\\images\\torreblanco.png"))).repaint();}
		    				else{arrayPanel[filaProxima][columnaProxima].add(new JLabel(new ImageIcon("src\\images\\torrenegro.png"))).repaint();}
		    					 				
		    			}			
		    		}
		    		x++;
		    	}
	    		
	    	}
	    	
	    	x=0;
	    	
	    	if(ban_pieza)
	    	{
	    		while( x<4)
		    	{
		    		if(caballos.get(x).getFila()==filaActual && caballos.get(x).getColumna()==columnaActual && caballos.get(x).isState() && (caballos.get(x).getColor()==turno))
		    		{
		    			System.out.print("caballos");
		    			ban_pieza=false;
		    			if(caballos.get(x).validarMovimiento(filaActual, columnaActual, filaProxima, columnaProxima))
		    			{
		    				comerficha(filaProxima,columnaProxima);
		    				System.out.print("caballosEntro");
		    				caballos.get(x).setFila(filaProxima);
		    				caballos.get(x).setColumna(columnaProxima);
		    				arrayPanel[filaActual][columnaActual].removeAll();
		    				arrayPanel[filaActual][columnaActual].repaint();
		    				if(turno=="Blanco"){arrayPanel[filaProxima][columnaProxima].add(new JLabel(new ImageIcon("src\\images\\caballoblanco.png"))).repaint();}
		    				else{arrayPanel[filaProxima][columnaProxima].add(new JLabel(new ImageIcon("src\\images\\caballonegro.png"))).repaint();}
		    					 				
		    			}			
		    		}
		    		x++;
		    	}
	    		
	    	}
	    	x=0;
	    	
	    	if(ban_pieza)
	    	{
	    		while( x<4)
		    	{
		    		if(alfiles.get(x).getFila()==filaActual && alfiles.get(x).getColumna()==columnaActual && alfiles.get(x).isState() && (alfiles.get(x).getColor()==turno))
		    		{
		    			System.out.print("alfiles");
		    			ban_pieza=false;
		    			if(alfiles.get(x).validarMovimiento(filaActual, columnaActual, filaProxima, columnaProxima))
		    			{
		    				comerficha(filaProxima,columnaProxima);
		    				System.out.print("alfilesEntro");
		    				alfiles.get(x).setFila(filaProxima);
		    				alfiles.get(x).setColumna(columnaProxima);
		    				arrayPanel[filaActual][columnaActual].removeAll();
		    				arrayPanel[filaActual][columnaActual].repaint();
		    				if(turno=="Blanco"){arrayPanel[filaProxima][columnaProxima].add(new JLabel(new ImageIcon("src\\images\\alfilblanco.png"))).repaint();}
		    				else{arrayPanel[filaProxima][columnaProxima].add(new JLabel(new ImageIcon("src\\images\\alfilnegro.png"))).repaint();}
		    					 				
		    			}			
		    		}
		    		x++;
		    	}
	    		
	    	}
	    	x=0;
	    	
	    	if(ban_pieza)
	    	{
	    		while( x<2)
		    	{
		    		if(reyes.get(x).getFila()==filaActual && reyes.get(x).getColumna()==columnaActual && reyes.get(x).isState() && (reyes.get(x).getColor()==turno))
		    		{
		    			System.out.print("reyes");
		    			ban_pieza=false;
		    			if(reyes.get(x).validarMovimiento(filaActual, columnaActual, filaProxima, columnaProxima))
		    			{
		    				comerficha(filaProxima,columnaProxima);
		    				System.out.print("reyesEntro");
		    				reyes.get(x).setFila(filaProxima);
		    				reyes.get(x).setColumna(columnaProxima);
		    				arrayPanel[filaActual][columnaActual].removeAll();
		    				arrayPanel[filaActual][columnaActual].repaint();
		    				if(turno=="Blanco"){arrayPanel[filaProxima][columnaProxima].add(new JLabel(new ImageIcon("src\\images\\reyblanco.png"))).repaint();}
		    				else{arrayPanel[filaProxima][columnaProxima].add(new JLabel(new ImageIcon("src\\images\\reynegro.png"))).repaint();}
		    					 				
		    			}			
		    		}
		    		x++;
		    	}
	    		
	    	}
	    	x=0;
	    	
	    	if(ban_pieza)
	    	{
	    		while( x<2)
		    	{
		    		if(reinas.get(x).getFila()==filaActual && reinas.get(x).getColumna()==columnaActual && reinas.get(x).isState() && (reinas.get(x).getColor()==turno))
		    		{
		    			System.out.print("reinas");
		    			ban_pieza=false;
		    			if(reinas.get(x).validarMovimiento(filaActual, columnaActual, filaProxima, columnaProxima))
		    			{
		    				comerficha(filaProxima,columnaProxima);
		    				System.out.print("reyesEntro");
		    				reinas.get(x).setFila(filaProxima);
		    				reinas.get(x).setColumna(columnaProxima);
		    				arrayPanel[filaActual][columnaActual].removeAll();
		    				arrayPanel[filaActual][columnaActual].repaint();
		    				if(turno=="Blanco"){arrayPanel[filaProxima][columnaProxima].add(new JLabel(new ImageIcon("src\\images\\reinablanco.png"))).repaint();}
		    				else{arrayPanel[filaProxima][columnaProxima].add(new JLabel(new ImageIcon("src\\images\\reinanegro.png"))).repaint();}
		    					 				
		    			}
		    			
		    		}
		    		x++;
		    	}

	    	}
	             return ban_pieza;
	  }
	    
	    
	    private void comerficha(int filaProxima,int columnaProxima){
	    	int x=0;
	    	while(x<16)
	    	{
	    		if(peones.get(x).getFila()==filaProxima && peones.get(x).getColumna()==columnaProxima && peones.get(x).isState())
	    		{
	    		
	    				System.out.print("PeonMurio");
	    				arrayPanel[filaProxima][columnaProxima].removeAll();
	    				arrayPanel[filaProxima][columnaProxima].repaint();
	    				peones.get(x).setState(false);		 				
	    		}	
	    		x++;
	    	}
	    	x=0;
	    	while(x<4)
	    	{
	    		if(torres.get(x).getFila()==filaProxima && torres.get(x).getColumna()==columnaProxima && torres.get(x).isState())
	    		{
	    		
	    				System.out.print("torreMurio");
	    				arrayPanel[filaProxima][columnaProxima].removeAll();
	    				arrayPanel[filaProxima][columnaProxima].repaint();
	    				torres.get(x).setState(false);		 				
	    		}
	    		if(caballos.get(x).getFila()==filaProxima && caballos.get(x).getColumna()==columnaProxima && caballos.get(x).isState())
	    		{
	    		
	    				System.out.print("caballoMurio");
	    				arrayPanel[filaProxima][columnaProxima].removeAll();
	    				arrayPanel[filaProxima][columnaProxima].repaint();
	    				caballos.get(x).setState(false);		 				
	    		}
	    		if(alfiles.get(x).getFila()==filaProxima && alfiles.get(x).getColumna()==columnaProxima && alfiles.get(x).isState())
	    		{
	    		
	    				System.out.print("alfilMurio");
	    				arrayPanel[filaProxima][columnaProxima].removeAll();
	    				arrayPanel[filaProxima][columnaProxima].repaint();
	    				alfiles.get(x).setState(false);		 				
	    		}
	    		x++;
	    	}
	    	x=0;
	    	while(x<2)
	    	{
	    		if(reyes.get(x).getFila()==filaProxima && reyes.get(x).getColumna()==columnaProxima && reyes.get(x).isState())
	    		{
	    		
	    				System.out.print("reyesMurio");
	    				arrayPanel[filaProxima][columnaProxima].removeAll();
	    				arrayPanel[filaProxima][columnaProxima].repaint();
	    				reyes.get(x).setState(false);		 				
	    		}
	    		if(reinas.get(x).getFila()==filaProxima && reinas.get(x).getColumna()==columnaProxima && reinas.get(x).isState())
	    		{
	    		
	    				System.out.print("reinasMurio");
	    				arrayPanel[filaProxima][columnaProxima].removeAll();
	    				arrayPanel[filaProxima][columnaProxima].repaint();
	    				reinas.get(x).setState(false);		 				
	    		}
	    		
	    		x++;
	    	}
	    		
	    }
	    
	    public void guardarPartida(){
	    	
	    	for(int x=0;x<4;x++){
	    		alfilLogic.insertAlfil(alfiles.get(x));
	    		caballoLogic.insertCaballo(caballos.get(x));
	    		torreLogic.insertTorre(torres.get(x));
	    	}
	    	for(int x=0;x<2;x++){
	    		reinaLogic.insertReina(reinas.get(x));
	    		reyLogic.insertRey(reyes.get(x));
	    	}
	    	for(int x=0;x<16;x++){
	    		peonLogic.insertPeon(peones.get(x));
	    	}
	    	partidaLogic.insertPartida(partida);
	    	
	    }
	    
	    public void recuperarPartida(int idSeleccionada){
	    	peones=peonLogic.getPeon(idSeleccionada);
	    	alfiles=alfilLogic.getAlfil(idSeleccionada);
	    	caballos=caballoLogic.getCaballo(idSeleccionada);
	    	torres=torreLogic.getTorre(idSeleccionada);
	    	reyes=reyLogic.getRey(idSeleccionada);
	    	reinas=reinaLogic.getReina(idSeleccionada);
	    	partida=partidaLogic.getPartida(idSeleccionada);
	    	jugador1=jugadorLogic.getJugador(partida.getJ1());
	    	jugador2=jugadorLogic.getJugador(partida.getJ2());
	    	System.out.println(peones.size());
	    	boolean ban_tipo_par=false;
	    	buildBoard (ban_tipo_par);
	    }
	    
}
	



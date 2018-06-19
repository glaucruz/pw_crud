import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RacaGui extends JFrame {

	private JPanel contentPane;
	private JPanel painelBotoesTopo;
	private JButton btnNovo;
	private JButton btnListar;
	private JButton btnSair;
	private JTabbedPane PainelTabs;
	private JPanel painelCadastrar;
	private JPanel painelConsultar;
	private JPanel painelBotoesLateral;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private JPanel painelLogo;
	private JLabel lblImagemJulies;
	private JTextField txtCod;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblConsulta;
	private JTextField txtConsulta;
	private JScrollPane scrollPane;
	private JTable tabelaConsulta;
	private JTextField txtNomeConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RacaGui frame = new RacaGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private DefaultTableModel tabelaModeloRaca;
	private List<RacaBean> listaRacas = new ArrayList<RacaBean>();
	private RacaController objRacaController = new RacaController();


	
	
	public RacaGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		painelBotoesTopo = new JPanel();
		painelBotoesTopo.setBackground(Color.WHITE);
		painelBotoesTopo.setBounds(10, 11, 462, 66);
		contentPane.add(painelBotoesTopo);
		painelBotoesTopo.setLayout(null);
		
		btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon("H:\\TEC_INF_INTEGRADO_ENSINOMEDIO\\T\u00E9cnico em Inform\u00E1tica Diurno\\Java e Banco de Dados\\2012\\Tela1\\imagens\\8440_32x32.png"));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnNovo_actionPerformed(arg0);
			}
		});
		btnNovo.setBounds(25, 4, 120, 48);
		painelBotoesTopo.add(btnNovo);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnListar_actionPerformed(arg0);
			}
		});
		btnListar.setIcon(new ImageIcon("H:\\TEC_INF_INTEGRADO_ENSINOMEDIO\\T\u00E9cnico em Inform\u00E1tica Diurno\\Java e Banco de Dados\\2012\\Tela1\\imagens\\7713_32x32.png"));
		btnListar.setBounds(170, 4, 120, 48);
		painelBotoesTopo.add(btnListar);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSair_actionPerformed(e);
			}
		});
		btnSair.setIcon(new ImageIcon("H:\\TEC_INF_INTEGRADO_ENSINOMEDIO\\T\u00E9cnico em Inform\u00E1tica Diurno\\Java e Banco de Dados\\2012\\Tela1\\imagens\\8443_32x32.png"));
		btnSair.setBounds(315, 4, 120, 48);
		painelBotoesTopo.add(btnSair);
		
		PainelTabs = new JTabbedPane(JTabbedPane.TOP);
		PainelTabs.setBounds(10, 81, 462, 345);
		contentPane.add(PainelTabs);
		
		painelConsultar = new JPanel();
		PainelTabs.addTab("Consultar", null, painelConsultar, null);
		painelConsultar.setLayout(null);
		
		lblConsulta = new JLabel("Nome:");
		lblConsulta.setBounds(10, 24, 46, 14);
		painelConsultar.add(lblConsulta);
		
		txtConsulta = new JTextField();
		txtConsulta.setBounds(56, 21, 313, 20);
		painelConsultar.add(txtConsulta);
		txtConsulta.setColumns(10);
		txtConsulta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				do_txtConsulta_keyTyped(arg0);
			}
		});
		
		txtNomeConsulta = new JTextField();
		txtNomeConsulta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				do_txtNomeConsulta_keyTyped(arg0);
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 437, 235);
		painelConsultar.add(scrollPane);
		
		tabelaConsulta = new JTable();
		tabelaConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_tabelaConsulta_mouseClicked(arg0);
			}
		});

		scrollPane.setColumnHeaderView(tabelaConsulta);
		
		painelCadastrar = new JPanel();
		PainelTabs.addTab("Cadastrar", null, painelCadastrar, null);
		painelCadastrar.setLayout(null);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setEnabled(false);
		txtCod.setVisible(false);
		txtCod.setBounds(10, 11, 86, 20);
		painelCadastrar.add(txtCod);
		txtCod.setColumns(10);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 53, 46, 14);
		painelCadastrar.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(61, 50, 154, 20);
		painelCadastrar.add(txtNome);
		txtNome.setColumns(10);
		
		painelBotoesLateral = new JPanel();
		painelBotoesLateral.setBackground(Color.WHITE);
		painelBotoesLateral.setBounds(482, 173, 168, 253);
		contentPane.add(painelBotoesLateral);
		painelBotoesLateral.setLayout(null);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSalvar_actionPerformed(e);
			}
		});
		btnSalvar.setBounds(24, 12, 123, 41);
		btnSalvar.setIcon(new ImageIcon("H:\\TEC_INF_INTEGRADO_ENSINOMEDIO\\T\u00E9cnico em Inform\u00E1tica Diurno\\Java e Banco de Dados\\2012\\Tela1\\imagens\\8441_32x32.png"));
		painelBotoesLateral.add(btnSalvar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAlterar_actionPerformed(e);
			}
		});
		btnAlterar.setBounds(24, 72, 123, 41);
		btnAlterar.setIcon(new ImageIcon("H:\\TEC_INF_INTEGRADO_ENSINOMEDIO\\T\u00E9cnico em Inform\u00E1tica Diurno\\Java e Banco de Dados\\2012\\Tela1\\imagens\\8448_32x32.png"));
		painelBotoesLateral.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnExcluir_actionPerformed(e);
			}
		});
		btnExcluir.setBounds(24, 136, 123, 41);
		btnExcluir.setIcon(new ImageIcon("H:\\TEC_INF_INTEGRADO_ENSINOMEDIO\\T\u00E9cnico em Inform\u00E1tica Diurno\\Java e Banco de Dados\\2012\\Tela1\\imagens\\8449_32x32.png"));
		painelBotoesLateral.add(btnExcluir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancelar_actionPerformed(e);
			}
		});
		btnCancelar.setBounds(24, 201, 123, 41);
		btnCancelar.setIcon(new ImageIcon("H:\\TEC_INF_INTEGRADO_ENSINOMEDIO\\T\u00E9cnico em Inform\u00E1tica Diurno\\Java e Banco de Dados\\2012\\Tela1\\imagens\\8443_32x32.png"));
		painelBotoesLateral.add(btnCancelar);
		
		painelLogo = new JPanel();
		painelLogo.setBackground(Color.WHITE);
		painelLogo.setBounds(482, 11, 168, 151);
		contentPane.add(painelLogo);
		painelLogo.setLayout(null);
		
		lblImagemJulies = new JLabel("");
		lblImagemJulies.setIcon(new ImageIcon(ModeloGui.class.getResource("/imagens/julies2.png")));
		lblImagemJulies.setBounds(-31, 0, 210, 151);
		painelLogo.add(lblImagemJulies);
	
		//inicializa��es
		this.setResizable(false);
        this.habilitaDesabilita(false);
		btnSalvar.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
		btnCancelar.setEnabled(false);

        // Monta a tabela com a consulta
 		defineModeloTabela();
        defineLarguraColunas();
		preencherTabela();
		
        // centralizar tela
    	this.setLocationRelativeTo(null);
		
		
	
	}
	
	protected void do_txtNomeConsulta_keyTyped(KeyEvent arg0) {
		
			limparTabela();
			preencherTabela(txtNomeConsulta.getText());
			txtNomeConsulta.requestFocusInWindow();
		
		
	}

	protected void do_btnSair_actionPerformed(ActionEvent e) {
		dispose();
		
	}

	public void preencherFields() {
    	habilitaDesabilita(false);
		btnSalvar.setEnabled(false);
		btnAlterar.setEnabled(true);
		btnExcluir.setEnabled(true);
		btnCancelar.setEnabled(true);
		
        int linhaSelecionada = tabelaConsulta.getSelectedRow();
        	
 
        txtCod.setText(String.valueOf(tabelaModeloRaca.getValueAt(linhaSelecionada, 0)));
        txtNome.setText(String.valueOf(tabelaModeloRaca.getValueAt(linhaSelecionada, 1)));            
        
}
	

	protected void do_txtConsulta_keyTyped(KeyEvent arg0) {
		limparTabela();
		preencherTabela(txtConsulta.getText());
		txtConsulta.requestFocusInWindow();
		
	}



	private void habilitaDesabilita(boolean opcao) {
		//setEnable habilita ou desabilita um campo
	}
	
	
	/**
	 * Metodo responsavel por definir o modelo e as colunas da tabela
	 */
	private void defineModeloTabela() {
		//cria um modelo de tabela
		tabelaModeloRaca = new DefaultTableModel();
		tabelaConsulta.setModel(tabelaModeloRaca);

		//cria um vetor com os campos do titulo
		Vector<String> titulo = new Vector<String>();
		titulo.add("C�digo");
		titulo.add("Nome");
		
		//altera os identificadores
		tabelaModeloRaca.setColumnIdentifiers(titulo);
	}
	
	private void defineLarguraColunas() {
		TableColumn tc = null;
		
		tc = tabelaConsulta.getColumnModel().getColumn(0); 
		tc.setPreferredWidth(55);
		tc.setMaxWidth(55);
		tc.setMinWidth(55);
	}
	void preencherTabela(){
		
		preencherTabela("");
		
	}
	
	void preencherTabela(String nome){
		//remove todos os tipos da lista de tipos
		listaRacas.removeAll(listaRacas);
		
		
		try {
			//faz a consulta no banco
			listaRacas=objRacaController.consultarRacas(nome);
			
			//para cada tipo da lista
			for(RacaBean objRaca : listaRacas){
				//cria um vetor que representa a linha
				Vector<String> linha = new Vector<String>();
				//adiciona os campos codigo e nome da linha
				linha.add(String.valueOf(objRaca.getCodRaca()));
				linha.add(objRaca.getNomeRaca());
						
				
				//adiciona a linha ao modelo da tabela
				tabelaModeloRaca.addRow(linha);
				
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro Interno", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} 
		}
	
	private void limparTabela() {
        int tamanho = tabelaModeloRaca.getRowCount();
        
        for (int i = 0; i < tamanho; i++) {
        	tabelaModeloRaca.removeRow(0);
        }
    }
	
	private void limparCampos() {
		txtCod.setText("");
		txtNome.setText("");
	}
	
	protected void do_tabelaConsulta_mouseClicked(MouseEvent arg0) {
		preencherFields();
		PainelTabs.setSelectedIndex(1);
	}
	
	protected void do_btnNovo_actionPerformed(ActionEvent arg0) {
		PainelTabs.setSelectedIndex(1);
		habilitaDesabilita(true);
		txtNome.requestFocusInWindow();
		btnSalvar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);	
	}
	
	
	
	
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		 limparCampos();
	     habilitaDesabilita(true);
	     btnSalvar.setEnabled(false);
	     btnAlterar.setEnabled(false);
	     btnExcluir.setEnabled(false);
	     JOptionPane.showMessageDialog(null,"Opera��o cancelada!","Cancelamento",JOptionPane.ERROR_MESSAGE);
	}
	
	protected void do_btnSalvar_actionPerformed(ActionEvent e) {
        RacaBean objRacaBean = new RacaBean();
		
		//nome	
		if (!txtNome.getText().equals("")) {
			objRacaBean.setNomeRaca(txtNome.getText());
		} else {
			JOptionPane.showMessageDialog(null, "Nome Obrigat�rio", "Campo Obrigat�rio", JOptionPane.WARNING_MESSAGE);
			txtNome.requestFocusInWindow();
			return;
		}	
		
		try {
			objRacaController.cadastrarRaca(objRacaBean);
			limparCampos();
			
			limparTabela();
			preencherTabela();
			
			btnSalvar.setEnabled(false);
			btnAlterar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnCancelar.setEnabled(false);
			
			habilitaDesabilita(false);
			
			//Mudar para a aba da consulta
			
			PainelTabs.setSelectedIndex(0);
		
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Erro Interno", "Erro",JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}	
		
		
	}
	
	
	protected void do_btnAlterar_actionPerformed(ActionEvent e) {
		// cria o objeto a ser inserido
		RacaBean objRaca = new RacaBean();

		// valida e altera campos do objeto
						
		// codigo
		objRaca.setCodRaca(Integer.parseInt(txtCod.getText()));
		objRaca.setNomeRaca(txtNome.getText());
		
		// nome
		if (!txtNome.getText().equals("")) {
			objRaca.setNomeRaca(txtNome.getText());
		} else {
			JOptionPane.showMessageDialog(null, "Nome Obrigat�rio", "Campo Obrigat�rio", JOptionPane.WARNING_MESSAGE);
			txtNome.requestFocusInWindow();
			return;
		}
		try {
			objRacaController.alterarRaca(objRaca);
			
			limparCampos();
			limparTabela();
			preencherTabela();
			
			//desabilita botoes
			btnSalvar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnCancelar.setEnabled(false);
			btnAlterar.setEnabled(false);
			
			// desabilita campos
			habilitaDesabilita(false);
			
			//abre a aba conculta
			PainelTabs.setSelectedIndex(0);
						
		} catch (Exception x) {
			JOptionPane.showMessageDialog(null,"Erro interno!","Erro",JOptionPane.ERROR_MESSAGE);
			x.printStackTrace();
		}	

	}
	
	
 	protected void do_btnExcluir_actionPerformed(ActionEvent e) {
 		int opcao=JOptionPane.showConfirmDialog(null, "Deseja excluir essa Ra�a?","Exclus�o",JOptionPane.YES_NO_OPTION);
 		
 		if(opcao==JOptionPane.YES_OPTION){
 			
 			int codigo=Integer.parseInt(txtCod.getText());
 			
 			try {
 				objRacaController.excluirRaca(codigo);
 				
 				limparCampos();
 				limparTabela();
 				preencherTabela();
 				
 				//desabilita botoes
 				btnSalvar.setEnabled(false);
 				btnExcluir.setEnabled(false);
 				btnCancelar.setEnabled(false);
 				btnAlterar.setEnabled(false);
 				
 				// desabilita campos
 				habilitaDesabilita(true);
 				
 				//abre a aba conculta
 				PainelTabs.setSelectedIndex(0);
 			} catch (Exception f) {
 				JOptionPane.showMessageDialog(null,"Erro interno!","Erro",JOptionPane.ERROR_MESSAGE);
 				f.printStackTrace();
 			}
 			
 			
 			
 		}else{
 			txtNome.requestFocusInWindow();
 		}	
	}
	
	
	protected void do_btnListar_actionPerformed(ActionEvent arg0) {
		limparTabela();
		preencherTabela();
		PainelTabs.setSelectedIndex(0);
		txtNomeConsulta.requestFocusInWindow();
		txtNomeConsulta.setText("");
		
	}
}

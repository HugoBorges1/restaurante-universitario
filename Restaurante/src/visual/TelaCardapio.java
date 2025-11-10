package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TelaCardapio extends JFrame implements ActionListener {
    
    private JTextField tfdia;
    private JTextField tfpratoprincipal;
    private JTextField tfbebida;
    private JTextField tfsobremesa;
    private JLabel lbdia;
    private JLabel lbpratoprincipal;
    private JLabel lbbebida;
    private JLabel lbsobremesa;
    private JButton btadd;
    private JButton btsair;
    private JButton btlimpa;
    private JButton btdelete;
    private JTable tbcardapio;
    private DefaultTableModel tbmodel;
    private JPanel Painel;
    

    private List<DiaCardapio> diasCardapio = new ArrayList<>();
    private DiaCardapio cardapio;
    
    public TelaCardapio() { 
        
        setTitle("Adicionar Cardápio do Dia");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        tbmodel = new DefaultTableModel(new String[]{"Dia da semana"}, 0);
        tbcardapio = new JTable(tbmodel);
        tbcardapio.getSelectionModel().addListSelectionListener(e -> detalhesDia());
        tbcardapio.setBackground(Color.LIGHT_GRAY);
                
        JScrollPane scrollPaneTable = new JScrollPane(tbcardapio);
        add(scrollPaneTable, BorderLayout.CENTER);
        
        Painel = new JPanel(new GridLayout(6,4));
        
        lbdia = new JLabel("Dia da semana:");
        lbpratoprincipal = new JLabel("Prato Principal:");
        lbbebida = new JLabel("Bebida:");
        lbsobremesa = new JLabel("Sobremesa:");
        
        tfdia = new JTextField();
        tfpratoprincipal = new JTextField();
        tfbebida = new JTextField();
        tfsobremesa = new JTextField();
        
        btadd = new JButton("Adicionar Cardápio");
        btsair = new JButton("Sair");
        btlimpa = new JButton("Limpar campos");
        btdelete = new JButton("Excluir dia");
        btadd.addActionListener(this);;
        btsair.addActionListener(this);
        btlimpa.addActionListener(this);
        btdelete.addActionListener(this);
                
        Painel.add(lbdia);
        Painel.add(tfdia);
        Painel.add(lbpratoprincipal);
        Painel.add(tfpratoprincipal);
        Painel.add(lbbebida);
        Painel.add(tfbebida);
        Painel.add(lbsobremesa);
        Painel.add(tfsobremesa);
        Painel.add(btadd); Painel.add(btlimpa); 
        Painel.add(btsair); Painel.add(btdelete);
   
        add(Painel, BorderLayout.NORTH);

        setVisible(true);
        
    }
    
    private void detalhesDia(){
        
        int selectedRow = tbcardapio.getSelectedRow();
        if(selectedRow != -1){
            
            DiaCardapio diaselecionado = diasCardapio.get(selectedRow);
            tfdia.setText(diaselecionado.getDiaSemana());
            tfpratoprincipal.setText(diaselecionado.getPratoPrincipal());
            tfbebida.setText(diaselecionado.getBebida());
            tfsobremesa.setText(diaselecionado.getSobremesa());
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btadd) {
            
            cardapio = new DiaCardapio(tfdia.getText(), tfpratoprincipal.getText(), tfbebida.getText(),tfsobremesa.getText());
            diasCardapio.add(cardapio);
            tbmodel.addRow(new String[] {tfdia.getText()});
            limparCampos();
 
        }else if (e.getSource() == btsair){
       
            int retry = JOptionPane.showConfirmDialog(null, "Deseja realmentente sair ?", "Conformação de saída", JOptionPane.YES_NO_OPTION);
            if(retry == 0){
                
                System.exit(1);
            }
            
        }else if(e.getSource() == btlimpa){
            
            limparCampos();
            
        }else if (e.getSource() == btdelete) {
            
            int selectedRow = tbcardapio.getSelectedRow();
            if (selectedRow != -1) {
                diasCardapio.remove(selectedRow);
                tbmodel.removeRow(selectedRow);
                limparCampos();
                
            }
        }
    }

    private void limparCampos() {
        tfdia.setText("");
        tfpratoprincipal.setText("");
        tfbebida.setText("");
        tfsobremesa.setText("");
    }

}
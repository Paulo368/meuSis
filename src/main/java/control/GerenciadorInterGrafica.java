/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.Cliente;
import org.hibernate.HibernateException;
import view.DlgCadCliente;
import view.DlgCadPedido;
import view.DlgConfiguracoes;
import view.DlgPesqCliente;
import view.FrmPrincipal;

/**
 *
 * @author 1547816
 */
public class GerenciadorInterGrafica {

    private FrmPrincipal princ = null;
    private DlgCadCliente cadCli = null;
    private DlgCadPedido cadPed = null;
    private DlgConfiguracoes config = null;
    private DlgPesqCliente pesqCli = null;
    
    GerenciadorDominio gerDom;
//    GerenciadorDominioCliente gerDomCli;
//    GerenciadorDominioVendas gerDomVendas;
    
    
    // SINGLETON
    private static final GerenciadorInterGrafica myInstance = new GerenciadorInterGrafica();
    
    private GerenciadorInterGrafica() {
        try {
            gerDom = new GerenciadorDominio();
        } catch ( ExceptionInInitializerError | HibernateException ex) {
            JOptionPane.showMessageDialog(princ, "ERRO ao abrir a conexão com o banco de dados.", "Abrir conexão", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static GerenciadorInterGrafica getMyInstance() {
        return myInstance;
    }

    public GerenciadorDominio getGerDom() {
        return gerDom;
    }
    
    
    
    // ABRIR JDIALOG
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null){     
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class).newInstance(parent,true);                                
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() + ". " + ex.getMessage() );
            } 
        }               
        dlg.setVisible(true); 
        return dlg;
    }
    
    public void abrirPrincipal () {
        princ = new FrmPrincipal();
        princ.setVisible(true);
    }
        
    public void abrirCadastroCliente () {
        cadCli = (DlgCadCliente) abrirJanela(princ, cadCli,  DlgCadCliente.class );
    }
    
    public Cliente abrirPesqCliente() {
        pesqCli = (DlgPesqCliente) abrirJanela(princ, pesqCli, DlgPesqCliente.class );
        return pesqCli.getCliSelecionado();
    }
    
    public void abrirCadastroPedido () {
        cadPed = (DlgCadPedido) abrirJanela(princ, cadPed,  DlgCadPedido.class );
    }
    
    public void abrirConfiguracoes () {
        config = (DlgConfiguracoes) abrirJanela(princ, config,  DlgConfiguracoes.class );
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // TRADUÇÃO
        javax.swing.UIManager.put("OptionPane.yesButtonText", "Sim"); 
        javax.swing.UIManager.put("OptionPane.noButtonText", "Não");
                

        GerenciadorInterGrafica.getMyInstance().abrirPrincipal();
               
    }
    
}

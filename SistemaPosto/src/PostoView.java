//LUAN MODESTO

import java.text.DecimalFormat;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PostoView extends JFrame implements ActionListener {

    DecimalFormat df = new DecimalFormat("0.000"); //Preços
    DecimalFormat rs = new DecimalFormat("0.00"); //Litros 

    /*
    ****-DECLARAÇÃO DE OBJETOS-******
     */
    public static Container ctnTela;
    public static JLabel lblLogo, lblServ, lblInfo, lblPreco, lblAdc, lblAcs, lblLucro, lblValorProd, lblValorServ;
    public static JLabel lblRProd, lblRServ, lblLitroP, lblCapMax;
    public static JButton btnVender, btnRelat, btnAbast, btnPagar;
    public static JComboBox cmbServ, cmbAdc;
    public static JTextField txtLitro, txtCapMax, txtReabast;

    /*
    ****-DECLARAÇÃO DE OBJETOS AUXILIARES-****
     */
    public static String vProd[] = {"Escolha uma opção...", "1 - Gasolina Comum", "2 - Gasolina Aditivada", "3- Etanol", "4 - Diesel"};
    public static String vAdic[] = {"Escolha uma opção...", "1 - Ducha Ecológica", "2 - Troca de Óleo", "3- Balanceamento", "4 - Café"};
    public static int tmpTotal, tmpComb, tmpLitros, tmpServ;
    public static float tmpValor;

    public PostoView() {

        super("Sistema de Gerenciamento de Vendas - Posto de Gasolina");

        PostoVO objVO = new PostoVO();

        /**
         * *** CONSTRUÇÃO DOS OBJETOS**
         */
        ctnTela = new Container();
        ctnTela.setLayout(null);
        this.add(ctnTela);

        lblLogo = new JLabel("POSTO DE GASOLINA");
        lblLogo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblLogo.setForeground(new Color(0, 110, 110));
        lblLogo.setBounds(300, 10, 200, 60);
        ctnTela.add(lblLogo);

        lblServ = new JLabel("ABASTECIMENTO DE TANQUES");
        lblServ.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblServ.setBounds(45, 80, 600, 60);
        ctnTela.add(lblServ);

        lblInfo = new JLabel("1 - Gasolina Comum  2 - Gasolina Aditivada  3- Etanol  4 - Diesel");
        lblInfo.setFont(new Font("Arial", Font.BOLD, 14));
        lblInfo.setBounds(45, 120, 1000, 60);
        ctnTela.add(lblInfo);

        cmbServ = new JComboBox(vProd); // combo box combustivel
        cmbServ.setFont(new Font("Arial", Font.BOLD, 14));
        cmbServ.setForeground(new Color(0, 110, 110));
        cmbServ.setBounds(45, 170, 500, 25);

        cmbServ.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (cmbServ.getSelectedIndex() == 1) {
                    txtLitro.setEditable(true);
                    txtCapMax.setText(Float.toString(SistemaPosto.objDados.Tanque[0]));
                    tmpComb = 1;

                } else if (cmbServ.getSelectedIndex() == 2) {
                    txtLitro.setEditable(true);
                    txtCapMax.setText(Float.toString(SistemaPosto.objDados.Tanque[1]));
                    tmpComb = 2;

                } else if (cmbServ.getSelectedIndex() == 3) {
                    txtLitro.setEditable(true);
                    txtCapMax.setText(Float.toString(SistemaPosto.objDados.Tanque[2]));
                    tmpComb = 3;

                } else if (cmbServ.getSelectedIndex() == 4) {
                    txtLitro.setEditable(true);
                    txtCapMax.setText(Float.toString(SistemaPosto.objDados.Tanque[3]));
                    tmpComb = 4;
                }

                lblRServ.setText("R$ " + rs.format((tmpTotal)));

            }

        });

        ctnTela.add(cmbServ);

        lblLitroP = new JLabel("VALOR:");
        lblLitroP.setFont(new Font("Arial", Font.BOLD, 14));
        lblLitroP.setBounds(45, 190, 1000, 60);
        ctnTela.add(lblLitroP);

        txtLitro = new JTextField();
        txtLitro.setFont(new Font("Arial", Font.BOLD, 14));
        txtLitro.setForeground(new Color(0, 110, 110));
        txtLitro.setBounds(45, 250, 80, 30);
        txtLitro.setEditable(false);
        ctnTela.add(txtLitro);

        lblCapMax = new JLabel("Capacidade de Tanque");
        lblCapMax.setFont(new Font("Arial", Font.BOLD, 14));
        lblCapMax.setBounds(200, 190, 1000, 60);
        ctnTela.add(lblCapMax);

        txtCapMax = new JTextField("" + 0.0);
        txtCapMax.setFont(new Font("Arial", Font.BOLD, 14));
        txtCapMax.setBounds(200, 250, 100, 30);
        txtCapMax.setEditable(false);
        ctnTela.add(txtCapMax);

        txtReabast = new JTextField("20000 Máx.");
        txtReabast.setFont(new Font("Arial", Font.BOLD, 14));
        txtReabast.setBounds(350, 250, 100, 30);
        txtReabast.setEditable(false);
        ctnTela.add(txtReabast);

        lblAdc = new JLabel("SERVIÇOS ADICIONAIS");
        lblAdc.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblAdc.setBounds(45, 300, 300, 60);
        ctnTela.add(lblAdc);

        lblAcs = new JLabel("1 - Ducha Ecólogica  2 - Troca de Óleo  3- Balanceamento  4 - Café");
        lblAcs.setFont(new Font("Arial", Font.BOLD, 14));
        lblAcs.setBounds(45, 340, 1000, 60);
        ctnTela.add(lblAcs);

        lblValorServ = new JLabel("VALOR DO PRODUTO:");
        lblValorServ.setFont(new Font("Arial", Font.BOLD, 14));
        lblValorServ.setBounds(600, 340, 500, 60);
        ctnTela.add(lblValorServ);

        lblRServ = new JLabel("R$ "+ 0.0);
        lblRServ.setFont(new Font("Arial", Font.BOLD, 20));
        lblRServ.setForeground(new Color(0, 110, 110));
        lblRServ.setBounds(650, 380, 500, 60);
        ctnTela.add(lblRServ);

        cmbAdc = new JComboBox(vAdic);
        cmbAdc.setFont(new Font("Arial", Font.BOLD, 14));
        cmbAdc.setBounds(45, 390, 500, 25);
        cmbAdc.setForeground(new Color(0, 110, 110));
        ctnTela.add(cmbAdc);

        cmbAdc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                tmpServ = cmbAdc.getSelectedIndex();

                if (tmpServ == 1) {
                    tmpTotal += 8.00;

                } else if (tmpServ == 2) {
                    tmpTotal += 50.00;

                } else if (tmpServ == 3) {
                    tmpTotal += 35.00;

                } else if (tmpServ == 4) {
                    tmpTotal += 2.00;

                }

                SistemaPosto.objDados.venderServicosAdd(
                        tmpServ);

                lblRServ.setText("R$ " + rs.format((tmpTotal)));

            }
        }
        );

        lblLucro = new JLabel("CAIXA:   R$ "+0.0);
        lblLucro.setFont(new Font("Verdana", Font.BOLD, 12));
        lblLucro.setBounds(45, 530, 200, 60);
        ctnTela.add(lblLucro);

        btnPagar = new JButton("VENDER");
        btnPagar.setBounds(650, 550, 100, 40);
        btnPagar.setForeground(new Color(0, 110, 110));
        btnPagar.addActionListener(this);

        ctnTela.add(btnPagar);

        btnRelat = new JButton("RELÁTORIO");
        btnRelat.addActionListener(this);

        btnRelat.setBounds(500, 550, 120, 40);
        btnRelat.setForeground(new Color(0, 110, 110));
        ctnTela.add(btnRelat);

        /**
         * ***** CONFIGS JANELA******
         */
        this.setLocation(300, 60);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 640);
        this.show();

    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnPagar) {

            if (txtLitro.getText().isEmpty()) {
                tmpValor = 0;
            } else {
                tmpValor = Float.parseFloat(txtLitro.getText());
            }

            tmpTotal += tmpValor;
            SistemaPosto.objDados.abastecerVeiculo(tmpComb, tmpValor);

            JOptionPane.showMessageDialog(null, "Venda Concluída !!!\nValor: R$ " + rs.format(tmpTotal), "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            tmpTotal = 0;

            this.dispose();
            new PostoView().setVisible(true);
            tmpServ = 0;

            lblLucro.setText("CAIXA: R$ " + rs.format((SistemaPosto.objDados.lucroTotal)));

        } else if (evt.getSource() == btnRelat) {

            RelatorioView telaRealtorio = new RelatorioView();
            this.dispose();

        }

        /**
         * ***********************************
         */
    }
}

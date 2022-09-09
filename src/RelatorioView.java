
import java.text.DecimalFormat;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class RelatorioView extends JFrame implements ActionListener {

    /*
    ****-DECLARAÇÃO DE OBJETOS-******
     */
    public static Container ctnRelatorio;
    public static JLabel lblLogo, lblServ, lblInfo, lblDesp, lblDespA;
    public static JLabel lblRelat, lblRelatA, lblRelatB, lblRelatC, lblRelatD, lblRServ, lblLitroP, lblCapMax;
    public static JLabel lblRelatServ, lblRelatServA,lblRelatServB, lblRelatServC, lblRelatServD;
    public static JLabel lblRelatAA, lblRelatBB, lblRelatCC, lblRelatDD;
    public static JButton btnVoltar, btnReabast;
    public static JComboBox cmbServ, cmbAdc;
    public static JTextField txtLitro, txtCapMax, txtReabast;
    public static PostoView appPosto;

    /*
    ****-DECLARAÇÃO DE OBJETOS AUXILIARES-****
     */
    public static int tmpComb, tmpLitros;

    DecimalFormat df = new DecimalFormat("0.000"); //Preços

    DecimalFormat rs = new DecimalFormat("0.00"); //Litros 

    public static String vProd[] = {"Escolha uma opção...", "1 - Gasolina Comum", "2 - Gasolina Adtivada", "3- Etanol", "4 - Diesel"};

    public RelatorioView() {

        super("Sistema de Gerenciamento de Vendas - Posto de Gasolina");

        /**
         * *** CONSTRUÇÃO DOS OBJETOS**
         */
        ctnRelatorio = new Container();
        ctnRelatorio.setLayout(null);
        this.add(ctnRelatorio);

        lblLogo = new JLabel("POSTO DE GASOLINA");
        lblLogo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblLogo.setForeground(new Color(0, 110, 110));
        lblLogo.setBounds(200, 10, 200, 60);
        ctnRelatorio.add(lblLogo);

        lblServ = new JLabel("BOMBA DE COMBUSÍVEL");
        lblServ.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblServ.setBounds(45, 80, 800, 60);
        ctnRelatorio.add(lblServ);

        lblInfo = new JLabel("1 - Gasolina Comum  2 - Gasolina Aditivada  3- Etanol  4 - Diesel");
        lblInfo.setFont(new Font("Arial", Font.BOLD, 14));
        lblInfo.setBounds(45, 120, 1000, 60);
        ctnRelatorio.add(lblInfo);

        cmbServ = new JComboBox(vProd); // COMBO BOX ABASTECER BOMBA
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

            }

        });

        ctnRelatorio.add(cmbServ);

        lblLitroP = new JLabel("LITROS:");
        lblLitroP.setFont(new Font("Arial", Font.BOLD, 14));
        lblLitroP.setBounds(45, 190, 1000, 60);
        ctnRelatorio.add(lblLitroP);

        txtLitro = new JTextField();
        txtLitro.setFont(new Font("Arial", Font.BOLD, 14));
        txtLitro.setForeground(new Color(0, 110, 110));
        txtLitro.setBounds(45, 250, 80, 30);
        txtLitro.setEditable(false);
        ctnRelatorio.add(txtLitro);

        lblCapMax = new JLabel("Capacidade de Tanque");
        lblCapMax.setFont(new Font("Arial", Font.BOLD, 14));
        lblCapMax.setBounds(200, 190, 1000, 60);
        ctnRelatorio.add(lblCapMax);

        txtCapMax = new JTextField("" + 0.0);
        txtCapMax.setFont(new Font("Arial", Font.BOLD, 14));
        txtCapMax.setBounds(200, 250, 100, 30);
        txtCapMax.setEditable(false);
        ctnRelatorio.add(txtCapMax);

        btnReabast = new JButton("REABASTECER");
        btnReabast.setBounds(420, 240, 150, 40);
        btnReabast.addActionListener(this);
        btnReabast.setForeground(new Color(0, 110, 110));
        ctnRelatorio.add(btnReabast);

        lblRelat = new JLabel("COMBUSTÍVEIS VENDIDOS");
        lblRelat.setFont(new Font("Verdana", Font.BOLD, 14));
        lblRelat.setBounds(45, 280, 400, 60);
        ctnRelatorio.add(lblRelat);

        lblRelatA = new JLabel("Gasolina Comum:");
        lblRelatA.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatA.setBounds(45, 310, 200, 60);
        ctnRelatorio.add(lblRelatA);

        lblRelatAA = new JLabel("0.0");
        lblRelatAA.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatAA.setBounds(205, 310, 200, 60);
        lblRelatAA.setText("R$ " + rs.format(SistemaPosto.objDados.lucroComb[0]) + " // " + df.format(SistemaPosto.objDados.litrosVendidos[0]));
        ctnRelatorio.add(lblRelatAA);

        lblRelatB = new JLabel("Gasolina Aditivada:");
        lblRelatB.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatB.setBounds(45, 340, 200, 60);
        ctnRelatorio.add(lblRelatB);

        lblRelatBB = new JLabel("" + 0.0);
        lblRelatBB.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatBB.setBounds(205, 340, 200, 60);
        lblRelatBB.setText("R$ " + rs.format(SistemaPosto.objDados.lucroComb[1]) + " // " + df.format(SistemaPosto.objDados.litrosVendidos[1]));
        ctnRelatorio.add(lblRelatBB);

        lblRelatC = new JLabel("Etanol:");
        lblRelatC.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatC.setBounds(45, 370, 200, 60);
        ctnRelatorio.add(lblRelatC);

        lblRelatCC = new JLabel("" + 0.0);
        lblRelatCC.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatCC.setBounds(205, 370, 200, 60);
        lblRelatCC.setText("R$ " + rs.format(SistemaPosto.objDados.lucroComb[2]) + " // " + df.format(SistemaPosto.objDados.litrosVendidos[2]));
        ctnRelatorio.add(lblRelatCC);

        lblRelatD = new JLabel("Diesel:");
        lblRelatD.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatD.setBounds(45, 400, 200, 60);
        ctnRelatorio.add(lblRelatD);

        lblRelatDD = new JLabel("" + 0.0);
        lblRelatDD.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatDD.setBounds(205, 400, 200, 60);
        lblRelatDD.setText("R$ " + rs.format(SistemaPosto.objDados.lucroComb[3]) + " // " + df.format(SistemaPosto.objDados.litrosVendidos[3]));
        ctnRelatorio.add(lblRelatDD);

        lblRelatServ = new JLabel("SERVIÇOS VENDIDOS:");
        lblRelatServ.setFont(new Font("Verdana", Font.BOLD, 14));
        lblRelatServ.setBounds(340, 280, 400, 60);
        ctnRelatorio.add(lblRelatServ);
        
        lblRelatServ = new JLabel("Ducha Ecológica:");
        lblRelatServ.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatServ.setBounds(340, 310, 400, 60);
        ctnRelatorio.add(lblRelatServ);
        
        lblRelatServA = new JLabel(""+0.0);
        lblRelatServA.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatServA.setBounds(530, 310, 400, 60);
        lblRelatServA.setText("R$ " + rs.format(SistemaPosto.objDados.lucroServ[0]) + " // " + SistemaPosto.objDados.ServicosAdd[0]);
        ctnRelatorio.add(lblRelatServA);
        
        lblRelatServ = new JLabel("Troca de Óleo:");
        lblRelatServ.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatServ.setBounds(340, 340, 400, 60);
        ctnRelatorio.add(lblRelatServ);
        
        lblRelatServB = new JLabel(""+0.0);
        lblRelatServB.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatServB.setBounds(530, 340, 400, 60);
        lblRelatServB.setText("R$ " + rs.format(SistemaPosto.objDados.lucroServ[1]) + " // " + SistemaPosto.objDados.ServicosAdd[1]);
        ctnRelatorio.add(lblRelatServB);
        
        lblRelatServ = new JLabel("Balaceamento:");
        lblRelatServ.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatServ.setBounds(340, 370, 400, 60);
        ctnRelatorio.add(lblRelatServ);
        
        lblRelatServC = new JLabel(""+0.0);
        lblRelatServC.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatServC.setBounds(530, 370, 400, 60);
        lblRelatServC.setText("R$ " + rs.format(SistemaPosto.objDados.lucroServ[2]) + " // " + SistemaPosto.objDados.ServicosAdd[2]);
        ctnRelatorio.add(lblRelatServC);
        
        lblRelatServ = new JLabel("Café:");
        lblRelatServ.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatServ.setBounds(340, 400, 400, 60);
        ctnRelatorio.add(lblRelatServ);
        
        lblRelatServD = new JLabel(""+0.0);
        lblRelatServD.setFont(new Font("Arial", Font.BOLD, 14));
        lblRelatServD.setBounds(530, 400, 400, 60);
        lblRelatServD.setText("R$ " + rs.format(SistemaPosto.objDados.lucroServ[3]) + " // " + SistemaPosto.objDados.ServicosAdd[3]);
        ctnRelatorio.add(lblRelatServD);


        lblDesp = new JLabel("DESPESAS TOTAL:");
        lblDesp.setFont(new Font("Verdana", Font.BOLD, 14));
        lblDesp.setBounds(45, 440, 200, 60);
        ctnRelatorio.add(lblDesp);

        lblDespA = new JLabel("R$ " + 0.0);
        lblDespA.setFont(new Font("Arial", Font.BOLD, 18));
        lblDespA.setForeground(new Color(0, 110, 110));
        lblDespA.setBounds(65, 480, 200, 60);
        lblDespA.setText("R$ " + rs.format(SistemaPosto.objDados.despesaCombustiveis));
        ctnRelatorio.add(lblDespA);

        btnVoltar = new JButton("MENU PRINCIPAL");
        btnVoltar.setBounds(420, 540, 150, 40);
        btnVoltar.addActionListener(this);
        btnVoltar.setForeground(new Color(0, 110, 110));
        ctnRelatorio.add(btnVoltar);

        this.setLocation(300, 60);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(660, 640);
        this.show();
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnReabast) {

            tmpLitros = Integer.parseInt(txtLitro.getText());
            SistemaPosto.objDados.abastecerBomba(tmpComb, tmpLitros);

            this.dispose();
            new RelatorioView().setVisible(true);

        } else if (evt.getSource() == btnVoltar) {

            this.dispose();
            appPosto = new PostoView();

        }

    }
}

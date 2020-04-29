// Luan Modesto
// Michael Ferreira

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class PostoVO {

    DecimalFormat df = new DecimalFormat("0.000"); //Preços
    DecimalFormat rs = new DecimalFormat("0.00"); //Litros 

    public int[] ServicosAdd = new int[5]; //0 = Ducha | 1 = Óleo | 2 = Balanceamento | 3 = Café | 4 = Total
    public float[] Tanque = new float[4]; //0 = Gasolina Comum | 1 = Gasolina Adiditivada | 2 = Etanol | 3 = Diesel
    public float lucroServicosAdd;
    public float[] litrosComprados = new float[5]; //0 = Gasolina Comum | 1 = Gasolina Adiditivada | 2 = Etanol | 3 = Diesel | 4 = Total
    public float[] litrosVendidos = new float[5]; //0 = Gasolina Comum | 1 = Gasolina Adiditivada | 2 = Etanol | 3 = Diesel | 4 = Total

    public float despesaCombustiveis;
    public float lucroTotal;
    public float[] lucroComb = new float[4];
    public float[] lucroServ = new float[4];

    public PostoVO() { //Inicializa os Tanque com 0;
        for (int i = 0; i < 4; i++) {
            this.Tanque[i] = 0;
        }
    }

    public void venderServicosAdd(int ServicosAdd) {
        if (ServicosAdd == 1) {
            this.ServicosAdd[0]++;
            this.ServicosAdd[4]++;
            this.lucroTotal += 8.00;
            this.lucroServ[0] += 8.00;

        } else if (ServicosAdd == 2) {
            this.ServicosAdd[1]++;
            this.ServicosAdd[4]++;
            this.lucroTotal += 50.00;
            this.lucroServ[1] += 50.00;

        } else if (ServicosAdd == 3) {
            this.ServicosAdd[2]++;
            this.ServicosAdd[4]++;
            this.lucroTotal += 35.00;
            this.lucroServ[2] += 35.00;

        } else if (ServicosAdd == 4) {
            this.ServicosAdd[3]++;
            this.ServicosAdd[4]++;
            this.lucroTotal += 2.00;
            this.lucroServ[3] += 2.00;

        }

    }

    public void abastecerBomba(int tmpComb, int tmpValor) {
        if (tmpComb == 1) { //BOMBA GASOLINA COMUM

            if ((this.Tanque[0] + tmpValor) <= 20000 && (tmpValor > 0)) {
                this.Tanque[0] += tmpValor;
                this.litrosComprados[0] += tmpValor;
                this.litrosComprados[4] += tmpValor;
                this.despesaCombustiveis += (tmpValor * 1.19);
                JOptionPane.showMessageDialog(null, "Tanque abastecido com sucesso !!!", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.Tanque[0] == 20000 && (tmpValor > 0)) {
                JOptionPane.showMessageDialog(null, "O Tanque está cheio!!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else if (tmpValor <= 0) {
                JOptionPane.showMessageDialog(null, "Erro, Valor negativo !!!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if ((this.Tanque[0] + tmpValor) > 2000) {
                JOptionPane.showMessageDialog(null, "O Valor excede a capacidade do Tanque!", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        } else if (tmpComb == 2) {//BOMBA GASOLINA ADTIVADA

            if ((this.Tanque[1] + tmpValor) <= 20000 && (tmpValor > 0)) {
                this.Tanque[1] += tmpValor;
                this.litrosComprados[1] += tmpValor;
                this.litrosComprados[4] += tmpValor;
                this.despesaCombustiveis += (tmpValor * 2.19);
                JOptionPane.showMessageDialog(null, "Tanque abastecido com sucesso !!!", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.Tanque[1] == 20000 && (tmpValor > 0)) {
                JOptionPane.showMessageDialog(null, "O Tanque está cheio!!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else if (tmpValor <= 0) {
                JOptionPane.showMessageDialog(null, "Erro, Valor negativo !!!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if ((this.Tanque[1] + tmpValor) > 2000) {
                JOptionPane.showMessageDialog(null, "O Valor excede a capacidade do Tanque!", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        } else if (tmpComb == 3) {// BOMBA ETANOL

            if ((this.Tanque[2] + tmpValor) <= 20000 && (tmpValor > 0)) {
                this.Tanque[2] += tmpValor;
                this.litrosComprados[2] += tmpValor;
                this.litrosComprados[4] += tmpValor;
                this.despesaCombustiveis += (tmpValor * 2.29);
                JOptionPane.showMessageDialog(null, "Tanque abastecido com sucesso !!!", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.Tanque[2] == 20000 && (tmpValor > 0)) {
                JOptionPane.showMessageDialog(null, "O Tanque está cheio!!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else if (tmpValor <= 0) {
                JOptionPane.showMessageDialog(null, "Erro, Valor negativo !!!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if ((this.Tanque[2] + tmpValor) > 2000) {
                JOptionPane.showMessageDialog(null, "O Valor excede a capacidade do Tanque!", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        } else if (tmpComb == 4) {//BOMBA DIESEL

            if ((this.Tanque[3] + tmpValor) <= 20000 && (tmpValor > 0)) {
                this.Tanque[3] += tmpValor;
                this.litrosComprados[3] += tmpValor;
                this.litrosComprados[4] += tmpValor;
                this.despesaCombustiveis += (tmpValor * 1.39);
                JOptionPane.showMessageDialog(null, "Tanque abastecido com sucesso !!!", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.Tanque[3] == 20000 && (tmpValor > 0)) {
                JOptionPane.showMessageDialog(null, "O Tanque está cheio!!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else if (tmpValor <= 0) {
                JOptionPane.showMessageDialog(null, "Erro, Valor negativo !!!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if ((this.Tanque[3] + tmpValor) > 2000) {
                JOptionPane.showMessageDialog(null, "O Valor excede a capacidade do Tanque!", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        }
    }

    public void abastecerVeiculo(int tmpComb, float tmpValor) {

        float tmpLitros;

        if (tmpComb == 1) {

            tmpLitros = (float) (tmpValor / 4.19);

            if ((this.Tanque[0] - tmpLitros) >= 0 && (tmpValor > 0)) {
                this.Tanque[0] -= tmpLitros;
                this.lucroComb[0] += tmpValor;
                this.litrosVendidos[0] += tmpLitros;
                this.litrosVendidos[4] += tmpLitros;
                this.lucroTotal += tmpValor;
                JOptionPane.showMessageDialog(null, "Abastecimento efetuado !!!\n" + df.format(tmpLitros) + " Litros", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.Tanque[0] == 0 && (tmpValor > 0)) {
                JOptionPane.showMessageDialog(null, "A bomba de Gasolina Comum está vazia !!!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else if (tmpValor < 0) {
                JOptionPane.showMessageDialog(null, "Erro, Valor negativo !!!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (tmpLitros > this.Tanque[0]) {
                JOptionPane.showMessageDialog(null, "Não há combustível o suficiente !!!", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        } else if (tmpComb == 2) {

            tmpLitros = (float) (tmpValor / 4.39);

            if ((this.Tanque[1] - tmpLitros) >= 0 && (tmpValor > 0)) {
                this.Tanque[1] -= tmpLitros;
                this.lucroComb[1] += tmpValor;
                this.litrosVendidos[1] += tmpLitros;
                this.litrosVendidos[4] += tmpLitros;
                this.lucroTotal += tmpValor;
                JOptionPane.showMessageDialog(null, "Abastecimento efetuado !!!\n" + df.format(tmpLitros) + " Litros", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.Tanque[1] == 0 && (tmpValor > 0)) {
                JOptionPane.showMessageDialog(null, "A bomba de Gasolina Aditivada está vazia !!!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else if (tmpValor < 0) {
                JOptionPane.showMessageDialog(null, "Erro, Valor negativo !!!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (tmpLitros > this.Tanque[1]) {
                JOptionPane.showMessageDialog(null, "Não há combustível o suficiente !!!", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        } else if (tmpComb == 3) {

            tmpLitros = (float) (tmpValor / 2.39);

            if ((this.Tanque[2] - tmpLitros) >= 0 && (tmpValor > 0)) {
                this.Tanque[2] -= tmpLitros;
                this.lucroComb[2] += tmpValor;
                this.litrosVendidos[2] += tmpLitros;
                this.litrosVendidos[4] += tmpLitros;
                this.lucroTotal += tmpValor;
                JOptionPane.showMessageDialog(null, "Abastecimento efetuado !!!\n" + df.format(tmpLitros) + " Litros", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.Tanque[2] == 0 && (tmpValor > 0)) {
                JOptionPane.showMessageDialog(null, "A bomba de Etanol está vazia !!!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else if (tmpValor < 0) {
                JOptionPane.showMessageDialog(null, "Erro, Valor negativo !!!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (tmpLitros > this.Tanque[2]) {
                JOptionPane.showMessageDialog(null, "Não há combustível suficiente !!!", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        } else if (tmpComb == 4) {

            tmpLitros = (float) (tmpValor / 3.29);

            if ((this.Tanque[3] - tmpLitros) >= 0 && (tmpValor > 0)) {
                this.Tanque[3] -= tmpLitros;
                this.lucroComb[3] += tmpValor;
                this.litrosVendidos[3] += tmpLitros;
                this.litrosVendidos[4] += tmpLitros;
                this.lucroTotal += tmpValor;
                JOptionPane.showMessageDialog(null, "Abastecimento efetuado !!!\n" + df.format(tmpLitros) + " Litros", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.Tanque[3] == 0 && (tmpValor > 0)) {
                JOptionPane.showMessageDialog(null, "A bomba de Diesel está vazia !!!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else if (tmpValor < 0) {
                JOptionPane.showMessageDialog(null, "Erro, Valor negativo !!!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (tmpLitros > this.Tanque[3]) {
                JOptionPane.showMessageDialog(null, "Não há combustível suficiente !!!", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        }
    }

}

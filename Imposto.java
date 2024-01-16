package package03_EstruturaCondicional.challenge;
import java.util.Scanner;
import java.util.Locale;

//Estrutura Condicinal
public class Imposto {
    public static void main(String[] args) {

        Double rendaAnual, salario, prestacaoServico, ganhoCapital, gastosMedicos, gastosEducacionais;
        Double impostoSalario, impostoServico, impostoGanhoCapital, impostoBrutoTotal, abatimento, impostoDevido;
        Double maximoDedutivel, gastosDedutiveis;

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        System.out.print("Renda anual com salário: ");
        rendaAnual = scan.nextDouble();
        System.out.print("Renda anual com prestação de serviço: ");
        prestacaoServico = scan.nextDouble();
        System.out.print("Renda anual com ganho de capital: ");
        ganhoCapital = scan.nextDouble();
        System.out.print("Gastos médicos: ");
        gastosMedicos = scan.nextDouble();
        System.out.print("Gastos educacionais: ");
        gastosEducacionais = scan.nextDouble();

        scan.close();

        
        //Cálculo de imposto sobre salário
        salario = rendaAnual / 12;

        if (salario < 3000.0) {
            impostoSalario = 0.0;
        } else if (salario < 5000.0) {
            impostoSalario = rendaAnual * 0.1;
        } else {
            impostoSalario = rendaAnual * 0.2;
        }

        //Imposto sobre serviço e ganho de capital
        impostoServico = (prestacaoServico > 0) ? prestacaoServico * 0.15 : 0.0;

        if (ganhoCapital > 0.0) {
            impostoGanhoCapital = ganhoCapital * 0.20;
        } else {
            impostoGanhoCapital = 0.0;
        }

        impostoBrutoTotal = impostoSalario + impostoServico + impostoGanhoCapital;
        
        maximoDedutivel = (gastosMedicos > 0 || gastosEducacionais > 0) ? impostoBrutoTotal * 0.30 : 0.00; // Ajuste de melhoria baseado no código da Vanessa
        gastosDedutiveis = gastosMedicos + gastosEducacionais;

        abatimento = (gastosDedutiveis > maximoDedutivel) ? maximoDedutivel : gastosDedutiveis;

        if (gastosDedutiveis > maximoDedutivel) {
            abatimento = maximoDedutivel;
        } else {
            abatimento = gastosDedutiveis;
        }

        impostoDevido = impostoBrutoTotal - abatimento;

        System.out.println();
        System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
        System.out.println();
        System.out.println("CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: %.2f%n", impostoSalario);
        System.out.printf("Imposto sobre serviços: %.2f%n", impostoServico);
        System.out.printf("Imposto sobre ganho de capital: %.2f%n", impostoGanhoCapital);

        System.out.println();
        System.out.println("DEDUÇÕES:");
        System.out.printf("Máximo dedutível: %.2f%n", maximoDedutivel);
        System.out.printf("Gastos dedutíveis: %.2f%n ", gastosDedutiveis);

        System.out.println();
        System.out.println("RESUMO:");
        System.out.printf("Imposto bruto total: %.2f%n", impostoBrutoTotal);
        System.out.printf("Abatimento: %.2f%n", abatimento);
        System.out.printf("Imposto devido: %.2f%n", impostoDevido);

        System.out.println();

    }
}
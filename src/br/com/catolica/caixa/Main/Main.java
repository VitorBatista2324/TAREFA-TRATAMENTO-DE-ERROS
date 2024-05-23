import br.com.catolica.caixa.Controller.Controller;
import br.com.catolica.caixa.Model.Conta;
import java.time.LocalDate;


    public static void main(String[] args) {
        Controller controller = new Controller();


        try {
            Conta conta1 = controller.criarConta("João", LocalDate.now(), "12345678901", "senha123");
            System.out.println("Conta criada com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());
        }


        try {
            controller.autenticar("12345678901", "senha123");
            System.out.println("Autenticação bem-sucedida.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
        }


        try {
            controller.depositar("12345678901", -100);
            System.out.println("Depósito realizado com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao depositar: " + e.getMessage());
        }


        try {
            double saldo = controller.consultarSaldo("12345678901");
            System.out.println("Saldo atual: " + saldo);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Erro ao consultar saldo: " + e.getMessage());
        }
    }


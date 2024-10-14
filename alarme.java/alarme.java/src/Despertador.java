import java.time.LocalTime;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Despertador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorDeAlarmes gerenciador = new GerenciadorDeAlarmes();

        // verifica os alarmes a cada segundo
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                gerenciador.verificarAlarmes();
            }
        }, 0, 1000);

        int opcao;

        do {
            System.out.println("\n--- Despertador ⏰ ---");
            System.out.println("1. Adicionar novo alarme");
            System.out.println("2. Listar alarmes");
            System.out.println("3. Remover um alarme");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o horário do alarme (HH:mm): ");
                    String horarioString = scanner.nextLine();
                    try {
                        LocalTime horario = LocalTime.parse(horarioString);
                        gerenciador.adicionarAlarme(horario);
                    } catch (Exception e) {
                        System.out.println("Formato de horário inválido. Use o formato HH:mm.");
                    }
                    break;

                case 2:
                    gerenciador.listarAlarmes();
                    break;

                case 3:
                    System.out.print("Digite o número do alarme a ser removido: ");
                    int indice = scanner.nextInt();
                    gerenciador.removerAlarme(indice);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

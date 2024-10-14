import java.time.LocalTime;
import java.util.ArrayList;

class GerenciadorDeAlarmes {
    private ArrayList<Alarme> listaDeAlarmes;

    // Construtor
    public GerenciadorDeAlarmes() {
        listaDeAlarmes = new ArrayList<>();
    }

    public void adicionarAlarme(LocalTime horario) {
        Alarme novoAlarme = new Alarme(horario);
        listaDeAlarmes.add(novoAlarme);
        System.out.println("Alarme adicionado com sucesso para " + horario);
    }

    // Método para listar alarmes
    public void listarAlarmes() {
        if (listaDeAlarmes.isEmpty()) {
            System.out.println("Nenhum alarme programado.");
        } else {
            for (int i = 0; i < listaDeAlarmes.size(); i++) {
                System.out.println((i + 1) + ". " + listaDeAlarmes.get(i));
            }
        }
    }

    // Método para remover alarme
    public void removerAlarme(int indice) {
        if (indice < 1 || indice > listaDeAlarmes.size()) {
            System.out.println("Índice inválido.");
        } else {
            listaDeAlarmes.remove(indice - 1);
            System.out.println("Alarme removido com sucesso.");
        }
    }

    // Verifica se algum alarme deve tocar
    public void verificarAlarmes() {
        for (Alarme alarme : listaDeAlarmes) {
            if (alarme.isAtivo() && alarme.getHorario().equals(LocalTime.now().withNano(0))) {
                System.out.println("Alarme tocando! Hora: " + alarme.getHorario());
                alarme.desativar();
            }
        }
    }
}

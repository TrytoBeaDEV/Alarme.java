import java.time.LocalTime;

class Alarme {
    private LocalTime horario;
    private boolean ativo;

    // Construtor
    public Alarme(LocalTime horario) {
        this.horario = horario;
        this.ativo = true; // Alarme começa como ativo
    }

    // Métodos getter e setter
    public LocalTime getHorario() {
        return horario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void desativar() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Alarme programado para: " + horario + " | Ativo: " + (ativo ? "Sim" : "Não");
    }
}

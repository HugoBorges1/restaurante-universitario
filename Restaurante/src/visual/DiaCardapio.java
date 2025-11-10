package visual;

public class DiaCardapio {
    
    private String diaSemana;
    private String pratoPrincipal;
    private String bebida;
    private String sobremesa;
    

    public DiaCardapio(String diaSemana, String pratoPrincipal, String bebida, String sobremesa) {
        this.diaSemana = diaSemana;
        this.pratoPrincipal = pratoPrincipal;
        this.bebida = bebida;
        this.sobremesa = sobremesa;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getPratoPrincipal() {
        return pratoPrincipal;
    }

    public void setPratoPrincipal(String pratoPrincipal) {
        this.pratoPrincipal = pratoPrincipal;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(String sobremesa) {
        this.sobremesa = sobremesa;
    }

    
}


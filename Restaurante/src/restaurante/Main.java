package restaurante;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import visual.DiaCardapio;
import visual.TelaCardapio;

public class Main {
    public static void main(String[] args) {
        
        List<DiaCardapio> diasCardapio = new ArrayList<>();
        SwingUtilities.invokeLater(() -> new TelaCardapio());
       
    }
}

package problemas_clasicos.barbero_dormilon;

/**
 *
 * @author santino.fuentes
 */
public class Main
{
        private static final int CANTIDAD_LUGARES = 4;
        private static final int CANTIDAD_CLIENTES = 500;
        private static Barbero barbero;
        private static Barberia barberia;
        private static Cliente clientes[];
        private static Thread clientesThread[];
        private static Thread barberoThread;
        
        public static void main(String[] args)
        {
                barberia = new Barberia("Estación 116", CANTIDAD_LUGARES);
                clientes = new Cliente[CANTIDAD_CLIENTES];
                barbero = new Barbero(barberia, "Makabro");
                barberoThread = new Thread(barbero);
                barberoThread.start();
                
                for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
                        clientes[i] = new Cliente(barberia);
                }
                
                for (int j = 0; j < CANTIDAD_CLIENTES; j++) {
                        clientesThread[j] = new Thread(clientes[j]);
                }
                
                for (int k = 0; k < CANTIDAD_CLIENTES; k++) {
                        clientesThread[k].start();
                }
        }
}

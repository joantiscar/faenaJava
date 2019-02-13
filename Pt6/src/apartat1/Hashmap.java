/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat1;

import java.util.*;

/**
 *
 * @author dios
 */
public class Hashmap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        HashMap<Integer, Client> clients = new HashMap<>();

        System.out.println("Programa d'introducció de clients.");
        String nom;
        int contador = 0;
        do {
            System.out.println("Disme el nom d'un client");
            nom = ent.nextLine();
            Client client = new Client(nom);
            clients.put(contador, client);
            contador++;
            System.out.println("Vols afegir un altre client? (si/no)");
            if (ent.nextLine().equals("no")) {
                break;
            }
        } while (true);
        Empresa mercadona = new Empresa();
        mercadona.setClients(clients);

        HashMap clients_mercadona = mercadona.getClients();
        Iterator iterador = clients_mercadona.entrySet().iterator();
        while (iterador.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) iterador.next();
            Client client_actual = (Client) pair.getValue();
            System.out.println(pair.getKey() + " = " + client_actual.getNom());
        }
        System.out.println("Vols borrar algun client? (escriu el seu numero)");
        int client_a_borrar = ent.nextInt();
        clients_mercadona.remove(client_a_borrar);
        System.out.println("Client esborrat. Mostrant clients restants");
        iterador = clients_mercadona.entrySet().iterator();
        while (iterador.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) iterador.next();
            Client client_actual = (Client) pair.getValue();
            System.out.println(pair.getKey() + " = " + client_actual.getNom());
        }
    }

}

class Empresa {

    private HashMap<Integer, Client> clients = new HashMap();

    public HashMap<Integer, Client> getClients() {
        return clients;
    }

    public void setClients(HashMap<Integer, Client> clients) {
        this.clients = clients;
    }

}

class Client {

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Client(String nom) {
        this.nom = nom;
    }
}

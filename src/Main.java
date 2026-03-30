/*
        Um sistema onde a pessoa:

        Reserva um quarto/sala
        Escolhe data de entrada e saída (LocalDateTime)
                O sistema valida conflitos de horário
        Mostra reservas ativas e passadas
        preço total = taxa fixa + (preço por dia × quantidade de dias)

        O que você pratica:

        BigDecimal na precificação
        LocalDateTime (perfeito pra isso)
        Arrays ou List
        POO (classe Reserva, Cliente, etc.)
        Regras de negócio (ex: não pode reservar datas passadas)
💥 Diferencial:

        Se você fizer validação de datas certinha → já sobe muito seu nível

        /*
        LocalDate T01 = new LocalDate;
        LocalDate T02 = new LocalDate;
        Faço o usuario escrever a data, em formato de data brasileiro DateFormat("dd/MM/yyyy");
        Faço até quando o usuario vai ficar
        Duration t = Duration.beetwen(T01, T02)
        t.toDays() pega quantos dias a pessoa vai ficar.
        Dai faço isso na regra de négocio pegando esse duration e colocando como valor no bigdecimal.

        Maior dificuldade, vai ser ver como o usuario vai digitar essa data, receber no formato brasileiro e depois
        transformalo em data no formato ISO.
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Reservation[] reservations = new Reservation[10];
        List<Client> clients = new ArrayList<>();
        boolean stop = true;
        char confirm;
        Integer room = null;

        LocalDate checkIn = null;
        LocalDate checkOut = null;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Email: ");
            String email = input.nextLine();
            Client client = new Client(name, email);
            clients.add(client);

            do {
                System.out.print("Room: ");
                room = input.nextInt();
                input.nextLine();
                if(room >= reservations.length || room < 0) {
                    System.out.println("Room number out of range");
                }
                else if(reservations[room] != null) {
                    System.out.println("Room already occupied");
                }else{
                  //Fazer condição para o dia de chekcout ser maior.
                    do {
                        System.out.println("What will be the entry date?");
                        System.out.print("dd/MM/yyyy: ");
                        String checkInStr = input.nextLine();
                        checkIn = LocalDate.parse(checkInStr, format);
                        System.out.println("What day will we be leaving?");
                        System.out.print("dd/MM/yyyy: ");
                        String checkOutStr = input.nextLine();
                        checkOut = LocalDate.parse(checkOutStr, format);
                        if(checkIn.isAfter(checkOut)){
                            System.out.println("Invalid date");
                        }
                    }while(checkIn.isAfter(checkOut));

                    reservations[room] = new Reservation(room, client, new StayPeriod(checkIn, checkOut));
                }
            }while(room >= reservations.length || room < 0);

            System.out.println("Stop?(Y/N): ");
            confirm = input.next().toLowerCase().charAt(0);
            input.nextLine();
            if(confirm == 'y') {
                stop = false;
            }
        }while(stop);


            for(int i = 0; i < reservations.length; i++) {
                if(reservations[i] != null) {
                    System.out.println(reservations[i]);
                }
            }
    }
}
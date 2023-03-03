import java.util.*;

public class CardDeckClient {
        public static void main(String[] args) {
            Set<card> cpu = new HashSet<card>();//I used a set since it's an array with no set length to keep adding, had issues.
            Set<card> player1 = new HashSet<card>();

            startCards(player1);
            startCards(cpu);//here we are dealing your first hand
            
            Scanner input = new Scanner(System.in);//taking the yes or no for calling from the user

            while(true){ //loops until computer or player busts or player calls
                printer( cpu, player1);
                if(summer(cpu)>21 || summer(player1)>21){
                    break;
                }

                System.out.print("Do you want to call? (y/n)");
                String userInput = input.nextLine();
                if(userInput.equals("y")) {
                    break;//stops the loop
                }

                
                player1.add(randomCard());
                cpu.add(randomCard());//give another card
            }

            printer( cpu, player1);
            System.out.println("Computer Sum: " +summer(cpu) + " Player Sum: "+ summer(player1)); //printing out the sum of each deck/checks bust

            if(summer(player1)<=21){//if player is less than 21 who has closer to 21
                if (summer(player1)<summer(cpu)&&summer(cpu)<21){
                    System.out.println("Loser!");
                }else{
                    System.out.println("You winn!");
                }
                if (summer(player1)>summer(cpu)){
                    System.out.println("You winn!");
                }    
            }else{
                System.out.println("you busted!");
            }
        }

    public static card[] makeDeck() { //creates deck of cards for access
        card[] cards = new card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new card(rank,suit);
                index++;
            }
        }
        return cards;
    }

    public static void printer(Set<card> cpu, Set<card> player1){//prints player and cpu hand
        System.out.println("CPU: " + cpu);
        System.out.println("PLayer: " + player1);

    }

    public static card randomCard(){
        card[] deck = makeDeck();
        Random rand = new Random();
        int num = rand.nextInt(52);

        return deck[num];
    }

    public static void startCards(Set<card> hand) {//start deck gives 2 cards
        for (int i = 0; i<2; i++){
            hand.add(randomCard());
        }
    }
    public static int summer(Set<card> hand) {//total
        int sum = 0;

        for (card elem: hand) {
            sum += elem.getRank();
        }    
        
        return sum;
    }
}

    


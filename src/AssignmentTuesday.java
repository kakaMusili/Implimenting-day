import java.lang.annotation.ElementType;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AssignmentTuesday {

    //Class to implement days of the week
    private static  class Day {
        private int Day;
        private String Days;

        @Override
        public String toString()
        {
            return (Days);
        }

        public void setDay(int Day)
        {
            if (Day == 0)
                Days = "Sun";
            if (Day == 1)
                Days = "Mon";
            if (Day == 2)
                Days = "Tue";
            if (Day == 3)
                Days = "Wed";
            if (Day == 4)
                Days = "Thur";
            if (Day == 5)
                Days = "Fri";
            if (Day == 6)
                Days = "Sat";
        }

        public Day setNameDay(String Day)
        {
            Day = Days;
            return this;
        }

        public void printDay()
        {
            System.out.println(Days);
        }


        public void previousDay()
        {
            Day=Day-1;

            if(Day<0)
            {
                switch(Day)
                {
                    case -1:
                        setDay(6);
                        printDay();
                        break;

                }
            }else
            {
                switch(Day)
                {
                    case 6:
                        setDay(6);
                        printDay();
                        break;
                    case 5:
                        setDay(5);
                        printDay();
                        break;
                    case 4:
                        setDay(4);
                        printDay();
                        break;
                    case 3:
                        setDay(3);
                        printDay();
                        break;
                    case 2:
                        setDay(2);
                        printDay();
                        break;
                    case 1:
                        setDay(1);
                        printDay();
                        break;
                    case 0:
                        setDay(0);
                        printDay();
                        break;

                }

            }

        }

        public void nextDay()
        {
            Day=Day+2;

            setDay(Day);
            printDay();


        }

        public void calculateDay()
        {
            int calc = 0;
            int dayAdd =0;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number of days to add: ");
            calc =scanner.nextInt();

            dayAdd = Day +(calc);

            Day = dayAdd %7;

            setDay(Day-1);
            printDay();
        }

        //Constructors
        public Day()
        {
            setDay(0);
        }
        public Day (int Day)
        {
            setDay(Day);
        }
    }


    //class to implement double Linked list
    private static class DoublyLinkedListImpl<E> {

        private Node head;
        private Node tail;
        private int size;

        public DoublyLinkedListImpl() {
            size = 0;
        }

        /**
         * this class keeps track of each element information
         */
        private class Node {
            E element;
            Node next;
            Node prev;

            public Node(E element, Node next, Node prev) {
                this.element = element;
                this.next = next;
                this.prev = prev;
            }
        }


        // returns the size of the linked list

        public int size() {
            return size;
        }


         // return whether the list is empty or not

        public boolean isEmpty() {
            return size == 0;
        }


        // adds element at the starting of the linked list

        public void addFirst(E element) {
            Node tmp = new Node(element, head, null);
            if (head != null) {
                head.prev = tmp;
            }
            head = tmp;
            if (tail == null) {
                tail = tmp;
            }
            size++;
            System.out.println("adding: " + element);
        }


         // adds element at the end of the linked list

        public void addLast(E element) {

            Node tmp = new Node(element, null, tail);
            if (tail != null) {
                tail.next = tmp;
            }
            tail = tmp;
            if (head == null) {
                head = tmp;
            }
            size++;
            System.out.println("adding: " + element);
        }


        //this method walks forward through the linked list

        public void iterateForward() {

            System.out.println("iterating forward..");
            Node tmp = head;
            while (tmp != null) {
                System.out.println(tmp.element);
                tmp = tmp.next;
            }
        }


          //this method walks backward through the linked list

        public void iterateBackward() {

            System.out.println("iterating backword..");
            Node tmp = tail;
            while (tmp != null) {
                System.out.println(tmp.element);
                tmp = tmp.prev;
            }
        }



         // this method removes element from the start of the linked list

        public E removeFirst() {
            if (size == 0) throw new NoSuchElementException();
            Node tmp = head;
            head = head.next;
            head.prev = null;
            size--;
            System.out.println("deleted: " + tmp.element);
            return tmp.element;
        }


        // this method removes element from the end of the linked list

        public E removeLast() {
            if (size == 0) throw new NoSuchElementException();
            Node tmp = tail;
            tail = tail.prev;
            tail.next = null;
            size--;
            System.out.println("deleted: " + tmp.element);
            return tmp.element;
        }
    }

    //Class to Implement a simple calculator
    private static class Calculator {

    private char[] expression;
    private char currentCharacter;
    private int indexOfCurrentCharacter = 0;

    //Creates a new Calculator with the given expression.
    public Calculator(String expression) {
               this.expression = expression.toCharArray();
                 readNextCharacter();
             }

             //reading the next character
    public void readNextCharacter() {
                          while ( indexOfCurrentCharacter < expression.length
                                    && Character.isWhitespace(expression[indexOfCurrentCharacter]) ) {
                                    indexOfCurrentCharacter++;
                             }

                         if ( indexOfCurrentCharacter < expression.length) {
                                  currentCharacter = expression[indexOfCurrentCharacter++];
                              } else {
                                   currentCharacter = 0;
                               }
                     }

    public int evaluateExpression() {
                 int valueOfExpression = evaluateTerm();

              while ( currentCharacter == '+' || currentCharacter == '-') {
                          char operator = currentCharacter;
                         readNextCharacter();
                           int term = evaluateTerm();
                           switch (operator) {
                             case '+': valueOfExpression += term;
                                          break;
                             case '-': valueOfExpression -= term;
                                             break;
                            }
                     }

                return valueOfExpression;
            }

            // Reads in a term, evalutes it and returns the result.
    private int evaluateTerm() {
                   int resultOfTerm = 0;

                   if (currentCharacter == '(') {
                          readNextCharacter();
                          resultOfTerm = evaluateExpression();
                          if (currentCharacter != ')') {
                                   System.out.println("Closing parenthesis expected");
                             } else {
                                 readNextCharacter();
                              }
                      } else if ( Character.isDigit(currentCharacter)) {
                         resultOfTerm = currentCharacter - '0';
                           readNextCharacter();
                       }

                 return resultOfTerm;
              }
   }

   //class to implement a  ChemicalElement
   private static class ChemicalElement
    {

        private String symbol = "";
        private String name="";

        private int atomicNumber = 1;
        private double electronegativity;


        //setting the symbol
        public void setSymbol(int symbol) {

            switch(symbol)
            {
                case 1:
                    this.symbol = "H";
                    break;
                case 2 :
                    this.symbol = "He";
                    break;
                case 3 :
                    this.symbol = "Li";
                    break;
                case 4:
                    this.symbol = "Be";
                    break;

                case 8:
                    this.symbol = "O";
                    break;
                case 19:
                    this.symbol = "K";
                    break;

            }


        }


        //Setting Element Name
        public void setName(int name) {
            switch(name)
            {
                case 1:
                    this.name = "Hydrogen";
                    break;
                case 2 :
                    this.name = "Helium";
                    break;
                case 3 :
                    this.name = "Lithium";
                    break;
                case 4:
                    this.name = "Beryllium";
                    break;

                case 8:
                    this.name = "Oxygen";
                    break;
                case 19:
                    this.name = "Potassium";
                    break;

            }

        }

        public String getName() {
            return name;
        }

        private static boolean [] alkaliMetal = new boolean[119];

        public ChemicalElement( int atomicNumber,
               double electronegativity)  {
            this.setName(atomicNumber);
            this.setSymbol(atomicNumber);

                     this.atomicNumber = atomicNumber;
                     this.electronegativity = electronegativity;
                }

        static {
                 alkaliMetal[3] = true;
                 alkaliMetal[11] = true;
                   alkaliMetal[19] = true;
                    alkaliMetal[37] = true;
                  alkaliMetal[55] = true;
                  alkaliMetal[85] = true;
                  }

        public ChemicalElement(String symbol, int electronegativity) {
                    this( electronegativity, 0);
                  }


                              // Returns true if and only if this chemical element is a metal.
      public boolean isMetal() {
                      boolean metal = false;

                              switch (atomicNumber) {
                                  case 13:
                                  case 31:
                                  case 49:
                                  case 50:
                                  case 81:
                                  case 82:
                                  case 83:
                                  case 113:
                          case 114:
                          case 115:
                        case 116: metal = true;
                           }
                   return metal;
              }

              //Returns true if and only if this chemical element is
        public boolean isAlkaliMetal() {
                       return alkaliMetal[atomicNumber];
                 }

       // Retruns true if and only if this chemical metal is
        //a transition metal.
        public boolean isTransitionMetal() {
                        return 21 <= atomicNumber && atomicNumber <= 30
                          || 39 <= atomicNumber && atomicNumber <= 48
                           || 72 <= atomicNumber && atomicNumber <= 80;
                 }

        //Returns the symbolic name of this chemical element
        //one or two first letter of its latin name).
        public String getSymbol() {
                       return symbol;
                 }


       // Returns the atomic number (number of protons) of this
       //chemical element.
      public int getAtomicNumber() {
                 return atomicNumber;
              }

        public double getElectronegativity() {
                      return electronegativity;
        }

        public String toString() {
                       return getSymbol();
                 }

    }


    public static void main(String[] args) {

        System.out.println();

        //importing scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Type  1 to Execute Question 1 ");
        System.out.println("Type  2 to Execute Question 2");
        System.out.println("Type  3 to Execute Question 3");
        System.out.println("Type  4 to Execute Question 4");
        System.out.println("Type  5 to Execute Question 5");
        System.out.println("Type  0 to Exit");

        int input= sc.nextInt();
        switch(input)
        {
            case 1:
                //prompting the user to choose his/her initial day
                System.out.println("What is your initial day?\nSunday\t\t=\t0\nMonday\t\t=\t1\nTuesday\t\t=\t2\nWednesday\t=\t3\nThursday\t=\t4\nFriday\t\t=\t5\nSaturday\t=\t6");
                System.out.print("Enter the number:");


                int x= sc.nextInt();

                //Initializing Object of type Day
                Day myDay = new Day(x);
                System.out.println("");

                //Printing the Day
                System.out.print("The day of the week is: ");
                myDay.printDay();
                System.out.println();

                //Printing the previous Day
                System.out.print("The previous day is: ");
                myDay.previousDay();

                System.out.println();

                //Printing the Next Day
                System.out.print("The next day is: ");
                myDay.nextDay();

                System.out.println();

                //Calculating the another day
                myDay.calculateDay();
                System.out.println();

                main(null);
                break;
            case 2:
                //instatiating a on object of type DoublyLinkedListImpl
                DoublyLinkedListImpl<Integer> dll = new DoublyLinkedListImpl<Integer>();
                dll.addFirst(110);
                dll.addFirst(300);
                dll.addLast(555);
                dll.addLast(364);

                dll.iterateForward();

                dll.removeFirst();
                dll.removeLast();
                dll.iterateBackward();

                main(null);

                break;
            case 3:

                int []arr= new int[]{4,8,6,1,2,9,4};
                smallestDistance(arr);
                main(null);
                break;
            case 4:
                System.out.println("Enter an expession like '(5+2)' or '(5-2)'");

                String exp=sc.next();
                Calculator calc=new Calculator(exp);
                calc.readNextCharacter();

                System.out.println( "Result of the Expression "+ exp  +"  =  "+ calc.evaluateExpression());

                main(null);
                break;
            case 5:

                ChemicalElement element = new ChemicalElement( 1, 2.20);
                ChemicalElement element1 = new ChemicalElement( 19, 0.82);

                System.out.println("element 1 Name  ="+ element.getName() );
                System.out.println("Chemical Symbol of the Element 1 =  "+ element.getSymbol());
                System.out.println("Atomic Number of the Element 1 = " + element.getAtomicNumber());
                System.out.println("The type of metal  of Element 1  =  ");
                if(element.isMetal()==true)
                {
                    if(element.isAlkaliMetal()==true)
                    {
                        System.out.print("Alkali Metal");
                    }else if(element.isTransitionMetal()==true)
                    {
                        System.out.print("Transition Metal");
                    }

                }else
                {
                    System.out.print("Element is not a metal ");
                }

                System.out.println();
                System.out.println();

                System.out.println("element 2 Name  = "+ element1.getName() );
                System.out.println("Chemical Symbol of the Element 2 =  "+ element1.getSymbol());
                System.out.println("Atomic Number of the Element 2 = " + element1.getAtomicNumber());
                System.out.println("The type of the metal of Element 2 = ");
                /*if(element1.isMetal()==true)
                {*/
                    if(element1.isAlkaliMetal()==true)
                    {
                        System.out.print("Alkali Metal");
                    }else if(element1.isTransitionMetal()==true)
                    {
                        System.out.print("Transition Metal");
                    }
                    else
                    {
                        System.out.print("Element is not a metal ");
                    }

                System.out.println();
                main(null);
                break;
            case 0:
                System.exit(0);
                break;
                default:
                    System.out.println("Invalid input");
                    main(null);

        }


    }

    //Method for  finding two neighbouring numbers
    // in an array with the smallest distance to each other.

    static void smallestDistance(int [] array){

        int smallest = Math.abs(array[0]-array[1]);
        int index = 0;
        for(int i=1; i<array.length-1; i++){
            int value = Math.abs(array[i]-array[i+1]);
            if(value< smallest){
                smallest= value;
                index = i;
            }

        }
        System.out.println(smallest);
        System.out.println(index);

    }



}

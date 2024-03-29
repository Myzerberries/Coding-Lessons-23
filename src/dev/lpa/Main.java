package dev.lpa;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
//        LinkedList<String> placesToVisit = new LinkedList<>();
        //We can use the var keyword for type LinkList, or any type, list, or collection. But when we do, we have to
        //specify the type parameter on the right side of the assignment operator in the angle brackets.
        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);

//        gettingElements(placesToVisit);

//        printItinerary(placesToVisit);
//        printItinerary2(placesToVisit);

//        printItinerary3(placesToVisit);

        testIterator(placesToVisit);

    }

    private static void addMoreElements(LinkedList<String> list){
        //The LinkedList can be used as different types of data collections:
        //A list:
        list.add("Darwin");
        list.add("Hobart");
        //Queue methods
        //A queue:
        list.offer("Melbourne");
        //A double ended queue:
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");
        //Stack Methods
        //And a stack:
        list.push("Alice Springs");
    }

    private static void removeElements(LinkedList<String> list){

        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);
        String s1 = list.remove();
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst();
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast();
        System.out.println(s3 + " was removed");

        //.poll returns and removes the element at the front end of a container.
        //Queue/Dequeue poll methods
        String p1 = list.poll(); //removes first element
        System.out.println(p1 + " was removed");

        String p2 = list.pollFirst(); //removes first element
        System.out.println(p2 + " was removed");

        String p3 = list.pollLast(); //removes last element
        System.out.println(p3 + " was removed");

        //.push adds an element at the top of the stack, similar to addFirst();
        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);

        //.pop returns the element that is available at the top of the stack and removes that element from the stack.
        String p4 = list.pop(); //removes first element
        System.out.println(p4 + " was removed");

    }

    private static void gettingElements(LinkedList<String> list){

        System.out.println("Retrieved Element = " + list.get(4));

        System.out.println("First Element = " + list.getFirst());
        System.out.println("Last Element = " + list.getLast());

        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at position: " + list.lastIndexOf("Melbourne"));

        //Queue retrieval
        System.out.println("Element from element() = " + list.element());
        //Stack retrieval methods
        System.out.println("Element from peek() = " + list.peek());
        System.out.println("Element from peekFirst() = " + list.peekFirst());
        System.out.println("Element from peekLast() = " + list.peekLast());
    }

    public static void printItinerary(LinkedList<String> list){

        System.out.println("Trip starts at " + list.getFirst());
        for(int i = 1; i < list.size(); i++){
            System.out.println("--> From: " + list.get(i - 1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());

    }

    public static void printItinerary2(LinkedList<String> list){

        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        for(String town : list){
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());

    }

    public static void printItinerary3(LinkedList<String> list){

        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();

        ListIterator<String> iterator = list.listIterator(1);

        //.hasNext() will return true if there are more elements to process.
        while(iterator.hasNext()){
            //We're setting town equal to the result of another method on the list iterator called .next()
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }

        System.out.println("Trip ends at " + list.getLast());

    }

    private static void testIterator(LinkedList<String> list){

        var iterator = list.listIterator();
        while(iterator.hasNext()){
//            System.out.println(iterator.next());
            if(iterator.next().equals("Brisbane")){
                iterator.add("Lake Wivenhoe");
            }
        }
        while(iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
        System.out.println(list);

        var iterator2 = list.listIterator(3);
        System.out.println(iterator2.previous());
    }

}

//Array of primitive values:

//When an array of primitive types is allocated, space is allocated for all of its elements contiguously, seen below:

//      Index               Value               Address

//      0                   34                  100
//      1                   18                  104
//      2                   91                  108
//      3                   57                  112
//      4                   453                 116
//      5                   68                  120
//      6                   6                   124

//On this slide, we have an array of seven integers.

//The index position is in the left column, and that's the number we use ot access a specific array value.

//So the first element when we use index position 0 will retrieve a value of 34.

//When we use index position 1, this gets the value of 18, and so on.

//The addresses we show are memory addresses, represented by the numbers in the "address" column.

//If 100 is the address of an integer, and we know an integer is 4 bytes, then the address of the next integer, if it's
//contiguous, would be 104 for the second element.

//Java can use simple math using the index and the address of the initial element in the array to get the address and
//retrieve the value of the element.

//For reference types (meaning anything that's not a primitive type) like a String, or any other object, the array
//elements aren't the values, but the addresses of the referenced object or String.

//ArrayLists are really implemented with arrays, under the covers.

//This means our objects aren't stored contiguously in memory, but their addresses are, in the array behind the ArrayList.

//The addresses can be easily retrieved with a bit of math if we know the index of the element.

//This is a cheap lookup, and doesn't change, no matter what size the ArrayList is.

//But to remove an element, the referenced addresses have to be re-indexed, or shifted, to remove an empty space.

//And when adding an element, the array that backs the ArrayList might be too small, and might need to be reallocated.

//Either of these operations can be an expensive process, if the number of elements is large.

//ArrayList capacity:

//An ArrayList is created with an initial capacity, depending on how many elements we create the list with, or if you
//specify a capacity when creating the list.

//Below, we see an ArrayList that has a capacity of 10, because we're passing 10 in the constructor of this list.

//ArrayList<Integer> intList = new ArrayList<>(10);

//We then add 7 elements:

//for (int i = 0; i < 7; i++) { intList.add((i + 1) * 5);}

//We can add 3 more elements, using the ArrayList add method, and the array that is used to store teh data doesn't need
//to change:

//intList.add(40); intList.add(45); intList.add(50);

//The elements at indices 7, 8, and 9 get populated.

//But if the number of elements exceeds the current capacity, Java needs to reallocate memory to fit all the elements,
//and this can be a costly operation, especially if your ArrayList contains a lot of items.

//So now, if our code simply calls add on this ArrayList, the next operation is going ot create a new array, with more
//elements, but copy the existing 10 elements over.

//Then the new element is added. You can imagine this add operation costs more in both time and memory than the previous
//add methods did.

//When Java re-allocates new memory for the ArrayList, it automatically sets the capacity to a greater capacity.

//But the Java language doesn't really specify exactly how it determines the new capacity, or promise that it will
//continue to increase the capacity in the same way in future versions.

//We can't actually get this capacity size from the ArrayList.

//From their own documentation, Java states that, "The details of teh growth policy are not specified beyond the fact
//that adding an element has constant amortized time cost".

//So what is amortized time?

//Let's start with how to determine cost, which in this case is generally considered in terms of time, but may include
//memory usage and processing costs, etc.

//Big O Notation:

//There are a couple simple concepts that will help us understand how cheap or expensive an operation is, in therms of
//time and memory usage as the operation scales.

//This means it's a way to express how well the operation performs, when applied to more and more elements.

//Big O approximates the cost of an operation for a certain number of elements, called n.

//Cost is usually determined by the time it takes, but can include memory usage and complexity, for example.

//As n (the number of elements) gets bigger, an operation's cost can stay the same.

//But cost often grows as the number of elements grow.

//Costs can grow linearly, meaning the cost stays in step with the magnitude of the number of elements.

//Or costs can grow exponentially, or by some other non-linear fashion.

//In a perfect world, an operation's time and complexity would never change. This ideal world in Big O Notation is O(1),
//sometimes called constant time.

//In many situations, an operation's cost is in direct correlation to the number of elements n. In Big O Notation, this
//is O(n), sometimes called linear time.

//So if we have 10 elements, the cost is 10 times what it would be for 1 element, because the operation may have to
//execute some functions, up to 10 times vs. just once, and 100 times for 100 elements.

//O(n) is generally our worst case scenario for List operations, but there are Big O Notations for worse performers.

//Another scenario is the one Java docs declared for the growth of the ArrayList that adding an element has constant
//amortized time cost.

//In our case, we'll designate this constant amortized time as O(1)*

//This means that in the majority of cases, the cost is close to O(1), but at certain intervals, the cost is O(n).

//If we add an element to an ArrayList, where the capacity of the List is already allocated, and space is available,
//the cost is the same each time, regardless of how many elements we add.

//But as soon as we reach teh capacity, and all the elements (all n elements) need to be copied in memory, this single
//add would have a maximum cost of O(n).

//After this operation, that forced reallocation, any additional add operations go back to O(1), until the capacity is
//reached again.

//As the expensive intervals decrease, the cost gets closer to O(1), so we give it the notation O(1)*.

//LinkedList:

//The LinkedList is not indexed at all.

//There is no array, storing the addresses in a neat ordered way, as we saw with the ArrayList.

//Instead, each element that's added to a linked list forms chain, and the chain has links to the previous element, and
//the next element.

//This architecture is called a double linked list, meaning an element is linked to the next element, but it's also
//linked to a previous element in this chain of elements.

//The beginning of the chain is called the head of the list, and the end is called the tail.

//This can also be considered a queue, in this case, a double ended queue, because we can traverse both backwards and
//forwards through these elements.

//Getting an element from the list, or setting a value of element, isn't just simple math anymore with the LinkedList type.

//To find an element, we'd need to start at the head or tail, and check if the element matches, or keep track of the
//number of elements traversed, if we are matching by an index, because the index isn't stored as part of the list.

//For example, even if you know you want to find teh 5th element, you'd still have to traverse the chain this way
//to get the fifth element.

//This type of retrieval is considered expensive in computer currency, which is processing time and memory usage.

//On the other hand, inserting and removing an element is much simpler for this type of collection.

//LinkedList- Inserting or Removing an Element may be less costly than using an ArrayList:

//In contrast to an ArrayList, inserting or removing an item in a LinkedList is just a matter of breaking two links
//in the chain, and re-establishing two different links.

//No new array needs to be created, and elements don't need to be shifted into different positions.

//A reallocation of memory to accommodate all existing elements is never required.

//So for a LinkedList, inserting and removing elements is generally considered cheap in computer currency, compared to
//doing these functions in an ArrayList.

//Although there is debate as to if that is important as Java improves and computer hardware improves.

//Things to remember when considering whether to use an ArrayList vs LinkedList:

//The ArrayList is usually the better default choice for a List, especially if the List is used predominantly for
//storing and reading data.

//If you know the maximum number of possible items, then it's probably better to use an ArrayList but set it's capacity.

//The code below demonstrates how to set the capacity for your ArrayList to 500,000:

// int capacity = 500_000;
// ArrayList<String> stringArray = new ArrayList<>(capacity);

//An ArrayList's index is an int type, so an ArrayList's capacity is limited to the maximum number of elements an int
//can hold (Integer.MAX_VALUE - 2,147,483,647).

//You may want to consider using a LinkedList if you're adding and processing or manipulating a large amount of elements,
//and the maximum elements isn't known, but may be great, or if your number of elements may exceed Integer.MAX_VALUE.

//A LinkedList can be more efficient, when items are being processed predominantly from either the head or tail of the
//list.

//Iterator:

//We can use a traditional for loop and an index to index into a list.

//We can also use the enhanced for loop and a collection to step through elements on at a time.

//But Java provides other means to traverse lists.

//Two alternatives are the Iterator and the ListIterator.

//A database cursor is a mechanism that enables traversal over records in a database.

//An iterator can be thought of as similar to a database cursor.

//The kind of cursor we are referring to can be described as an object that allows traversal over records in a collection.

//When you get an instance of an iterator, you can call the next method, to get the next element in the list.

//You can use the hasNext method to check if any elements remain to be processed.

//An iterator moves forwards only, and supports only the remove method.

//A ListIterator can be used to go both forwards and backwards, and in addition to the remove method, it also supports
//the add and set methods.

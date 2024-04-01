/*Iliya Klishin
  Dr. Steinberg
  COP 3330 Spring 2022
  Programming Assignment 3
  */
  
  class Book{
  
  private String title;
  private String author;
  private double cost;
  Book nextptr;
  
    public Book(String title, String author, double cost) // This constructor assigns title, author, and cost of the book
    {
    
      this.title = title;
      this.author = author;
      this.cost = cost;
      nextptr = null;
    
    }
    
    public Book(Book old){ // Making a deep copy of the old book
    
      //Book book1 = new Book(old.title, old.author, old.cost);
      title = old.title;
      author = old.author;
      cost = old.cost;
      nextptr = null;
    
    }
  
  
    public String getTitle()
    {
    
      return title;
    
    }
    
    public String getAuthor(){
    
      return author;
    
    }
    
    public double getCost(){
    
      return cost;
    
    }
  
  }
  
  
  
  public class Library{
  
    
    Book first;
    int total;
    
    public Library(){
    
      this.first = null;
      this.total = 0;
    
    }
    
    public Library(Library obj){ // Making a deep copy of the library
    
      System.out.println("Copying your Library collection.");
  
      this.total = obj.total;
      
      Book temp = obj.first;
      first = new Book(temp.getTitle(), temp.getAuthor(), temp.getCost());
      Book temp1 = first;
      temp = temp.nextptr;
      while(temp != null)
      {
        
        temp1.nextptr = new Book(temp.getTitle(), temp.getAuthor(), temp.getCost());
        temp1 = temp1.nextptr;
        
        temp = temp.nextptr;
      }
      
      temp1 = first;
      
      
    }
  
  
    public void add(String title, String author, double cost) // This method adds a book to the library
    {

      if(full())
      {
         System.out.println("Your library is full.");
         //return;
      }
    
      else if(first == null)
      {
      
        first = new Book(title, author, cost);
        total++;
      }
      
      else
      {
      
        Book temp = first;
        
        while(temp.nextptr != null)
        {
        
          temp = temp.nextptr;
        }
        
        temp.nextptr = new Book(title, author, cost);
        
        total++;
      }
      
    }
    
    public Book search(String title){ // This method searches a title of the book and returns the book.
    
      Book temp = first;
      //int i = 1;
      while(temp != null)
      {
        //System.out.printf("%s title of book number %d%n", temp.getTitle(), i);
        //i++;
        if(temp.getTitle().equals(title))//temp.title.equals(title)
          return temp;
      
        temp = temp.nextptr;
      }
      
      return null;
    
    }
    
    
    public void reverse()// This method reverses the linked list in the library list of books.
    {
    
      Book cur = first;
      Book prev = null;
      Book next = null;
      
      while(cur != null){
      
        next = cur.nextptr;
        cur.nextptr = prev;
        prev = cur;
        cur = next;
      
      }
      
      first = prev;
    
    }
    
    public void remove(String title){// This method removes a book with the title passed to the method if it is in the library.
    
    //this.display();
    
    if(empty())
    {
      System.out.println("Library is empty, nothing to remove.");
    }
      
    else if(search(title) != null){
    //System.out.println("Search was not null.");
      if(first.getTitle().equals(title))//first.getTitle().equals(title)
      {
        first = first.nextptr;
        total--;
        
        //System.out.printf("%d books left%n", total);
      }
    
      else if(total == 1){
      
        first = null;
        total--;
        
        //System.out.printf("%d books left%n", total);
      }
      
      else
        {
      
        Book temp = first;
      
        while(!temp.nextptr.getTitle().equals(title)) //temp.nextptr.getTitle().equals(title) != true
        {
        temp = temp.nextptr;
        }
      
        temp.nextptr = temp.nextptr.nextptr;
        total--;
      
        //System.out.printf("%d books left%n", total);
      
        }
        
    }
    
    
    else{
    
      return;
      }
      
      
    }
    
    
    public boolean empty(){// Checking if library is empty.
    
      if(total == 0)
        return true;
        
      else
        return false;
    }
    
    public boolean full(){// Checking if library is full.
    
    if(total == 5)
    {
      return true;
    }
    
    else
      return false;
    
    }
    
    public String getTitle(Book temp)// This method returns the title of the given book object.
    {
    
      return temp.getTitle();
    
    }
    
    public void display(){ // This method displays the title, author, and cost of the book.
    
    Book temp = first;
    
      while(temp != null)
      {
        System.out.printf("Title: %s%n", temp.getTitle());
        System.out.printf("Author: %s%n", temp.getAuthor());
        System.out.printf("Cost: %.2f%n", temp.getCost());
    
        temp = temp.nextptr;
    
      }
    
    
    }
    
    public void clearLibrary()// This method removes all the books in the library
    {
      //first = null;
      
      while(first != null)
      {
      
        first = first.nextptr;
        total--;
      
      }
    
    }
  
  }
object LibraryManagement {

  // Define the Book case class
  case class Book(title: String, author: String, isbn: String)

  // Initial set containing at least three different books
  var library: Set[Book] = Set(
    Book("1984", "George Orwell", "9780451524935"),
    Book("To Kill a Mockingbird", "Harper Lee", "9780060935467"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565")
  )

  def addBook(book: Book): Unit = {
    library += book
    println(s"Added book: ${book.title}")
  }

  def removeBook(isbn: String): Unit = {
    val bookToRemove = library.find(_.isbn == isbn)
    bookToRemove match {
      case Some(book) =>
        library -= book
        println(s"Removed book: ${book.title}")
      case None =>
        println(s"No book found with ISBN: $isbn")
    }
  }

  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    println("Current Library Collection:")
    library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
  }

  def searchBookByTitle(title: String): Unit = {
    val bookFound = library.find(_.title == title)
    bookFound match {
      case Some(book) =>
        println(s"Book found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None =>
        println(s"No book found with title: $title")
    }
  }

  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author == author)
    if (booksByAuthor.nonEmpty) {
      println(s"Books by $author:")
      booksByAuthor.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    } else {
      println(s"No books found by author: $author")
    }
  }

  def main(args: Array[String]): Unit = {
    displayLibrary()

    val newBook = Book("Brave New World", "Aldous Huxley", "9780060850524")
    addBook(newBook)
    displayLibrary()

    removeBook("9780451524935")
    displayLibrary()

    println(s"Is '1984' in the library? ${isBookInLibrary("9780451524935")}")

    searchBookByTitle("The Great Gatsby")

    displayBooksByAuthor("Harper Lee")
  }
}
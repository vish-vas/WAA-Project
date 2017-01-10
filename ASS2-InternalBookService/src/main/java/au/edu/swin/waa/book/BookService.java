package au.edu.swin.waa.book;


public class BookService 
{
	String separator ="~";
	
	/**
	 * add new book method receives request to add a new book to db and calls the database method to add the book to database.
	 * @param bookID
	 * @param bookTitle
	 * @param bookAuthors
	 * @param bookIsbn
	 * @param bookIsbn13
	 * @param bookPublisher
	 * @param bookPublishDate
	 * @param bookStatus
	 * @return success or failure depending on outcome.
	 */
	public String addNewBook(String bookID, String bookTitle, String bookAuthors, String bookIsbn, String bookIsbn13, String bookPublisher, String bookPublishDate, String bookStatus)
	{
		String bookData = bookID+separator+bookTitle+separator+bookAuthors+separator
				+bookIsbn+separator+bookIsbn13+separator+bookPublisher+separator+bookPublishDate+separator
				+bookStatus;
		BookDBInterface db = new BookDBInterface();
		if(db.addNewBookToDB(bookData))
			return "success";
		else
			return "failure";
	}
	/** used to validate book and check if a book is present or ordered in library or not.
	 * @param bookISBN
	 * @return true or false depending on result.
	 */
	
	public String validateBookInLibrary(String bookIsbn)
	{
		BookDBInterface db = new BookDBInterface();
		String resp = db.getBookFromDB(bookIsbn);
		String[] bookDet = splitData(resp);
		if(resp!=null && !resp.equals("") && bookDet[7].equalsIgnoreCase("back order"))
		{
			return "ordered";
		}
		else if(resp!=null && !resp.equals(""))
		{
			return "available";
		}
		else
		{
			return "true";
		}
	}
	private static String[] splitData(String data)
    {
    	String[] parts = data.split("\\~");
    	return parts;
    }
}

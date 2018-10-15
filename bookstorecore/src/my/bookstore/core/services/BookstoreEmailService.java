package my.bookstore.core.services;

import java.util.List;

import my.bookstore.core.model.BookModel;

public interface BookstoreEmailService
{
	void sendMostRentedBooks(List<BookModel> books);
}

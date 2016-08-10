(ns hello.books)

(defn book [title,author,publisher,isbn13,publishedDate] {:title title
	 :authors (list author)
	 :publisher publisher
	 :isbn13 isbn13
	 :publishedDate publishedDate})

(def list-of-books (list 
	(book "Animal Farm", "George Orwell", "Penguin", 9780141036137, "April 27, 2014")
	(book "1984", "George Orwell", "Penguin", 9780141036144, "April 27, 2014")
	(book "The Razor's Edge", "William Sommerset Maugham", "Vintage", 9780099284864, "April 27, 2014")))

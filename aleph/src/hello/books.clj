(ns hello.books
  (:require
   [clj-time.core :as t]
   [clj-time.format :as f]))

(def cf (f/formatter "MMMM d, yyyy"))

(defn book [title,author,publisher,isbn13,publishedDate] {:title title
	 :authors (list author)
	 :publisher publisher
	 :isbn13 isbn13
	 :publishedDate publishedDate})

(def list-of-books (list 
	(book "Animal Farm", "George Orwell", "Penguin", 9780141036137, (f/unparse cf (t/now)))
	(book "1984", "George Orwell", "Penguin", 9780141036144, (f/unparse cf (t/now)))
	(book "The Razor's Edge", "William Sommerset Maugham", "Vintage", 9780099284864, (f/unparse cf (t/now)))))

package main

import (
	"fmt"
    "github.com/julienschmidt/httprouter"
    "net/http"
    "encoding/json"
)

// model
type Entity struct {
	Title  string
	Authors []string
	Publisher string
	Isbn13 uint64
	PublishedDate string
}

// entities
var msg = []Entity { 
	{
		Title: "Animal Farm",
		Authors: []string { "George Orwell" },
		Publisher: "Penguin",
		Isbn13: 9780141036137,
		PublishedDate: "April 27, 2014",
	},
	{
		Title: "1984",
		Authors: []string { "George Orwell" },
		Publisher: "Penguin",
		Isbn13: 9780141036144,
		PublishedDate: "April 27, 2014",
	},
	{
		Title: "The Razor's Edge",
		Authors: []string { "William Sommerset Maugham" },
		Publisher: "Vintage",
		Isbn13: 9780099284864,
		PublishedDate: "April 27, 2014",
	},
}

var text, _ = json.Marshal(msg) 

func get(w http.ResponseWriter, r *http.Request, _ map[string]string) {
	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(&msg)
}

func plain(w http.ResponseWriter, r *http.Request, _ map[string]string) {
	w.Header().Set("Content-Type", "text/plain")
	fmt.Fprintf(w, "%s", text)
}

func main() {
    router := httprouter.New()

    // routes
    router.GET("/", plain)
    router.GET("/text/", plain)
    router.GET("/json/", get)

    http.ListenAndServe(":8000", router)
}
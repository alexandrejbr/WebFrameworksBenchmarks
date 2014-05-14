package main

import (
        "net/http"
        "encoding/json"
        "fmt"

        "github.com/zenazn/goji"
        "github.com/zenazn/goji/web"
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

func get(c web.C, w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(&msg)
}

func plain(c web.C, w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "text/plain")
	fmt.Fprintf(w, "%s", text)
}

// routes
func routes() {
	goji.Get("/", plain)
	goji.Get("/text/", plain)
	goji.Get("/json/", get)
}

func main() {
	routes()
    goji.Serve()
}
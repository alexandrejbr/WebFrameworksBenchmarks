package org.restexpress.scaffold.minimal.controller;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.*;
import org.restexpress.Request;
import org.restexpress.Response;
import org.restexpress.scaffold.minimal.Book;

public class SampleController
{
    private static final String text = objectAsString();
	public SampleController()
	{
		super();
	}

	public Book[] json(Request request, Response response)
	{
		return Book.all;
	}

    public String text(Request request, Response response){
        response.setContentType("text/plain");
        return text;
    }

    private static String objectAsString(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            return mapper.writeValueAsString(Book.all);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package org.restexpress.scaffold.minimal.controller;

import java.util.Collections;
import java.util.List;

import org.restexpress.Request;
import org.restexpress.Response;
import org.restexpress.scaffold.minimal.Book;

public class SampleController
{
	public SampleController()
	{
		super();
	}

	public Object create(Request request, Response response)
	{
		//TODO: Your 'POST' logic here...
		return null;
	}

	public Object read(Request request, Response response)
	{
		//TODO: Your 'GET' logic here...
		return null;
	}

	public Book[] readAll(Request request, Response response)
	{
		//TODO: Your 'GET collection' logic here...
		return Book.all;
	}

	public void update(Request request, Response response)
	{
		//TODO: Your 'PUT' logic here...
		response.setResponseNoContent();
	}

	public void delete(Request request, Response response)
	{
		//TODO: Your 'DELETE' logic here...
		response.setResponseNoContent();
	}
}

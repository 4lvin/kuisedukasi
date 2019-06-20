package com.jongjava.alvin.kuisgame.model;

import java.util.List;

public class Response{
	private List<DataItem> data;
	private Message message;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setMessage(Message message){
		this.message = message;
	}

	public Message getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}
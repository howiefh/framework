package io.github.howiefh.console;

import java.util.List;

public class Person {
	private int id;
	private String name;
    private List<Person> friends;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

	public Person(int id, String name, List<Person> friends) {
		this.id = id;
		this.name = name;
        this.friends = friends;
	}
	
	public int testId() {
		return id;
	}
}

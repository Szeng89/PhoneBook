package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        phonebook.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, new ArrayList<String>(List.of(phoneNumbers)));
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        return phonebook.containsKey(name) && phonebook.get(name).contains(phoneNumber);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        Set<String> keys = phonebook.keySet();
        StringBuilder sb = new StringBuilder();
        for (String i : keys) {
            if (phonebook.get(i).contains(phoneNumber)) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public List<String> getAllContactNames() {
        List<String> list = new ArrayList<>();
        for (String i : phonebook.keySet()) {
            list.add(i);
        }
        return list;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}

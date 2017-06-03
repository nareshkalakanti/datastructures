package com.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Treet implements Comparable<Treet>,Serializable {

    //member variables shouldnt be exposed to anyone outside the class
    private static final long serialVersionUID = 4971834102583986773L;
    private  boolean mBreakIt = true;
    private String mAuthor;
    private String mDescription;
    private Date mCreationDate;

    //Constructor : to populate data of the class

    public Treet(String author , String description , Date creationDate ){
        //initialize the variables below
        mAuthor = author;
        mDescription= description;
        mCreationDate=creationDate;

    }

    public String toString(){

        return String.format("Treet: \"%s\" by %s on %s", mDescription, mAuthor, mCreationDate);
    }

    //To get the information out of the object : set getters

    public  String getmAuthor(){
        return mAuthor;
    }

    public  String getDescription(){
        return mDescription;
    }

    public Date getCreationDate(){
        return mCreationDate;
    }

    public List<String> getWords(){
        String[] words = mDescription.toLowerCase().split("[^\\w#@']+");
        return Arrays.asList(words);
    }


    public List<String> getMentions(){
        return getWordsPrefixedWith("@");
    }

    public List<String> getHashTags(){
        return getWordsPrefixedWith("#");
    }

    private List<String> getWordsPrefixedWith(String prefix){
        List<String> results = new ArrayList<String>();
        for (String word: getWords()){
            if (word.startsWith(prefix)){
                results.add(word);
            }
        }
            return results;
    }


    public int compareTo(Treet obj){
        if (equals(obj)){
            return 0;
        }
        int dateCmp = mCreationDate.compareTo(obj.mCreationDate);
        if (dateCmp == 0){
            return mDescription.compareTo(obj.mDescription);
        }
        return dateCmp;
    }

}
